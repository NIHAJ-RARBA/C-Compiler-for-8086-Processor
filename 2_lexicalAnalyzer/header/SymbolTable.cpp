#include <iostream>
#include <string>
#include <sstream>

#include "ScopeTable.cpp"

#define ull unsigned long long

using namespace std;

void saveStats(Stats& s1, Stats& s2)
{
    s1.collisionsPerBucket += s2.collisionsPerBucket;
    s1.insertions += s2.insertions;
    s1.deletions += s2.deletions;
    s1.totalCollisions += s2.totalCollisions;
    s1.loadFactor += s2.loadFactor;
    s1.maxChainLength += s2.maxChainLength;
}

class SymbolTable 
{
    private:
        ScopeTable* root;
        ScopeTable* stackTop; // Current scope will act as the "end" as this is a stack
        
        int hashFunction;
        ull totalScopeCount;
        bool rehash = false;
        Stats escapedScopesStats;
        
        

    public:
        
        SymbolTable(ull numBuckets, bool rehashDecision = false, int hashFunction = 0) 
        {
            this->rehash = rehashDecision;
            this->root = new ScopeTable(numBuckets, hashFunction, nullptr, rehash);
            // cout << "\tScopeTable# " << this->root->scopeNumber << " created" << endl;
            // this is the only time we will have a scope with no parent
            this->stackTop = this->root;
            this->totalScopeCount = 1;
            this->hashFunction = hashFunction;
        }
        
        ~SymbolTable() 
        {
            // due to exitScope's implementation,
            // root and stackTop will be the same only when the stack is empty
            // i.e. stackTop pointed to head on the last step and then it was removed
            // so we can safely delete the root
            
            while (root != stackTop)
            {
                exitScope();
            }

            delete root;
            root = nullptr;
            
        }


        bool enterScope()
        {
            ScopeTable* newScope = new ScopeTable(this->stackTop->numBuckets, this->hashFunction, this->stackTop, this->rehash);
            // cout << "\tScopeTable# " << newScope->scopeNumber << " created" << endl;
            this->stackTop = newScope;
            this->totalScopeCount++;
            return true;
        }


        void exitScope()
        {
            // cout << "\t" ;

            if (this->stackTop == this->root)
            {
                // cout << "ScopeTable# " << this->stackTop->scopeNumber << " cannot be removed" << endl;
                return;
            }

            Stats tempStats = this->stackTop->getStats();

            saveStats(this->escapedScopesStats, tempStats);

            ScopeTable* temp = this->stackTop;
            this->stackTop = this->stackTop->parentScope;
            
            // cout << "ScopeTable# " << temp->scopeNumber << " removed" << endl;

            delete temp;

        }

        bool insert(string name, string type)
        {
            // cout << "\t" ;
            return this->stackTop->insert(name, type);
        }


        pair<ull, ull> getSymbolPosition(string name)
        {
            // cout << "\t" ;
            return this->stackTop->getSymbolPosition(name);
        }

        string insertFailureMessage(string name, string type)
        {
            ostringstream oss;
            pair<unsigned long long, unsigned long long> position = this->stackTop->getSymbolPosition(name);
            // < arr : ID > already exists in ScopeTable# 1.1 at position 6, 2 <<-- format reminder

            oss << "< " << name << " : " << type << " > already exists in ScopeTable# " << this->stackTop->scopeId << " at position " << position.first << ", " << position.second;
            return oss.str();
        }

        bool remove(string name)
        {
            
            return this->stackTop->remove(name);
        }

        SymbolInfo* lookUp(string name)
        {
            ScopeTable* currScope = this->stackTop;
            

            while(currScope != nullptr)
            {
                SymbolInfo* entry = currScope->lookUp(name);
                
                if(entry != nullptr)
                {
                    return entry;
                }

                currScope = currScope->parentScope;
            }
            
            cout << "\t'" << name << "' not found in any of the ScopeTables" << endl;
            return nullptr;
        }

        void printCurrentScopeTable()
        {
            this->stackTop->printScopeTable();
        }

        string getCurrentScopeTableString()
        {
            return this->stackTop->getScopeString();
        }

        void printAllScopeTables()
        {
            // tabs are disabled from within scopeTable now.
            // keeping the i here was only to match the output format for assignment 1
            
            int i = 1;
            ScopeTable* currScope = this->stackTop;
            while(currScope != nullptr)
            {
                // cout << "ScopeTable# " << currScope->scopeNumber << endl;
                currScope->printScopeTable(i);
                currScope = currScope->parentScope;
                i++;
            }
            
        }

        string getAllScopeTablesString()
        {
            ostringstream oss;

            // keeping i here was only to match the output format for assignment 1
            // it is disabled from within scopeTable now. 
            // keeping the i here is not necessary. but will keep it just in case
            int i = 1;
            ScopeTable* currScope = this->stackTop;
            while(currScope != nullptr)
            {
                // oss << "ScopeTable # " << currScope->scopeNumber << endl;
                oss << currScope->getScopeString(i);
                currScope = currScope->parentScope;
                i++;
            }
            return oss.str();
        }

        void quit()
        {
            while (root != stackTop)
            {
                exitScope();
            }
            // cout << "\tScopeTable# " << root->scopeNumber << " removed" << endl;
        }


        string printStats() {
            ostringstream oss;
            oss << "\tTotal ScopeTables: " << this->totalScopeCount << endl;
        
            Stats aggregated;
            int numScopes = 0;
        
            ScopeTable* currentScope = this->stackTop;

            saveStats(aggregated, this->escapedScopesStats);
        
            while (currentScope != nullptr) {
                Stats s = currentScope->getStats();
        
                saveStats(aggregated, s);
        
                numScopes++;
                currentScope = currentScope->parentScope;
            }
        
            if (numScopes > 0) {
                // calculate averages
                
                aggregated.collisionsPerBucket /= numScopes;
                aggregated.insertions /= numScopes;
                aggregated.deletions /= numScopes;
                aggregated.totalCollisions /= numScopes;
                aggregated.loadFactor /= numScopes;
                aggregated.maxChainLength /= numScopes;
            }
            else {
                oss << "\tNo scopes available." << endl;
                return oss.str();
            }
        
            oss << "\tAverage Collisions per Bucket: " << aggregated.collisionsPerBucket << endl;
            oss << "\tAverage Insertions: " << aggregated.insertions << endl;
            oss << "\tAverage Deletions: " << aggregated.deletions << endl;
            oss << "\tAverage Collisions: " << aggregated.totalCollisions << endl;
            oss << "\tAverage Load Factor: " << aggregated.loadFactor << endl;
            oss << "\tAverage Max Chain Length: " << aggregated.maxChainLength << endl;
        
            return oss.str();
        }
        


    };




#pragma once
// #include <iostream>
// #include <string>
// #include <sstream>

// #include "SymbolInfo.hpp"
// #include "HashFunctions.hpp"
// #include <cmath>

// #define ull unsigned long long

#include "ScopeTable.hpp"

int ScopeTable::scopeCount = 0; // static variable to keep track of the number of scopes created

using namespace std;


ull nearestPrime(ull N)
{
    if (N < 2) N = 2;

    
    ull prime = N;
    bool found = false;

    while (!found)
    {
        bool isPrime = true;
        for (ull i = 2; i <= prime / 2; i++)
        {
            if (prime % i == 0)
            {
                isPrime = false;
                break;
            }
        }

        if (isPrime)
        {
            found = true;
        }

        else
        {
            prime++;
        }
    }

    return prime;
}



void ScopeTable::setId() {
    
    if(this->parentScope == nullptr)
    {
        this->scopeId = "1";
        return;
    }
    
    // root/main scope is 1
    // child of 1 is 1_1, 1_2 which are on the same level
    // child of 1_1 is 1_1_1, 1_1_2 ,
    // child of 1_2 are 1_2_1, 1_2_2 and so on.




    this->scopeId = parentScope->scopeId + "." + to_string(++(parentScope->childNumber));
}

void ScopeTable::setMaxChainLength() {
    this->maxChainLength = this->numBuckets / 2;
}

void ScopeTable::rehash(ull newNumBucket) {


        // cout << "Before rehashing: " << endl
            // << endl;
        this->printStats();


        SymbolInfo** newTable = new SymbolInfo*[newNumBucket];
        ull *newChainSizeArr = new ull[newNumBucket];

        SymbolInfo** tempTable = this->table;
        ull* tempChainSizeArr = this->chainSizeArr;

        for (ull i = 0; i < newNumBucket; i++)
        {
            newTable[i] = nullptr;
            newChainSizeArr[i] = 0;
        }
        
        // if primes are used, then the newNumBucket should also be prime
        // newNumBucket = nearestPrime(newNumBucket);

        ull temp = this->numBuckets;
        this->numBuckets = newNumBucket;
        this->setMaxChainLength();
        this->collisionCount = 0;
        this->currMaxChainLength = 0;

        // rehashing existing symbols

        for (ull i = 0; i < temp; i++) {

            SymbolInfo* currSymbol = this->table[i];

            while(currSymbol != nullptr) {
                SymbolInfo* next = currSymbol->next;

                // hash the symbol name to find the new index
                ull newIndex = hashEval(currSymbol->getSymbolName(), newNumBucket);

                if (newIndex >= newNumBucket)
                {
                    // cout << "Uhm wtf" << endl;
                }


                if (newTable[newIndex] == nullptr) 
                {
                    newTable[newIndex] = currSymbol;
                    newChainSizeArr[newIndex] = 1;

                    currSymbol->next = nullptr;
                } 
                
                else 
                {
                    this->collisionCount++;

                    SymbolInfo* temp = newTable[newIndex];
                    while (temp->next != nullptr) {
                        temp = temp->next;
                    }
                    temp->next = currSymbol;
                    newChainSizeArr[newIndex]++;

                    currSymbol->next = nullptr;
                }

                // update the current max chain length

                currMaxChainLength = max(currMaxChainLength, newChainSizeArr[newIndex]);

                currSymbol = next;
                
            }
            
        }
            
            
        SymbolInfo** oldTable = this->table;
        ull* oldChainSizes = this->chainSizeArr;
        
        this->table = newTable;
        this->chainSizeArr = newChainSizeArr;
        
        delete[] oldTable;
        delete[] oldChainSizes;
        

        // cout << "After rehashing: " << endl
            // << endl;
        this->printStats();
        


}


void ScopeTable::setHashFunc(int hashFunction) {
   
    if (hashFunction == 0)
    {
        hashFunc = &SBDM_HASH;
    }
    else if (hashFunction == 1)
    {
        hashFunc = &jenkinsHash;
    }
    else if (hashFunction == 2)
    {
        hashFunc = &polynomialRollingHash;
    }
    else if (hashFunction == 3)
    {
        hashFunc = &murmurHash;
    }
    else
    {
        // cout << "Invalid hash function. Using default SDBM hash function." << endl;
        hashFunc = &SBDM_HASH;
    }
}


ScopeTable::ScopeTable(ull numBuckets, int hashFunction,ScopeTable* parentScope, bool rehash) {
            
    // decision to be made whether to use prime number for numBuckets or not

    this->numBuckets = numBuckets;
    // this->numBuckets = nearestPrime(numBuckets);

    this->parentScope = parentScope;
    this->childNumber = 0;

    this->rehashDecision = rehash;

    this->setId();
    this->setHashFunc(hashFunction);
    this->scopeNumber = ++scopeCount;

    
    this->maxChainLength = this->numBuckets / 2;

    this->table = new SymbolInfo*[numBuckets];
    this->chainSizeArr = new ull[numBuckets];
    this->totalStackSpace = 0;

    for (ull i = 0; i < numBuckets; i++)   
    {
        table[i] = nullptr;
        chainSizeArr[i] = 0;
    }

    // cout << "hashfunction: " << hashFunction << endl;

}

ScopeTable::~ScopeTable() {

    for (ull i = 0; i < numBuckets; i++)
    {
        SymbolInfo* entry = table[i];
        while (entry != nullptr)
        {
            SymbolInfo* temp = entry;
            entry = entry->next;
            delete temp;
        }
    }
    
    // cout << "ScopeTable# " << this->scopeNumber << "removed" << endl;
    delete[] table;
    delete[] chainSizeArr;

    table = nullptr;
    chainSizeArr = nullptr;

}


ull ScopeTable::hashEval(string key, ull customBucketSize) {
    ull buckets = (customBucketSize != 0) ? customBucketSize : this->numBuckets;
    return hashFunc(key, buckets) % buckets;
}



void ScopeTable::printStats() {



    cout << "ScopeTable ID: " << this->scopeId << endl;
    cout << "Number of Buckets: " << this->numBuckets << endl << endl;

    cout << "Collisions Per Bucket(Avg): " << (double)(this->collisionCount) / (double)(this->numBuckets) << endl 
                << endl;

    cout << "Number of Insertions: " << this->insertions << endl;
    cout << "Number of Deletions: " << this->deletions << endl;
    cout << "Number of Collisions: " << this->collisionCount << endl;
    cout << "Load Factor: " << (double)(this->insertions) / (double)(this->numBuckets) << endl 
                << endl;

    cout << "Max Chain Length: " << this->currMaxChainLength << endl;
    cout << "Max Chain Length Allowed: " << this->maxChainLength << endl
                << endl;

    // potentially add probe count statistics

}

Stats ScopeTable::getStats() {
    Stats s;
    s.collisionsPerBucket = (double)(this->collisionCount) / (double)(this->numBuckets);
    s.insertions = this->insertions;
    s.deletions = this->deletions;
    s.totalCollisions = this->collisionCount;
    s.loadFactor = (double)(this->insertions) / (double)(this->numBuckets);
    s.maxChainLength = this->currMaxChainLength;
    return s;
}






SymbolInfo* ScopeTable::lookUp(string name) {


    // cout << "\t" ;
    ull index = this->hashEval(name);


    SymbolInfo* entry = this->table[index];
    ull chain = 1;
    while (entry != nullptr)
    {
        if (entry->getSymbolName() == name)
        {
            cout << "\t'" << name << "' found in ScopeTable# " << this->scopeNumber 
            << " at position " << index+1 << ", " << chain << endl;
            return entry;
        }

        entry = entry->next;
        chain++;
    }

    // cout << "'" << name << "' not found in ScopeTable# " << this->scopeNumber << endl;
    return nullptr;

    
}


bool ScopeTable::lookupHelper(string name) {
    ull index = this->hashEval(name);

    SymbolInfo* entry = this->table[index];
    while (entry != nullptr)
    {
        if (entry->getSymbolName() == name)
        {
            return true;
        }

        entry = entry->next;
    }
    return false;

}

pair<ull, ull> ScopeTable::getSymbolPosition(string name) {
    ull index = this->hashEval(name);

    ull position = 0;
    SymbolInfo* entry = this->table[index];
    while (entry != nullptr)
    {
        if (entry->getSymbolName() == name)
        {
            return make_pair(index, position);
        }

        entry = entry->next;
        position++;
    }
    return make_pair(-1, -1);

}


bool ScopeTable::insert(string name, string type) {
    // cout << "\t" ;

    if(this->lookupHelper(name))
    {
        // cout << "'" << name << "' already exists in the current ScopeTable" << endl;
        return false;
    }

    ull index = this->hashEval(name);
    SymbolInfo* newEntry = new SymbolInfo(name, type);

    if (this->table[index] == nullptr)
    {
        this->table[index] = newEntry;
        this->chainSizeArr[index] = 1;
    }
    
    else
    {
        this->collisionCount++;
        this->chainSizeArr[index]++;

        SymbolInfo* temp = this->table[index];
        while (temp->next != nullptr)
        {
            temp = temp->next;
        }

        temp->next = newEntry;
        newEntry->next = nullptr;

    }

    // insertion is done

    this->insertions++;
    this->currMaxChainLength = max(this->currMaxChainLength, this->chainSizeArr[index]);

    if(rehashDecision == true)
    {
        // cout << "CurrMaxChainLen = " << currMaxChainLength << "MaxLen = " << maxChainLength;
        if (currMaxChainLength > maxChainLength)
        {
            // cout << "Rehashing required" << endl;
            this->rehash(this->numBuckets * 2);
        }

        if (currMaxChainLength < 0.8* maxChainLength)
        {
            // cout << "Rehashing required" << endl;
            this->rehash(this->numBuckets / 2);
        }
    }
    
    index = hashEval(name);

    // cout << "Inserted in ScopeTable# " << this->scopeNumber 
                            // << " at position " << index+1 << ", " << this->chainSizeArr[index] << endl;

    

    return true;

}


SymbolInfo* ScopeTable::removeHelper(string name) {
    cout << "\t" ;

    ull index = this->hashEval(name);

    if (this->table[index] == nullptr)
    {
        cout << "Not found in the current ScopeTable" << endl;
        return nullptr;
    }

    


    ull chain = 1;
    // first check if the first element is the one to be deleted
    if (this->table[index]->getSymbolName() == name)
    {
        cout << "Deleted '" << name 
                << "' from ScopeTable# " << this->scopeNumber  << " at position " << index+1 << ", " << chain << endl;

        SymbolInfo* temp = this->table[index];
        this->table[index] = this->table[index]->next;
        this->chainSizeArr[index]--;

        this->currMaxChainLength = max(this->currMaxChainLength, this->chainSizeArr[index]);
    
        
        if (rehashDecision == true)
        {
            if (currMaxChainLength < 0.8* maxChainLength)
            {
                // cout << "Rehashing required" << endl;
                this->rehash(this->numBuckets / 2);
            }
        }

        return temp;
    }


    // pointers for fixing the linked list after deletion of non-first chain symbol
    SymbolInfo* curr = this->table[index]->next;
    SymbolInfo* prev = this->table[index];
    chain++;

    while(curr != nullptr)
    {
        if (curr->getSymbolName() == name)
        {
            // cout << "Deleted '" << name << "' from ScopeTable# " << this->scopeNumber 
                            // << " at position " << index+1 << ", " << chain << endl;
            prev->next = curr->next;
            this->chainSizeArr[index]--;


            this->currMaxChainLength = max(this->currMaxChainLength, this->chainSizeArr[index]);
    
    
            if (rehashDecision == true)
            {
                    if (currMaxChainLength < 0.8* maxChainLength)
                {
                    // cout << "Rehashing required" << endl;
                    this->rehash(this->numBuckets / 2);
                }
            }


            return curr;
        }

        prev = curr;
        curr = curr->next;
        chain++;
    }

    cout << "Not found in the current ScopeTable" << endl;
    return nullptr; 
}


bool ScopeTable::remove(string name) {
    SymbolInfo* deletedSymbol = this->removeHelper(name);

    if (deletedSymbol != nullptr)
    {
        delete deletedSymbol;
        this->deletions++;


        return true;
    }

    return false;
}


void ScopeTable::printScopeTable(int tabCount) {

    // int temp = tabCount;
    // while (temp-- > 0)
    // {
    //      cout << "\t" ;
    // }
    
    // format for assignment 2
    
    cout << "ScopeTable # " << this->scopeId << endl;

    for (ull i = 0; i < this->numBuckets; i++)
    {

        // int temp = tabCount;
        // while (temp-- > 0)
        // {
        //     cout << "\t" ;
        // }

        cout << i+1 << "--> ";
        SymbolInfo* currEntry = this->table[i];
        if (currEntry == nullptr)
        {
            cout << endl;
            continue;
        }

        while (currEntry != nullptr)
        {
            cout << "< " << currEntry->getSymbolName() << " , " << currEntry->getSymbolType() << " >";
            currEntry = currEntry->next;
        }

        cout << endl;
    }
            
}


// Changing again to match the output format for assignment 3
string ScopeTable::getScopeString(int tabCount) {
    ostringstream ss;
    
    // specs changed for assignment 2 T^T
    // int temp = tabCount;
    // while (temp-- > 0)
    // {
    //     ss << "\t" ;
    // }
    
    
    ss << "ScopeTable # " << this->scopeId << "\n";

    for (ull i = 0; i < this->numBuckets; i++)
    {
        // just for matching output indentation for the assignment

        // int temp = tabCount;
        // while (temp-- > 0)
        // {
        //     ss << "\t" ;
        // }

        SymbolInfo* currEntry = this->table[i];
        if (currEntry == nullptr)
        {
            // ss << "\n";
            continue;
        }
        
        ss << i << " --> ";

        while (currEntry != nullptr)
        {
            ss << "< " << currEntry->getSymbolName() << " : " << currEntry->getSymbolType() << " >";
            // change for assignment 3
            // ss << "< " << currEntry->getSymbolName() << " : " << "ID" << " >";
            currEntry = currEntry->next;
        }

        ss << "\n";
    }

   return ss.str();
}






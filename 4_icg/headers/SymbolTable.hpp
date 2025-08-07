#pragma once

#include <iostream>
#include <string>
#include <sstream>
#include <utility> // Required for std::pair

#include "ScopeTable.hpp"

// Forward declaration if SymbolInfo is used but not fully defined here
class SymbolInfo; 

#define ull unsigned long long

using namespace std;


void saveStats(Stats& s1, Stats& s2);


class SymbolTable 
{
private:
    ScopeTable* root;
    ScopeTable* stackTop; // Current scope
    
    int hashFunction;
    ull totalScopeCount;
    bool rehash;
    Stats escapedScopesStats;

public:

    SymbolTable(ull numBuckets, bool rehashDecision = false, int hashFunction = 0);

    ~SymbolTable();

    bool enterScope();


    void exitScope();


    bool insert(string name, string type);

    pair<ull, ull> getSymbolPosition(string name);

    
    string insertFailureMessage(string name, string type);

    
    bool remove(string name);

   
    SymbolInfo* lookUp(string name);

    
    void printCurrentScopeTable();

   
    string getCurrentScopeTableString();

    
    void printAllScopeTables();

    
    string getAllScopeTablesString();

    void quit();

    

    string printStats();

    int getCurrentLocalOffset();
    void addLocalOffset(int offset);
};

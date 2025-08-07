#pragma once

#include <iostream>
#include <string>
#include <sstream>
#include <utility>
#include <cmath>

#include "SymbolInfo.hpp"
#include "HashFunctions.hpp"

#define ull unsigned long long

using namespace std;

struct Stats {
    double collisionsPerBucket = 0.0;
    int insertions = 0;
    int deletions = 0;
    int totalCollisions = 0;
    double loadFactor = 0.0;
    int maxChainLength = 0;
};

ull nearestPrime(ull N);

class ScopeTable 
{
private:
    ull maxChainLength;
    ull insertions = 0;
    ull deletions = 0;
    
    unsigned int (*hashFunc)(string str, unsigned int numBuckets);

    static int scopeCount;

    void setId();
    void setMaxChainLength();
    void rehash(ull newNumBucket);
    void setHashFunc(int hashFunction);

public:
    ull scopeNumber;
    string scopeId;
    ull childNumber;

    ull numBuckets;
    
    ull collisionCount = 0;
    ull currMaxChainLength = 0;
    
    SymbolInfo** table;
    ull* chainSizeArr;
    
    ScopeTable* parentScope;
    bool rehashDecision = false;

    ScopeTable(ull numBuckets, int hashFunction = 1, ScopeTable* parentScope = nullptr, bool rehash = false);
    ~ScopeTable();

    ull hashEval(string key, ull customBucketSize = 0);

    void printStats();
    bool insert(string name, string type);
    bool lookupHelper(string name);
    SymbolInfo* lookUp(string name);
    bool remove(string name);
    SymbolInfo* removeHelper(string name);
    void printScopeTable(int tabCount = 1);

    Stats getStats();
    string getScopeString(int tabCount = 1);
    pair<ull, ull> getSymbolPosition(string name);
};

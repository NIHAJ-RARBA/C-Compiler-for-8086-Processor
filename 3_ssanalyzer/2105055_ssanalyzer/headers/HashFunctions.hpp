#pragma once
#include <string>

// #include "MurMurHash3.cpp"
// #include "MurMurHash3.h"
// #include <string.h>

using namespace std;

unsigned int polynomialRollingHash(string str, unsigned int numBuckets);

unsigned int jenkinsHash(string s, unsigned int numBuckets);

unsigned int murmurHash(string str, unsigned int numBuckets);

unsigned int SBDM_HASH(string str, unsigned int numBuckets);
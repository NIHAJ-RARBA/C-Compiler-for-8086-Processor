#include <string>

#include "MurMurHash3.cpp"
#include "MurMurHash3.h"
#include <string.h>



using namespace std;

// unsigned int according to given specification.
// unsigned long or unsigned long long would give higher bit range

// function definitions need to me same to be interchangeable

unsigned int polynomialRollingHash(string str, unsigned int numBuckets)
{
    // cout << "Poly"<< endl;
    const int p = 59;
    const int m = 1e9+9;

    unsigned int hashValue = 0;
    unsigned int pPow = 1;

    for (size_t i = 0; i < str.length(); i++)
    {
        char c = str[i];
        hashValue = (hashValue + (c - 'a' + 1) * pPow) % m;
        pPow = (pPow * p) % m;
    }

    return hashValue;

}


unsigned int jenkinsHash(string s, unsigned int numBuckets)
{
    // cout << "jenkins" << endl;
    const int len = s.length();
    const unsigned char* str = (const unsigned char*)s.c_str();
    
    unsigned int hash = 0;    


    for (size_t i = 0; i < len; ++i)
    {
        hash += str[i];
        hash += (hash << 10);
        hash ^= (hash >> 6);
    }


    hash += (hash << 3);
    hash ^= (hash >> 11);
    hash += (hash << 15);

    return hash;

}



unsigned int murmurHash(string str, unsigned int numBuckets)
{
    // cout << "murmur" << endl;
    const char* data = str.c_str();
    const int len = str.length(); 

    const uint32_t seed = 210505587;

    uint32_t hashVal;

    MurmurHash3_x86_32(data, len, seed, &hashVal);

    return hashVal;

}


// unsigned int SBDM_HASH(string str, unsigned int numBuckets)
// {
//     // cout << "sbdm" << endl;
//     unsigned int hash = 0;

//     unsigned int len = str.length();

//     for (unsigned int i = 0; i < len; i++)
//     {
//         hash = ((str[i]) + (hash << 6) + (hash << 16) - hash) % numBuckets;
//     }
    

//     return hash;
// }


// alternate implementation for matching output for assignment 2
unsigned int SBDM_HASH(string str, unsigned int numBuckets) {
    
    unsigned int hash = 0; 
    auto *stringPtr = (unsigned char *) str.c_str(); 
    int c{}; 
    while ((c = *stringPtr++)) { 
        hash = c + (hash << 6) + (hash << 16) - hash; 
    } 
    return hash; 
} 


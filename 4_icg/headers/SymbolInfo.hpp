#pragma once
#include <string>
#include <vector>
#include <utility>

#define param_name(p) ((p).first)
#define param_type(p) ((p).second)

using namespace std;

class SymbolInfo {

    private :
        string symbolName;
        string symbolType;

    public:
        
        SymbolInfo* next;


        string interpretedType; // will be return type for functions
        int offset;
        bool global = false; 
        
        bool isArray = false;
        int arrayLength = -1;


        bool isFunction = false;
        bool definedFunction = false; // insertion only when declared or defined.
        vector<pair<string, string>> parameters;



        SymbolInfo(const string &name, const string &type, SymbolInfo* next = nullptr)
        {
            symbolName = name;
            symbolType = type;
            this->next = next;

        }



        
        int getSize()
        {
            if(interpretedType == "int")
            {
                return 2;
            }
            else if(interpretedType == "float")
            {
                return 4;
            }
            return 0;
        }
        
        void setOffset(int offset)
        {
            this->offset = offset;
        }
        int getOffset()
        {
            return offset;
        }

        string getSymbolName()
        {
            return symbolName;
        }


        string getSymbolType()
        {
            return symbolType;
        }


        void makeFunctionSymbol(const string& returnType, const vector<string>& paramTypes, const vector<string>& paramNames)
        {
            isFunction = true;
            interpretedType = returnType;
            definedFunction = false;
            parameters.clear();

            for (int i = 0; i < paramTypes.size(); i++)
            {
                parameters.push_back(make_pair(paramNames[i], paramTypes[i]));
            }

        }

        void setFunctionDefined()
        {
            definedFunction = true;
        }


        void makeArraySymbol(const string& type, int length)
        {
            isArray = true;
            interpretedType = type;
            arrayLength = length;
        }

};

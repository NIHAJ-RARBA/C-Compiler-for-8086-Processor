#include <string>

using namespace std;

class SymbolInfo {

    private :
        string symbolName;
        string symbolType;

    public:
        
        SymbolInfo* next;

        SymbolInfo(const string &name, const string &type, SymbolInfo* next = nullptr)
        {
            symbolName = name;
            symbolType = type;
            this->next = next;
        }


        string getSymbolName()
        {
            return symbolName;
        }


        string getSymbolType()
        {
            return symbolType;
        }

};

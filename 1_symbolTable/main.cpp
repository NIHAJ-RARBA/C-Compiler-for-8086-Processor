#include <iostream>
#include <string>
#include <sstream>
#include <fstream>


#include "SymbolTable.cpp"

string packageSymbolType(string &symbolType, string &typeList)
{
    string type;
    stringstream parser(typeList);
    if (symbolType == "FUNCTION")
    {
        string returnType;
        parser >> returnType;
        type = symbolType + "," + returnType + "<==(";

        string argType;

        bool notFirst = false;
        while ( parser >> argType )
        {
            if (notFirst == true)
            {
                type += ",";
            }

            type += argType;
            notFirst = true;
        }

        type += ")";

    }

    else if (symbolType == "STRUCT" || symbolType == "UNION")
    {
        
        type = symbolType + ",{";
        
        string memberType, memberName;

        bool notFirst = false;

        while (parser >> memberType >> memberName)
        {
            if (notFirst == true)
            {
                type += ",";
            }

            type += "(" + memberType + "," + memberName + ")";
            notFirst = true;
        }

        type += "}";

    }

    else 
    {
        type = symbolType;
    }

    return type;
}


bool isValidIdentifier(const string& str, bool checkEmpty = true) 
{
    if (checkEmpty == true)
    {
        if (str.empty() || (!isalpha(str[0]) && str[0] != '_')) 
        {
            return false;
        }
    }
    else 
    {
        if ((!isalpha(str[0]) && str[0] != '_'))
        {
            return false;
        }
    }

    for (size_t i = 1; i < str.length(); ++i)
    {
        if (!isalnum(str[i]) && str[i] != '_') // if not alphanumeric, then must be "_"
        {
            return false;
        }
    }


    return true;
}



bool validateInsertCmd(string &name, string &symbolType, string &typelist) 
{
    stringstream typeStream(typelist);

    if (name.empty() || symbolType.empty()) {
        return false;
    }

    if (symbolType == "FUNCTION") 
    {
        if (typelist.empty()) {
            return false;
        }

        string returnType, argType;
        typeStream >> returnType;

        // function must have a minimum of one valid return type 
        if (!isValidIdentifier(returnType, true))
        {
            return false;
        }
        
        
        // 0 or more valid input types
        while (typeStream >> argType) 
        {
            if (!isValidIdentifier(argType, false))
            {
                return false;
            }
        }

    } 
    
    
    else if (symbolType == "STRUCT" || symbolType == "UNION") 
    {
        string memberType, memberName;

        // struct or union must have (memberType, memberName) pairs
        // if not paired, then invalid
        while (typeStream >> memberType >> memberName) {
            if (!isValidIdentifier(memberType) || !isValidIdentifier(memberName))
            {
                return false;
            }
            
        }
    } 
    
    else 
    {
        
        if (!isValidIdentifier(symbolType))
        {
            return false;
        }

        if (symbolType == "INT" || symbolType == "FLOAT" || symbolType == "DOUBLE" || symbolType == "BOOL" || symbolType == "VOID" || symbolType == "CHAR" || symbolType == "RELOP" || symbolType == "EQOP")
        {
            string check;
            typeStream >> check;
            if(!check.empty())
            {
                return false;
            }
        }

    }


    return true;
}

void errorMessage(const string& command) 
{
    cout << "\tNumber of parameters mismatch for the command " << command << endl;
}


int main(int argc, char* argv[])
{
    if (argc < 3 || argc > 4)
    {
        cerr << "Usage: " << argv[0] << " <input_file> <output_file> <hash_function_number(optional)>" << endl;
        cerr << "Hash functions: 0 (SDBM, default), 1 (Jenkins), 2 (Polynomial Rolling), 3 (Murmur)" << endl;
        return 1;
    }


    ifstream inputFile(argv[1]);


    if (!inputFile.is_open())
    {
        cerr << "Error opening input file: " << argv[1] << endl;
        return 1;
    }

    if (freopen(argv[2], "w", stdout) == NULL) {  // Redirect stdout to output file
        cerr << "Error opening output file: " << argv[2] << endl;
        return 1;
    }

    unsigned int numBuckets;
    inputFile >> numBuckets >>ws;

    unsigned int hashFunction = 0;
    if (argc == 4)
    {
        hashFunction = stoi(argv[3]);
    }

    SymbolTable symbolTable(numBuckets, false);

    string command;
    unsigned int commandCount = 0;

    while (getline(inputFile, command))
    {
        if (command.empty()) 
            continue;

        commandCount++;

        // print command number and the command
        // trim leading and trailing spaces
        command.erase(0, command.find_first_not_of(" \t\r"));
        command.erase(command.find_last_not_of(" \t\r") + 1);

        cout << "Cmd " << commandCount << ": " << command << endl;

        stringstream commandStream(command);
        
        string currCmd;
        commandStream >> currCmd;

        if (currCmd == "I")
        {
            string name, symbolType, typeList;

            commandStream >> name >> ws >> symbolType >> ws;
            getline(commandStream, typeList);

            if (validateInsertCmd(name, symbolType, typeList) == false)
            {
                
                errorMessage(currCmd);
                continue;
            }
            
            string type = packageSymbolType(symbolType, typeList);

            bool insertSuccess = symbolTable.insert(name, type);

            // insertSuccess unused, as the printing is done within the inner classes

        }


        else if (currCmd == "L")
        {
            string name, remaining;
            commandStream >> name;

            getline(commandStream, remaining);
            
            if (name.empty())
            {
                errorMessage(currCmd);
                continue;
            }
            remaining.erase(0, remaining.find_first_not_of(" \t\r"));
            remaining.erase(remaining.find_last_not_of(" \t\r") + 1);



            if (!remaining.empty())
            {
                errorMessage(currCmd);
                continue;
            }
            else
            {
                symbolTable.lookUp(name);
            }

        }


        else if (currCmd == "D")
        {
            string name, remaining;

            commandStream >> name;
            getline(commandStream, remaining);

            if (name.empty())
            {
                errorMessage(currCmd);
                continue;
            }
            remaining.erase(0, remaining.find_first_not_of(" \t\r"));
            remaining.erase(remaining.find_last_not_of(" \t\r") + 1);



            if (!remaining.empty())
            {
                errorMessage(currCmd);
                continue;
            }
            else
            {
                symbolTable.remove(name);
            }
        }

        else if (currCmd == "P")
        {
            string remaining, remaining2;
            commandStream >> remaining >> remaining2;

            if(!remaining2.empty())
            {
                errorMessage(currCmd);
                continue;
            }

            if (remaining == "C")
            {
                symbolTable.printCurrentScopeTable();
            }
            else if (remaining == "A")
            {
                symbolTable.printAllScopeTables();
            }
            else
            {
                errorMessage(currCmd);
                continue;
            }


    
        }



        else if (currCmd == "E")
        {
            string remaining;

            commandStream >> remaining;
            remaining.erase(0, remaining.find_first_not_of(" \t\r"));
            remaining.erase(remaining.find_last_not_of(" \t\r") + 1);



            if (!remaining.empty())
            {
                errorMessage(currCmd);
                continue;
            }
            else
            {
                symbolTable.exitScope();
            }

        }



        else if (currCmd == "S")
        {
            string remaining;

            commandStream >> remaining;
            remaining.erase(0, remaining.find_first_not_of(" \t\r"));
            remaining.erase(remaining.find_last_not_of(" \t\r") + 1);



            if (!remaining.empty())
            {
                errorMessage(currCmd);
                continue;
            }
            else
            {
                symbolTable.enterScope();
            }

        }



        else if (currCmd == "Q")
        {
            string remaining;
            commandStream >> remaining;

            remaining.erase(0, remaining.find_first_not_of(" \t\r"));
            remaining.erase(remaining.find_last_not_of(" \t\r") + 1);



            if (!remaining.empty())
            {
                errorMessage(currCmd);
                continue;
            }
            else
            {
                symbolTable.quit();
            }
        }


        else
        {
            cout << "\tInvalid Command" << endl;
            continue;
        }
    }


    inputFile.close();
    fclose(stdout); 

    return 0;
}

























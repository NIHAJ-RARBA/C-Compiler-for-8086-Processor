// the focus of this file is the report generation, rather than being similar to main.cpp

#include <iostream>
#include <string>
#include <sstream>
#include <fstream>
#include <iomanip>


#include "SymbolTable.cpp"

using namespace std;

string hashFunctionName(int hashFunction)
{
    switch (hashFunction)
    {
        case 0:
            return "SDBM";
        case 1:
            return "Jenkins";
        case 2:
            return "Polynomial Rolling";
        case 3:
            return "Murmur";
        default:
            return "Unknown Hash Function";
    }
}

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

    }

    return true;
}

void errorMessage(const string& command) 
{
    cout << "\tNumber of parameters mismatch for the command " << command << endl;
}


void generateReport(int argc, char* argv[])
{

    ifstream inputFile(argv[1]);


    if (!inputFile.is_open())
    {
        cerr << "Error opening input file: " << argv[1] << endl;
        return;
    }

    
    if (freopen(argv[2], "a", stdout) == NULL) {  // Redirect stdout to output file
        cerr << "Error opening output file: " << argv[2] << endl;
        return;
    }



    
    unsigned int numBuckets;
    inputFile >> numBuckets;
    inputFile.ignore();
    
    unsigned int hashFunction = stoi(argv[3]);
    // cout << argv[3] << endl;

    std::cout.setstate(std::ios_base::failbit);
    
    SymbolTable symbolTable(numBuckets, true, hashFunction);

    string command;
    unsigned int commandCount = 0;

    while (getline(inputFile, command))
    {
        if (command.empty()) 
            continue;

        commandCount++;



        // print command number and the command
        // trim leading and trailing spaces
        command.erase(0, command.find_first_not_of(" \t"));
        command.erase(command.find_last_not_of(" \t") + 1);

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
            string remaining;
            commandStream >> remaining;

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



            if (remaining != "")
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



            if (remaining != "")
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


            if (remaining != "")
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
    


    std::cout.clear();
    cout << "----------------------------------------" << endl;
    cout << "----------------------------------------" << endl;
    cout << "Hash Function: " << hashFunctionName(hashFunction) << endl;
    cout << symbolTable.printStats() << endl;
    cout << "----------------------------------------" << endl;
    std::cout.setstate(std::ios_base::failbit);
    // symbolTable.printAllScopeTables();
    cout << endl;


    inputFile.close();

    
}


int main (int argc, char* argv[])
{
    if (argc < 3) 
    {
        cerr << "Usage: " << argv[0] << " <input_file(test_commands.txt)> <report_output_file(report.txt)>" << endl;
        return 1;
    }

    string hashStr = "0";
    argv[3] = &hashStr[0]; // default hash function

    for (int i = 0; i < 4; i++)
    {
        hashStr[0] = '0' + i;
        std::cout.clear();
        generateReport(argc, argv);
        // cout << "----------------------------------------" << endl;
        // cout << "----------------------------------------" << endl;
    }

    std::cout.clear();
    cout << "---------------------------------------------------------------------------------------------" << endl;
    cout << "\t Hash Function Sources: " << endl;
    cout << "\t\t SBDM : https://www.programmingalgorithms.com/algorithm/sdbm-hash/cpp/" << endl;
    cout << "\t\t Jenkins : https://en.wikipedia.org/wiki/Jenkins_hash_function" << endl;
    cout << "\t\t Polynomial Rolling : https://www.geeksforgeeks.org/polynomial-rolling-hash/" << endl;
    cout << "\t\t Murmur : https://en.wikipedia.org/wiki/MurmurHash" << endl << endl;
    
    cout << "\t\t The implementation of MurmurHash3 is taken from the internet and \r\t\t\tthe author is credited in the MurMurHash3 files." << endl;

    cout << endl;
    cout << "\t\t The other hash functions were implemented during L2 for our hashing offline; \r\t\t\tthus the exact sources are not listed, but a close implementation is." << endl;
    cout << "---------------------------------------------------------------------------------------------" << endl;

    fclose(stdout); // Close the output file
    std::cout.clear();
    return 0;
}





















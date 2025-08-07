#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <map>
#include <sstream>
#include <algorithm>
#include <cctype>

using namespace std;

struct Instruction {
    string originalLine;
    int lineNumber = 0;
    string operator_;
    string operands;
    string type;
    string labelName;
    bool removed = false;
    bool isLabel = false;
    bool isComment = false;
};

class ICGOptimizer {
private:
    vector<Instruction> instructions;
    map<string, int> labels;
    map<string, vector<int>> labelReferences;
    
    string trim(const string& str) {
        size_t start = str.find_first_not_of(" \t\r\n");
        if (start == string::npos) return "";
        size_t end = str.find_last_not_of(" \t\r\n");
        return str.substr(start, end - start + 1);
    }
    
    string toUpper(const string& str) {
        string result = str;
        transform(result.begin(), result.end(), result.begin(), ::toupper);
        return result;
    }
    
    vector<string> getInstructionTokens(const string& str, char delimiter) {
        vector<string> tokens;
        stringstream ss(str);
        string token;
        while (getline(ss, token, delimiter)) {
            tokens.push_back(trim(token));
        }
        return tokens;
    }
    
    bool isLabelLine(const string& line) {
        return line.find(':') != string::npos && !line.empty() && line[0] != ';';
    }

    Instruction parseInstruction(const string& line, int lineNum) {
        Instruction instr;
        instr.originalLine = line;
        instr.lineNumber = lineNum;
        
        string cleanLine = line;
        
    
        size_t commentPos = cleanLine.find(';');
        if (commentPos != string::npos) {
            cleanLine = cleanLine.substr(0, commentPos);
        }
        cleanLine = trim(cleanLine);
        
    
        if (line.empty() || line[0] == ';') {
            instr.type = "comment";
            instr.isComment = true;
            return instr;
        }
        
    
        if (isLabelLine(cleanLine)) {
            instr.type = "label";
            instr.isLabel = true;
            size_t colonPos = cleanLine.find(':');
            instr.labelName = trim(cleanLine.substr(0, colonPos));
            return instr;
        }
        
    
        if (!cleanLine.empty()) {
            instr.type = "instruction";
            vector<string> parts = getInstructionTokens(cleanLine, ' ');
            if (!parts.empty()) {
                instr.operator_ = toUpper(parts[0]);
                if (parts.size() > 1) {
                    string operands = "";
                    for (size_t i = 1; i < parts.size(); i++) {
                        if (i > 1) operands += " ";
                        operands += parts[i];
                    }
                    instr.operands = operands;
                }
            }
        } else {
            instr.type = "empty";
        }
        
        return instr;
    }
    


    vector<string> parseMovOperands(const string& operands) {
        vector<string> result;
        size_t commaPos = operands.find(',');
        if (commaPos != string::npos) {
            result.push_back(trim(operands.substr(0, commaPos)));
            result.push_back(trim(operands.substr(commaPos + 1)));
        }
        return result;
    }
        
public:
    bool readAssemblyFile(const string& filename) {
        ifstream file(filename);
        if (!file.is_open()) {
            cerr << "Error: Cannot open file '" << filename << "'" << endl;
            return false;
        }
        
        string line;
        int lineNumber = 1;
        instructions.clear();

        cout << "Reading assembly file: " << filename << endl;

        while (getline(file, line)) {
            if (!line.empty() || line.find_first_not_of(" \t") != string::npos) {
                Instruction instr = parseInstruction(line, lineNumber);
                instructions.push_back(instr);
            }
            lineNumber++;
        }
        
        file.close();
        return true;
    }
    
    int optimizeMOVInstructions() {
        int optimizedCount = 0;
        
        for (size_t i = 0; i < instructions.size() - 1; i++) {
            Instruction& curr = instructions[i];
            Instruction& next = instructions[i + 1];
            
            if (!curr.removed && !next.removed &&
                curr.type == "instruction" && next.type == "instruction" &&
                curr.operator_ == "MOV" && next.operator_ == "MOV") {
                
                vector<string> currOps = parseMovOperands(curr.operands);
                vector<string> nextOps = parseMovOperands(next.operands);
                
                if (currOps.size() == 2 && nextOps.size() == 2 &&
                    currOps[0] == nextOps[1] && currOps[1] == nextOps[0]) {
                    next.removed = true;
                    optimizedCount++;
                    cout << "Removed redundant MOV at line " << next.lineNumber << endl;
                }
            }
        }
        
        return optimizedCount;
    }
    
    int optimizePushPop() {
        int optimizedCount = 0;
        
        for (size_t i = 0; i < instructions.size() - 1; i++) {
            Instruction& curr = instructions[i];
            Instruction& next = instructions[i + 1];
            
            if (!curr.removed && !next.removed &&
                curr.type == "instruction" && next.type == "instruction" &&
                curr.operator_ == "PUSH" && next.operator_ == "POP" &&
                curr.operands == next.operands) {
                
                curr.removed = true;
                next.removed = true;
                optimizedCount += 2;
                cout << "Removed redundant PUSH/POP pair at lines " 
                         << curr.lineNumber << "-" << next.lineNumber << endl;
            }
        }
        
        return optimizedCount;
    }
    
    int removeUnnecessaryArithmeticOperations() {
        int optimizedCount = 0;
        
        for (auto& instr : instructions) {
            if (!instr.removed && instr.type == "instruction") {
                if ((instr.operator_ == "ADD" || instr.operator_ == "SUB") &&
                    instr.operands.find(", 0") != string::npos) {
                    instr.removed = true;
                    optimizedCount++;
                    cout << "Removed redundant " << instr.operator_ 
                             << " with 0 at line " << instr.lineNumber << endl;
                }
                else if ((instr.operator_ == "MUL" || instr.operator_ == "DIV") &&
                         instr.operands.find(", 1") != string::npos) {
                    instr.removed = true;
                    optimizedCount++;
                    cout << "Removed redundant " << instr.operator_ 
                             << " with 1 at line " << instr.lineNumber << endl;
                }
            }
        }
        
        return optimizedCount;
    }
    
    void findLabelsAndReferences() {
        labels.clear();
        labelReferences.clear();
        
        for (size_t i = 0; i < instructions.size(); i++) {
            if (instructions[i].isLabel && !instructions[i].removed) {
                string labelName = instructions[i].labelName;
                labels[labelName] = i;
                labelReferences[labelName] = vector<int>();
            }
        }
        
        for (size_t i = 0; i < instructions.size(); i++) {
            if (!instructions[i].removed && instructions[i].type == "instruction") {
                for (const auto& labelPair : labels) {
                    const string& labelName = labelPair.first;
                    const string& operands = instructions[i].operands;
                    
                    size_t pos = 0;
                    while ((pos = operands.find(labelName, pos)) != string::npos) {
                        bool isWholeWord = true;
                        
                        if (pos > 0) {
                            char prevChar = operands[pos - 1];
                            if (isalnum(prevChar) || prevChar == '_') {
                                isWholeWord = false;
                            }
                        }
                        
                        if (isWholeWord && pos + labelName.length() < operands.length()) {
                            char nextChar = operands[pos + labelName.length()];
                            if (isalnum(nextChar) || nextChar == '_') {
                                isWholeWord = false;
                            }
                        }
                        
                        if (isWholeWord) {
                            labelReferences[labelName].push_back(i);
                            break;
                        }
                        
                        pos += labelName.length();
                    }
                }
            }
        }
    }
    
    void updateLabelReferences(const string& oldLabel, const string& newLabel) {
        for (auto& instr : instructions) {
            if (!instr.removed && instr.type == "instruction") {
                bool foundReference = false;
                
                size_t pos = 0;
                while ((pos = instr.operands.find(oldLabel, pos)) != string::npos) {
                    bool isWholeWord = true;
                    
                    if (pos > 0) {
                        char prevChar = instr.operands[pos - 1];
                        if (isalnum(prevChar) || prevChar == '_') {
                            isWholeWord = false;
                        }
                    }
                    
                    if (isWholeWord && pos + oldLabel.length() < instr.operands.length()) {
                        char nextChar = instr.operands[pos + oldLabel.length()];
                        if (isalnum(nextChar) || nextChar == '_') {
                            isWholeWord = false;
                        }
                    }
                    
                    if (isWholeWord) {
                        instr.operands.replace(pos, oldLabel.length(), newLabel);
                        foundReference = true;
                        pos += newLabel.length();
                    } else {
                        pos += oldLabel.length();
                    }
                }
                
                if (foundReference) {
                    pos = 0;
                    while ((pos = instr.originalLine.find(oldLabel, pos)) != string::npos) {
                        bool isWholeWord = true;
                        
                        if (pos > 0) {
                            char prevChar = instr.originalLine[pos - 1];
                            if (isalnum(prevChar) || prevChar == '_') {
                                isWholeWord = false;
                            }
                        }
                        
                        if (isWholeWord && pos + oldLabel.length() < instr.originalLine.length()) {
                            char nextChar = instr.originalLine[pos + oldLabel.length()];
                            if (isalnum(nextChar) || nextChar == '_') {
                                isWholeWord = false;
                            }
                        }
                        
                        if (isWholeWord) {
                            instr.originalLine.replace(pos, oldLabel.length(), newLabel);
                            pos += newLabel.length();
                        } else {
                            pos += oldLabel.length();
                        }
                    }
                }
            }
        }
    }
    
    int optimizeRedundantLabels() {
        
        findLabelsAndReferences();
        int optimizedCount = 0;
        
        for (size_t i = 0; i < instructions.size(); i++) {
            if (!instructions[i].removed && instructions[i].isLabel) {
                vector<size_t> consecutiveLabels;
                consecutiveLabels.push_back(i);
                
                size_t j = i + 1;
                while (j < instructions.size() && 
                       instructions[j].isLabel && 
                       !instructions[j].removed) {
                    consecutiveLabels.push_back(j);
                    j++;
                }
                
                if (consecutiveLabels.size() > 1) {
                    string keepLabel = instructions[consecutiveLabels[0]].labelName;
                    
                    for (size_t k = 1; k < consecutiveLabels.size(); k++) {
                        size_t idx = consecutiveLabels[k];
                        string oldLabel = instructions[idx].labelName;
                        instructions[idx].removed = true;
                        optimizedCount++;
                        
                        updateLabelReferences(oldLabel, keepLabel);
                        
                        cout << "Removed redundant label " << oldLabel 
                                 << " at line " << instructions[idx].lineNumber << endl;
                    }
                }
                
                i = j - 1;
            }
        }
        
        return optimizedCount;
    }
    
    int removeUnreferencedLabels() {


        findLabelsAndReferences();
        int optimizedCount = 0;
        
        for (size_t i = 0; i < instructions.size(); i++) {
            if (!instructions[i].removed && instructions[i].isLabel) {
                string labelName = instructions[i].labelName;
                
                if (labelReferences.find(labelName) != labelReferences.end() &&
                    labelReferences[labelName].empty()) {
                    instructions[i].removed = true;
                    optimizedCount++;
                    cout << "Removed unreferenced label " << labelName 
                             << " at line " << instructions[i].lineNumber << endl;
                }
            }
        }
        
        return optimizedCount;
    }
    
    bool writeOptimizedFile(const string& filename) {
        ofstream file(filename);
        if (!file.is_open()) {
            cerr << "Error: Cannot create output file '" << filename << "'" << endl;
            return false;
        }
        
        for (const auto& instr : instructions) {
            if (!instr.removed) {
                file << instr.originalLine << endl;
            }
        }
        
        file.close();
        cout << "Optimized code written to " << filename << endl;
        return true;
    }
    

};

int main(int argc, char* argv[]) {
    if (argc != 3) {
        cout << "Usage: " << argv[0] << " <input_file.asm> <output_file.asm>" << endl;
        cout << "Example: " << argv[0] << " code.asm optimized_code.asm" << endl;
        return 1;
    }
    
    
    string inputFile = argv[1];
    string outputFile = argv[2];
    
    ICGOptimizer optimizer;
    
    if (!optimizer.readAssemblyFile(inputFile))
    {
        return 1;
    }
    
    

    cout << "\nPerforming optimizations..." << endl;
    int totalOptimizations = 0;

    totalOptimizations += optimizer.optimizeMOVInstructions();
    totalOptimizations += optimizer.optimizePushPop();
    totalOptimizations += optimizer.removeUnnecessaryArithmeticOperations();
    totalOptimizations += optimizer.optimizeRedundantLabels();
    totalOptimizations += optimizer.removeUnreferencedLabels();

    cout << "\nTotal optimizations performed: " << totalOptimizations << endl;

    if (!optimizer.writeOptimizedFile(outputFile)) {
        return 1;
    }

    return 0;
}
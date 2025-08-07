#pragma once
#include <iostream>
#include <fstream>
#include <string>
#include "antlr4-runtime.h"
// #include "C8086Lexer.h"
// #include "C8086Parser.h"
#include "C2105055Lexer.h"
#include "C2105055Parser.h"
#include "2105055_icg.hpp"

using namespace antlr4;
using namespace std;

ofstream parserLogFile; // global output stream
ofstream errorFile; // global error stream
ofstream lexLogFile; // global lexer log stream

ofstream ssaLogFile; 
ofstream ssaErrorFile; 
ofstream asmFile; 
ofstream tempFile;

int lineCount; 
// int semanticErrorCount; 

// int syntaxErrorCount;

int main(int argc, const char* argv[]) {
    if (argc < 2) {
        cerr << "Usage: " << argv[0] << " <input_file>" << endl;
        return 1;
    }

    // ---- Input File ----
    ifstream inputFile(argv[1]);
    if (!inputFile.is_open()) {
        cerr << "Error opening input file: " << argv[1] << endl;
        return 1;
    }

    string outputDirectory = "output/";
    // string parserLogFileName = outputDirectory + "parserLog.txt";

    // for .txt files in this format -> x1.txt etc just like the offline, that is
    // string ssaLogFileName = outputDirectory + "log" + argv[1][strlen(argv[1]) - 5] +".txt";
    // string ssaErrorFileName = outputDirectory + "error" + argv[1][strlen(argv[1]) - 5] + ".txt";
    // string lexLogFileName = outputDirectory + "lexerLog" + argv[1][strlen(argv[1]) - 5] + ".txt";

    // for .c files as per spec. but will be used with number like x1.c etc
    // string ssaLogFileName = outputDirectory + "log" + argv[1][strlen(argv[1]) - 3] +".txt";
    // string ssaErrorFileName = outputDirectory + "error" + argv[1][strlen(argv[1]) - 3] + ".txt";
    // string lexLogFileName = outputDirectory + "lexerLog" + argv[1][strlen(argv[1]) - 3] + ".txt";
    
    // for evaluation. non numbered.
    string ssaLogFileName = outputDirectory + "log.txt";
    string ssaErrorFileName = outputDirectory + "error.txt";
    string lexLogFileName = outputDirectory + "lexerLog.txt";

    string asmFileName = outputDirectory + "out.asm";
    string temp = outputDirectory + "temp.asm";
    
    // string errorFileName = outputDirectory + "errorLog.txt";

    // create output directory if it doesn't exist
    system(("mkdir -p " + outputDirectory).c_str());

    // ---- Output Files ----
    // parserLogFile.open(parserLogFileName);
    // if (!parserLogFile.is_open()) {
    //     cerr << "Error opening parser log file: " << parserLogFileName << endl;
    //     return 1;
    // }

    ssaLogFile.open(ssaLogFileName);
    if (!ssaLogFile.is_open()) {
        cerr << "Error opening SSA log file: " << ssaLogFileName << endl;
        return 1;
    }

    ssaErrorFile.open(ssaErrorFileName);
    if (!ssaErrorFile.is_open()) {
        cerr << "Error opening SSA error file: " << ssaErrorFileName << endl;
        return 1;
    }

    asmFile.open(asmFileName);
    if (!asmFile.is_open()) {
        cerr << "Error opening ASM file: " << asmFileName << endl;
        return 1;
    }

    tempFile.open(temp);
    if (!tempFile.is_open()) {
        cerr << "Error opening temp file: " << temp << endl;
        return 1;
    }


    // errorFile.open(errorFileName);
    // if (!errorFile.is_open()) {
    //     cerr << "Error opening error log file: " << errorFileName << endl;
    //     return 1;
    // }

    lexLogFile.open(lexLogFileName);
    if (!lexLogFile.is_open()) {
        cerr << "Error opening lexer log file: " << lexLogFileName << endl;
        return 1;
    }


   
    // ---- Parsing Flow ----
    ANTLRInputStream input(inputFile);
    // C8086Lexer lexer(&input);
    C2105055Lexer lexer(&input);
    CommonTokenStream tokens(&lexer);
    // C8086Parser parser(&tokens);
    C2105055Parser parser(&tokens);

    // this is necessary to avoid the default error listener and use our custom error handling
    parser.removeErrorListeners();

    // start parsing at the 'start' rule
    // parser.start();
    
    tree::ParseTree* parseTree= parser.start(); // for two pass using visitor

    ASMGenerator asmGen;
    asmGen.visit(parseTree);

    // clean up
    inputFile.close();
    
    ssaLogFile.close();
    ssaErrorFile.close();
    asmFile.close();

    // parserLogFile.close();
    // errorFile.close();
    lexLogFile.close();
    cout << "Parsing completed. Check the output files for details." << endl;
    cout << "ASM file generated: " << asmFileName << endl;


    return 0;
}

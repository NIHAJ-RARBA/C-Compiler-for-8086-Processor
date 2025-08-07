#!/bin/bash
set -e
# set -x


# antlr4 -v 4.13.2 -Dlanguage=Cpp C8086Lexer.g4
# antlr4 -v 4.13.2 -Dlanguage=Cpp C8086Parser.g4
# g++ -std=c++17 -w -I/usr/local/include/antlr4-runtime -c C8086Lexer.cpp C8086Parser.cpp headers/SymbolTable.cpp headers/ScopeTable.cpp headers/HashFunctions.cpp Ctester.cpp
# g++ -std=c++17 -w C8086Lexer.o C8086Parser.o Ctester.o SymbolTable.o ScopeTable.o HashFunctions.o -L/usr/local/lib/ -lantlr4-runtime -o Ctester.out -pthread
# LD_LIBRARY_PATH=/usr/local/lib ./Ctester.out $1


antlr4  -Dlanguage=Cpp C2105055Lexer.g4
antlr4  -Dlanguage=Cpp -visitor C2105055Parser.g4

g++ -std=c++17 -w -I/usr/local/include/antlr4-runtime -c C2105055Lexer.cpp C2105055Parser.cpp headers/SymbolTable.cpp headers/ScopeTable.cpp headers/HashFunctions.cpp Ctester.cpp
g++ -std=c++17 -w C2105055Lexer.o C2105055Parser.o Ctester.o SymbolTable.o ScopeTable.o HashFunctions.o -L/usr/local/lib/ -lantlr4-runtime -o Ctester.out -pthread

g++ 2105055_icg_optimizer.cpp -o optimizer.o -std=c++17


LD_LIBRARY_PATH=/usr/local/lib ./Ctester.out $1
./optimizer.o output/out.asm output/optimized_code.asm




#!/bin/bash

# Enable extended globbing for pattern matching
shopt -s extglob

# Loop through all files that do NOT match *.sh, *.g4, or Ctester.cpp
for file in !(*.sh|*.g4|Ctester.cpp|icg.out|printproc.asm|2105055_icg.hpp|2105055_icg_optimizer.cpp); do
# for file in !(*.sh|*.g4|Ctester.cpp|C8086Lexer.h|C8086Parser.h); do
    # Only delete if it's a regular file
    if [[ -f "$file" ]]; then
        rm -f "$file"
    fi
done

# Remove the 'output' directory if it exists
rm -rf output

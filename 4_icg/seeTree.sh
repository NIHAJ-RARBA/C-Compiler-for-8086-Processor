
#!/bin/bash
if [ -z "$1" ]; then
    echo "Usage: $0 <code_file>"
    exit 1
fi

source antlr-env/bin/activate
antlr4-parse C2105055Lexer.g4 C2105055Parser.g4 start -gui < "$1"
deactivate
flex -o 2105055.lex.cpp 2105055.l
g++ 2105055.lex.cpp -o main.out -lfl
./main.out TEST/input$1.txt 

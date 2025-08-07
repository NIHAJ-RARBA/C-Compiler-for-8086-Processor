g++ main.cpp -fsanitize=address -g -o main
./main in.txt out.txt
g++ generate_report.cpp -fsanitize=address -g -o rep
./rep test_commands.txt report.txt
./rep in2.txt report2.txt
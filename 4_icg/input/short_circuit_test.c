/*
1
5
2
4
3
2
4
11
5
0
0
6
1
2
3
7
1
0
*/
int main()
{
    int i;
    int j;
    int k;
    int x;
    
    // Test 1: OR short-circuit - first operand true, second should NOT 
    x = 1;
    println(x);

    i = 5;
    if(i == 5 || i++ == 6)
    {
        println(i);
    }
    
    // Test 2: OR no short-circuit - first operand false, second SHOULD execute  
    x = 2;
    println(x);

    j = 3;
    if(j == 4 || j++ == 3)
    {
        println(j);
    }
    
    // Test 3: AND short-circuit - first operand false, second should NOT execute
    x = 3;
    println(x);

    k = 2;
    if(k == 3 && k++ == 2)
    {
        println(k);
    }
    println(k);
    
    // Test 4: AND no short-circuit - first operand true, second SHOULD execute
    x = 4;
    println(x);


    i = 10;
    if(i == 10 && i++ == 10)
    {
        println(i);
    }
    
    // Test 5: Simple nested conditions
    
    x = 5;
    println(x);

    j = 0;
    k = 0;
    if(j == 0 || k++ == 1)
    {
        println(j);
        println(k);
    }
    
    // Test 6: Multiple AND conditions
    x = 6;
    println(x);


    i = 1;
    j = 2;
    k = 3;
    if(i == 1 && j == 2)
    {
        println(i);
        println(j);  
        println(k);
    }
    
    // Test 7: OR with first condition true (should short-circuit)
    x = 7;
    println(x);

    
    i = 1;
    j = 0; 
    if(i == 1 || j++ == 1)
    {
        println(i);
        println(j);
    }
}
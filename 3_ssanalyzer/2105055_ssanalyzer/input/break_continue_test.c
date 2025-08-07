int var(int a, int b)
{
    break;
    return a + b;
}
int main()
{
    float d;
    d = var(1, 2 * 3) + 3.5 * 2;
    int j, k;
    int i = 0;

    for (j = 0; j < 5; j++)
    {
        if (j == 2)
            continue;
        if (j == 4)
            break;
        i = i + j;
    }

    do
    {
        if (i == 3)
            break;
        i++;
    } while (i < 5);

    while (i < 10)
    {
        if (i == 7)
            continue;
        i++;
    }

    break;
    break;
    continue;


    for (k = 0; k < 5; k++)
    {
        while(k < 3)
        {
            if (k == 1)
                continue;
            k++;
            do
            {
                if (k == 2)
                    break;
                k++;
            } while (k < 5);
        }
        if (k == 4)
        {
            break;
        }
    }

    if (i == 9)
        continue;


    return 0;
}
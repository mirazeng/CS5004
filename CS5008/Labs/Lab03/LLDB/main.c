#include <stdio.h>


int try_pointer() {
    int *pointer = NULL;
    *pointer = 25;
    return 0;
}


int main()
{
    try_pointer();
    // this is not working because the segmentation fault
    printf("Hello, World!\n");
    return 0;
}

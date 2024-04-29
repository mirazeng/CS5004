#include <stdio.h>

// gcc -g bugmain.c -o bug
// ./bug
// lldb ./bug


void func1() {
    int *ptr = NULL;
    *ptr = 9;
    printf("The value of ptr is: %d\n", *ptr);
}

void func2() {
    func1();
}

int main() {
    func2();
}


// test cases: 5,
#include <stdio.h>

int mountain_star(int num) {

    // rows need to be printed based on input number
    for (int i = 1; i <= num; i++) {
        // count spaces for each row and print
        int space = num - i;
        for (int e = 1; e <= space; e++) {
            printf(" ");
        }
        // count stars for each row and print
        int count = 2 * i - 1;
        for (int q = 1; q <= count; q++) {
            printf("*");
        }
        // a line breaker
        printf("\n");
    }
    // function ends
    return 0;
}

int main() {
    // initialize an integer variable
    int num;

    // prompt for user input
    printf("Please enter a positive integer: ");

    // read user input
    scanf("%d", &num);

    // call function
    mountain_star(num);
}
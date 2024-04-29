// test cases: num = -5, d, 0, !
#include <stdio.h>

int power_of_two(int num) {

    // initialize variable with bitwise AND operation
    int bit = num & (num - 1);

    // check if the outcome is 0
    if(bit == 0) {
        printf("%d is a power of 2", num);
    } else {
        printf("%d is not power of 2", num);
    }
    // a liner breaker
    printf("\n");
    // function ends
    return 0;
}

int main() {

    // initialize integer variable
    int num;

    // prompt user for input
    printf("Please enter a positive integer: ");

    // read user input
    scanf("%d", &num);

    // Make sure the input number is positive
    if (num < 0) {
        printf("The entered number should be positive");
    } else {
        // call function
        power_of_two(num);
    }
}
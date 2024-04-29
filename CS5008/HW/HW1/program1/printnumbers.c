// gcc printnumbers.c -o printNumbers
// ./printNumbers

#include <stdio.h>
#include <stdlib.h>

int main() {
    // Initialize variables and assign data type
    int a;
    int b;

    // Input prompt and expect an integer
    printf("Please enter an integer: ");
    // Read user's answer
    scanf("%d", &a);

    printf("Please enter an integer again: ");
    scanf("%d", &b);

    // Compare a and b, ensure a < b
    if (a > b || a == b) {
        printf("Please make sure the first number is smaller than the second");
        exit(0);
    } else {
        // to get every number between a and b in ascending order
        for (int i = a; i <= b; i++) {
            printf("%d", i);
            // no space after the last number
            if (i < b) {
                printf(" ");
            }
        }
        // line breaker
        printf("\n");
        // to get every number between a and b in descending order
        for (int n = b; n >= a; n--) {
            printf("%d", n);
            // no space after the last number
            if (n > a) {
                printf(" ");
            }
        }
        // line breaker
        printf("\n");

        // Initialize a pointer 'left' for integer a
        int *left = &a;
        // Initialize a pointer 'right' for integer b
        int *right = &b;

        // Dereferencing the value
        while (*left <= *right) {
            // if 'left' and 'right' pointer meets
            if (*left == *right) {
                // Print the number and then stop where two pointer meet up
                printf("%d", *left);
                break;
            } else {
                printf("%d ", *left); // Print the number from the 'left'
                printf("%d ", *right); // Print the number from the 'right'
            }
            (*left)++; // 'left' pointer increment
            (*right)--; // 'right' pointer decrement
        }
        printf("\n");
        return 0;
    }
}


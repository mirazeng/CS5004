#include <stdio.h>
#include "bits.h"

// main driver
int main() {
    // Initialize variable
    int num;
    // Prompt user input
    printf("Please enter an integer: ");
    // Read user input and store in variable
    scanf("%d", &num);
    // Call function
    countOne(num);
}
#include <stdio.h>
#include <stdlib.h>
#include "bits.h"

// Implementation file - define the function
int countOne(int num) {
    // Make sure the input number is positive
    if (num < 0) {
        printf("The entered number should be positive");
        exit(0);
    } else {
        // Initialize a tracker to count the 1
        int counter = 0;
        // Store the input number
        int ogNum = num;


        while (num > 0) {
            // Check if modular is 1
            if (num % 2 == 1) {
                // Increment when 1 shows
                counter++;
            }
            // right shift in bit = positive number / 2
            num = num >> 1;
            printf("%d",num);
        }
        printf("the number of 1s in %d is %d in "
               "its binary representation", ogNum, counter);
        printf("\n");
        return counter;
    }
}
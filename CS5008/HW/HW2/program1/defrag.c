#include <stdio.h>

// this function moves all the -1s to the end of the array
// by swapping the left first -1 with the right first non -1 value
void defragment(int *array, int size)
{
    // initialize the left pointer moving to the right
    // in a loop through the array
    for (int left = 0; left < size; left++) {
        // until meet the first -1 in the array
        if (array[left] == -1) {
            // initialize the right pointer moving to the left
            // in a loop through the array
            for (int right = left; right < size; right++) {
                // until meet the first non -1 in the array
                if (array[right] != -1) {
                    // swap the two values based on the pointers
                    int temp = array[right]; // a temp variable to store the value of the left pointer
                    array[left] = temp;
                    array[right] = -1;
                    break;
                }
            }
        }
    }
    // Print the array with a for loop by using an iterator i
    for (int i = 0; i < size; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
}
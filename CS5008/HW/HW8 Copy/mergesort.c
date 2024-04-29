#include "mergesort.h"
#include <string.h>
#include <stdlib.h>

#ifdef LOG

#include "logger.h"

extern log_t logger;

#endif

// a merge function that compares given arrays and merge them in a sorted order
void merge_function(int *array, int *temp, int left, int mid, int right)

{
    // handle empty given arrays
    if (array == NULL) {
#ifdef LOG
        logger_add(2); // conditional comparison, one return
#endif
        return;
    }
    // handle invalid indices
    if (left < 0 || right < 0) {
#ifdef LOG
        logger_add(3); // two conditional comparison, one return
#endif
        return;
    }
    // handle empty temp array
    if (temp == NULL) {
#ifdef LOG
        logger_add(2); // conditional comparison, one return
#endif
        return;
    }

    // initialize trackers
    int i, j, k;

    i = left; // start of the left bound
#ifdef LOG
    logger_add(1); // assign variable
#endif

    j = mid + 1; //  start of the right bound
#ifdef LOG
    logger_add(2); // assign variable and one operation
#endif

    k = 0; // starting index of the temp array
#ifdef LOG
    logger_add(1); // assign variable
#endif

    // merge process

    // compare elements from left beginning to mid and from mid to right
    while (i <= mid && j <= right) {
#ifdef LOG
        logger_add(2); // comparisons in while loop conditions
#endif
        if (array[i] <= array[j]) {
#ifdef LOG
            logger_add(1); // comparison
#endif
            temp[k] = array[i];
#ifdef LOG
            logger_add(1); // put sorted element in temp
#endif
            i++;
#ifdef LOG
            logger_add(2); // increment i
#endif
        } else {
            temp[k] = array[j];
#ifdef LOG
            logger_add(1); // put sorted element in temp
#endif
            j++;
#ifdef LOG
            logger_add(2); // increment j
#endif
        }
        k++;
#ifdef LOG
        logger_add(2); // increment k
#endif
    }

    // make sure to merge the remaining elements
    while (i <= mid) {
#ifdef LOG
        logger_add(1); //comparisons in while loop conditions
#endif
        temp[k] = array[i];
#ifdef LOG
        logger_add(1); // put sorted element in temp
#endif
        i++;
#ifdef LOG
        logger_add(2); // increment i
#endif
        k++;
#ifdef LOG
        logger_add(2); // increment k
#endif
    }
    while (j <= right) {
#ifdef LOG
        logger_add(1); //comparisons in while loop conditions
#endif
        temp[k] = array[j];
#ifdef LOG
        logger_add(1); // put sorted element in temp
#endif
        j++;
#ifdef LOG
        logger_add(2); // increment j
#endif
        k++;
#ifdef LOG
        logger_add(2); // increment k
#endif
    }

#ifdef LOG
    logger_add(1); // assign start to 0
#endif
    for (int start = 0; start < k; start++) {
#ifdef LOG
        logger_add(3);
#endif
        array[left + start] = temp[start];
#ifdef LOG
        logger_add(2);
#endif
    }
#ifdef LOG
    logger_add(2); // call function
#endif
}

// a recursive merge sort function that sorts two sorted halves of an array
void merge_sort(int *array, int *temp, int left, int right)
{
    // handle empty cases
    if (array == NULL) {
#ifdef LOG
        logger_add(4); // conditional comparisons, one return, one function call
#endif
        return;
    }
    if (left < 0 || right < 0) {
#ifdef LOG
        logger_add(5); // conditional comparisons, one return. one function call
#endif
        return;
    }
    if (temp == NULL) {
#ifdef LOG
        logger_add(4); // conditional comparison, one return, one function call
#endif
        return;
    }
    // make sure the sorted element is greater than 1
    if (left < right) {
#ifdef LOG
        logger_add(1); //comparison in while loop conditions
#endif
        // find the midpoint
        int mid = left + (right - left) / 2; // avoid overflow
#ifdef LOG
        logger_add(4); // one assignment and one and three operations
#endif

        // recursively sort the left and right halves
        merge_sort(array, temp, left, mid);
#ifdef LOG
        logger_add(2); //call helper function
#endif

        merge_sort(array, temp, mid + 1, right); // conquer
#ifdef LOG
        logger_add(2); //call helper function
#endif

        // combine the sorted halves into single sorted element
        merge_function(array, temp, left, mid, right);
#ifdef LOG
        logger_add(2); //call helper function
#endif
    } else {

#ifdef LOG
        logger_add(3); //return + function call
#endif
        return;
    }
}

// a top-down merge implementation
// time complexity: O(n log n)
// space complexity: O(n)
void td_mergesort(int *array, int size)
{
    // handle empty cases
    if (array == NULL) {
#ifdef LOG
        logger_add(4); // conditional comparison, one return, one function call
#endif
        return;
    }
    if (size <= 1) {
#ifdef LOG
        logger_add(4); // conditional comparison, one return, one function call
#endif
        return;
    }
    // create a temporary array to store the sorted elements
    int *temp = (int *)malloc(size * sizeof(int));
#ifdef LOG
    logger_add(6); // malloc 2, sizeof 2, one assignment, one operation
#endif

    // sort the given array
    merge_sort(array, temp, 0, size - 1);
#ifdef LOG
    logger_add(1); // arithmetic operation
#endif
    // free the temporary array
    free(temp);
#ifdef LOG
    logger_add(2); //call helper function
#endif
}




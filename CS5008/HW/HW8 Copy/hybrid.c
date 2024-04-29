#include "stdlib.h"

#ifdef LOG

#include "logger.h"

extern log_t logger;

#endif


// a merge function that compares given arrays and merge them in a sorted order
void merge(int *array, int *temp, int left, int mid, int right)
{
    // handle empty given arrays
    if (array == NULL) {
        return;
    }
#ifdef LOG
    logger_add(2);
#endif
    // handle invalid indices
    if (left < 0 || right < 0) {
        return;
    }
#ifdef LOG
    logger_add(3);
#endif
    // handle empty temp array
    if (temp == NULL) {
        return;
    }
#ifdef LOG
    logger_add(2);
#endif
    // initialize trackers
    int i, j, k;

    i = left; // start of the left bound
    j = mid + 1; //  start of the right bound
    k = 0; // starting index of the temp array
#ifdef LOG
    logger_add(4);
#endif

    // merge process

    // compare elements from left beginning to mid and from mid to right
    while (i <= mid && j <= right) {
#ifdef LOG
        logger_add(2);
#endif
        if (array[i] <= array[j]) {
#ifdef LOG
            logger_add(1);
#endif
            temp[k] = array[i];
#ifdef LOG
            logger_add(1);
#endif
            i++;
#ifdef LOG
            logger_add(2);
#endif
        } else {
            temp[k] = array[j];
#ifdef LOG
            logger_add(1);
#endif
            j++;
#ifdef LOG
            logger_add(2);
#endif
        }
        k++;
#ifdef LOG
        logger_add(2);
#endif
    }
    // make sure to merge the remaining elements
    while (i <= mid) {
#ifdef LOG
        logger_add(1);
#endif
        temp[k] = array[i];
        i++;
        k++;
#ifdef LOG
        logger_add(5);
#endif
    }
    while (j <= right) {
#ifdef LOG
        logger_add(1);
#endif
        temp[k] = array[j];
        j++;
        k++;
#ifdef LOG
        logger_add(5);
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

void insertion_sort(int *A, int left, int right)
{
#ifdef LOG
    logger_add(2);
#endif
    for (int i = left + 1; i <= right; i++) {
#ifdef LOG
        logger_add(3);
#endif
        int element = A[i];
#ifdef LOG
        logger_add(1); // assign
#endif
        int j = i - 1;
#ifdef LOG
        logger_add(2); // assign
#endif
        while (j >= left && A[j] > element) {
#ifdef LOG
            logger_add(2); // 2 comparisons in while loop conditions
#endif
            A[j + 1] = A[j];
#ifdef LOG
            logger_add(2);
#endif
            j = j - 1;
#ifdef LOG
            logger_add(2);
#endif
        }
        A[j + 1] = element;
    }
#ifdef LOG
    logger_add(2); // call function
#endif
}

void hybrid_sort_with_condition(int *A, int *temp, int left, int right)
{
    if ((right - left + 1) <= 20) {
#ifdef LOG
        logger_add(3); // arithmetic operation and comparison
#endif
        insertion_sort(A, left, right);
#ifdef LOG
        logger_add(3); // call function + return
#endif
        return;
    }

    if (left < right) {
#ifdef LOG
        logger_add(1);
#endif
        int mid = left + (right - left) / 2;
#ifdef LOG
        logger_add(4); // arithmetic operation and assign
#endif
        hybrid_sort_with_condition(A, temp, left, mid);
#ifdef LOG
        logger_add(2); // call function
#endif
        hybrid_sort_with_condition(A, temp, mid + 1, right);
#ifdef LOG
        logger_add(3); // call function + arithmetic operation
#endif
        merge(A, temp, left, mid, right);
#ifdef LOG
        logger_add(2); // call function
#endif
    }
}


void hybrid(int *A, int size)
{
    int *temp = (int *)malloc(size * sizeof(int));
#ifdef LOG
    logger_add(6); // 2 function calls + arithmetic operation + assign
#endif
    hybrid_sort_with_condition(A, temp, 0, size - 1);
#ifdef LOG
    logger_add(3); // call function + arithmetic operation
#endif
    free(temp);
#ifdef LOG
    logger_add(2); // call function
#endif
}
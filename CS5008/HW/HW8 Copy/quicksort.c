#include <stdlib.h>
#include "quicksort.h"

#ifdef LOG

#include "logger.h"

extern log_t logger;

#endif

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
#ifdef LOG
    logger_add(3); // one assignment and two swaps
#endif
#ifdef LOG
    logger_add(2); //call function
#endif
}

int make_partition(int *A, int start, int end)
{
    int pivot_index = start + rand() % (end - start + 1);
#ifdef LOG
    logger_add(7); // 4 arithmetic, 1 call, 1 assignment
#endif

    swap(&A[pivot_index], &A[end]);


    int pivot = A[end];
#ifdef LOG
    logger_add(1); // assign variable
#endif
    int j = start - 1;
#ifdef LOG
    logger_add(2); // assign variable and one operation
#endif


#ifdef LOG
    logger_add(1); // assign 1 to i
#endif

    for (int i = start; i <= end - 1; i++) {
#ifdef LOG
        logger_add(4); //operating on iteration variable costs 4 every loop
#endif
        if (A[i] < pivot) {
#ifdef LOG
            logger_add(1); //comparisons in while loop conditions
#endif
            j++;
#ifdef LOG
            logger_add(2); // increment j
#endif
            swap(&A[i], &A[j]);
        }
    }
    swap(&A[j + 1], &A[end]);
#ifdef LOG
    logger_add(1); //call helper function: swap function and one operation
#endif

#ifdef LOG
    logger_add(4); //return + function call
#endif
    return j + 1;
}

void sort_left_and_right(int *A, int start, int end)
{
    if (start < end) {
#ifdef LOG
        logger_add(1); // conditional comparison
#endif

        int piv = make_partition(A, start, end);
#ifdef LOG
        logger_add(1);
#endif

        sort_left_and_right(A, start, piv - 1);
#ifdef LOG
        logger_add(1);
#endif

        sort_left_and_right(A, piv + 1, end);
#ifdef LOG
        logger_add(1);
#endif
    }
#ifdef LOG
    logger_add(2); //call helper function
#endif
}

void quicksort(int *A, int size)
{
    if (size == 0) {
#ifdef LOG
        logger_add(4); // conditional comparison, one return
#endif
        return;
    }
    if (size == 1) {
#ifdef LOG
        logger_add(4); // conditional comparison, one return
#endif
        return;
    }
    sort_left_and_right(A, 0, size - 1);

#ifdef LOG
    logger_add(1);
#endif

#ifdef LOG
    logger_add(2);
#endif
}
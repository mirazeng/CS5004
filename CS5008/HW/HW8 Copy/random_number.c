#include <stdlib.h>
#include <stdio.h>
#include "logger.h"
#include "random_number.h"
#include "mergesort.h"
#include "quicksort.h"
#include "insertionsort.h"
#include "hybrid.h"

int *random_data(int n)
{
    int* A = malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        A[i] = rand() % n;
    }
    return A;
}

// a higher order function that takes a sorting function and an array and sorts the array
void sort(int *A, int size, void (*sorting_function)(int *, int))
{
    sorting_function(A, size);
}

void copy_array(int new[], int const old[], int size)
{
    for (int i = 0; i < size; i++) {
        new[i] = old[i];
    }
}

int main()
{
    srand(200);

    int array_size[] = {5, 20, 100,500,
                        1000, 5000,
                        10000, 50000, 100000,
                       500000,1000000};

    for (int diff_size = 0; diff_size < 11; diff_size++) {

        printf("\n===== Array with %d random elements =====\n", array_size[diff_size]);

        for (int i = 1; i <= 5; i++) {
            int *A = random_data(array_size[diff_size]);

            int A_copy_1[array_size[diff_size]];
            copy_array(A_copy_1, A, array_size[diff_size]);

            int A_copy_2[array_size[diff_size]];
            copy_array(A_copy_2, A, array_size[diff_size]);

            int A_copy_3[array_size[diff_size]];
            copy_array(A_copy_3, A, array_size[diff_size]);

            printf("\n=== this is %dth test ===\n", i);

//            logger_reset();
//            sort(A_copy_1, array_size[diff_size], &insertionsort);
//            printf("Total steps taken for insertion sort: %lld\n", logger.num_steps);

            logger_reset();
            sort(A_copy_1, array_size[diff_size], &hybrid);
            printf("Total steps taken for hybrid sort: %lld\n", logger.num_steps);

//            logger_reset();
//            sort(A_copy_2, array_size[diff_size], &td_mergesort);
//            printf("Total steps taken for top-down mergesort: %lld\n", logger.num_steps);

//
//            logger_reset();
//            sort(A_copy_3, array_size[diff_size], &quicksort);
//            printf("Total steps taken for quicksort: %lld\n", logger.num_steps);

            free(A);
            //Cleanup the memory

        }
    }
}

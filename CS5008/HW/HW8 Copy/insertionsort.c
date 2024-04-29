

#ifdef LOG

#include "logger.h"

extern log_t logger;  //the global variable logger from logger.h. "extern" means it is defined elsewhere.
                     // This makes the compiler happy, but the linker would need to find it.
#endif

#include "insertionsort.h"

void insertionsort(int *A, int size)
{
    int i;
    int j;
    int key;

#ifdef LOG
    logger_add(1); // assign 1 to i
#endif
    for (i = 1; i < size; i++) {
#ifdef LOG
        logger_add(3); // operating on iteration variable costs 3 every loop
#endif
        key = A[i];
#ifdef LOG
        logger_add(1); // assign
#endif
        j = i - 1;
#ifdef LOG
        logger_add(2); // i-1 costs one, assign to j costs one
#endif


        while (j >= 0 && A[j] > key) {
#ifdef LOG
            logger_add(2); // 2 comparisons in while loop conditions
#endif

#ifdef LOG
            logger_add(2); // assignment and j+1 each costs 1
#endif
            A[j + 1] = A[j];

#ifdef LOG
            logger_add(2); // minus and assignment each costs 1
#endif
            j = j - 1;
        }
#ifdef LOG
        logger_add(2); // j+1 and assignment
#endif
        A[j + 1] = key;
    }
#ifdef LOG
    logger_add(2); // call function
#endif
}


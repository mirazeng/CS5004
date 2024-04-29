// gcc -g hashtable.c try_hashtable.c -o hash
// valgrind --leak-check=full --show-leak-kinds=all ./hash

#include "hashtable.h"
#include <stdio.h>
#include <stdbool.h>

int main()
{
    // starter code
    hashtable_t *table = create_hashtable(12);

    hashtable_add(table, "the");
    hashtable_add(table, "blue");
    hashtable_add(table, "whale");
    hashtable_add(table, "is");
    hashtable_add(table, "so");
    hashtable_add(table, "big");

    bool present;

    present = hashtable_contains(table, "is");
    printf("Is \"is\" present? %d\n", present);

    present = hashtable_contains(table, "big");
    printf("Is \"big\" present? %d\n", present);

    present = hashtable_contains(table, "Big");
    printf("Is \"Big\" present? %d\n", present);

    present = hashtable_contains(table, "whales");
    printf("Is \"whales\" present? %d\n", present);

    delete_hashtable(table);
}

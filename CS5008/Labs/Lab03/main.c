// gcc main.c mylist.c -o main
// ./main

#include <stdio.h>
#include "mylist.h"

int main()
{
    list_t l;

    //create an empty list
    make_empty_list(&l);

    // create the list 2 -> 3 -> 4;
    add_front(&l, 4);
    add_front(&l, 3);
    add_front(&l, 2);

    // add back to list
    add_back(&l, 5);
    add_back(&l, 6);
    add_back(&l, 7);
    add_back(&l, 8); // 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8

    //print the contents
    print_list(&l);
    printf("This deque has %d element(s) in total.",list_size(&l));

    //done, so clean up
    delete_list(&l);
}

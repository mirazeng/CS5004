// gcc testmain.c mylist.c -o testmain
// ./testmain

#include <stdio.h>
#include "mylist.h"

// test make_empty_list by checking if the head and tail are NULL
int test_make_empty_list()
{
    printf("---Test test_make_empty_list begin: ---\n");
    list_t my_list;
    make_empty_list(&my_list);

    if (my_list.head != NULL || my_list.tail != NULL) {
        printf("make_empty_list failed, because either %p or %p is not NULL\n", my_list.head, my_list.tail);
        return 0;
    }
    printf("---Test test_make_empty_list end ---\n");
    delete_list(&my_list);
    printf("\n");
    return 1;
}

// test add_front by checking if the head and tail are not NULL
int test_add_front_to_empty_list()
{
    printf("\n---Test test_add_front_to_empty_list begin: ---\n");

    list_t my_list;
    make_empty_list(&my_list);
    add_front(&my_list, 1);

    if (my_list.head->data != 1) {
        printf("my_list failed, my_list head should be 1 but it is %d\n", my_list.head->data);
        return 0;
    } else if (my_list.tail == NULL) {
        printf("my_list failed, tail should not be Null but it is null \n");
        return 0;
    } else if (my_list.head != my_list.tail) {
        printf("my_list failed, head and tail should be the same but they are not.\n");
        return 0;
    }

    printf("---Test test_add_front_to_empty_list end---\n");
    delete_list(&my_list);
    printf("\n");
    return 1;
}

// test add_front by checking if the head and tail data are as expected
int test_add_front_one_element_list()
{
    printf("\n---Test test_add_front_one_element_list begin: ---\n");

    list_t my_list;
    make_empty_list(&my_list);
    add_front(&my_list, 0);

    // add 5 elements in the front of this list
    for (int i = 1; i <= 5; ++i) {
        add_front(&my_list, i);
        if (my_list.head->data != i) {
            printf("add_front failed, list head should be %d but it is %d.\n", i, my_list.head->data);
            return 0;
        }
            // Check if tail data is not as expected
            // Tail should still point to the one with 0 as data
        else if (my_list.tail->data != 0) {
            printf("add_front failed, list tail should be 0 but it is %d.\n", my_list.tail->data);
            return 0;
        }
    }
    printf("---Test test_add_front_one_element_list end---\n");
    delete_list(&my_list);
    printf("\n");
    return 1;
}

// test add_front by checking if the head and tail data are as expected
int test_add_front_regular_list()
{
    printf("\n---Test test_add_front_regular_list begin: ---\n");

    list_t my_list;
    make_empty_list(&my_list);
    add_front(&my_list, 0);

    // add 5 elements in the front of this deque
    for (int i = 1; i <= 5; ++i) {
        add_front(&my_list, i);
    }

    add_front(&my_list, 6);

    // the head should be 5 and the tail should be 11
    if (my_list.head->data != 6) {
        printf("add_front failed: list head should be 6 but it is %d.\n", my_list.head->data);
        return 0;
    }
        // Check if tail data is not as expected
        // which should still be 0
    else if (my_list.tail->data != 0) {
        printf("add_front failed: list tail should be 0 but it is %d.\n", my_list.tail->data);
        return 0;
    }

    printf("---Test test_add_front_regular_list end---\n");
    delete_list(&my_list);
    printf("\n");
    return 1;
}

int test_add_back_to_empty_list()
{
    printf("\n---Test test_add_back_to_empty_list begin: ---\n");

    list_t my_list;
    make_empty_list(&my_list);
    add_back(&my_list, 5);

    // Check if head data is not as expected
    if (my_list.head->data != 5) {
        printf("add_back failed, list head should be 5 but it is %d.\n", my_list.head->data);
        return 0;
    } else if (my_list.head != my_list.tail) {
        printf("add_back failed, head and tail should be the same but they are not.\n");
        return 0;
    }
        // Check if tail is unexpectedly NULL (Note: In a well-functioning linked list, tail should NOT be NULL after add_back)
    else if (my_list.tail == NULL) {
        printf("add_back failed, tail should not be NULL but it is.\n");
        return 0;
    }
    printf("---Test test_add_back_to_empty_list end---\n");
    delete_list(&my_list);
    printf("\n");
    return 1;
}

int test_add_back_to_one_element_list()
{
    printf("\n---Test test_add_back_to_one_element_list begin: ---\n");

    list_t my_list;
    make_empty_list(&my_list);
    add_back(&my_list, 5);

    // Add elements 6 through 10 and check after each addition
    for (int i = 6; i <= 10; i += 1) {
        add_back(&my_list, i);

        if (my_list.head->data != 5) {
            printf("add_back failed, list head should be 5 but it is %d.\n", my_list.head->data);
            return 0;
        }
        // Check if tail data is not as expected
        if (my_list.tail->data != i) {
            printf("add_back failed, list tail should be %d but it is %d.\n", i, my_list.tail->data);
            return 0;
        }
    }
    printf("---Test test_add_back_to_one_element_list end---\n");
    delete_list(&my_list);
    printf("\n");
    return 1;
}

int test_add_back_to_regular_list()
{
    printf("\n---Test test_add_back_to_regular_list begin: ---\n");

    list_t my_list;
    make_empty_list(&my_list);

    // Make a list with 5 elements (6 to 10), checking after each addition
    for (int i = 5; i <= 10; i += 1) {
        add_back(&my_list, i);
    }

    // add 11 to the back of this deque
    add_back(&my_list, 11);

    // the head should be 5 and the tail should be 11
    if (my_list.head->data != 5) {
        printf("add_back failed: deque head should be 5 but it is %d.\n", my_list.head->data);
        return 0;
    }
    if (my_list.tail->data != 11) {
        printf("add_back failed: deque tail should be 11 but it is %d.\n", my_list.tail->data);
        return 0;
    }
    printf("---Test test_add_back_to_regular_list end---\n");
    delete_list(&my_list);
    printf("\n");
    return 1;
}

int test_list_size_empty()
{
    printf("\n---Test test_list_size_empty begin: ---\n");

    list_t my_list;
    make_empty_list(&my_list);

    if (list_size(&my_list) != 0) {
        printf("list_size failed, list size should be NULL but it is %d\n", list_size(&my_list));
        return 0;
    }
    printf("---Test test_list_size_empty end---\n");
    delete_list(&my_list);
    printf("\n");
    return 1;
}

int test_list_size_regular()
{
    printf("\n---Test test_list_size_regular begin: ---\n");

    list_t my_list;
    make_empty_list(&my_list);

    // make a list with 5 elements from 5 to 10
    for (int i = 5; i <= 10; i += 1) {

        add_back(&my_list, i);

        if (list_size(&my_list) != i - 4) {
            printf("list_size failed, list size should be %d but it is %d\n", i, list_size(&my_list));
            return 0;
        }
    }

    printf("---Test test_list_size_regular end---\n");
    delete_list(&my_list);
    printf("\n");
    return 1;
}


int main()
{
    int passed = 0;
    int total = 0;

    passed += test_make_empty_list();
    total += 1;

    passed += test_add_front_to_empty_list();
    total += 1;

    passed += test_add_front_one_element_list();
    total += 1;

    passed += test_add_front_regular_list();
    total += 1;

    passed += test_add_back_to_empty_list();
    total += 1;

    passed += test_add_back_to_one_element_list();
    total += 1;

    passed += test_add_back_to_regular_list();
    total += 1;

    passed += test_list_size_empty();
    total += 1;

    passed += test_list_size_regular();
    total += 1;

    printf("Passed %d out of %d tests.\n", passed, total);
    return 0;
}
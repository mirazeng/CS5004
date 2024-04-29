// gcc -g tests_dlist.c dlist.c logger.c -o tests
// ./tests

#include "dlist.h"
#include <stdio.h>

// Test if the init function initializes the list correctly
int test_init()
{
    printf("---Test test_init begin: ---\n");
    list *list = init();

    if (list->head != NULL || list->tail != NULL) {
        printf("expected result head should be NULL and tail should be NULL "
               "but got head: %p and tail: %p\n", list->head, list->tail);
        destroy(list);
        return 0;
    }
    if (list->length != 0) {
        printf("The result does not match and expected length be 0 "
               "but length is %d\n", list->length);
        destroy(list);
        return 0;
    }
    printf("---Test test_init end:---\n");
    destroy(list);
    return 1;
}

int test_add_front_empty()
{

    printf("\n---Test test_add_front_empty begin: ---\n");
    list *list = init();
    add_front(list, 1);
    if (list->head->element != 1 || list->tail->element != 1) {
        printf("expected result head and tail should be 1 "
               "but head is %d and tail is %d\n", list->head->element, list->tail->element);
        destroy(list);
        return 0;
    }
    if (list->length != 1) {
        printf("The result does not match: expected length: 1 "
               "but length is %d\n", list->length);
        destroy(list);
        return 0;
    }
    printf("---Test test_add_front_empty end:---\n");
    destroy(list);
    return 1;
}

int test_add_front_regular()
{
    printf("\n---Test test_add_front_regular begin: ---\n");
    list *list = init();
    add_front(list, 1);
    add_front(list, 2);
    add_front(list, 3);
    add_front(list, 4);

    if (list->head->element != 4 || list->tail->element != 1) {
        printf("expected result head should be 4 and tail should be 1 "
               "but head be %d and tail be %d\n", list->head->element, list->tail->element);
        destroy(list);
        return 0;
    }
    if (list->length != 4) {
        printf("The result does not match: expected length: 4 "
               "but length is %d\n", list->length);
        destroy(list);
        return 0;
    }
    printf("---Test test_add_front_regular end:---\n");
    return 1;
}

int test_add_back_empty()
{
    printf("\n---Test test_add_back_empty begin: ---\n");
    list *list = init();
    add_back(list, 1);
    if (list->head->element != 1 || list->tail->element != 1) {
        printf("expected result head and tail should be 1 "
               "but head is %d and tail is %d\n", list->head->element, list->tail->element);
        destroy(list);
        return 0;
    }
    if (list->length != 1) {
        printf("The result does not match: expected length: 1 "
               "but length is %d\n", list->length);
        destroy(list);
        return 0;
    }
    printf("---Test test_add_back_empty end:---\n");
    destroy(list);
    return 1;
}

int test_add_back_regular()
{
    printf("\n---Test test_add_back_regular begin: ---\n");
    list *list = init();
    add_back(list, 1);
    add_back(list, 2);
    add_back(list, 3);
    add_back(list, 4);

    if (list->head->element != 1 || list->tail->element != 4) {
        printf("expected result head should be 1 and tail should be 4 "
               "but head is %d and tail is %d\n", list->head->element, list->tail->element);
        destroy(list);
        return 0;
    }
    if (list->length != 4) {
        printf("The result does not match: expected length: 4 "
               "but length is %d\n", list->length);
        destroy(list);
        return 0;
    }
    printf("---Test test_add_back_regular end:---\n");
    destroy(list);
    return 1;
}

int test_remove_front_empty()
{
    printf("\n---Test test_remove_front_empty begin: ---\n");
    list *list = init();
    remove_front(list);
    if (list->head != NULL || list->tail != NULL) {
        printf("expected result head and tail should be NULL "
               "but head is %p and tail is %p\n", list->head, list->tail);
        destroy(list);
        return 0;
    }
    if (list->last_index != -1 || list->last_node != NULL) {
        printf("The result does not match and "
               "expected last index should be -1 and last node should be NULL "
               "but it is %d and %p", list->last_index, list->last_node);
        destroy(list);
        return 0;
    }
    printf("---Test test_remove_front_empty end:---\n");
    destroy(list);
    return 1;
}

int test_remove_front_one_node() {
    printf("\n---Test test_remove_front_one_node begin: ---\n");
    list *list = init();
    add_front(list, 1);
    remove_front(list);
    if (list->head != NULL || list->tail != NULL) {
        printf("expected result head and tail should be NULL "
               "but head is %p and tail is %p\n", list->head, list->tail);
        destroy(list);
        return 0;
    }
    if (list->length != 0) {
        printf("The result does not match and the expected length should be 0 "
               "but length is %d\n", list->length);
        destroy(list);
        return 0;
    }
    printf("---Test test_remove_front_one_node end:---\n");
    destroy(list);
    return 1;
}

int test_remove_front_regular()
{
    printf("\n---Test test_remove_front_regular begin: ---\n");
    list *list = init();
    add_front(list, 1);
    add_front(list, 2);
    add_front(list, 3);
    add_front(list, 4);
    remove_front(list);
    if (list->head->element != 3 || list->tail->element != 1) {
        printf("expected result head should be 3 and tail should be 1 "
               "but head is %d and tail is %d\n", list->head->element, list->tail->element);
        destroy(list);
        return 0;
    }
    if (list->length != 3) {
        printf("The result does not match and "
               "the expected length should be 3 "
               "but length is %d\n", list->length);
        destroy(list);
        return 0;
    }
    printf("---Test test_remove_front_regular end:---\n");
    destroy(list);
    return 1;
}

int test_remove_back_empty()
{
    printf("\n---Test test_remove_back_empty begin: ---\n");
    list *list = init();
    remove_back(list);
    if (list->head != NULL || list->tail != NULL) {
        printf("expected result head and tail should be NULL "
               "but head is %p and tail is %p\n", list->head, list->tail);
        destroy(list);
        return 0;
    }
    if (list->length != 0) {
        printf("The result does not match and the expected length is 0 "
               "but length is %d\n", list->length);
        destroy(list);
        return 0;
    }
    printf("---Test test_remove_back_empty end:---\n");
    destroy(list);
    return 1;
}

int test_remove_back_one_node()
{
    printf("\n---Test test_remove_back_one_node begin: ---\n");
    list *list = init();
    add_front(list, 1);
    remove_back(list);
    if (list->head != NULL || list->tail != NULL) {
        printf("expected result head and tail should be NULL "
               "but head is %p and tail is %p\n", list->head, list->tail);
        destroy(list);
        return 0;
    }
    if (list->length != 0) {
        printf("The result does not match and "
               "expected length should be 0 "
               "but length is %d\n", list->length);
        destroy(list);
        return 0;
    }
    printf("---Test test_remove_back_one_node end:---\n");
    destroy(list);
    return 1;
}

int test_remove_back_regular()
{
    printf("\n---Test test_remove_back_regular begin: ---\n");
    list *list = init();
    add_front(list, 1);
    add_front(list, 2);
    add_front(list, 3);
    add_front(list, 4);
    remove_back(list);
    if (list->head->element != 4 || list->tail->element != 2) {
        printf("expected result head should be 4 and tail should be 2 "
               "but head is %d and tail is %d\n", list->head->element, list->tail->element);
        destroy(list);
        return 0;
    }
    if (list->length != 3) {
        printf("The result does not match and the expected length is 3 "
               "but length is %d\n", list->length);
        destroy(list);
        return 0;
    }
    printf("---Test test_remove_back_regular end:---\n");
    destroy(list);
    return 1;
}

int test_get_with_negative_index()
{
    printf("\n---Test test_get_with_negative_index begin: ---\n");
    list *list = init();
    add_front(list, 1);
    add_front(list, 2);
    add_front(list, 3);
    add_front(list, 4);
    int result = get(list, -1);
    if (result != -1) {
        printf("The result does not match and should expected -1 "
               "but got %d\n", result);
        destroy(list);
        return 0;
    }
    printf("---Test test_get_with_negative_index end:---\n");
    destroy(list);
    return 1;
}

int test_get_with_index_out_of_bound()
{
    printf("\n---Test test_get_with_index_out_of_bound begin: ---\n");
    list *list = init();
    add_front(list, 1);
    add_front(list, 2);
    add_front(list, 3);
    add_front(list, 4);
    int result = get(list, 10);
    if (result != -1) {
        printf("The result does not match and should expected -1 "
               "but got %d\n", result);
        destroy(list);
        return 0;
    }
    printf("---Test test_get_with_index_out_of_bound end:---\n");
    destroy(list);
    return 1;
}

int test_get_with_index_in_bound()
{
    printf("\n---Test test_get_with_index_in_bound begin: ---\n");
    list *list = init();
    add_front(list, 2);
    add_front(list, 3);
    add_front(list, 4);
    add_front(list, 5);
    int result = get(list, 2);
    if (result != 4) {
        printf("The result does not match and should expected 4 "
               "but got %d\n", result);
        destroy(list);
        return 0;
    }
    printf("---Test test_get_with_index_in_bound end:---\n");
    destroy(list);
    return 1;
}

int test_set_with_negative_index()
{
    printf("\n---Test test_set_with_negative_index begin: ---\n");
    list *list = init();
    add_front(list, 2);
    add_front(list, 3);
    add_front(list, 4);
    add_front(list, 5);
    set(list, -1, 10);
    int result = get(list, -1);
    if (result != -1) {
        printf("The result does not match and should expected -1 "
               "but got %d\n", result);
        destroy(list);
        return 0;
    }
    printf("---Test test_set_with_negative_index end:---\n");
    destroy(list);
    return 1;
}

int test_set_with_index_out_of_bound()
{
    printf("\n---Test test_set_with_index_out_of_bound begin: ---\n");
    list *list = init();
    add_front(list, 2);
    add_front(list, 3);
    add_front(list, 4);
    add_front(list, 5);
    set(list, 10, 10);
    int result = get(list, 10);
    if (result != -1) {
        printf("The result does not match and should expected -1 "
               "but got %d\n", result);
        destroy(list);
        return 0;
    }
    printf("---Test test_set_with_index_out_of_bound end:---\n");
    destroy(list);
    return 1;
}

int test_set_with_index_in_bound()
{
    printf("\n---Test test_set_with_index_in_bound begin: ---\n");
    list *list = init();
    add_front(list, 2);
    add_front(list, 3);
    add_front(list, 4);
    add_front(list, 5);
    set(list, 2, 10);
    int result = get(list, 2);
    if (result != 10) {
        printf("The result does not match and should expected 10 "
               "but got %d\n", result);
        destroy(list);
        return 0;
    }
    printf("---Test test_set_with_index_in_bound end:---\n");
    destroy(list);
    return 1;
}


int main()
{
    int total_tests = 17;
    int passed_tests = 0;

    passed_tests += test_init();

    passed_tests += test_add_front_empty();
    passed_tests += test_add_front_regular();

    passed_tests += test_add_back_empty();
    passed_tests += test_add_back_regular();

    passed_tests += test_remove_front_empty();
    passed_tests += test_remove_front_one_node();
    passed_tests += test_remove_front_regular();

    passed_tests += test_remove_back_empty();
    passed_tests += test_remove_back_one_node();
    passed_tests += test_remove_back_regular();

    passed_tests += test_get_with_negative_index();
    passed_tests += test_get_with_index_out_of_bound();
    passed_tests += test_get_with_index_in_bound();

    passed_tests += test_set_with_negative_index();
    passed_tests += test_set_with_index_out_of_bound();
    passed_tests += test_set_with_index_in_bound();

    printf("\nPassed %d of %d tests\n", passed_tests, total_tests);
    return 0;
}

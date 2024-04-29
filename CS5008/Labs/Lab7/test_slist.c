#include "slist.h"
#include <stdio.h>

// test with empty linked list
int test_merge_empty()
{
    printf("---Test test_merge_empty begin: ---\n");
    list *l = init();
    my_mergesort(l);
    if (l->head != NULL || l->tail != NULL || l->length != 0) {
        printf("expected empty list, but the function to build an empty list or merge failed\n");
        return 0;
    }
    destroy(l);
    printf("---Test test_merge_empty end: ---\n");
    return 1;
}

// test with a linked list with one element
int test_merge_one_element()
{
    printf("\n---Test test_merge_one_element begin: ---\n");
    list *l = init();
    add_back(l, 1);
    my_mergesort(l);
    if (l->head->element != 1 || l->tail->element != 1 || l->length != 1) {
        printf("expected result: 1,but it is %d\n", l->head->element);
        return 0;
    }
    destroy(l);
    printf("---Test test_merge_one_element end: ---\n");
    return 1;
}

// test with a linked list with two elements
int test_merge_two_elements()
{
    printf("\n---Test test_merge_two_elements begin: ---\n");
    list *l = init();
    add_back(l, 2);
    add_back(l, 1);
    my_mergesort(l);
    if (l->head->element != 1 || l->tail->element != 2 || l->length != 2) {
        printf("expected result: 1,2,but it is %d,%d\n", l->head->element, l->tail->element);
        return 0;
    }
    destroy(l);
    printf("---Test test_merge_two_elements end: ---\n");
    return 1;
}

// test with a linked list with ten elements
int test_merge_ten_elements()
{
    printf("\n---Test test_merge_ten_elements begin: ---\n");
    list *l = init();
    add_back(l, 2);
    add_back(l, 1);
    add_back(l, 4);
    add_back(l, 3);
    add_back(l, 6);
    add_back(l, 5);
    add_back(l, 8);
    add_back(l, 7);
    add_back(l, 10);
    add_back(l, 9);
    my_mergesort(l);
    node *curr = l->head;
    for (int i = 1; i <= 10; i++) {
        if (curr->element != i) {
            printf("expected result: 1,2,3,4,5,6,7,8,9,10,but it is %d\n", curr->element);
            return 0;
        }
        curr = curr->next;
    }
    destroy(l);
    printf("---Test test_merge_ten_elements end: ---\n");
    return 1;
}

// test with a large linked list
int test_merge_large_list()
{
    printf("\n---Test test_merge_large_list begin: ---\n");
    list *l = init();
    for (int i = 100000; i > 0; i--) {
        add_back(l, i);
    }
    my_mergesort(l);
    node *curr = l->head;
    for (int i = 1; i <= 100000; i++) {
        if (curr->element != i) {
            printf("merge large list failed\n");
            return 0;
        }
        curr = curr->next;
    }
    destroy(l);
    printf("---Test test_merge_large_list end: ---\n");
    return 1;
}

// test with a sorted linked list
int test_merge_sorted_list()
{
    printf("\n---Test test_merge_sorted_list begin: ---\n");
    list *l = init();
    add_back(l, 1);
    add_back(l, 2);
    add_back(l, 3);
    add_back(l, 4);
    add_back(l, 5);
    add_back(l, 6);
    add_back(l, 7);
    add_back(l, 8);
    add_back(l, 9);
    add_back(l, 10);
    my_mergesort(l);
    node *curr = l->head;
    for (int i = 1; i <= 10; i++) {
        if (curr->element != i) {
            printf("expected result: 1,2,3,4,5,6,7,8,9,10,but it is %d\n", curr->element);
            return 0;
        }
        curr = curr->next;
    }
    destroy(l);
    printf("---Test test_merge_sorted_list end: ---\n");
    return 1;
}

int main() {
    int total_tests = 6;
    int passed_tests = 0;

    passed_tests += test_merge_empty();
    passed_tests += test_merge_one_element();

    passed_tests += test_merge_two_elements();

    passed_tests += test_merge_ten_elements();
    passed_tests += test_merge_large_list();

    passed_tests += test_merge_sorted_list();

    printf("Passed %d/%d tests\n", passed_tests, total_tests);
}
// gcc deque.c test_deque.c -o tests
// ./tests

#include <stdio.h>
#include "deque.h"


// test make_empty_deque by checking if the head and tail are NULL
int test_make_empty_deque()
{
    printf("---Test test_make_empty_deque begin: ---\n");
    deque_t deque;
    make_empty_deque(&deque);

    if (deque.head != NULL || deque.tail != NULL) {
        printf("make_empty_deque failed, because either %p or %p is not NULL\n", deque.head, deque.tail);
        return 0;
    }
    printf("---Test test_make_empty_deque end ---\n");
    printf("\n");
    return 1;
}

// test delete_deque by checking if the head and tail are NULL
int test_delete_empty_deque()
{
    printf("\n---Test test_delete_empty_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);
    delete_deque(&deque);

    if (deque.head != NULL || deque.tail != NULL) {
        printf("delete_empty_deque failed, because either %p or %p is not NULL\n", deque.head, deque.tail);
        return 0;
    }
    printf("---Test test_delete_empty_deque end---\n");
    printf("\n");
    return 1;
}

// test delete_deque by checking if the head and tail are NULL
int test_delete_one_element_deque()
{
    printf("\n---Test test_delete_one_element_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);
    add_front(&deque, 1);
    delete_deque(&deque);

    if (deque.head != NULL || deque.tail != NULL) {
        printf("delete_one_element_deque failed, because either %p or %p is not NULL\n", deque.head, deque.tail);
        return 0;
    }
    printf("---Test test_delete_one_element_deque end---\n");
    printf("\n");
    return 1;
}

// test delete_deque by checking if the head and tail are NULL
int test_delete_deque()
{
    printf("\n---Test test_delete_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);

    // make a deque with 5 elements
    for (int i = 5; i > 0; i -= 1) {
        add_front(&deque, i);
    }

    // Then delete the whole deque
    delete_deque(&deque);

    // Check if the head and tail are NULL
    if (deque.head != NULL || deque.tail != NULL) {
        printf("delete_deque failed, because either %p or %p is not NULL\n", deque.head, deque.tail);
        return 0;
    }
    printf("---Test test_delete_deque end---\n");
    printf("\n");
    return 1;
}

// test add_front by checking if the head and tail are 1 and 5
// based on the established deque
int test_add_front_to_empty_deque()
{
    printf("\n---Test test_add_front_to_empty_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);
    // add one element to the front of the deque
    add_front(&deque, 1);

    if (deque.head->data != 1) {
        printf("add_front failed, deque head should be 1 but it is %d\n", deque.head->data);
        return 0;
    } else if (deque.tail == NULL) {
        printf("add_front failed, tail should not be Null but it is null \n");
        return 0;
    } else if (deque.head != deque.tail) {
        printf("add_front failed, head and tail should be the same but they are not.\n");
        return 0;
    }

    printf("---Test test_add_front_to_empty_deque end---\n");
    printf("\n");
    return 1;
}

// test add_front by checking if the head is 1 and the tail is NULL
// based on the established deque
int test_add_front_one_element_deque()
{
    printf("\n---Test test_add_front_one_element_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);
    add_front(&deque, 0);

    // add 5 elements in the front of this deque
    for (int i = 1; i <= 5; ++i) {
        add_front(&deque, i);
        // Check if head data is not as expected
        if (deque.head->data != i) {
            printf("add_front failed, deque head should be %d but it is %d.\n", i, deque.head->data);
            return 0;
        }
            // Check if tail data is not as expected
            // Tail should still point to the one with 0 as data
        else if (deque.tail->data != 0) {
            printf("add_front failed, deque tail should be 0 but it is %d.\n", deque.tail->data);
            return 0;
        }
    }
    printf("---Test test_add_front_one_element_deque end---\n");
    printf("\n");
    return 1;
}

int test_add_front_regular_deque()
{
    printf("\n---Test test_add_front_regular_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);
    add_front(&deque, 0);

    // add 5 elements in the front of this deque
    for (int i = 1; i <= 5; ++i) {
        add_front(&deque, i);
    }

    add_front(&deque, 6);

    // the head should be 5 and the tail should be 11
    if (deque.head->data != 6) {
        printf("add_back failed: deque head should be 6 but it is %d.\n", deque.head->data);
        return 0;
    }
        // Check if tail data is not as expected
        // which should still be 0
    else if (deque.tail->data != 0) {
        printf("add_back failed: deque tail should be 0 but it is %d.\n", deque.tail->data);
        return 0;
    }

    printf("---Test test_add_front_regular_deque end---\n");
    printf("\n");
    return 1;
}


// test add_back by checking if the head and tail are correct in the end
// based on the established deque
int test_add_back_to_empty_deque()
{
    printf("\n---Test test_add_back_to_empty_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);
    add_back(&deque, 5);

    // Check if head data is not as expected
    if (deque.head->data != 5) {
        printf("add_back failed, deque head should be 5 but it is %d.\n", deque.head->data);
        return 0;
    } else if (deque.head != deque.tail) {
        printf("add_back failed, head and tail should be the same but they are not.\n");
        return 0;
    }
        // Check if tail is unexpectedly NULL (Note: In a well-functioning deque, tail should NOT be NULL after add_back)
    else if (deque.tail == NULL) {
        printf("add_back failed, tail should not be NULL but it is.\n");
        return 0;
    }
    printf("---Test test_add_back_to_empty_deque end---\n");
    printf("\n");
    return 1;
}


// test add_back by checking if the head is 5 and the tail is NULL
// based on the established deque
int test_add_back_to_one_element_deque()
{
    printf("\n---Test test_add_back_to_one_element_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);
    add_back(&deque, 5);

    // Add elements 6 through 10 and check after each addition
    for (int i = 6; i <= 10; i += 1) {
        add_back(&deque, i);

        if (deque.head->data != 5) {
            printf("add_back failed, deque head should be 5 but it is %d.\n", deque.head->data);
            return 0;
        }
        // Check if tail data is not as expected
        if (deque.tail->data != i) {
            printf("add_back failed, deque tail should be %d but it is %d.\n", i, deque.tail->data);
            return 0;
        }
    }

    printf("---Test test_add_back_to_one_element_deque end---\n");
    printf("\n");
    return 1;
}


// test add_back by checking if the head is 5 and the tail is 11
// based on the established deque
int test_add_back_to_regular_deque()
{
    printf("\n---Test test_add_back_to_regular_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);

    // Make a deque with 5 elements (6 to 10), checking after each addition
    for (int i = 5; i <= 10; i += 1) {
        add_back(&deque, i);
    }

    // add 11 to the back of this deque
    add_back(&deque, 11);

    // the head should be 5 and the tail should be 11
    if (deque.head->data != 5) {
        printf("add_back failed: deque head should be 5 but it is %d.\n", deque.head->data);
        return 0;
    }
    if (deque.tail->data != 11) {
        printf("add_back failed: deque tail should be 11 but it is %d.\n", deque.tail->data);
        return 0;
    }
    printf("---Test test_add_back_to_regular_deque end---\n");
    printf("\n");
    return 1;
}

// test get_front by checking if the head is 5
// based on the established deque
int test_get_front_empty_deque()
{
    printf("\n---Test test_get_front_empty_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);

    if (get_front(&deque) != -12345) {
        printf("get_front failed, and this deque is not empty.\n");
        return 0;
    }
    printf("---Test test_get_front_empty_deque end---\n");
    printf("\n");
    return 1;
}

// test get_front by checking if the head is 5
// based on the established deque
int test_get_front_regular_deque()
{
    printf("\n---Test test_get_front_regular_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);

    // Make a deque with 5 elements, checking after each
    for (int i = 5; i <= 10; i += 1) {
        add_back(&deque, i);

        if (get_front(&deque) != 5) { // Head should always be 5
            printf("get_front failed: Head should be 5 but it is %d.\n", get_front(&deque));
            return 0;
        }
    }
    printf("---Test test_get_front_regular_deque end---\n");
    printf("\n");
    return 1;
}

// test get_back by checking if the tail is 10
// based on the established deque
int test_get_back_empty_deque()
{
    printf("\n---Test test_get_back_empty_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);

    if (get_back(&deque) != -12345) {
        printf("get_back failed, and this deque is not empty.\n");
        return 0;
    }
    printf("---Test test_get_back_empty_deque end---\n");
    printf("\n");
    return 1;
}


// test get_back by checking if the tail is 10
// based on the established deque
int test_get_back_regular_deque()
{
    printf("\n---Test test_get_back_regular_deque begin: ---\n");
    deque_t deque;
    make_empty_deque(&deque);

    // make a deque with 6 elements from 5 to 10
    for (int i = 5; i <= 10; i += 1) {
        add_back(&deque, i);

        // Check if tail data is not as expected
        if (get_back(&deque) != i) {
            printf("get_back failed, deque tail should be %d but it is %d\n", i, deque.tail->data);
            return 0;
        }
    }

    printf("---Test test_get_back_regular_deque end---\n");
    printf("\n");
    return 1;
}


// test remove_front by checking if the head and tail are NULL
// based on the established empty deque
int test_remove_front_empty()
{
    printf("\n---Test test_remove_front_empty begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);

    remove_front(&deque);

    if (deque.head != NULL || deque.tail != NULL) {
        printf("remove_front failed, either %p or %p is not NULL\n", deque.head, deque.tail);
        return 0;
    }

    printf("---Test test_remove_front_empty end---\n");
    printf("\n");
    return 1;
}

// test remove_front by checking if the head and tail are NULL
// based on the established deque with one element
int test_remove_front_one_element_deque()
{
    printf("\n---Test test_remove_front_one_element_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);

    add_front(&deque, 1);
    remove_front(&deque);

    if (deque.head != NULL || deque.tail != NULL) {
        printf("remove_front failed, because either %p or %p is not NULL\n", deque.head, deque.tail);
        return 0;
    }
    printf("---Test test_remove_front_one_element_deque end---\n");
    printf("\n");
    return 1;
}

// test remove_front by checking if the head is 6
// based on the established deque
int test_remove_front_regular_deque()
{
    printf("\n---Test test_remove_front_regular_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);

    // make a deque with 5 elements from 5 to 10
    for (int i = 5; i <= 10; i += 1) {
        add_back(&deque, i);
    }

    // remove the front of the deque
    remove_front(&deque);

    // the head should be 6
    if (deque.head->data != 6) {
        printf("remove_front failed, deque head should be 6 but it is %d\n", deque.head->data);
        return 0;
    }
    printf("---Test test_remove_front_regular_deque end---\n");
    printf("\n");
    return 1;
}

// test remove_back by checking if the head and tail are NULL
// based on the established empty deque
int test_remove_back_empty()
{
    printf("\n---Test test_remove_back_empty begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);
    remove_back(&deque);

    if (deque.head != NULL || deque.tail != NULL) {
        printf("remove_back failed, because either %p or %p is not NULL\n", deque.head, deque.tail);
        return 0;
    }
    printf("---Test test_remove_back_empty end---\n");
    printf("\n");
    return 1;
}

// test remove_back by checking if the head and tail are NULL
// based on the established deque with one element
int test_remove_back_one_element_deque()
{
    printf("\n---Test test_remove_back_one_element_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);
    add_front(&deque, 1);
    remove_back(&deque);

    if (deque.head != NULL || deque.tail != NULL) {
        printf("remove_back failed, because either %p or %p is not NULL\n", deque.head, deque.tail);
        return 0;
    }
    printf("---Test test_remove_back_one_element_deque end---\n");
    printf("\n");
    return 1;
}

// test remove_back by checking if the head is 9
// based on the established deque
int test_remove_back_regular_deque()
{
    printf("\n---Test test_remove_back_regular_deque begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);

    // make a deque with 6 elements from 5 to 10
    for (int i = 5; i <= 10; i += 1) {
        add_back(&deque, i);
    }

    // remove the front of the deque
    remove_back(&deque);

    // the tail should be 9
    if (deque.tail->data != 9) {
        printf("remove_back failed, deque head should be 9 but it is %d\n", deque.tail->data);
        return 0;
    }
    printf("---Test test_remove_back_regular_deque end---\n");
    printf("\n");
    return 1;
}

// test deque_size by checking if the size is 0
// based on the established empty deque
int test_deque_size_empty()
{
    printf("\n---Test test_deque_size_empty begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);

    if (deque_size(&deque) != 0) {
        printf("deque_size failed, deque size should be NULL but it is %d\n", deque_size(&deque));
        return 0;
    }
    printf("---Test test_deque_size_empty end---\n");
    printf("\n");
    return 1;
}

// test deque_size by checking if the size is always updated
// based on the established deque
int test_deque_size_regular()
{
    printf("\n---Test test_deque_size_regular begin: ---\n");

    deque_t deque;
    make_empty_deque(&deque);

    // make a deque with 5 elements from 5 to 10
    for (int i = 5; i <= 10; i += 1) {

        add_back(&deque, i);

        if (deque_size(&deque) != i - 4) {
            printf("deque_size failed, deque size should be %d but it is %d\n", i, deque_size(&deque));
            return 0;
        }
    }

    printf("---Test test_deque_size_regular end---\n");
    printf("\n");
    return 1;
}

// test deque_node_t by checking if the node data is 5 and the next is NULL
// based on the established node
int test_deque_node_t()
{
    printf("\n---Test test_deque_node_t begin: ---\n");

    deque_node_t *node = make_node(5, NULL);

    if (node->data != 5) {
        printf("make_node failed, node data should be 5 but it is %d\n", node->data);
        return 0;
    } else if (node->next != NULL) {
        printf("make_node failed, node next should be NULL but it is %p\n", node->next);
        return 0;
    }

    printf("---Test test_deque_node_t end---\n");
    printf("\n");
    return 1;
}

int test_deque_comprehensive()
{
    // This test mixes a bunch of functions calling on one deque
    // To see if deque handle real-life usage
    deque_t deque;
    make_empty_deque(&deque);

    // Add 6 elements to the front
    for (int i = 5; i <= 10; i += 1) {
        add_front(&deque, i);
    }
    // Add 5 elements to the back
    for (int i = 11; i <= 15; i += 1) {
        add_back(&deque, i);
    }

    // Remove 3 elements from the front and back
    for (int i = 0; i < 3; i += 1) {
        remove_front(&deque);
        remove_back(&deque);
    }

    // Check if the size is 5
    if (deque_size(&deque) != 5) {
        printf("deque_size failed, deque size should be 5 but it is %d\n", deque_size(&deque));
        return 0;
    }

    // Check if the head is 7
    if (get_front(&deque) != 7) {
        printf("remove_front failed, deque head should be 7 but it is %d\n", deque.head->data);
        return 0;
    }

    // Check if the tail is 12
    if (get_back(&deque) != 12) {
        printf("remove_back failed, deque tail should be 12 but it is %d\n", deque.tail->data);
        return 0;
    }

    // Delete the deque
    delete_deque(&deque);

    // Check if the head and tail are NULL
    if (deque.head != NULL || deque.tail != NULL) {
        printf("delete_deque failed, either %p or %p is not NULL\n", deque.head, deque.tail);
        return 0;
    }

    return 1;
}


int main()
{
    int total_tests = 24;
    int tests_passed = 0;

    // run the tests
    tests_passed += test_make_empty_deque();

    tests_passed += test_delete_empty_deque();
    tests_passed += test_delete_one_element_deque();
    tests_passed += test_delete_deque();

    tests_passed += test_add_front_to_empty_deque();
    tests_passed += test_add_front_one_element_deque();
    tests_passed += test_add_front_regular_deque();

    tests_passed += test_add_back_to_empty_deque();
    tests_passed += test_add_back_to_one_element_deque();
    tests_passed += test_add_back_to_regular_deque();

    tests_passed += test_get_front_empty_deque();
    tests_passed += test_get_front_regular_deque();

    tests_passed += test_get_back_empty_deque();
    tests_passed += test_get_back_regular_deque();

    tests_passed += test_remove_front_empty();
    tests_passed += test_remove_front_one_element_deque();
    tests_passed += test_remove_front_regular_deque();

    tests_passed += test_remove_back_empty();
    tests_passed += test_remove_back_one_element_deque();
    tests_passed += test_remove_back_regular_deque();

    tests_passed += test_deque_size_empty();
    tests_passed += test_deque_size_regular();

    tests_passed += test_deque_node_t();
    tests_passed += test_deque_comprehensive();

    printf("Ran %d tests, passed %d tests, failed %d tests\n", total_tests, tests_passed, total_tests - tests_passed);
    return 0;
}
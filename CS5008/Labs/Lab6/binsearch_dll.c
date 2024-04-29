// gcc binsearch_dll.c double_linked_list.c -o main
// ./main

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include "double_linked_list.h"

// binary search implemented in a double linked list
bool binsearch_dll(node *head, node *tail, int n, int element)
{

    // handle the empty list
    if (head == NULL || tail == NULL || n == 0) {
        return false;
    }
    // handle the list with one element
    if (n == 1) {
        if (head->data == element) {
            return true;
        } else {
            return false;
        }
    }

    // Set initial search area [0, n-1]
    // which also we will begin with the whole array
    int left = 0;
    int right = n - 1;

    // initialize a previous accessed node and its index
    // keep as trackers for future reference
    node *previous_node = NULL;
    int previous_index = -1;

    // while our search area has more than 2 things (if only 1, see above)
    while (left <= right) {
        // Calculate the new midpoint
        int mid = (left + right) / 2;
        // set the starting point of traversal
        node *current;

        // Check if previous_node can be used
        // If we can, then traverse from previous_node
        // If not, traverse from head
        if (previous_node == NULL) {
            // we have not updated Previous_node yet, start traversal from head
            current = head;
            // then, traverse from head to new mid
            for (int i = 0; i < mid; i++) {
                current = current->next;
            }
        } else {
            // previous_node exists, start traversal from there to new mid
            current = previous_node;
            // calculate the steps traverse from previous node to new midpoint
            int distance = abs(mid - previous_index);
            // set to traverse first and then check moving direction
            for (int j = 0; j < distance; j++) {
                if (mid > previous_index) {
                    current = current->next;
                } else {
                    current = current->previous;
                }
            }
        }
        // Traversal is done, now we update previous_*
        previous_index = mid;
        previous_node = current;

        // Check whether the target is on the left/right of mid
        // Or, if target is found at mid
        if (current->data == element) {
            return true;
        }
        // narrow down search interval
        else if (current->data < element) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return false;
}

// a function to print the list
void print_list(list *ls)
{
    node *current = ls->head;
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    free(current);
    printf("\n");
}

int main()
{
    // test binsearch_dll with a regular list
    list *double_list = create_double_linked_list();
    add_front(double_list, 8);
    add_front(double_list, 7);
    add_front(double_list, 6);
    add_front(double_list, 5);
    add_front(double_list, 4);
    add_front(double_list, 3);
    add_front(double_list, 2);
    add_front(double_list, 1);
    add_front(double_list, 0);
    print_list(double_list);

    int n = length(double_list);
    int element = 2;
    bool result = binsearch_dll(double_list->head, double_list->tail, n, element);
    if (result == true) {
        printf("Element found in the list\n");
    } else {
        printf("Element not found in the list\n");
    }
    delete_list(double_list);


    // test binsearch_dll with an empty list
    list *double_list2 = create_double_linked_list();

    int n2 = length(double_list2);
    int element2 = 10;
    bool result2 = binsearch_dll(double_list2->head, double_list2->tail, n2, element2);
    if (result2 == true) {
        printf("Element found in the list\n");
    } else {
        printf("Element not found in the list\n");
    }
    delete_list(double_list2);


    // test binsearch_dll with a list with one element
    list *double_list3 = create_double_linked_list();
    add_front(double_list3, 1);
    print_list(double_list3);
    bool result3 = binsearch_dll(double_list3->head, double_list3->tail, 1, 1);
    if (result3 == true) {
        printf("Element found in the list\n");
    } else {
        printf("Element not found in the list\n");
    }
    delete_list(double_list3);

    return 0;
}

/* ================================== Efficiency Analysis:

Looking at the algorithm binsearch_dll(A, n, element):

Operation | Time

empty list check: O(1)
n=1 list check: O(1)
init left: O(1)
init right: O(1)
init prev_node: O(1)
init prev_index: O(1)

The while loop:
in each loop we cut the search interval by half the size of input double linked list,
so its total number of execution scales by log2(n);

Within the while loop:
inside each loop, we use previous_index and previous_node for optimized traversal,
and it follows a certain pattern: the first iteration traverses n/2 distance,
the second n/4 distance, the third n/8 distance, and so on....
which means that the total number of execution scales by n * (1/2 + 1/4 + 1/8 + 1/16 + ...).
By converging to a limit, this becomes n * 1, thus just equals to scaling up by (n).

Therefore, the total time complexity of binsearch_dll(A, n, element) is O(n).
 */
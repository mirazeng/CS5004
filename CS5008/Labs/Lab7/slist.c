#include "slist.h"
#include <stdlib.h>
#include <stdio.h>

node *makenode(int element, node *next)
{
    node *newnode = (node *) malloc(sizeof(node));
    newnode->element = element;
    newnode->next = next;
    return newnode;
}

list *init()
{
    //create a new list object and initialize its head and tail
    list *newlist = (list *) malloc(sizeof(list));
    newlist->head = NULL;
    newlist->tail = NULL;
    //length is 0
    newlist->length = 0;
    return newlist;
}

void destroy(list *l)
{
    node *curr = l->head;
    while (curr != NULL) {
        node *next = curr->next;
        free(curr);
        curr = next;
    }
    free(l);
}

void add_back(list *l, int element)
{
    //create a new node whose next is NULL
    node *new_node = makenode(element, NULL);
    if (l->head == NULL) {
        l->head = new_node;
        l->tail = new_node;
    } else {
        l->tail->next = new_node; //it is after the current tail
        l->tail = new_node; //tail is now the new node
    }
    l->length += 1;
}

// a function to merge two sorted linked lists
node *merge(node *l1_head, node *l2_head)
{
    // create a dummy node to hold the merged list
    node dummy;
    // assign tail to the dummy node
    node *merged_tail = &dummy;
    // set the next pointer of the dummy node to NULL
    dummy.next = NULL;

    // while l1 and l2 are not empty
    while (l1_head != NULL && l2_head != NULL) {
        // compare each element of the two lists

        // if l1_head's element is less than l2_head's element
        if (l1_head->element < l2_head->element) {
            // adding the smaller element to the merged list
            merged_tail->next = l1_head; // changes current tail pointer to l1_head
            // moving pointer forward in l1
            l1_head = l1_head->next;
        } else {
            // if l2_head's element is less than l1_head's element, add that instead
            merged_tail->next = l2_head; // changes current tail pointer to l2_head
            // moving forward in l2
            l2_head = l2_head->next;
        }
        // moving forward in the merged list
        merged_tail = merged_tail->next;
    }
    // after any of the list is depleted, add all the remaining from the other one
    if (l1_head != NULL) {
        merged_tail->next = l1_head;
    } else {
        merged_tail->next = l2_head;
    }
    // return the merged list
    return dummy.next;
}

// a function to find the midpoint of a linked list
node *find_mid(node *head, node *tail)
{
    // create two pointers, slow and fast
    node *slow = head;
    node *fast = head;
    while (fast != tail) {
        // move slow one step at a time
        slow = slow->next;
        fast = fast->next;
        // move fast one more step, so it moves twice as fast until it reaches the end
        if (fast != tail) {
            fast = fast->next;
        }
    }
    // when fast reaches the end of the list
    // slow will be at the midpoint
    return slow;
}

// a function to sort a linked list
node *sort_list(node *head, node *tail)
{
    // base case
    if (head == NULL) {
        return head;
    }
    if (head->next == tail) {
        head->next = NULL;
        return head;
    }

    node *mid = find_mid(head, tail);

    // divide the list into two halves and start with pointers
    node *left = sort_list(head, mid); // recursively sort the left half
    node *right = sort_list(mid, tail); // and the right half

    // call merge the two sorted halves
    return merge(left, right);
}

// a merge sort function for a singly linked list
void my_mergesort(list *l)
{
    // update the head pointer to the sorted list
    l->head = sort_list(l->head, NULL);

    // update the tail pointer to the new node
    for (node *curr = l->head; curr != NULL; curr = curr->next) {
        if (curr->next == NULL) {
            l->tail = curr;
        }
    }
}
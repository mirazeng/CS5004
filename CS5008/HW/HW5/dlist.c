// gcc -g dlist.c logger.c dlist_main.c tests_dlist.c -o double -lm
// ./double

#include "macros.h" //should always be before any use of LOG

#ifdef LOG

#include "logger.h"

extern log_t logger;  //the global variable logger from logger.h. "extern" means it is defined elsewhere. This makes the compiler happy, but the linker would need to find it.
#endif

#include "dlist_hidden.h"
#include <stdlib.h>
#include <stdio.h>
#include "dlist.h"

// Function to initialize a new list
list *init()
{
    //create a new list object and initialize its head and tail
    list *newlist = (list *) malloc(sizeof(list));
    newlist->head = NULL;
    newlist->tail = NULL;
    //length is 0
    newlist->length = 0;

    //initialize the last index and last node
    newlist->last_index = -1;
    newlist->last_node = NULL;

    return newlist;
}

// Function to delete a list and free its memory
void destroy(list *l)
{
    // locate current head
    node *curr = l->head;
    // check if current head is not NULL
    // stop when the current head is NULL
    while (curr != NULL) {
        // set the current head pointer to the next node
        node *next = curr->next;
        // free the current node
        free(curr);
        curr = next;
    }
    // free the list
    free(l);
}

// Modified function to add a new node to the front of the list
void add_front(list *l, int element)
{

#ifdef LOG
    logger_add();
#endif
    // make a node with NULL previous pointer
    // and be ready to add front in the double linked list
    // also set the new node's next to the current head
    node *new_node = makenode(NULL, element, l->head);

    // when list is empty
    if (l->tail == NULL) {
        // set the list head and tail to the new node
        l->tail = new_node;
        l->head = new_node;

        // when list head is not empty
    } else {
        // set the current head's previous pointer to the new node
        l->head->prev = new_node;
        // move the current head pointer to the new node
        l->head = new_node;

    }
    // add to the length of the list
    l->length += 1;

    // reset the last index and last node
    l->last_index = -1;
    l->last_node = NULL;
}

// Modified function to add a new node to the back of the list
void add_back(list *l, int element)
{
    // make a node pointing to the current tail
    // with next pointer set to NULL
    node *new_node = makenode(l->tail, element, NULL);

    // from empty list to list with one element
    if (l->head == NULL) {
        l->head = new_node;
        l->tail = new_node;
    } else {
        // add new node to a regular list
        // link the current tail's next pointer to the new node
        l->tail->next = new_node;
        // move the current tail pointer to the new node
        l->tail = new_node;
    }
    // add to the length of the list
    l->length += 1;

    // reset the last index and last node
    l->last_index = -1;
    l->last_node = NULL;

#ifdef LOG
    logger_add();
#endif
}

// Modified function to remove the front node from the list
void remove_front(list *l)
{
    if (l->head != NULL) {
        // find the current head node
        node *current_head = l->head;
        // set the current head pointer to the next node
        l->head = l->head->next;

        if (l->head == NULL) { //list is now empty
            l->tail = NULL;
        } else {
            // set the new head's previous pointer to NULL
            l->head->prev = NULL;
        }
        // free the current head node
        free(current_head);

        // reduce the length of the list
        l->length -= 1;
        // reset the last index and last node
        l->last_index = -1;
        l->last_node = NULL;
    }

#ifdef LOG
    logger_add();
#endif
}

// Modified function to remove the back node from the list
void remove_back(list *l)
{
    if (l->head != NULL) {
#ifdef LOG
        logger_add();
#endif
        // find the current tail node
        node *current_tail = l->tail;
        // move the current tail pointer to the previous node
        l->tail = l->tail->prev;

        // if the list is now empty
        if (l->tail == NULL) {
            // set the head to NULL
            l->head = NULL;
        } else {
            // set the new tail's next pointer to NULL
            l->tail->next = NULL;
        }
        // free the current tail node
        free(current_tail);

        // reduce the length of the list
        l->length -= 1;

        // reset the last index and last node
        l->last_index = -1;
        l->last_node = NULL;
    }
}


// Modified function to get the element at a given index
int get(list *l, int index)
{
    // Invalid Index check
    if ((index < 0) || (index >= length(l))) {
        return -1;
    }
#ifdef LOG
    logger_add();
#endif
    // initialize the index tracker and current node
    int i = 0;
    node *curr = l->head;
    // find the node at the given index
    if (l->last_node != NULL) {
        // when there is some record on last node
        i = l->last_index;
        curr = l->last_node;
    }
    //make sure the index is moving closer to the target index
    while (i != index) {
        // when the index is less than the target index
        if (i < index) {
            // move to the next node by add value to the index
            i += 1;
            // move to the next node by moving the current node to the next node
            curr = curr->next;
        } else {
            // move to the previous node by subtracting value from the index
            i -= 1;
            // move to the previous node by moving the current node to the previous node
            curr = curr->prev;
        }
#ifdef LOG
        logger_add();
#endif
    }

    //update the last node and last index
    l->last_index = index;
    l->last_node = curr;

    return curr->element; //return the element in the found node
}

// Modified function to set the element at a given index
void set(list *l, int index, int element)
{
    // Invalid Index check
    if ((index < 0) || (index >= length(l))) {
        return;
    }
#ifdef LOG
    logger_add();
#endif

    // initialize the index tracker and current node
    int i = 0;
    node *curr = l->head;
    // find the last node
    // and set the last element and stop
    if (l->last_node != NULL) {
        i = l->last_index;
        curr = l->last_node;
    }
    // make sure the index is moving closer to the target index
    while (i != index) {
        if (i < index) {
            i += 1;
            curr = curr->next;
        } else {
            i -= 1;
            curr = curr->prev;
        }
#ifdef LOG
        logger_add();
#endif
    }
    curr->element = element;

    //update the last node and last index
    l->last_index = index;
    l->last_node = curr;
}


// Function to find the index of a given element
int index_of(list *l, int element)
{
    node *curr = l->head;
    int i = 0;
#ifdef LOG
    logger_add();
#endif
    //find the first time the element is found
    while ((curr != NULL) && (curr->element != element)) {
        curr = curr->next;
        i += 1;
#ifdef LOG
        logger_add();
#endif
    }
    if (curr != NULL) { //element is found
        return i;
    }
    return -1;
}

// Function to find the length of the list
int length(list *l)
{
    return l->length;
}

// Function to create a new node
node *makenode(node *prev, int element, node *next)
{
    node *newnode = (node *) malloc(sizeof(node));
    newnode->prev = prev;
    newnode->element = element;
    newnode->next = next;
    return newnode;
}

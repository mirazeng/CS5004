#include "macros.h" //should always be before any use of LOG

#ifdef LOG

#include "logger.h"

extern log_t logger;  //the global variable logger from logger.h. "extern" means it is defined elsewhere. This makes the compiler happy, but the linker would need to find it.
#endif

#include "dlist_hidden.h"
#include <stdlib.h>
#include <stdio.h>
#include "dlist.h"


list *init()
{
    //create a new list object and initialize its head and tail
    list *newlist = (list *) malloc(sizeof(list));
    newlist->head = NULL;
    newlist->tail = NULL;
    //length is 0
    newlist->length = 0;

    newlist -> last_index = -1;
    newlist -> last_node = NULL;

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

    // from empty list to list with one element
    if (l->tail == NULL) {
        l->tail = new_node;
        l->head = new_node;

        l->last_index = 0;
        l->last_node = new_node;
        // when list head is not empty
    } else {
        // set the current head's previous pointer to the new node
        l->head->prev = new_node;
        // move the current head pointer to the new node
        l->head = new_node;
    }

    // add to the length of the list
    l->length += 1;

// adding to the front only changes indexes in l
    l->last_index += 1;

}

void add_back(list *l, int element)
{
    // make a node pointing to the current tail
    // with next pointer set to NULL
    node *new_node = makenode(l->tail, element, NULL);

    // from empty list to list with one element
    if (l->head == NULL) {
        l->head = new_node;
        l->tail = new_node;
        l->last_index = 0;
        l->last_node = new_node;
    } else {
        // add new node to a regular list
        // link the current tail's next pointer to the new node
        l->tail->next = new_node;
        // move the current tail pointer to the new node
        l->tail = new_node;
    }
    l->length += 1;

    // When adding to the back to existing list (more than 1 node), last index and last node remain unchanged

#ifdef LOG
    logger_add();
#endif
}

void remove_front(list *l)
{
    if (l->head != NULL) {
        node *current_head = l->head;
        //move current head to the next
        l->head = l->head->next;

        if (l->head == NULL) { //list is now empty
            l->tail = NULL;
            l->last_index = -1;
            l->last_node = NULL;
        } else {
            if (l->last_index == 0) {
                l->last_index = -1;
                l->last_node = NULL;
            } else {
                l->last_index -= 1;
            }

            // set the new head's previous pointer to NULL
            l->head->prev = NULL;
        }
        free(current_head);
    }
    l->length -= 1;

#ifdef LOG
    logger_add();
#endif
}

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
            l->head = NULL;

            l->last_index = -1;
            l->last_node = NULL;
        } else {
            // set the new tail's next pointer to NULL
            l->tail->next = NULL;

        }
        free(current_tail);
        l->length -= 1;
    }
    l->last_index = 0;
    l->last_node = NULL;
}


int get(list *l, int index)
{
    if ((index < 0) || (index >= length(l))) {
        return -1;
    }
#ifdef LOG
    logger_add();
#endif

    //find the node at the given index
    if (l->last_node != NULL && index == l->last_index) {
        // return the last element data
        return l->last_node->element;
    }

    int i = l->last_index;
    node *curr = l->last_node;

    //make sure the index is moving closer to the target index
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

    //update the last node and last index
    l->last_index = index;
    l->last_node = curr;

    return curr->element; //return the element in the found node
}

void set(list *l, int index, int element)
{
    if ((index < 0) || (index >= length(l))) {
        return;
    }
#ifdef LOG
    logger_add();
#endif

    // find the last node
    // and set the last element and stop
    if (l->last_node != NULL && l->last_index == index) {
        // set the last element data
        l->last_node->element = element;
        return;
    }
    //find the node at the given index
    int i = l->last_index;
    node *curr = l->last_node;
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

int length(list *l)
{
    return l->length;
}

node *makenode(node *prev, int element, node *next)
{
    node *newnode = (node *) malloc(sizeof(node));
    newnode->prev = prev;
    newnode->element = element;
    newnode->next = next;
    return newnode;
}

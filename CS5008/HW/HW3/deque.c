#include <stdio.h>
#include <stdlib.h>
#include "deque.h"

//Make an empty deque
void make_empty_deque(deque_t *dq)
{
    // set the head and tail to NULL
    dq->head = NULL;
    dq->tail = NULL;
}

//delete an existing deque
void delete_deque(deque_t *dq)
{
    // define pointers to traverse of the deque
    deque_node_t *current_node;
    deque_node_t *previous_node;

    // initialize the pointers to the head of the deque
    current_node = dq->head;
    previous_node = NULL;

    // iterate through the deque until the tail is reached
    while (current_node != NULL) {
        // move the previous node to the current node
        previous_node = current_node;
        // move the current node to the next node
        current_node = current_node->next;
        // free the previous node memory
        free(previous_node);
    }
    // set the head and tail to NULL after removing all the nodes
    // to indicate that the deque is empty
    dq->head = NULL;
    dq->tail = NULL;
}

//add the given data to the front of the given deque
void add_front(deque_t *dq, int data)
{
    // call helper function to create a new node
    // with data and the next pointer to the current head
    deque_node_t *new_node = make_node(data, dq->head);

    // set the current head to the new node
    dq->head = new_node;

    // handling when the deque is empty
    if (dq->tail == NULL) {
        dq->tail = new_node;
    }
}

//add the given data to the back of the given deque
void add_back(deque_t *dq, int data)
{
    // make a new node and the next pointer should be null
    deque_node_t *new_node = make_node(data, NULL);

    // handling when the deque is empty
    if (dq->head == NULL && dq->tail == NULL) {
        dq->head = dq->tail = new_node;
    } else {
        // set the next pointer of the current tail to the new node
        dq->tail->next = new_node;
        // set the tail to the new node
        dq->tail = new_node;
    }
}

//get the element at the front of the deque. If the deque is empty, return -12345
int get_front(deque_t *dq)
{
    // handling when the deque is empty
    if (dq->head == NULL && dq->tail == NULL) {
        return -12345;
    } else {
        // return the data of the head
        return dq->head->data;
    }
}

//get the element at the back of the queue. If the deque is empty, return -12345
int get_back(deque_t *dq)
{
    // handling when the deque is empty
    if (dq->head == NULL && dq->tail == NULL) {
        return -12345;
    } else {
        // return the data of the tail
        return dq->tail->data;
    }
}

//remove the element at the front of the queue
void remove_front(deque_t *dq)
{
    // handling when the deque is empty
    if (dq->head == NULL && dq->tail == NULL) {
        return;
    }
    // handling when the deque has only one element
    if (dq->head == dq->tail) {
        // prohibit memory leak
        free(dq->head);
        // set the deque to be empty
        dq->head = NULL;
        dq->tail = NULL;
    } else {
        // create a pointer to the current head
        deque_node_t *current_node = dq->head;
        // set the next node to be the new head
        dq->head = dq->head->next;
        // free the memory of last head
        free(current_node);
    }
}

//remove the element at the back of the queue
void remove_back(deque_t *dq)
{
    // handling when the deque is empty
    if (dq->head == NULL && dq->tail == NULL) {
        return;
    }
    // handling when the deque has only one element
    if (dq->head == dq->tail) {
        // prohibit memory leak
        free(dq->head);
        // set the deque to be empty
        dq->head = NULL;
        dq->tail = NULL;
    } else {
        // create a pointer to the current head
        deque_node_t *current_node = dq->head;
        // a tracker of the node before the current node
        deque_node_t *previous_node = NULL;

        // find the node before the tail
        // loop will stop when the current_node->next is the tail
        while (current_node->next != NULL) {
            // move the previous node to the current node
            previous_node = current_node;
            // move the current node to the next node
            current_node = current_node->next;
        }
        // detach the tail from the previous node
        previous_node->next = NULL;
        // set the tail to the previous node
        dq->tail = previous_node;
        // free the memory of the last tail
        free(current_node);
    }
}

unsigned int deque_size(deque_t *dq)
{
    // track the number of elements within list
    int tracker = 0;
    // create a pointer to the current head
    deque_node_t *current_node = dq->head;

    // iterate through the deque and count the number of elements
    while (current_node != NULL) {
        // increment the tracker
        tracker++;
        // move the current node to the next node
        current_node = current_node->next;
    }
    return tracker;
}

// a helper function to create a new node for the deque
deque_node_t *make_node(int data, deque_node_t *next)
{
    // allocate memory for the new node
    deque_node_t *new_node = (deque_node_t *) malloc(sizeof(deque_node_t));
    // set the data and next pointer of the new node
    new_node->data = data;
    // set the next pointer of the new node
    new_node->next = next;
    return new_node;
}
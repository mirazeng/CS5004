#include <stdio.h>
#include <stdlib.h>
#include "mylist.h"

// Make an empty list
void make_empty_list(list_t *mylist)
{
    mylist->head = NULL;
    mylist->tail = NULL;
}

// Add a number to the front of a list
void add_front(list_t *mylist, int data)
{

    //create a new node that has data, and its next points to head
    node_t *newnode = make_node(data, mylist->head);

    //make this new node the new head
    mylist->head = newnode;

    //change tail only if it is NULL (which means that the list was empty before this)
    if (mylist->tail == NULL) {
        mylist->tail = newnode;
    }

}

// Add a number to the back of a list
void add_back(list_t *mylist, int data)
{
    //create a new node that has data, and its next points to NULL
    node_t *newnode = make_node(data, NULL);

    //if the list is empty, then the new node is both the head and the tail
    if (mylist->head == NULL) {
        mylist->head = newnode;
        mylist->tail = newnode;
    } else {
        //otherwise, the current tail's next is the new node
        mylist->tail->next = newnode;
        //and the new node is the new tail
        mylist->tail = newnode;
    }
}

// Print the contents of the list, front to back
void print_list(list_t *mylist)
{
    node_t *current_node;

    // start at the head
    current_node = mylist->head;

    while (current_node != NULL) {
        printf("%d ", current_node->data);
        // go advance to the next node
        current_node = current_node->next;
    }

    printf("\n");
}

// Delete the list
void delete_list(list_t *mylist)
{
    node_t *current_node;
    node_t *previous_node;

    current_node = mylist->head;
    previous_node = NULL;
    while (current_node != NULL) {
        previous_node = current_node; //new previous is current
        current_node = current_node->next;  //new current is advanced
        free(previous_node);
    }
    mylist->head = NULL;
    mylist->tail = NULL;

}

// Get the size of the list
unsigned int list_size(list_t *mylist)
{
    // track the number of elements within list
    int count = 0;

    // create a pointer to the current head
    node_t *current_node;;
    current_node = mylist->head;

    // iterate through the deque and count the number of elements
    while (current_node != NULL) {
        // increment the tracker
        count += 1;
        // move the current node to the next node
        current_node = current_node->next;
    }
    return count;
}

node_t *make_node(int data, node_t *next)
{
    node_t *newnode = (node_t *) malloc(sizeof(node_t));
    newnode->data = data;
    newnode->next = next;
    return newnode;
}

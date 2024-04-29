#include <stdlib.h>
#include "double_linked_list.h"

// the following functions are used to create and manipulate a double linked list
// it is from previous homework

list *create_double_linked_list()
{

    list *newlist = (list *) malloc(sizeof(list));
    newlist->head = NULL;
    newlist->tail = NULL;

    newlist->length = 0;

    newlist->previous_node = NULL;
    newlist->previous_index = -1;

    return newlist;
}

node *makenode(node *previous, int data, node *next)
{

    node *newnode = (node *) malloc(sizeof(node));
    newnode->previous = previous;
    newnode->data = data;
    newnode->next = next;
    return newnode;
}

void delete_list(list *ls)
{

    node *current = ls->head;

    while (current != NULL) {
        node *next = current->next;
        free(current);
        current = next;
    }
    free(ls);
}

void add_front(list *ls, int data)
{

    node *new_node = makenode(NULL, data, ls->head);

    if (ls->tail == NULL) {
        ls->head = new_node;
        ls->tail = new_node;
    } else {
        ls->head->previous = new_node;
        ls->head = new_node;
    }
    ls->length++;
}

int length(list *l)
{
    return l->length;
}
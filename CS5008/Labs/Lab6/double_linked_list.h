#ifndef LAB6_DOUBLE_LINKED_LIST_H

typedef struct node {
    // define the structure of the node

    // assign the previous and next pointers
    struct node *previous;
    int data; // the data of the node
    struct node *next;
} node; // define the node as a type

typedef struct d_list {
    // define the structure of the double linked list

    // assign the head and tail pointers to the list
    node *head;
    node *tail;
    // initialize the length of the list
    int length;

    // initialize the previous accessed node
    node *previous_node;
    // initialize the previous accessed node index
    int previous_index;
} list;

list *create_double_linked_list();

node *makenode(node *previous, int data, node *next);

void delete_list(list *ls);

void add_front(list *ls, int data);

int length(list *ls);

#define LAB6_DOUBLE_LINKED_LIST_H

#endif //LAB6_DOUBLE_LINKED_LIST_H

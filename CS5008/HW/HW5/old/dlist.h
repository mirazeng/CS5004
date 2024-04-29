#ifndef __SLIST_H_
#define __SLIST_H_

//a structure to represent a node of a double linked list
typedef struct s_node {
    // add a previous pointer to the node
    struct s_node *prev;
    // node data
    int element;
    // add a next pointer to the node
    struct s_node *next;
} node;

//a structure to represent the double linked list
typedef struct s_list {
    node *head;
    node *tail;
    int length;

    node *last_node;
    int last_index;
} list;

//initialize and return an empty list
list *init();

//free all the memory of a list
void destroy(list *l);

//add the given element to the front of the given list
void add_front(list *l, int element);

//add the given element to the back of the given list
void add_back(list *l, int element);

//remove an element from the front of the given list
void remove_front(list *l);

//remove an element from the back of the given list
void remove_back(list *l);

//get the element at a specified index of the given list. If the index is invalid, it returns -1
int get(list *l, int index);

//set the element at the specified index of the given list. If the index is invalid, this function does nothing
void set(list *l, int index, int element);

//return the number of elements present in the given list
int length(list *l);

//return the index of the first occurrence of the given element in the given list. If the element is not present, this function returns -1
int index_of(list *l, int element);

#endif

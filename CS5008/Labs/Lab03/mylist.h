#ifndef __MYLIST_H__

#define __MYLIST_H__

//node representation
typedef struct node {
  int data;
  struct node *next;
} node_t;

//list representation

typedef struct list {
  node_t *head;
  node_t *tail;
} list_t;

//make an empty list
void make_empty_list(list_t *mylist);

//add a number to the front of a list
void add_front(list_t *mylist,int data);

//add a number to the back of a list
void add_back(list_t *mylist,int data);

//print the contents of the list, front to back
void print_list(list_t *mylist);

// delete the list
void delete_list(list_t *mylist);

// get the size of the list
unsigned int list_size(list_t *mylist);

//helper functions
node_t * make_node(int data,node_t *next);

#endif

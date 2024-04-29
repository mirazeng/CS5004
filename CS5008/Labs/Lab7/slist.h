#ifndef __SLIST_H_
#define __SLIST_H_

//a structure to represent a node of a singly linked list
typedef struct s_node
{
  int element;
  struct s_node *next;
} node;

//a structure to represent the singly linked list
typedef struct s_list
{
  node *head;
  node *tail;
  int length;
} list;

//initialize and return an empty list
list *init();

//free all the memory of a list
void destroy(list *l);

//add the given element to the back of the given list
void add_back(list* l,int element);

void my_mergesort(list* l);

#endif

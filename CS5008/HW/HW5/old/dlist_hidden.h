#ifndef __SLIST_HIDDEN_H
#define __SLIST_HIDDEN_H

#include "dlist.h"

//this header file stores the functions that are "hidden".
//A user of the list only needs to know dlist.h

node * makenode(node *prev, int element, node *next);

#endif

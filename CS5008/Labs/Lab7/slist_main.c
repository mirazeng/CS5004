#include "slist.h"
#include <stdio.h>
#include <stdlib.h>

int main()
{
  list *l = init();
  int i,j;
  node *curr;

  srand(100); //set the seed of the random number generator

  int size = 100000;

  //generate random numbers between 0 and 10000 and add them to the list
  for (i=0;i<size;i+=1) {
    int num = rand()%10000;
    add_back(l,num);
  }
/*
  printf("Before sorting: \n");
  curr = l->head;
  while (curr!=NULL) {
    printf("%d ",curr->element);
    curr = curr->next;
  }
  printf("\n");
*/
  my_mergesort(l);

/*
  printf("After sorting: \n");
  curr = l->head;
  while (curr!=NULL) {
    printf("%d ",curr->element);
    curr = curr->next;
  }
  printf("\n");

*/
  //verifying that the list is indeed sorted
  curr = l->head;
  while (curr->next!=NULL) {
    if (curr->element>curr->next->element) {
      printf("List is not sorted!\n");
      break;
    }
    curr = curr->next;
  }
  printf("List is properly sorted\n");

  destroy(l);
}

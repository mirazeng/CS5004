// gcc -g memoryleak.c -o memoryleak
// valgrind --leak-check=full --show-leak-kinds=all ./memoryleak

#include <stdio.h>
#include <stdlib.h>

int main() {
  int *arr;
  int size = 5;
  int i;

  arr = (int *)malloc(size * sizeof(int));
  for (i=0;i<size;i+=1) {
    arr[i] = 1;
  }

  printf("The contents of the array are: ");
  for (i=0;i<size;i+=1) {
    printf("%d",arr[i]);
    if (i<size-1) {
      printf(" ");
    }
  }
  printf("\n");

  //create a new array that is twice the size of the old one
  //now we want to add 5 "2s" to the array, but it cannot be resized
  int *arr2 = (int *)malloc(2*size*sizeof(int));
  //copy over all elements
  for (i=0;i<size;i+=1) {
    arr2[i] = arr[i];
  }

  // free up the memory before use the new array to avoid memory leak
  // because the old array will not be used anymore
  free(arr);

  // use the new array from now on
  arr = arr2;
  size = 2*size;

  // add the numbers in now
  for (i=0;i<5;i+=1) {
    arr[5+i] = 2;
  }
  
  printf("The contents of the array now are: ");
  for (i=0;i<size;i+=1) {
    printf("%d",arr[i]);
    if (i<size-1) {
      printf(" ");
    }
  }
  printf("\n");

  // free up the unused memory
  free(arr);
}

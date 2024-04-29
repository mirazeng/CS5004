#include <stdio.h>

// a function to count the number of even numbers in an array
int count_even_numbers(int A[], int length)
{
    // initialize a tracker
    int even_counts = 0;
    // iterate through the array
    for (int i = 0; i < length; i++) {
        // modulo 2 to check if the number is even
        if (A[i] % 2 == 0) {
            even_counts++;
        }
    }
    return even_counts;
}

// a function to count the number of odd numbers in an array
// by using the modulo to check if the number is odd
int count_odd_numbers(int A[], int length)
{
    int odd_counts = 0;
    for (int i = 0; i < length; i++) {
        if (A[i] % 2 != 0) {
            odd_counts++;
        }
    }
    return odd_counts;
}


// a function to find the number of pairs of elements in an array
int find_pairs(int A[], int length)
{
    // base case
    if (length <= 1) {
        return 0;
    }
    // find the midpoint of the array
    int midpoint = length / 2;

    // divide and conquer approach
    int left = find_pairs(A, midpoint); // recursive call the left half
    int right = find_pairs(&A[midpoint], length - midpoint); // recursive call the right half
    int crossover = count_even_numbers(A, midpoint)
            * count_odd_numbers(&A[midpoint], length - midpoint); // a permutation of even and odd numbers pairs

    return left + right + crossover;
}

int main()
{
    int array1[] = {3,2,1,6,4,7};
    int size1 = sizeof(array1) / sizeof(array1[0]);
    printf("The even odd pairs are %d\n", find_pairs(array1, size1));

    int array2[] = {3,1,2,4};
    int size2 = sizeof(array2) / sizeof(array2[0]);
    printf("The even odd pairs are %d\n", find_pairs(array2, size2));

    int array3[] = {2,4,6,1,3,5};
    int size3 = sizeof(array3) / sizeof(array3[0]);
    printf("The even odd pairs are %d\n", find_pairs(array3, size3));
}
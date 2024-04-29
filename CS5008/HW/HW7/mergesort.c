#include "mergesort.h"
#include <string.h>
#include <stdlib.h>

void mergesort_topdown(char **strings, int left, int mid, int right) {
    int i, j, k;
    int str_left = mid - left + 1;
    int str_right = right - mid;

    // create dummy arrays with left and right
    char **L = (char **) malloc(str_left * sizeof(char *));
    char **R = (char **) malloc(str_right * sizeof(char *));

    // copy string data into dummy arrays
    for (i = 0; i < str_left; i++) {
        L[i] = strings[left + i];
    }
    for (j = 0; j < str_right; j++) {
        R[j] = strings[mid + 1 + j];
    }

    // initialize trackers
    i = 0;
    j = 0;
    k = left;
    // compare each element on left and right side of the array
    while (i < str_left && j < str_right) {
        // string comparison
        if (strcmp(L[i], R[j]) <= 0) {
            // substitute with the sorted array
            strings[k] = L[i];
            // move to the right on the left side
            i++;
        } else {
            strings[k] = R[j];
            // move to th next element on the right side
            j++;
        }
        // string tracker increment
        k++;
    }

    // make sure to sort the remaining elements
    while (i < str_left) {
        strings[k] = L[i];
        i++;
        k++;
    }

    while (j < str_right) {
        strings[k] = R[j];
        j++;
        k++;
    }
    // Free dummy arrays
    free(L);
    free(R);
}

void td_mergesort(char **strings,int size) {

    if (size <= 1) {
        return;
    }

    int mid = size / 2;
    td_mergesort(strings, mid);
    td_mergesort(strings + mid, size - mid);

    mergesort_topdown(strings, 0, mid - 1, size - 1);
}

void mergesort_bottom_up(char **string, int left, int mid, int right) {

    int i, j, k;

    while (i <= mid && j <= right) {
        if (strcmp(string[i], string[j]) <= 0) {
            string[k] = string[i];
            i++;
        } else {
            string[k] = string[j];
            j++;
        }
        k++;
    }
    for (int i = 0; i < mid; i++) {
        string[k] = string[i];
        k++;
    }
    for (int j = 0; j < right; j++) {
        string[k] = string[j];
        k++;
    }
    for (int i = 0; i < right; i++) {
        string[i] = string[i];
    }
}

void bu_mergesort(char **strings, int n) {

    int pair;
    int left, mid, right;

    for (pair = 2; pair <= n; pair *= 2) {
        for (int i = 0; i + pair - 1 < n; i += pair) {
            left = i;
            right = i + pair - 1;
            mid = (left + right) / 2;
            mergesort_bottom_up(strings, left, mid, right);
        }
    }
    if (pair / 2 < n) {
        mergesort_bottom_up(strings, 0, (pair / 2) - 1, n - 1);
    }
}
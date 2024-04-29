#include <string.h>

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
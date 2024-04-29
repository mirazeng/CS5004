#include <stdlib.h>
#include "hashtable.h"
#include <string.h>

// Function to create a hashtable
hashtable_t *create_hashtable(int buckets)
{
    // allocate memory for the hashtable
    hashtable_t *table = (hashtable_t *) malloc(sizeof(hashtable_t));
    // allocate memory for the buckets
    table->no_of_buckets = buckets;
    // allocate memory for the buckets
    table->buckets = (node_t **) malloc(sizeof(node_t *) * buckets);

    // initialize the buckets and implement the hash function
    for (int i = 0; i < buckets; i += 1) {
        // set each bucket to NULL
        table->buckets[i] = NULL;
    }
    hashfunction_type myHashFunction = hash;
    table->hash_function = myHashFunction;
    return table;
}

// Function to add data to the hashtable
void hashtable_add(hashtable_t *table, char *entry)
{
    // if there is already the same data in the hashtable
    // ending add operation
    if (hashtable_contains(table, entry)) {
        return;
    }

    // make a copy of the data
    // make sure that the data is not changed
    char *data_copy = strdup(entry);

    // get the number of the buckets
    int bucket = table->hash_function(data_copy, table->no_of_buckets);

    // handle the case where the bucket is empty
    if (table->buckets[bucket] == NULL) {
        // allocate memory for the node
        table->buckets[bucket] = (node_t *) malloc(sizeof(node_t));
        table->buckets[bucket]->data = data_copy;
        table->buckets[bucket]->next = NULL;
    } else {
        // handle when there is a collision
        // AKA when the bucket is not empty and the hashed value is the same

        // create a new node
        node_t *current = table->buckets[bucket];
        // find the last node in the list
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = (node_t *) malloc(sizeof(node_t));
        // add the data to the new node
        current->next->data = data_copy;
        // set the next pointer to NULL
        current->next->next = NULL;
    }
}

// hash function to calculate the hash value
int hash(char *name_pointer, int buckets)
{
    // if the string is empty, return 0
    if (strcmp(name_pointer, "") == 0) {
        return 0;
    }

    // a variable to store the length of the string
    unsigned int string_length = strlen(name_pointer);

    // first letter of the string in ASCII
    char first_letter = name_pointer[0];
    // last letter of the string in ASCII
    char last_letter = name_pointer[string_length - 1];
    // middle letter is 1/2 size of the string
    char middle_letter = name_pointer[string_length / 2];

    // the average of three values
    int sum = (first_letter + last_letter + middle_letter) / 3;

    // return the modulo of the sum and the number of buckets
    // make sure that the result is within the range of the buckets
    return sum % buckets;
}

// Function to check if the hashtable contains the data
bool hashtable_contains(hashtable_t *table, char *entry)
{
    // get the number of the buckets
    int bucket = table->hash_function(entry, table->no_of_buckets);

    // check if the data is in the bucket
    node_t *current = table->buckets[bucket];
    while (current != NULL) {
        // compare the data
        // and if the data is found, return true
        if (strcmp(current->data, entry) == 0) {
            return true;
        }
        // move to the next node
        current = current->next;
    }
    // if the data is not found, return false
    return false;
}

// Function to delete an existing hashtable
void delete_hashtable(hashtable_t *table)
{
    // iterate through the buckets
    for (int i = 0; i < table->no_of_buckets; i += 1) {
        node_t *current = table->buckets[i];
        // iterate through the nodes in the bucket
        while (current != NULL) {
            node_t *temp = current;
            // move to the next node
            current = current->next;
            // free the memory allocated for the data
            free(temp->data);
            // free the memory allocated for the node
            free(temp);
        }
    }
    // free the memory allocated for the buckets
    free(table->buckets);
    // free the memory allocated for the hashtable
    free(table);
}
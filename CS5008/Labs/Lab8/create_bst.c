#include <stdlib.h>
#include "create_bst.h"

// a function to create a new node
bst_node_t *create_node(int data) {
    bst_node_t *new_node = (bst_node_t *) malloc(sizeof(bst_node_t));
    new_node->data = data;
    new_node->left = NULL;
    new_node->right = NULL;
    return new_node;
}

// a function to clear the binary search tree
void clear_tree(bst_node_t *root) {
    if (root == NULL) {
        return;
    }

    clear_tree(root->left); // recursively clear the left subtree
    clear_tree(root->right); // recursively clear the right subtree

    free(root); // free the current node
}
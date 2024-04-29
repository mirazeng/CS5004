#ifndef LAB8_CREATE_BST_H

// a structure to represent a node of a binary search tree
typedef struct bst_node {
    int data;
    struct bst_node* left;
    struct bst_node* right;
} bst_node_t;

bst_node_t *create_node(int data);

void clear_tree(bst_node_t *root);

#define LAB8_CREATE_BST_H

#endif //LAB8_CREATE_BST_H

#include "bst.h"
#include <stdlib.h>

bst_node_t *makenode(int element, bst_node_t *left, bst_node_t *right)
{
    bst_node_t *root;
    root = (bst_node_t *) malloc(sizeof(bst_node_t));
    root->data = element;
    root->left = left;
    root->right = right;
    return root;
}

int size(bst_node_t *root)
{
}

bst_node_t *add(bst_node_t *root, int element)
{

    bst_node_t *curr = root;
    bst_node_t *prev = NULL;

    while ((curr != NULL) && (curr->data != element)) {
        prev = curr;
        if (curr->data > element) {
            curr = curr->left;
        } else {
            curr = curr->right;
        }
    }

    if (curr == NULL) {
        curr = makenode(element, NULL, NULL);
        if (prev != NULL) {
            if (prev->data > element) {
                prev->left = curr;
            } else {
                prev->right = curr;
            }
        } else {
            root = curr;
        }
    }
    return root;
}

bool exists(bst_node_t *root, int element)
{
    bst_node_t *curr = root;
    while (curr != NULL) {
        if (curr->data == element) {
            return true;
        } else if (curr->data > element) {
            curr = curr->left;
        } else {
            curr = curr->right;
        }
    }
    return false;
}

int height(bst_node_t *root)
{
    if (root == NULL) {
        return -1;
    } else {
        int left = height(root->left);
        int right = height(root->right);
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }
}

bool is_balanced(bst_node_t *root)
{

}

void clean(bst_node_t *root)
{
    if (root != NULL) {
        clean(root->left);
        clean(root->right);
        free(root);
    }
}
      

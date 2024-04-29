#include <stdio.h>
#include <stdlib.h>
#include "create_bst.h"

// a function to make the binary search tree into a sorted array
int *bst_to_array(bst_node_t *root, int *array, int *index)
{
    // handle empty tree or has reached the leaf node
    if (root == NULL) {
        return array;
    }
    // recursively append the left and right subtrees
    // since the left subtree is always less than the root
    bst_to_array(root->left, array, index);

    // append the current root to the array first
    array[*index] = root->data;
    // increment the index
    *index += 1;

    // then append the right subtree
    // the right is always greater than the root
    bst_to_array(root->right, array, index);

    return array;
}

// a function to count nodes in the binary search tree
// returns the size of the tree
int count_nodes(bst_node_t *root)
{
    if (root == NULL) {
        return 0;
    }
    // recursively count the left and right subtrees
    return 1 + count_nodes(root->left) + count_nodes(root->right);
}

// a function to make the sorted array into a binary search tree
bst_node_t *array_to_bst(int *array, int start, int end)
{
    // handle the base case
    if (start > end) {
        return NULL;
    }
    // find the middle of the array
    int mid = (start + end) / 2;
    // create a new node with the middle element
    bst_node_t *root = create_node(array[mid]);
    // recursively create the left and right subtrees
    root->left = array_to_bst(array, start, mid - 1); // to the left
    root->right = array_to_bst(array, mid + 1, end); // to the right
    return root;
}

// a function to balance the binary search tree
// by converting it to a sorted array and then creating a new binary search tree
// from the sorted array
// the runtime complexity of this function is O(n) where n is the number of nodes in the tree
// the space complexity of this function is O(n) where n is the number of nodes in the tree
bst_node_t *balance(bst_node_t *root)
{
    int size = count_nodes(root);

    // create an array to store the elements of the tree
    int *array = (int *) malloc(sizeof(int) * size);

    // initialize the index to 0
    // make sure to start from the beginning of the temp array
    int index = 0;
    // convert the binary search tree to a sorted array
    array = bst_to_array(root, array, &index);
    // clear the memory of the original binary search tree
    clear_tree(root);

    // create a new binary search tree from the sorted array
    bst_node_t *new_root = array_to_bst(array, 0, size - 1);
    // free the memory
    free(array);

    // return the new balanced binary search tree
    return new_root;
}

// a function to print the binary search tree
void print_tree(bst_node_t *root)
{
    if (root == NULL) {
        return;
    }

    printf("%d\n", root->data);

    printf("left: \n");
    print_tree(root->left); // recursively print the left subtree

    printf("right: \n");
    print_tree(root->right); // recursively print the right subtree
}

int main()
{
    // ==================== Test case 1 ====================
    // create a binary search tree
    bst_node_t *node1 = create_node(7);
    bst_node_t *node2 = create_node(3);
    bst_node_t *node3 = create_node(2);
    bst_node_t *node4 = create_node(4);
    bst_node_t *node5 = create_node(1);
    bst_node_t *node6 = create_node(10);

    node1->left = node2; // 7 left -> 3
    node1->right = node6; // 7 right -> 10

    node2->left = node3; // 3 left -> 2
    node2->right = node4; // 3 right -> 4

    node3->left = node5; // 2 left -> 1

    //              7
    //            /   \
    //           3     10
    //          / \
    //        2    4
    //       /
    //      1

    // print the balanced binary search tree
    bst_node_t *balanced_tree_1 = balance(node1);
    print_tree(balanced_tree_1);

    //              3
    //            /   \
    //           1     7
    //            \   / \
    //            2  4   10

    // free the memory
    clear_tree(balanced_tree_1);

    // ==================== Test case 2 ====================
    // create a binary search tree with only right children
    bst_node_t *node7 = create_node(1);
    bst_node_t *node8 = create_node(2);
    bst_node_t *node9 = create_node(3);
    bst_node_t *node10 = create_node(4);

    node7->right = node8; // 1 right -> 2
    node8->right = node9; // 2 right -> 3
    node9->right = node10; // 3 right -> 4
    //              1
    //               \
    //                2
    //                 \
    //                  3
    //                   \
    //                    4

    // print the balanced binary search tree
    bst_node_t *balanced_tree_2 = balance(node7);
    printf("\nBalanced tree 2: \n");
    print_tree(balanced_tree_2);

    //              2
    //            /   \
    //           1     3
    //                 \
    //                  4

    // free the memory
    clear_tree(balanced_tree_2);

    // ==================== Test case 3 ====================
    // create a binary search tree with only left children
    bst_node_t *node11 = create_node(4);
    bst_node_t *node12 = create_node(3);
    bst_node_t *node13 = create_node(2);
    bst_node_t *node14 = create_node(1);

    node11->left = node12; // 4 left -> 3
    node12->left = node13; // 3 left -> 2
    node13->left = node14; // 2 left -> 1
    //              4
    //            /
    //           3
    //         /
    //        2
    //      /
    //     1

    // print the balanced binary search tree
    bst_node_t *balanced_tree_3 = balance(node11);
    printf("\nBalanced tree 3: \n");
    print_tree(balanced_tree_3);
    //              2
    //            /   \
    //           1     3
    //                 \
    //                  4

    // free the memory
    clear_tree(balanced_tree_3);

    // ==================== Test case 4 ====================
    // create a binary search tree is already balanced
    bst_node_t *node15 = create_node(2);
    bst_node_t *node16 = create_node(1);
    bst_node_t *node17 = create_node(3);

    node15->left = node16; // 2 left -> 1
    node15->right = node17; // 2 right -> 3
    //              2
    //            /   \
    //           1     3

    // print the balanced binary search tree
    bst_node_t *balanced_tree_4 = balance(node15);
    printf("\nBalanced tree 4: \n");
    print_tree(balanced_tree_4);
    //              2
    //            /   \
    //           1     3

    // free the memory
    clear_tree(balanced_tree_4);

    // ==================== Test case 5 ====================
    // create a binary search tree with only one node
    bst_node_t *node18 = create_node(1);

    // print the balanced binary search tree
    bst_node_t *balanced_tree_5 = balance(node18);

    printf("\nBalanced tree 5: \n");
    print_tree(balanced_tree_5);

    // free the memory
    clear_tree(balanced_tree_5);

    return 0;
}
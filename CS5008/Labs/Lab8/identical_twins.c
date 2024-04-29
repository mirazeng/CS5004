#include "create_bst.h"
#include "identical_twins.h"
#include <stdio.h>
#include <stdlib.h>

// this function checks if two binary search trees are identical
// by recursively checking the data of the roots and the left and right subtrees
// and comparing with each other
// the runtime complexity of this function is O(n) where n is the number of nodes in the tree
// the space complexity of this function is O(n) where n is the number of nodes in the tree
bool is_identical(bst_node_t *root1, bst_node_t *root2)
{
    // if both trees are empty, they are identical
    if (root1 == NULL && root2 == NULL) {
        return true;
    }
    // if one of the trees is empty, they are not identical
    else if (root1 == NULL || root2 == NULL) {
        return false;
    }
    // if the data of the roots are not equal, they are not identical
    else if (root1->data != root2->data) {
        return false;
    }
    // recursively check the left and right subtrees
    return is_identical(root1->left, root2->left)
           && is_identical(root1->right, root2->right);
}

int main()
{
    // ==================== Test with identical trees ====================
    bst_node_t *root1 = create_node(1);
    root1->left = create_node(2);
    root1->right = create_node(3);
    root1->left->left = create_node(4);
    root1->left->right = create_node(5);
    root1->right->left = create_node(6);
    root1->right->right = create_node(7);
    //              1
    //            /   \
    //           2     3
    //          / \   / \
    //         4   5 6   7

    bst_node_t *root2 = create_node(1);
    root2->left = create_node(2);
    root2->right = create_node(3);
    root2->left->left = create_node(4);
    root2->left->right = create_node(5);
    root2->right->left = create_node(6);
    root2->right->right = create_node(7);
    //              1
    //            /   \
    //           2     3
    //          / \   / \
    //         4   5 6   7
    if (is_identical(root1, root2) == true) {
        printf("The first two trees are identical\n");
    } else {
        printf("The first two trees are not identical\n");
    }

    // ==================== Test with non-identical trees but same root =====
    bst_node_t *root3 = create_node(3);
    root3->left = create_node(1);
    root3->right = create_node(7);
    root3->left->right = create_node(2);
    root3->right->left = create_node(4);
    root3->right->right = create_node(10);
    //              3
    //            /   \
    //           1     7
    //            \   / \
    //            2  4   10

    bst_node_t *root4 = create_node(3);
    root4->left = create_node(2);
    root4->right = create_node(7);
    root4->left->left = create_node(1);
    root4->right->left = create_node(4);
    root4->right->right = create_node(10);
    //              3
    //            /   \
    //           2     7
    //          /     / \
    //         1     4   10
    if (is_identical(root3, root4) == true) {
        printf("The second two trees are identical\n");
    } else {
        printf("The second two trees are not identical\n");
    }

    // ================ Test with non-identical trees with different root =====
    bst_node_t *root5 = create_node(3);
    root5->left = create_node(1);
    root5->right = create_node(7);
    root5->left->right = create_node(2);
    root5->right->left = create_node(4);
    root5->right->right = create_node(10);
    //              3
    //            /   \
    //           1     7
    //            \   / \
    //            2  4   10

    bst_node_t *root6 = create_node(4);
    root6->left = create_node(2);
    root6->right = create_node(7);
    root6->left->left = create_node(1);
    //              4
    //            /   \
    //           2     7
    //          /
    //         1
    if (is_identical(root5, root6) == true) {
        printf("The third two trees are identical\n");
    } else {
        printf("The third two trees are not identical\n");
    }

    // free the memory
    clear_tree(root1);
    clear_tree(root2);
    clear_tree(root3);
    clear_tree(root4);
    clear_tree(root5);
    clear_tree(root6);

    return 0;
}
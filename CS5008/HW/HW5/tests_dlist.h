
#ifndef CODE_TESTS_DLIST_H
#define CODE_TESTS_DLIST_H

//int test_driver();

int test_init();
int test_add_front_empty();
int test_add_front_regular();
int test_add_back_empty();
int test_add_back_regular();
int test_remove_front_empty();
int test_remove_front_one_node();
int test_remove_front_regular();
int test_remove_back_empty();
int test_remove_back_one_node();
int test_remove_back_regular();
int test_get_with_negative_index();
int test_get_with_index_out_of_bound();
int test_get_with_index_in_bound();
int test_set_with_negative_index();
int test_set_with_index_out_of_bound();
int test_set_with_index_in_bound();


#endif //CODE_TESTS_DLIST_H

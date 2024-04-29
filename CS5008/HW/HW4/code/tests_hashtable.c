// gcc -g tests_hashtable.c hashtable.c -o tests
// valgrind --leak-check=full --show-leak-kinds=all ./tests

#include "hashtable.h"
#include <stdio.h>
#include <string.h>

// test create hashtable function with nothing in it
int test_create_empty_hashtable()
{
    printf("\n---Test create_empty_hashtable begin: ---\n");

    hashtable_t *empty_table = create_hashtable(10);
    if (empty_table->no_of_buckets != 10) {
        printf("create_empty_hashtable failed, because %d is not 10\n", empty_table->no_of_buckets);
        return 0;
    }
    for (int i = 0; i < 10; i += 1) {
        if (empty_table->buckets[i] != NULL) {
            printf("create_empty_hashtable failed, because empty_table.buckets[%d] is not NULL\n", i);
            return 0;
        }
    }
    printf("---Test create_empty_hashtable end ---\n");
    printf("\n");

    delete_hashtable(empty_table);

    return 1;
}

// test add function with regular string
int test_hashtable_add_regular()
{
    printf("\n---Test hashtable_add_regular begin: ---\n");

    hashtable_t *table = create_hashtable(200);
    hashtable_add(table, "the");
    hashtable_add(table, "blue");
    hashtable_add(table, "sky");

    bool correctness = true;

    // compare the element in the bucket with the expected value
    int bucket_index_the = table->hash_function("the", table->no_of_buckets);
    int bucket_index_blue = table->hash_function("blue", table->no_of_buckets);
    int bucket_index_sky = table->hash_function("sky", table->no_of_buckets);


    // check if the first element is "the"
    if (strcmp(table->buckets[bucket_index_the]->data, "the") != 0) {
        printf("hashtable_add failed, because \"the\" is not present\n");
        correctness = false;
    }

    // check if the second element is "blue"
    if (strcmp(table->buckets[bucket_index_blue]->data, "blue") != 0) {
        printf("hashtable_add failed, because \"blue\" is not present\n");
        correctness = false;
    }

    // check if the third element is "whale"
    if (strcmp(table->buckets[bucket_index_sky]->data, "sky") != 0) {
        printf("hashtable_add failed, because \"sky\" is not present\n");
        correctness = false;
    }

    delete_hashtable(table);

    if (correctness == false) {
        return 0;
    } else {
        printf("---Test hashtable_add_regular end ---\n");
        printf("\n");
    }
    return 1;
}

// test add function using strings with varied case
int test_hashtable_add_case_matter()
{
    printf("\n---Test hashtable_add_cases_matter begin: ---\n");

    hashtable_t *table = create_hashtable(4);
    hashtable_add(table, "the");
    hashtable_add(table, "The");
    hashtable_add(table, "tHe");
    hashtable_add(table, "thE");

    bool correctness = true;
    // use hash contain to see if the value is here
    if (hashtable_contains(table, "the") != true) {
        printf("hashtable_add_cases_matter failed, because \"the\" is not present\n");
        correctness = false;
    }
    if (hashtable_contains(table, "The") != true) {
        printf("hashtable_add_cases_matter failed, because \"The\" is not present\n");
        correctness = false;
    }
    if (hashtable_contains(table, "tHe") != true) {
        printf("hashtable_add_cases_matter failed, because \"tHe\" is not present\n");
        correctness = false;
    }
    if (hashtable_contains(table, "thE") != true) {
        printf("hashtable_add_cases_matter failed, because \"thE\" is not present\n");
        correctness = false;
    }

    delete_hashtable(table);

    if (correctness == false) {
        return 0;
    } else {
        printf("---Test hashtable_add_cases_matter end ---\n");
        printf("\n");
        return 1;
    }
}

// test add function with strings that produce collision
int test_hashtable_add_collision()
{

    printf("\n---Test hashtable_add_collision begin: ---\n");

    hashtable_t *table = create_hashtable(999);
    hashtable_add(table, "whale");
    hashtable_add(table, "wbace");

    int bucket_index_whale = table->hash_function("whale", table->no_of_buckets);
    node_t *current = table->buckets[bucket_index_whale];

    bool correctness = true;

    // check if the first element is "whale"
    if (strcmp(current->data, "whale") != 0) {
        printf("hashtable_add_collision failed, because \"whale\" is not present\n");
        correctness = false;
    }

    // check if the second element is "wbace"
    current = current->next;

    // check if the second element is "wbace"
    if (strcmp(current->data, "wbace") != 0) {
        printf("hashtable_add_collision failed, because \"wbace\" is not present\n");
        correctness = false;
    }
    // check if there is a third element
    if (current->next != NULL) {
        printf("hashtable_add_collision failed, because there is a third element\n");
        correctness = false;
    }

    delete_hashtable(table);

    if (correctness == false) {
        return 0;
    } else {
        printf("---Test hashtable_add_collision end ---\n");
        printf("\n");
    }
    return 1;
}

// test add function with empty string
int test_hashtable_add_empty()
{

    printf("\n---Test hashtable_add_empty begin: ---\n");

    hashtable_t *table = create_hashtable(10);
    hashtable_add(table, "");

    int bucket_index_empty = table->hash_function("", table->no_of_buckets);
    node_t *current = table->buckets[bucket_index_empty];

    bool correctness = true;

    // check if the first element is ""
    if (strcmp(current->data, "") != 0) {
        printf("hashtable_add_empty failed, because \"\" is not present\n");
        correctness = false;
    }

    // check if there is a second element
    if (current->next != NULL) {
        printf("hashtable_add_empty failed, because there is a second element\n");
        correctness = false;
    }

    delete_hashtable(table);

    if (correctness == false) {
        return 0;
    } else {
        printf("---Test hashtable_add_empty end ---\n");
        printf("\n");
    }
    return 1;
}

// test adding a group of string to a hashtable with one bucket
int test_hashtable_add_large()
{
    printf("\n---Test hashtable_add_large begin: ---\n");

    hashtable_t *table = create_hashtable(1);
    hashtable_add(table, "the");
    hashtable_add(table, "blue");
    hashtable_add(table, "whale");
    hashtable_add(table, "is");
    hashtable_add(table, "so");
    hashtable_add(table, "big");
    hashtable_add(table, "aba");

    bool correctness = true;

    // implement hash contain to check
    if (hashtable_contains(table, "the") != true) {
        printf("hashtable_add_large failed, because \"the\" is not present\n");
        correctness = false;
    }
    if (hashtable_contains(table, "blue") != true) {
        printf("hashtable_add_large failed, because \"blue\" is not present\n");
        correctness = false;
    }
    if (hashtable_contains(table, "whale") != true) {
        printf("hashtable_add_large failed, because \"whale\" is not present\n");
        correctness = false;
    }
    if (hashtable_contains(table, "is") != true) {
        printf("hashtable_add_large failed, because \"is\" is not present\n");
        correctness = false;
    }
    if (hashtable_contains(table, "so") != true) {
        printf("hashtable_add_large failed, because \"so\" is not present\n");
        correctness = false;
    }
    if (hashtable_contains(table, "big") != true) {
        printf("hashtable_add_large failed, because \"big\" is not present\n");
        correctness = false;
    }
    if (hashtable_contains(table, "aba") != true) {
        printf("hashtable_add_large failed, because \"aba\" is not present\n");
        correctness = false;
    }

    delete_hashtable(table);

    if (correctness == false) {
        return 0;
    } else {
        printf("---Test hashtable_add_large end ---\n");
        printf("\n");
    }
    return 1;
}

// test adding the same string to the hashtable
int test_hashtable_add_same()
{
    printf("\n---Test test_hashtable_add_same begin: ---\n");

    hashtable_t *table = create_hashtable(1);
    hashtable_add(table, "the");
    hashtable_add(table, "the");

    bool correctness = true;

    // check if the first element "the" is added and present
    if (hashtable_contains(table, "the") != true) {
        printf("test_hashtable_add_same failed, because \"the\" is not present\n");
        correctness = false;
    }
    // check if the second element "the" is not added
    if (table->buckets[0]->next != NULL) {
        printf("test_hashtable_add_same failed, because there is a second element\n");
        correctness = false;
    }

    delete_hashtable(table);

    if (correctness == false) {
        return 0;
    } else {
        printf("---Test test_hashtable_add_same end ---\n");
        printf("\n");
    }
    return 1;
}

// test hash calculation with empty string
int test_hash_function_empty()
{

    printf("\n---Test test_hash_function_empty begin: ---\n");

    if (hash("", 10) != 0) {
        printf("test_hash_function_empty failed, because hash value is not 0\n");
        return 0;

    }
    printf("---Test test_hash_function_empty end ---\n");
    printf("\n");
    return 1;
}

// testing hash value with input even length string
int test_hash_function_even_length()
{
    printf("\n---Test test_hash_function_even_length begin: ---\n");

    // compare the hash value with expected one
    if (hash("aabcc", 10) != 8) {
        printf("test_hash_function_even_length failed, because hash value is not 8\n");
        return 0;
    }
    printf("---Test test_hash_function_even_length end ---\n");
    printf("\n");
    return 1;
}

// testing hash value with input odd length string
int test_hash_function_odd_length()
{
    printf("\n---Test test_hash_function_odd_length begin: ---\n");

    // compare the hash value with expected one
    if (hash("aaabbb", 10) != 7) {
        printf("test_hash_function_odd_length failed, because hash value is not 8\n");
        return 0;
    }
    printf("---Test test_hash_function_odd_length end ---\n");
    printf("\n");
    return 1;
}

// test hash value of strings with special characters
int test_hash_function_special_characters()
{
    printf("\n---Test test_hash_function_special_characters begin: ---\n");

    // compare the hash value with expected one
    if (hash("a!@#$%^&*()_+b", 10) != 7) {
        printf("test_hash_function_special_characters failed, because hash value is not 8\n");
        return 0;
    }
    printf("---Test test_hash_function_special_characters end ---\n");
    printf("\n");
    return 1;
}

// test contains method by checking if non-existent item exists
int test_hashtable_contains_none()
{
    printf("\n---Test test_hashtable_contains_none begin: ---\n");

    hashtable_t *table = create_hashtable(10);

    bool present = hashtable_contains(table, "is");
    if (present != false) {
        printf("test_hashtable_contains_none failed, because \"is\" is present\n");
        return 0;
    }

    delete_hashtable(table);

    printf("---Test test_hashtable_contains_none end ---\n");
    printf("\n");
    return 1;
}

// test hashtable contains the added strings to see
// if hashtable_contains works well
int test_hashtable_contains_regular()
{

    printf("\n---Test test_hashtable_contains_regular begin: ---\n");

    hashtable_t *table = create_hashtable(3);
    hashtable_add(table, "the");
    hashtable_add(table, "blue");
    hashtable_add(table, "whale");

    bool present_1 = hashtable_contains(table, "the");
    if (present_1 != true) {
        printf("test_hashtable_contains_regular failed, because \"the\" is not present\n");
        return 0;
    }

    bool present_2 = hashtable_contains(table, "blue");
    if (present_2 != true) {
        printf("test_hashtable_contains_regular failed, because \"blue\" is not present\n");
        return 0;
    }

    bool present_3 = hashtable_contains(table, "whale");
    if (present_3 != true) {
        printf("test_hashtable_contains_regular failed, because \"whale\" is not present\n");
        return 0;
    } else {

        delete_hashtable(table);

        printf("---Test test_hashtable_contains_regular end ---\n");
        printf("\n");
        return 1;
    }
}

// test if hashtable correctly contains empty strings
int test_hashtable_contains_empty()
{

    printf("\n---Test test_hashtable_contains_empty begin: ---\n");

    hashtable_t *table = create_hashtable(1);
    hashtable_add(table, "");

    bool present = hashtable_contains(table, "");

    if (present != true) {
        printf("test_hashtable_contains_empty failed, because \"\" is not present\n");
        return 0;
    } else {

        delete_hashtable(table);

        printf("---Test test_hashtable_contains_empty end ---\n");
        printf("\n");
        return 1;
    }
}

// a comprehensive test with all the functions
int test_comprehensive_path()
{

    printf("\n---Test test_comprehensive_path begin: ---\n");

    hashtable_t *my_table = create_hashtable(4);

    // hash add will call hash function
    // hash value calculation included
    hashtable_add(my_table, "Thank");
    hashtable_add(my_table, "you");
    hashtable_add(my_table, "CS");
    hashtable_add(my_table, "5008");

    bool present_1 = hashtable_contains(my_table, "Thank");
    if (present_1 != true) {
        printf("test_comprehensive_path failed, because \"Thank\" is not present\n");
        return 0;
    }
    bool present_2 = hashtable_contains(my_table, "you");
    if (present_2 != true) {
        printf("test_comprehensive_path failed, because \"you\" is not present\n");
        return 0;
    }
    bool present_3 = hashtable_contains(my_table, "CS");
    if (present_3 != true) {
        printf("test_comprehensive_path failed, because \"CS\" is not present\n");
        return 0;
    }
    bool present_4 = hashtable_contains(my_table, "5008");
    if (present_4 != true) {
        printf("test_comprehensive_path failed, because \"5008\" is not present\n");
        return 0;
    } else {
        delete_hashtable(my_table);
        printf("---Test test_comprehensive_path end ---\n");
        printf("\n");
        return 1;
    }
}

int main()
{
    // test begin
    int total_tests = 15;
    int passed_tests = 0;

    passed_tests += test_create_empty_hashtable();

    passed_tests += test_hashtable_add_regular();
    passed_tests += test_hashtable_add_case_matter();
    passed_tests += test_hashtable_add_collision();

    passed_tests += test_hashtable_add_empty();
    passed_tests += test_hashtable_add_large();
    passed_tests += test_hashtable_add_same();

    passed_tests += test_hash_function_empty();
    passed_tests += test_hash_function_even_length();
    passed_tests += test_hash_function_odd_length();
    passed_tests += test_hash_function_special_characters();

    passed_tests += test_hashtable_contains_none();
    passed_tests += test_hashtable_contains_regular();
    passed_tests += test_hashtable_contains_empty();

    passed_tests += test_comprehensive_path();

    printf("\nPassed %d out of %d tests\n", passed_tests, total_tests);
}


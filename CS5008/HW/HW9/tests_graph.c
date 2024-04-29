#include "graph.h"
#include <stdio.h>
#include <stdlib.h>

// Test on using init_graph method
int test_init_graph()
{
    printf("Testing init_graph():\n");

    // Test with valid number of vertices
    graph_t *graph = init_graph(5);
    int passed = 1;
    if (graph == NULL || graph->num_vertices != 5 || graph->num_edges != 0) {
        printf("  Test failed: Valid number of vertices\n");
        passed = 0;
    }
    delete_graph(graph);

    // Test with invalid number of vertices
    graph = init_graph(-1);
    if (graph != NULL) {
        printf("  Test failed: Invalid number of vertices\n");
        passed = 0;
    }

    if (passed) {
        printf("  Test passed: init_graph()\n");
    }
    printf("\n");
    return passed;
}

// Test creating a graph with lots of vertices
int test_init_graph_large()
{
    printf("Testing init_graph() with a large number of vertices:\n");
    int num_vertices = 10000;
    graph_t *graph = init_graph(num_vertices);

    int passed = 1;
    if (graph == NULL || graph->num_vertices != num_vertices || graph->num_edges != 0) {
        printf("  Test failed: Large number of vertices\n");
        passed = 0;
    }

    delete_graph(graph);
    return passed;
}

// Tests on adding edge to vertices in a graph
int test_add_edge()
{
    printf("Testing add_edge():\n");
    graph_t *graph = init_graph(5);

    int passed = 1;

    // Test adding a valid edge
    add_edge(graph, 0, 1, 5);
    if (graph->num_edges != 1 || graph->adjacency_list[0]->destination != 1 || graph->adjacency_list[0]->weight != 5) {
        printf("  Test failed: Adding a valid edge\n");
        passed = 0;
    }

    // Test adding an edge with invalid vertices
    add_edge(graph, -1, 3, 2);
    if (graph->num_edges != 1) {
        printf("  Test failed: Adding an edge with invalid vertices\n");
        passed = 0;
    }

    // Test updating an existing edge
    add_edge(graph, 0, 1, 10);
    if (graph->num_edges != 1 || graph->adjacency_list[0]->weight != 10) {
        printf("  Test failed: Updating an existing edge\n");
        passed = 0;
    }

    if (passed) {
        printf("  Test passed: add_edge()\n");
    }

    delete_graph(graph);
    printf("\n");
    return passed;
}

// Testing adding an edge with the same vertices, a self loop
int test_add_edge_same_vertices()
{
    printf("Testing add_edge() with the same vertices:\n");
    graph_t *graph = init_graph(5);
    add_edge(graph, 1, 1, 5);

    int passed = 1;
    if (graph->num_edges != 1) {
        printf("  Test failed: Adding an edge with the same vertices\n");
        passed = 0;
    }

    delete_graph(graph);
    return passed;
}

// Testing is_adject() method on a graph
int test_is_adjacent()
{
    printf("Testing is_adjacent():\n");
    graph_t *graph = init_graph(5);
    add_edge(graph, 0, 1, 5);
    add_edge(graph, 1, 2, 3);

    int passed = 1;

    // Test with adjacent vertices
    if (!is_adjacent(graph, 0, 1)) {
        printf("  Test failed: Adjacent vertices\n");
        passed = 0;
    }

    // Test with non-adjacent vertices
    if (is_adjacent(graph, 0, 2)) {
        printf("  Test failed: Non-adjacent vertices\n");
        passed = 0;
    }

    // Test with invalid vertices
    if (is_adjacent(graph, -1, 3)) {
        printf("  Test failed: Invalid vertices\n");
        passed = 0;
    }

    if (passed) {
        printf("  Test passed: is_adjacent()\n");
    }

    delete_graph(graph);
    printf("\n");
    return passed;
}


// Testing finding shortest paths on unweighted graph
int test_lengths_unweighted_shortest_paths()
{
    printf("Testing lengths_unweighted_shortest_paths():\n");
    graph_t *graph = init_graph(5);
    add_edge(graph, 0, 1, 1);
    add_edge(graph, 0, 2, 1);
    add_edge(graph, 1, 3, 1);
    add_edge(graph, 2, 3, 1);
    add_edge(graph, 3, 4, 1);

    int expected[] = {0, 1, 1, 2, 3};
    int *result = lengths_unweighted_shortest_paths(graph, 0);

    int passed = 1;
    for (int i = 0; i < graph->num_vertices; i++) {
        if (result[i] != expected[i]) {
            passed = 0;
            break;
        }
    }

    if (passed) {
        printf("  Test passed: Unweighted shortest paths\n");
    } else {
        printf("  Test failed: Unweighted shortest paths\n");
    }

    free(result);
    delete_graph(graph);
    printf("\n");
    return passed;
}

// Testing finding shortest paths on unweighted graph with separation
int test_lengths_unweighted_shortest_paths_disconnected()
{
    printf("Testing lengths_unweighted_shortest_paths() with disconnected components:\n");
    graph_t *graph = init_graph(6);
    add_edge(graph, 0, 1, 1);
    add_edge(graph, 1, 2, 1);
    add_edge(graph, 3, 4, 1);
    add_edge(graph, 4, 5, 1);

    int INFINITE_VALUE = 123456;
    int expected[] = {0, 1, 2, INFINITE_VALUE, INFINITE_VALUE, INFINITE_VALUE};
    int *result = lengths_unweighted_shortest_paths(graph, 0);

    int passed = 1;
    for (int i = 0; i < graph->num_vertices; i++) {
        if (result[i] != expected[i]) {
            printf("  Test failed: test_lengths_unweighted_shortest_paths() on graph with separated vertex groups errors.\n");
            passed = 0;
            break;
        }
    }

    free(result);
    delete_graph(graph);
    return passed;
}

// Testing finding shortest paths on weighted graph
int test_lengths_weighted_shortest_paths()
{
    printf("Testing lengths_weighted_shortest_paths():\n");
    graph_t *graph = init_graph(5);
    add_edge(graph, 0, 1, 1);
    add_edge(graph, 0, 2, 4);
    add_edge(graph, 1, 2, 2);
    add_edge(graph, 1, 3, 7);
    add_edge(graph, 2, 3, 3);
    add_edge(graph, 3, 4, 2);

    int expected[] = {0, 1, 3, 6, 8};
    int *result = lengths_weighted_shortest_paths(graph, 0);

    int passed = 1;
    for (int i = 0; i < graph->num_vertices; i++) {
        if (result[i] != expected[i]) {
            passed = 0;
            break;
        }
    }

    if (passed) {
        printf("  Test passed: Weighted shortest paths\n");
    } else {
        printf("  Test failed: Weighted shortest paths\n");
    }

    free(result);
    delete_graph(graph);
    printf("\n");
    return passed;
}

// Testing finding shortest paths on weighted graph with equal weights
int test_lengths_weighted_shortest_paths_equal_weights()
{
    printf("Testing lengths_weighted_shortest_paths() with equal weights:\n");
    graph_t *graph = init_graph(5);
    add_edge(graph, 0, 1, 1);
    add_edge(graph, 0, 2, 1);
    add_edge(graph, 1, 3, 1);
    add_edge(graph, 2, 3, 1);
    add_edge(graph, 3, 4, 1);

    int expected[] = {0, 1, 1, 2, 3};
    int *result = lengths_weighted_shortest_paths(graph, 0);

    int passed = 1;
    for (int i = 0; i < graph->num_vertices; i++) {
        if (result[i] != expected[i]) {
            printf("  Test failed: Equal weights\n");
            passed = 0;
            break;
        }
    }

    free(result);
    delete_graph(graph);
    return passed;
}

// Testing finding shortest paths on weighted edge graph with negative weights
int test_lengths_weighted_shortest_paths_negative_weights()
{
    printf("Testing lengths_weighted_shortest_paths() with negative weights:\n");
    graph_t *graph = init_graph(4);
    add_edge(graph, 0, 1, -1);
    add_edge(graph, 0, 2, 4);
    add_edge(graph, 1, 2, 3);
    add_edge(graph, 1, 3, 2);
    add_edge(graph, 2, 3, 5);

    int expected[] = {0, -1, 2, 1};
    int *result = lengths_weighted_shortest_paths(graph, 0);

    int passed = 1;
    for (int i = 0; i < graph->num_vertices; i++) {
        if (result[i] != expected[i]) {
            printf("  Test failed: Negative weights\n");
            passed = 0;
            break;
        }
    }

    free(result);
    delete_graph(graph);
    return passed;
}

int main()
{
    int total_tests = 10;
    int tests_passed = 0;

    tests_passed += test_init_graph();
    tests_passed += test_init_graph_large();
    tests_passed += test_add_edge();
    tests_passed += test_add_edge_same_vertices();
    tests_passed += test_is_adjacent();
    tests_passed += test_lengths_unweighted_shortest_paths();
    tests_passed += test_lengths_unweighted_shortest_paths_disconnected();
    tests_passed += test_lengths_weighted_shortest_paths();
    tests_passed += test_lengths_weighted_shortest_paths_equal_weights();
    tests_passed += test_lengths_weighted_shortest_paths_negative_weights();

    printf("\nRan %d tests, passed %d tests, failed %d tests\n", total_tests, tests_passed, total_tests - tests_passed);
    return 0;
}
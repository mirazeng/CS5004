#include "graph.h"
#include <stdlib.h>
#include <stdbool.h>
#include <stdio.h>

//==============================================================================
// Below are using queues
//==============================================================================

// Create a new node that has a destination and weight
dnode_t *make_node(int destination, int weight)
{
    dnode_t *node = (dnode_t *) malloc(sizeof(dnode_t));
    node->destination = destination;
    node->weight = weight;

    node->next = NULL;
    node->prev = NULL;
    return node;
}

// Initiate a graph with the given number of vertices
graph_t *init_graph(int num_vertices)
{
    graph_t *graph = (graph_t *) malloc(sizeof(graph_t));

    // Check if memory allocation was successful
    if (graph == NULL) {
        return NULL;
    }

    // initialize graph to hold given number of vertices
    graph->num_vertices = num_vertices;
    // No connections between vertices yet
    graph->num_edges = 0;

    graph->adjacency_list = (dnode_t **) malloc(num_vertices * sizeof(dnode_t *));
    if (graph->adjacency_list == NULL) {
        free(graph);
        return NULL;
    }

    // Initialize adjacency list with NULL
    for (int i = 0; i < num_vertices; i++) {
        graph->adjacency_list[i] = NULL;
    }
    // Return the Graph
    return graph;
}

// Delete a given graph
void delete_graph(graph_t *g)
{
    // Iterate through each vertex and free the adjacency list
    for (int i = 0; i < g->num_vertices; i++) {
        dnode_t *current = g->adjacency_list[i];
        while (current != NULL) {
            dnode_t *temp = current;
            current = current->next;
            free(temp);
        }
    }
    free(g->adjacency_list);
    free(g);
}

// Add an edge between two vertices with a given weight
void add_edge(graph_t *graph, int u, int v, int weight)
{
    // Edge Case
    if (graph == NULL) {
        return;
    }
    // vertice must exist in graph
    if (u < 0 || v < 0) {
        return;
    }
    if (u >= graph->num_vertices || v >= graph->num_vertices) {
        return;
    }

    dnode_t *current = graph->adjacency_list[u];
    while (current != NULL) {
        // Find the edge from u to v
        if (current->destination == v) {
            current->weight = weight;
            return;
        }
        current = current->next;
    }

    // If nothing connects to v yet, create a new node and edge
    dnode_t *new_node = make_node(v, weight);
    new_node->next = graph->adjacency_list[u];
    if (graph->adjacency_list[u] != NULL) {
        graph->adjacency_list[u]->prev = new_node;
    }
    graph->adjacency_list[u] = new_node;
    graph->num_edges++;
}

// Check if two vertices are adjacent
bool is_adjacent(graph_t *graph, int u, int v)
{
    if (graph == NULL) {
        return false;
    }
    if (u < 0 || v < 0) {
        return false;
    }
    if (u >= graph->num_vertices || v >= graph->num_vertices) {
        return false;
    }

    // Check if there is an direct edge from u to v; if yes then adjacent
    dnode_t *current = graph->adjacency_list[u];
    while (current != NULL) {
        if (current->destination == v) {
            return true;
        }
        current = current->next;
    }
    return false;
}

// Create a new queue
queue_t *make_queue()
{
    queue_t *queue = (queue_t *) malloc(sizeof(queue_t));
    queue->front = NULL;
    queue->rear = NULL;
    return queue;
}

// Add a vertex to a queue
void enqueue(queue_t *queue, int vertex)
{
    queue_node_t *new_node = (queue_node_t *) malloc(sizeof(queue_node_t));
    if (new_node == NULL) {
        return; // check if allocation was successful
    }
    new_node->vertex = vertex;
    new_node->next = NULL;
    // if the queue is empty, set the front to the new node
    if (queue->rear == NULL) {
        queue->front = new_node;
    } else {
        //Add new node to the rear
        queue->rear->next = new_node;
    }
    // Set the new rear to new node
    queue->rear = new_node;
}

// Check if the queue is empty
bool is_empty(queue_t *queue)
{
    if (queue->front == NULL) {
        return true;
    }
    return false;
}

// Get the item from the front of the queue
int dequeue(queue_t *queue)
{
    // Check if the queue is empty
    if (is_empty(queue)) {
        return -1;
    }
    int vertex = queue->front->vertex;
    queue_node_t *temp = queue->front;
    // Move the front to the next node in line
    queue->front = queue->front->next;

    // If moving clears the queue, set rear to NULL
    if (queue->front == NULL) {
        queue->rear = NULL;
    }
    free(temp);
    return vertex;
}

// Delete a queue
void delete_queue(queue_t *queue)
{
    queue_node_t *current = queue->front;
    while (current != NULL) {
        queue_node_t *temp = current;
        current = current->next;
        free(temp);
    }
    free(queue);
}

// Finding shortest paths from a source vertex to all other vertices with unweighted edges
int *lengths_unweighted_shortest_paths(graph_t *graph, int from)
{
    int *shortest = (int *) malloc(graph->num_vertices * sizeof(int));
    if (shortest == NULL) {
        return NULL;
    }

    int INFINITY = 123456;

    // Initialize shortest path to all vertices as infinity, then update later
    for (int i = 0; i < graph->num_vertices; i++) {
        shortest[i] = INFINITY;
    }
    // Set source to source as 0
    shortest[from] = 0;

    // Create a queue for BFS
    queue_t *queue = make_queue();
    // First in line is the source
    enqueue(queue, from);

    while (is_empty(queue) == false) {
        int current = dequeue(queue);
        // Find source node
        dnode_t *node = graph->adjacency_list[current];
        while (node != NULL) {
            // Check if a node has never been visited before
            if (shortest[node->destination] == INFINITY) {
                // Update the shortest path to the destination to whatever current path turns out to be, plus 1
                shortest[node->destination] = shortest[current] + 1;
                // Add destination to the queue, for next iteration
                enqueue(queue, node->destination);
            }
            // Get next in line
            node = node->next;
        }
    }
    delete_queue(queue);
    return shortest;
}

// ========================================================================
// Below are priority queue implementations
// ========================================================================

// Create a priority queue with given capacity
priority_queue_t *make_priority_queue(int capacity)
{
    priority_queue_t *pq = (priority_queue_t *) malloc(sizeof(priority_queue_t));
    pq->capacity = capacity;
    pq->size = 0;
    pq->nodes = (pq_node_t *) malloc(capacity * sizeof(pq_node_t));
    return pq;
}

// Delete a priority queue
void delete_priority_queue(priority_queue_t *pq)
{
    free(pq->nodes);
    free(pq);
}

// Add a vertex to the priority queue, to the correct position using distance
void pq_enqueue(priority_queue_t *pq, int vertex, int distance)
{
    // If full, cannot enqueue
    if (pq->size == pq->capacity) {
        return;
    }
    // New node to be added
    pq_node_t new_node = {vertex, distance};
    int i = pq->size;
    // Increase size by 1
    pq->size = pq->size + 1;
    // Add new node to the end of the list
    pq->nodes[i] = new_node;
    // Loop to compare the new node with its parent
    while (i > 0) {
        int parent = (i - 1) / 2;
        // If parent node's distance is less than or equal to the new node's distance, break
        if (pq->nodes[parent].distance <= pq->nodes[i].distance) {
            break;
        }
        // If not, swap new node with parent and update index, repeat
        pq_node_t temp = pq->nodes[parent];
        pq->nodes[parent] = pq->nodes[i];
        pq->nodes[i] = temp;
        i = parent;
    }
}

// Get the highest priority node from the priority queue
pq_node_t pq_dequeue(priority_queue_t *pq)
{
    // If empty, return dummy node
    if (pq->size == 0) {
        pq_node_t dummy_empty = {-1, -1};
        return dummy_empty;
    }
    // assign the minimum priority node to the first node in the queue
    pq_node_t min_node = pq->nodes[0];
    pq->size--;
    pq->nodes[0] = pq->nodes[pq->size]; // now the new first node is the last node

    // Now restore the min heap property after last operation
    int i = 0;
    // Iterate until the wrong node is in the right order in the heap
    while (true) {
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child
        int smallest = i; // smallest node
        // If left child is smaller than the parent, set smallest to left
        if (left < pq->size && pq->nodes[left].distance <
                               pq->nodes[smallest].distance) {
            smallest = left;
        }
        // If right child is smaller than the parent, set smallest to right
        if (right < pq->size && pq->nodes[right].distance <
                                pq->nodes[smallest].distance) {
            smallest = right;
        }
        // When the smallest points to current node already, then we are done
        if (smallest == i) {
            break;
        }
        // Swap the smallest node with the current node
        pq_node_t temp = pq->nodes[smallest];
        pq->nodes[smallest] = pq->nodes[i];
        pq->nodes[i] = temp;
        i = smallest;
    }
    return min_node;
}

// Function to maintain the min-heap property
void change_priority(priority_queue_t *pq, int vertex, int new_distance)
{

    // Find matching vertex
    int i;
    for (i = 0; i < pq->size; i++) {
        if (pq->nodes[i].vertex == vertex) {
            break; // when found, stop
        }
    }
    // vertex was not found, so we add a new one
    if (i == pq->size) {
        pq_enqueue(pq, vertex, new_distance);
        return;
    }
    // Update the distance of the vertex
    pq->nodes[i].distance = new_distance;
    // Maintain minheap property again
    while (i > 0) {
        int parent = (i - 1) / 2; // calculate parent node index
        if (pq->nodes[parent].distance <= pq->nodes[i].distance) {
            break;
        }
        pq_node_t temp = pq->nodes[parent];
        pq->nodes[parent] = pq->nodes[i];
        pq->nodes[i] = temp;
        i = parent;
    }
}

// Using priority queue, this algorithm finds the shortest path from a source vertex to all other vertices
int *lengths_weighted_shortest_paths(graph_t *graph, int from)
{
    int *dist = (int *) malloc(graph->num_vertices * sizeof(int));
    int INFINITY = 123456;
    for (int i = 0; i < graph->num_vertices; i++) {
        dist[i] = INFINITY;
    }
    // Set the distance of the starting vertex (from) to 0
    dist[from] = 0;

    // Create a priority queue to store vertices and their distances
    priority_queue_t *pq = make_priority_queue(graph->num_vertices);
    // From source vertex, to itself is zero
    pq_enqueue(pq, from, 0);

    // Until the priority queue is empty
    while (pq->size > 0) {
        // Dequeue the vertex with the minimum distance
        pq_node_t min_node = pq_dequeue(pq);
        int u = min_node.vertex;

        // Iterate through the neighbors of the dequeued vertex
        dnode_t *node = graph->adjacency_list[u];
        while (node != NULL) {
            int v = node->destination;
            int weight = node->weight;

            // If the distance to the neighbor (v) can be improved,
            // update its distance and enqueue/update it in the priority queue
            if (dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
                change_priority(pq, v, dist[v]);
            }
            node = node->next;
        }
    }
    delete_priority_queue(pq);
    return dist;
}

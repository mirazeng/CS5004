#ifndef __GRAPH_H__
#define __GRAPH_H__

#include <stdbool.h>

typedef struct dnode {
  int destination;
  int weight;
  struct dnode *prev;
  struct dnode *next;
} dnode_t;

//a directed graph
typedef struct graph {
    int num_vertices;
    int num_edges;
    //insert representation of an adjacency list, possibly using the above dnode
    dnode_t **adjacency_list;
} graph_t;

typedef struct queue_node {
    int vertex;
    struct queue_node *next;
} queue_node_t;

typedef struct queue {
    queue_node_t *front;
    queue_node_t *rear;
} queue_t;

typedef struct pq_node {
    int vertex;
    int distance;
} pq_node_t;

typedef struct priority_queue {
    int capacity;
    int size;
    pq_node_t *nodes;
} priority_queue_t;

//create a graph of the given number of vertices. Once created, the number of vertices 
//will not change, but one can add edges to the list
graph_t *init_graph(int num_vertices);

//delete the specified graph
void delete_graph(graph_t *g);


//add a new edge from u to v of the specified graph with the specified weight.
//the graph cannot have multiple edges from u to v.
//if an edge already exists then its weight will be replaced with this specified weight.
//this function can insert the vertices in each other's adjacency lists in any order
void add_edge(graph_t *graph,int u,int v,int weight);

// determine if there is an edge from u to v in the specified graph
bool is_adjacent(graph_t *graph,int u,int v);

// find the lengths of the unweighted shortest paths from the given vertex to all the vertices of this graph
/*
This can be determined by starting a BFS from the "from" vertex.

Keep in mind that you will have to keep track, for every vertex v:
1. shortest[v]: the length of the shortest path from the first vertex to v the length of the shortest path from the first vertex to v.
This is what we return after the BFS from the first vertex is over.

If v cannot be reached from the "from" vertex, the length of its shortest path should be 123456, an arbitrary number that represents infinity.
2. parent[v]: the vertex from which BFS reached v.

Then, shortest[v] = shortest[parent[v]] + 1

Also, shortest[from] = 0

This function will ignore the weights of an edge (or in other words, assume all weights are 1)
*/
int *lengths_unweighted_shortest_paths(graph_t *graph,int from);

// find the lengths of the weighted shortest paths from the given vertex to all the vertices of this graph
/*
This can be determined by using the Dijkstra's shortest path algorithm from the "from" vertex.

If v cannot be reached from the "from" vertex, the length of its shortest path should be 123456, an arbitrary number that represents infinity.
*/
int *lengths_weighted_shortest_paths(graph_t *graph,int from);

dnode_t *make_node(int destination, int weight);


#endif

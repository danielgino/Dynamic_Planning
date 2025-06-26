# Longest Increasing Subsequence (LIS) - Dynamic Programming Solution

##  Problem Description
Given an array `V` of size `n` containing natural numbers, find the **length of the longest increasing subsequence (LIS)**.  
The subsequence does **not** have to be contiguous — only strictly increasing.

### Example:

## Input:
```
int[] original = {12, 5, 18, 7, 19, 8, 10};
```

One possible longest increasing subsequence is:
[5, 7, 8, 10] → Length = 4


## Output
```
Longest increasing subsequence length: 4
Total Cost :O(N^2)
```

# Question 2

# Longest Path in a DAG

##  Description

This Java program computes the **longest path** in a **Directed Acyclic Graph (DAG)** using a dynamic programming approach combined with topological sorting.

Given a DAG `G = (V, E)`, the program finds the longest path in the graph in **O(|V| + |E|)** time.

---

##  Algorithm Overview

The algorithm proceeds in three main steps:

1. **Topological Sort**  
   - Performs a DFS-based topological sort to order the vertices such that for every edge `u → v`, `u` comes before `v`.
  
2. **Longest Path Computation**  
   - Initializes `delta[v]` for each vertex `v`, representing the length of the longest path ending at `v`.
   - Iterates through the graph in topological order, updating `delta[u] = max(delta[u], delta[v] + 1)` for every edge `v → u`.
   - Uses an auxiliary array `parent[]` to store the previous node for each vertex in the longest path.

3. **Path Reconstruction**  
   - Finds the vertex with the highest `delta` value (i.e., the endpoint of the longest path).
   - Reconstructs the path by tracing back through the `parent` array.

---

##  Graph Input
The program uses a sample graph with 6 nodes and the following edges:
```
0 → 1
0 → 2
1 → 3
2 → 3
3 → 4
4 → 5
graph.get(0).add(1);
graph.get(0).add(2);
graph.get(1).add(3);
graph.get(2).add(3);
graph.get(3).add(4);
graph.get(4).add(5);
```


## Output

```
Longest path length: 4
Longest path: [0, 2, 3, 4, 5]
```

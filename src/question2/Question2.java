package question2;

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(4).add(5);
        List<Integer> topOrder = topologicalSort(graph, V);
        int[] delta = new int[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for (int v : topOrder) {
            for (int u : graph.get(v)) {
                if (delta[u] < delta[v] + 1) {
                    delta[u] = delta[v] + 1;
                    parent[u] = v;
                }
            }
        }
        int maxLen = 0;
        int end = 0;
        for (int i = 0; i < V; i++) {
            if (delta[i] > maxLen) {
                maxLen = delta[i];
                end = i;
            }
        }
        List<Integer> path = new ArrayList<>();
        while (end != -1) {
            path.add(end);
            end = parent[end];
        }
        Collections.reverse(path);
        System.out.println("Longest path length: " + maxLen);
        System.out.println("Longest path: " + path);
        System.out.println("Total Cost: O(V + E)");
    }

    public static List<Integer> topologicalSort(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, graph);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }
        return order;
    }

    public static void dfs(int v, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph) {
        visited[v] = true;
        for (int u : graph.get(v)) {
            if (!visited[u]) {
                dfs(u, visited, stack, graph);
            }
        }
        stack.push(v);
    }
}


// Breadth First Search (BFS) implementation in Java
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch {

    static void bfs(int[][] graph, int startVertex) {
        int vertices = graph.length;
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < vertices; i++) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;

        // Adjacency matrix representation
        int[][] graph = {
                { 0, 1, 1, 0, 0 },
                { 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 1, 1, 0, 1 },
                { 0, 0, 1, 1, 0 }
        };

        System.out.println("Breadth First Search (BFS):");
        bfs(graph, 0);
    }
}
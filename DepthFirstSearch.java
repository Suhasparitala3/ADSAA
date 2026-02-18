import java.util.Scanner;

// Depth First Search (DFS) implementation in Java
class DFS {
    int n;
    int adj[][];;
    boolean visited[];

    DFS(int n) {
        this.n = n;
        adj = new int[n][n];
        visited = new boolean[n];
    }

    void addEdge(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int i = 0; i < n; i++) {
            if (adj[vertex][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of vertices:");
        int n = sc.nextInt();
        DFS graph = new DFS(n);
        System.out.print("Enter no of edges:");
        int e = sc.nextInt();
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }
        System.out.println("Depth First Search (DFS):");
        graph.dfs(0); // Starting DFS from vertex 0
    }
}
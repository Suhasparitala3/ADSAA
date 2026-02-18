//Program to implement Krushkal's Algorithm
public class krushkal {

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    static boolean union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX == rootY) {
            return false;
        }
        parent[rootX] = rootY;
        return true;
    }

    public static void main(String[] args) {
        int vertices = 4;
        Edge[] edges = {
                new Edge(0, 1, 10),
                new Edge(0, 2, 6),
                new Edge(0, 3, 5),
                new Edge(1, 3, 15),
                new Edge(2, 3, 4)
        };

        // Sort edges by weight (simple bubble sort)
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edge temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }

        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        System.out.println("Kruskal's Algorithm - MST");
        System.out.println("Src\tDest\tWeight");

        int totalWeight = 0;
        for (int i = 0; i < edges.length; i++) {
            if (union(parent, edges[i].src, edges[i].dest)) {
                System.out.println(edges[i].src + "\t" + edges[i].dest + "\t" + edges[i].weight);
                totalWeight += edges[i].weight;
            }
        }

        System.out.println("\nTotal Weight: " + totalWeight);
    }
}

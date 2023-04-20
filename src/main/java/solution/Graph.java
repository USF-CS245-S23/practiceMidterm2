package solution;

import java.util.ArrayList;

public class Graph {
    private Edge[] graph; // adjacency list for this graph

    // Static nested class Edge
    public static class Edge { // Class Edge
        private int neighbor; // id of the neighbor (id of the destination node)
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    } // class Edge

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     *
     * @param vertexId id of the vertex
     * @param edge     outgoing edge
     *                 Do not modify.
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        graph[vertexId] = edge; // insert in front
        if (head != null) {
            edge.next = head;
        }
    }

    public ArrayList<Integer> noIncomingEdges() {
        ArrayList<Integer>  verticesNoIncomingEdges = new ArrayList<>();
        int[] arr = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            Edge current = graph[i];
            while (current != null) {
                arr[current.neighbor] = 1; // if the vertex is  neighbor of some other vertex, then set the flag to true (it means it has at least one incoming edge).
                current = current.next;
            }
        }
        // Vertices for which the flag is 0 have no incoming edges
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                verticesNoIncomingEdges.add(i);
        }


        return verticesNoIncomingEdges;
    }


    public static void main(String[] args) {
        Graph g = new Graph(8);

        // edges going out of vertex 1
        Edge edge10 = new Edge(0);
        Edge edge12 = new Edge(2);
        g.addEdge(1, edge10);
        g.addEdge(1, edge12);

        // edge going out of 0
        Edge edge05 = new Edge(5);
        g.addEdge(0, edge05);

        //edge going out of 2
        Edge edge26 = new Edge(6);
        g.addEdge(2, edge26);

        // edges going out of 5
        Edge edge54 = new Edge(4);
        Edge edge56 = new Edge(6);
        g.addEdge(5, edge54);
        g.addEdge(5, edge56);

        // edge going out of 6
        Edge edge67 = new Edge(7);
        g.addEdge(6, edge67);

        //edge going out of 4
        Edge edge47 = new Edge(7);
        g.addEdge(4, edge47);

        // edge going out of 7
        Edge edge75 = new Edge(5);
        g.addEdge(7, edge75);

        System.out.println(g.noIncomingEdges());
        // Vertices without any incoming edges: [1, 3]
    }
}


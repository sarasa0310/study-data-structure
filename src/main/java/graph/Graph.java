package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Graph {

    private List<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    // 버텍스 추가
    public Vertex addVertex(String data) {
        Vertex vertex = new Vertex(data);
        vertices.add(vertex);
        return vertex;
    }

    // 버텍스 삭제
    public void removeVertex(Vertex vertex) {
        vertices.remove(vertex);
    }

    // 버텍스 검색
    public Vertex findVertex(String data) {
        for (Vertex v : vertices) {
            if (v.getData().equals(data)) {
                return v;
            }
        }
        return null;
    }

    // 간선 추가
    public void addEdge(Vertex from, Vertex to, Integer weight) {
        if (!this.isWeighted) {
            weight = null;
        }
        from.addEdge(to, weight);
        if (!this.isDirected) {
            to.addEdge(from, weight);
        }
    }

    // 간선 삭제
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeEdge(vertex2);
        if (!this.isDirected) {
            vertex2.removeEdge(vertex1);
        }
    }

    public void print() {
        for (Vertex v : vertices) {
            v.print(this.isWeighted);
        }
    }

    public static void dfs(Vertex start, ArrayList<Vertex> visited) {
        System.out.println(start.getData());

        for (Edge e : start.getEdges()) {
            Vertex neighbor = e.getEnd();

            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(neighbor, visited);
            }
        }
    }

    public static void bfs(Vertex start, ArrayList<Vertex> visited) {
        Queue<Vertex> visitQueue = new ConcurrentLinkedQueue<>();
        visitQueue.add(start);

        while (!visitQueue.isEmpty()) {
            Vertex current = visitQueue.poll();
            System.out.println(current.getData());

            for (Edge e : current.getEdges()) {
                Vertex neighbor = e.getEnd();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    visitQueue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph airPortNetwork = new Graph(true, false);

        Vertex incheon = airPortNetwork.addVertex("ICN");
        Vertex gimpo = airPortNetwork.addVertex("GMP");
        Vertex gimhae = airPortNetwork.addVertex("PUS");
        Vertex jeju = airPortNetwork.addVertex("CJU");
        Vertex daegu = airPortNetwork.addVertex("TAE");

        Vertex beijing = airPortNetwork.addVertex("PEK");
        Vertex narita = airPortNetwork.addVertex("NRT");

        airPortNetwork.removeVertex(gimpo);

        airPortNetwork.addEdge(incheon, daegu, 330);
        airPortNetwork.addEdge(daegu, gimhae, 100);
        airPortNetwork.addEdge(incheon, jeju, 560);
        airPortNetwork.addEdge(jeju, daegu, 430);
        airPortNetwork.addEdge(gimhae, jeju, 380);

        airPortNetwork.addEdge(incheon, beijing, 300);
        airPortNetwork.addEdge(gimhae, narita, 300);

        airPortNetwork.removeEdge(incheon, jeju);

        airPortNetwork.print();

        System.out.println(airPortNetwork.findVertex("ICN"));

        ArrayList<Vertex> visited = new ArrayList<>();
        visited.add(daegu);

        dfs(daegu, visited);
//        bfs(daegu, visited);
    }

}

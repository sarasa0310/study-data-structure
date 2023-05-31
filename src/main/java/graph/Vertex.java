package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String data;
    private List<Edge> edges;

    public Vertex(String data) {
        this.data = data;
        this.edges = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Vertex target, Integer weight) {
        Edge edge = new Edge(this, target, weight);
        edges.add(edge);
    }

    public void removeEdge(Vertex target) {
        edges.removeIf(edge -> edge.getEnd().equals(target));
    }

    public void print(boolean showWeight) {
        String message = "";

        if (this.edges.size() == 0) {
            System.out.println(this.data + " -->");
            return;
        }

        for(int i = 0; i < this.edges.size(); i++) {
            if (i == 0) {
                message += this.edges.get(i).getStart().data + " -->  ";
            }

            message += this.edges.get(i).getEnd().data;

            if (showWeight) {
                message += " (" + this.edges.get(i).getWeight() + ")";
            }

            if (i != this.edges.size() - 1) {
                message += ", ";
            }
        }

        System.out.println(message);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data='" + data + '\'' +
                '}';
    }

}

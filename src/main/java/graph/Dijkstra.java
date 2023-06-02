package graph;

import java.util.HashMap;
import java.util.Map;

public class Dijkstra {

    public static Map[] dijkstra(Graph g, Vertex startingVertex) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, Vertex> previous = new HashMap<>();

        for (Vertex v : g.getVertices()) {
            distances.put(v.getData(), Integer.MAX_VALUE);
            previous.put(v.getData(), new Vertex("Null"));
        }

        distances.put(startingVertex.getData(), 0);

        Vertex current = startingVertex;

        for (Edge e : current.getEdges()) {
            Integer alternate = e.getWeight() + distances.get(current.getData());
            String neighborValue = e.getEnd().getData();
            if (alternate < distances.get(neighborValue)) {
                distances.put(neighborValue, alternate);
                previous.put(neighborValue, current);
            }
        }

        return new Map[]{distances, previous};
    }

    public static void main(String[] args) {

    }

}

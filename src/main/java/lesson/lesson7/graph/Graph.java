package lesson.lesson7.graph;

import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjMap;

    public Graph() {
        this.adjMap = new HashMap<>();
    }

    public void assVertex(String label){
        adjMap.putIfAbsent(new Vertex(label),new ArrayList<>());
    }

    public void removeVertex(String lable){
        Vertex v = new Vertex(lable);
        //Удаляем вершины из всех связей
        adjMap.values().stream().forEach(list -> list.remove(v));
        adjMap.remove(v);
    }

    public void addEdge(String label1, String label2){
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjMap.get(v1).add(v2);
        adjMap.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2){
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List <Vertex> ev1 = adjMap.get(v1);
        List <Vertex> ev2 = adjMap.get(v2);
        if(ev1 != null){
            ev1.remove(v2);
        }
        if(ev2 != null){
            ev2.remove(v1);
        }
    }

    public void depthFirstTraversal(){
        Set<Vertex> visited = new LinkedHashSet<>();
    }
}

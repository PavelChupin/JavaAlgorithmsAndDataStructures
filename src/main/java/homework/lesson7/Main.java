package homework.lesson7;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addVertex("Pavel");
        graph.addVertex("Jek");
        graph.addVertex("John");
        graph.addVertex("Sveta");
        graph.addVertex("Ivan");

        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Mark");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Mark","Bob");
        graph.addEdge("Mark","John");
        graph.addEdge("Alice", "Bob");
        graph.addEdge("Alice", "Pavel");
        graph.addEdge("Rob", "Pavel");
        graph.addEdge("Rob", "Bob");
        graph.addEdge("Pavel", "Rob");
        graph.addEdge("Pavel", "Alice");
        graph.addEdge("Pavel", "Sveta");
        graph.addEdge("Pavel", "Ivan");
        graph.addEdge("John", "Mark");
        graph.addEdge("John", "Jek");
        graph.addEdge("John", "Sveta");
        graph.addEdge("Sveta", "John");
        graph.addEdge("Sveta", "Pavel");
        graph.addEdge("Ivan", "Pavel");
        graph.addEdge("Jek", "Maria");
        graph.addEdge("Jek", "John");
        graph.addEdge("Maria", "Pavel");
        graph.addEdge("Maria", "Jek");

        System.out.println("Обход в глубину: " + graph.depthFirstSearch(new Vertex("Bob")));
        System.out.println("Обход в ширину: " + graph.breadthFirstSearch(new Vertex("Bob")));
        Vertex find = new Vertex("Mark");
        System.out.println("Поиск в ширину, ищем " + find + ": " + graph.breadthFirstSearchObject(new Vertex("Bob"),find));
        System.out.println("Поиск в глубину, ищем " + find + ": " + graph.depthFirstSearchObject(new Vertex("Bob"),find));
        System.out.println("Поиск в ширину, ищем " + find + ": " + graph.breadthFirstSearchObject(new Vertex("Ivan"),find));
        System.out.println("Поиск в глубину, ищем " + find + ": " + graph.depthFirstSearchObject(new Vertex("Ivan"),find));
        System.out.println("Поиск в ширину, ищем " + find + ": " + graph.breadthFirstSearchObject(new Vertex("Maria"),find));
        System.out.println("Поиск в глубину, ищем " + find + ": " + graph.depthFirstSearchObject(new Vertex("Maria"),find));
    }
}

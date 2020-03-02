package lesson.lesson7.graph;

import java.util.Objects;

public class Vertex {
    private final  String label;

    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex ventex = (Vertex) o;
        return label.equals(ventex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}

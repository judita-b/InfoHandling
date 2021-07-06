package com.epam.infohandling.model;

import java.util.Objects;

public class Leaf implements Component {

    private String value;
    private LeafType type;

    public Leaf(String value) {
        this.value = value;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Final Leaf in Composite pattern");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Final Leaf in Composite pattern");
    }

    @Override
    public void operation() {
        throw new UnsupportedOperationException("Final Leaf in Composite pattern");
    }

    @Override
    public Object getChild(int index) {
        throw new UnsupportedOperationException("Final Leaf in Composite pattern");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Leaf)) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        return Objects.equals(value, leaf.value) && type == leaf.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}
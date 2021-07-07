package com.epam.infohandling.model;

import java.util.Objects;

public class Leaf implements Component {

    private String value;
    private String name;
    private Composite parent;

    public Leaf(String name, String value) {
        this.name = name;
        this.value = value;
    }

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
    public Object getChild(int index) {
        throw new UnsupportedOperationException("Leaf doesn't have any children");
    }

    @Override
    public int childrenCount() {
        return 0;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Composite getParent() {
        return parent;
    }

    @Override
    public void setParent(Composite parent) {
        this.parent = parent;
    }

    @Override
    public void setChild(int index, Component component) {
        throw new UnsupportedOperationException("Leaf doesn't have any children");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Leaf other = (Leaf) obj;
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }
}
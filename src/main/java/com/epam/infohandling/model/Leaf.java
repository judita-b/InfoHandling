package com.epam.infohandling.model;

public class Leaf implements Component {

    private String value;
    private LeafType type;

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
}
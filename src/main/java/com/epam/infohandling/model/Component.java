package com.epam.infohandling.model;

public interface Component {

    void add(Component component);
    void remove(Component component);
    Object getChild(int index);

    int childrenCount();
    boolean isLeaf();
    Object getValue();
    String getName();
    Composite getParent();
    void setParent(Composite parent);
    void setChild(int index, Component component);
}

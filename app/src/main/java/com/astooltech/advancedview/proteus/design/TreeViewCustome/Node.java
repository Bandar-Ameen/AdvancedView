package com.astooltech.advancedview.proteus.design.TreeViewCustome;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public List<Node> Children = new ArrayList<>();
    public Node Parent;
    public MyObject Source;

    public MyObject getSourceObject() {
        return Source;
    }
    public void setSourceObject(MyObject Source) {
        Source = Source;
    }
    public Node getParent() {
        return Parent;
    }
    public void setParent(Node parent) {
        Parent = parent;
    }
}
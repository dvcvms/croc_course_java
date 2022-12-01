package ru.croc.task15;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private String parentName;
    private int time;

    private final List<Node> children = new ArrayList<>();

    public Node(String name, String parentName, int time) {
        this.name = name;
        this.parentName = parentName;
        this.time = time;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public int getTime() {
        return this.time;
    }
}

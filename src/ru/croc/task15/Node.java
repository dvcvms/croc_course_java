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

    public int getTime() {
        return this.time;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public int calculateTime() {
        int result = 0;

        for (Node node : children) {
            result = Math.max(result, node.calculateTime());
        }

        return result + this.getTime();
    }
}

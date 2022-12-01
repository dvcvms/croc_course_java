package ru.croc.task15;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Node root;
    private final Map<String, Node> nodes = new HashMap<>();

    public Graph() {
        // nothing...
    }

    public void addNode(String name, String parentName, int time) {
        Node node = new Node(name, parentName, time);
        nodes.put(name, node);

        if (parentName.equals("-")) {
            root = node;
        } else {
            nodes.get(parentName).addChild(node);
        }
    }

    public Node getRoot() {
        return this.root;
    }
}

package ru.croc.task15;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.HashMap;

public class Graph {

    private Node root;
    private final Map<String, Node> nodes = new HashMap<>();

    public void buildTree(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            String[] strings;

            while ((line = reader.readLine()) != null) {
                strings = line.split(",");
                addNode(strings[0], strings[1], Integer.parseInt(strings[2]));
            }
        }
    }

    private void addNode(String name, String parentName, int time) {
        Node node = new Node(name, parentName, time); // TODO: parse?
        nodes.put(name, node);

        if (parentName.equals("-")) {
            root = node;
        } else {
            nodes.get(parentName).addChild(node);
        }
    }

    public int getResult() { // TODO: rename
        return root.calculateTime();
    }
}

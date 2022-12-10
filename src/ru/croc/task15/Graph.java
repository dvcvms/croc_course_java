package ru.croc.task15;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.HashMap;

public class Graph {

    private Node root;
    private final Map<String, Node> nodes = new HashMap<>();
    private final String path;

    public Graph(String path) {
        this.path = path;
    }

    public void buildTree() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;
            while ((line = reader.readLine()) != null) {
                Node node = Node.parse(line);

                if (node.getParentName().equals("-")) {
                    root = node;
                } else {
                    nodes.get(node.getParentName()).addChild(node);
                }

                nodes.put(node.getName(), node);
            }
        }
    }

    public int getResult() {
        return root.calculateTime();
    }
}

import java.util.*;

public class GraphAndTrees<T> {

    public void traverseBFS (Node<T> root) {
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node<T> temp = q.poll();
            temp.setVisited();
            if (temp.children.size() > 0 && !temp.isVisited()) {
                // TODO: ACCESS CURRENT NODE HERE
                q.addAll(temp.children);
            }
        }
    }

    public void traverseDFS (Node<T> root) {
        Deque<Node<T>> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node<T> temp = stack.pop();
            if (!temp.isVisited()) {
                temp.setVisited();
                // TODO: ACCESS CURRENT NODE HERE
                stack.addAll(temp.children);
            }
        }
    }

    /**
     * Given a connected acyclic graph with n nodes and n-1
     * edges, count the pair of nodes that are at even distance
     * (number of edges) from each other.
     */


    public static class Node<T> {
        private final T data;
        private boolean visited;
        private ArrayList<Node<T>> children = new ArrayList<>(0);
        Node(T val) {
            data = val;
            visited = false;
        }

        public T getData() {
            return data;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited() {
            visited = true;
        }

        public void addChild(T val) {
            Node<T> newChild = new Node<>(val);
            children.add(newChild);
        }

        public ArrayList<Node<T>> getChildren() {
            return children;
        }

        public void setChildren(ArrayList<Node<T>> children) {
            this.children = children;
        }
    }
}



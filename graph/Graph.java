package graph;

import queue.Queue;

/**
 * Created by pinak on 16-03-2019.
 */
public class Graph {

    int size;
    Node[] vertices;

    public enum State {
        NEW, IN_Q, VISITED
    };

    Queue q;

    public Graph(int size) {
        this.size = size;
        this.vertices = new Node[this.size];
        q = new Queue(size);

        for(int i=0;i<size;i++){
            this.vertices[i] = new Node(i);
        }
    }

    class Node {
        int name;
        Neighbour neighbour;
        boolean isVisited;
        State state;

        public Node(int name) {
            this.name = name;
            state = State.NEW;
        }
    }

    class Neighbour {
        Node node;
        Neighbour next;

        public Neighbour(Node node, Neighbour next) {
            this.node = node;
            this.next = next;
        }
    }

    public void addEdge(int start, int end) {
        this.vertices[start].neighbour = new Neighbour(this.vertices[end], this.vertices[start].neighbour);
    }


    public void dfs(int index, boolean[] visited){

        visited[index] = true;
        Node node = this.vertices[index];
        System.out.println(node.name);

        Neighbour neighbour = node.neighbour;
        while(neighbour!=null){
            if(!visited[neighbour.node.name])
                dfs(neighbour.node.name,visited);

            neighbour = neighbour.next;
        }

    }

    public void bfs(Node node){
        node.state = State.IN_Q;
        q.add(node.name);

        while(!q.isEmpty()){
            Node removed = this.vertices[q.pop()];
            removed.state = State.VISITED;
            System.out.println(removed.name);
            Neighbour neighbour = removed.neighbour;
            while(neighbour!=null){
                if(neighbour.node.state == State.NEW){
                    q.add(neighbour.node.name);
                    neighbour.node.state = State.IN_Q;
                }
                neighbour = neighbour.next;

            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        //boolean[] visited = new boolean[4];
        //g.dfs(2, visited);

        g.bfs(g.vertices[2]);
    }

}

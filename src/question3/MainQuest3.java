package question3;


import java.util.*;

public class MainQuest3 {
    public static void main(String[] args) {
        int graphSize=6;
        List <List<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < graphSize; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(4).add(5);
        System.out.println("Printing Graph: ");
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Node: " + i + " Connected to: " + graph.get(i));
        }
        int[] distanceOriginal= bfs(graph,0);

        List <List<Integer>> reversed=reverseGraph(graph);
        System.out.println("==== Printing Reversed Graph: ==== ");
        for (int i = 0; i < reversed.size(); i++) {
            System.out.println("Reversed: Node: " + i + " Connected to: " + reversed.get(i));
        }
        int[] distanceReverse= bfs(reversed,0);
        boolean originalGraph=isReachableToAll(distanceOriginal);
        boolean reversedGraph=isReachableToAll(distanceReverse);

        if (originalGraph && reversedGraph){
            System.out.println("The Graph Well Tied!✅");
        }
        else {
            System.out.println("The Graph ❗Not❗ Well Tied!❌");
        }
    }


    public static int[] bfs(  List <List<Integer>> tree,int start){
        int n = tree.size();
        int[] distance = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance, -1);
        Arrays.fill(parent, -1);
        Queue<Integer> queue=new LinkedList<>();
        visited[start]=true;
        distance[start]=0;
        queue.add(start);
        while (!queue.isEmpty()){
            int u=queue.poll();
            for (int v: tree.get(u)){
                if (!visited[v]){
                    visited[v]=true;
                    distance[v]=distance[u]+1;
                    parent[v]=u;
                    queue.add(v);
                }
            }
        }
        return distance;
    }

    public static List<List<Integer>> reverseGraph(List<List<Integer>> graph) {
        int n = graph.size();
        List<List<Integer>> reversed = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reversed.add(new ArrayList<>());
        }
        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                reversed.get(v).add(u);
            }
        }

        return reversed;
    }

    public static boolean isReachableToAll(int[] distance) {
        for (int dis : distance) {
            if (dis == -1) return false;
        }
        return true;
    }
}

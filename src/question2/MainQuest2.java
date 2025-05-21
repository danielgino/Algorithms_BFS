package question2;

import java.util.*;

public class MainQuest2 {
    public static void main(String[] args) {
        int treeSize=6;
        List <List<Integer>> tree=new ArrayList<>();
        for (int i = 0; i < treeSize; i++) {
            tree.add(new ArrayList<>());
        }
        tree.get(0).add(1);
        tree.get(1).add(0);

        tree.get(1).add(2);
        tree.get(2).add(1);

        tree.get(3).add(1);
        tree.get(1).add(3);

        tree.get(3).add(4);
        tree.get(4).add(3);

        tree.get(4).add(5);
        tree.get(5).add(4);
        for (int i = 0; i < tree.size(); i++) {
            System.out.println("Node: " + i + " Connected to: " + tree.get(i));
        }

       int[] startNode= bfs(tree,0);
       int deepestNode= findDeepestNode(startNode);
        System.out.println("The Deepest Node:"+deepestNode);
       int[] finalNode=bfs(tree,deepestNode);
       int result=findFinalDistance(finalNode);
        System.out.println("Final Answer: The Diameter of tree is: "+result);
        System.out.println("Total cost of O(N) ");
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

    public static int findDeepestNode(int[] distance){
        int maxDistance=-1;
        int node=-1;
        for (int i = 0; i <distance.length ; i++) {
            if (distance[i]>maxDistance){
                maxDistance=distance[i];
                node=i;

            }
        }
        return node;
    }

    public static int findFinalDistance(int[] distance){
        int maxDistance=-1;
        for (int i = 0; i <distance.length ; i++) {
            if (distance[i]>maxDistance){
                maxDistance=distance[i];
            }
        }
        return maxDistance;
    }
}

package question1;

import java.util.*;

public class MainQuest1 {
    public static void main(String[] args) {
        System.out.println("====Welcome to Robot🤖 BFS!====\n" +
       "in this program we will find the most shortest route to slot\n"+
        "that all N robots(Marked as R) can reach ! \n" +
       "Robot can move only on white slots(Marked as W) \n"+
                "But beware of black Box(Marked as B)  ");
        System.out.println("============🤖============");
        System.out.println();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please Choose N Board size (N X N)");
        int userSize= scanner.nextInt();
        System.out.println("Please Choose Number Of Robots:");
        int numberOfRobots= scanner.nextInt();
        System.out.println("Please Choose Number Of Black Box:");
        int numberOfBlackBoxes= scanner.nextInt();
        List<int[]> blackBox = generateRandomPositions(numberOfBlackBoxes, userSize, userSize, new HashSet<>());
         List<int[]> robots = generateRandomPositions(numberOfRobots, userSize, userSize, toSet(blackBox));
        ////בדיקת התרגיל מתוך השיעורי בית
 //        List<int[]> blackBox=new ArrayList<>();
//        blackBox.add(new int[]{1,0});
//        blackBox.add(new int[]{2,0});
//        blackBox.add(new int[]{2,1});
//        blackBox.add(new int[]{1,4});
//        blackBox.add(new int[]{3,6});
//        blackBox.add(new int[]{4,6});
//        blackBox.add(new int[]{5,2});
//        blackBox.add(new int[]{6,1});
//        blackBox.add(new int[]{6,2});
//        blackBox.add(new int[]{6,3});
//        blackBox.add(new int[]{6,6});
//        blackBox.add(new int[]{7,5});
//        List<int[]> robots = new ArrayList<>();
//        robots.add(new int[]{0, 0});
//        robots.add(new int[]{1, 6});
//        robots.add(new int[]{4, 1});
        char[][] board1=fillBoard(robots,blackBox, userSize, userSize);
        printBoard(board1);
        int[][] totalDistances = new int[userSize][userSize];
        for (int i = 0; i < userSize; i++) {
            Arrays.fill(totalDistances[i], 0);
        }
        int[][] reachableCount = new int[userSize][userSize];
        for (int[] robot : robots) {
            int[][] dist = bfs(board1, robot);

            for (int i = 0; i < userSize; i++) {
                for (int j = 0; j < userSize; j++) {
                    if (dist[i][j] != -1) {
                        totalDistances[i][j] += dist[i][j];
                        reachableCount[i][j]++;
                    }

                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        int bestX = -1, bestY = -1;

        for (int i = 0; i < userSize; i++) {
            for (int j = 0; j < userSize; j++) {
                if (reachableCount[i][j] == robots.size()
                        && totalDistances[i][j] < minSum
                        && board1[i][j] != 'B') {
                    minSum = totalDistances[i][j];
                    bestX = i;
                    bestY = j;
                }
            }
        }
        System.out.println("Number Of Robots:"+numberOfRobots);
        System.out.println("Number Of Black slots:"+numberOfBlackBoxes);
        if (minSum == Integer.MAX_VALUE) {
            System.out.println("There is no slot that everyone can reach..");
        } else {
            System.out.println("The best slot: (" +"X: "+ bestX + ", Y: "  + bestY + ")");
            System.out.println("Total sum of Steps:  " + minSum);
            System.out.println("Total Cost:  O(k × n²)");
        }



    }


    public static char[][] fillBoard( List<int[]> robots,List<int[]> blackBox,int rows,int cols){
        char[][] board=new char[rows][cols];

        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j]='W';
            }
        }
        for (int[] r : robots) {
            board[r[0]][r[1]] = 'R';
        }
        for (int[] black : blackBox) {
            int x = black[0];
            int y = black[1];
            board[x][y] = 'B';
        }
        return board;
    }
    public static int[][] bfs(char[][] board,int[] robot){
        int n = board.length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] distance = new int[n][n];
        for (int[] row : distance) Arrays.fill(row, -1);
        int startX=robot[0];
        int startY=robot[1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY});
        distance[startX][startY] = 0;
        while (!queue.isEmpty()){
            int[] u= queue.poll();
            int x=u[0];
            int y=u[1];
            for (int[] direction: directions){
                int newX=x+direction[0];
                int newY=y+direction[1];
                if (newX>=0 && newX < n && newY >= 0 && newY < n &&
                board[newX][newY] !='B'  && distance[newX][newY] == -1  ){
                    distance[newX][newY] = distance[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return distance;
    }

    public static List<int[]> generateRandomPositions(int count, int rows, int cols, Set<String> occupied) {
        Random random = new Random();
        Set<String> used = new HashSet<>(occupied);
        List<int[]> positions = new ArrayList<>();

        while (positions.size() < count) {
            int x = random.nextInt(rows);
            int y = random.nextInt(cols);
            String key = x + "," + y;

            if (!used.contains(key)) {
                used.add(key);
                positions.add(new int[]{x, y});
            }
        }

        return positions;
    }

    public static Set<String> toSet(List<int[]> positions) {
        Set<String> set = new HashSet<>();
        for (int[] pos : positions) {
            set.add(pos[0] + "," + pos[1]);
        }
        return set;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }



}
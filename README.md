📌 Description
# Question 1
This Java program finds the best slot (white cell) on an N x N board that can be reached by all given robots, such that the total number of steps taken by all robots is minimized.

Robots (R) can only move on white slots (W) and must avoid black boxes (B). The algorithm uses Breadth-First Search (BFS) for each robot to compute the shortest distances to all accessible white cells.

▶️ How to Run
Open the project in IntelliJ IDEA or any Java IDE.

Make sure the main class is set to:
question1.MainQuest1

Run the program (e.g., click "Run" or execute via terminal if compiled manually).

📥 Input (via console)
The program will prompt you to enter:

Board size (N) – the board will be N x N

Number of Robots – number of robots to place randomly on the board

Number of Black Boxes – number of blocked cells (B) that robots cannot pass through

Note: Positions are chosen randomly at runtime.

📤 Output
The generated board will be printed, using:

R = Robot

B = Black box (obstacle)

W = White slot (free cell)

After running the algorithm, you will see:

Total number of robots and black boxes

The best slot: a cell that all robots can reach with minimum total steps

The total sum of steps for all robots to reach that cell

The time complexity of the algorithm
![צילום מסך 2025-06-19 193541](https://github.com/user-attachments/assets/7df8c6b9-a4e9-4b68-b4a5-77f95d4192a7)

## Example Output
```
====Welcome to Robot🤖 BFS!====
in this program we will find the most shortest route to slot
that all N robots(Marked as R) can reach ! 
Robot can move only on white slots(Marked as W) 
But beware of black Box(Marked as B)  
============🤖============

Please Choose N Board size (N X N)
8
Please Choose Number Of Robots:
3
Please Choose Number Of Black Box:
14
R W B W R W W W 
W B W W W B W W 
W W W W B W B W 
W B W W W W W W 
W B R W W W B W 
W B W W W W B B 
W W W W W W W B 
W W W W W B W B 
Number Of Robots:3
Number Of Black slots:14
The best slot: (X: 2, Y: 2)
Total sum of Steps:  10
Total Cost:  O(k × n²)
```

### Question 2

🌳 Tree Diameter – Question 2
Given an undirected tree T = (V, E) with n nodes, compute the diameter of the tree in linear time O(n).

The diameter of a tree is defined as the length of the longest shortest path between any two nodes.

💡 Algorithm Overview
This program uses two BFS traversals to find the tree's diameter efficiently.

Steps:
Perform BFS from any arbitrary node (e.g., node 0).

Find the farthest node x from the starting point.

Perform another BFS starting from node x.

The maximum distance found in this second BFS is the tree's diameter.

Time Complexity:
Each BFS traversal takes O(n) time.

Therefore, the overall time is O(n).

▶️ How to Run
Open the project in IntelliJ (or any Java IDE).

Run the MainQuest2 class.

The tree is hardcoded as an adjacency list.

## Input Graph
<img src="https://github.com/user-attachments/assets/4ab31fac-f235-47a6-922a-124bd7fa3690" width="300"/>


## Output
```
Node: 0 Connected to: [1]
Node: 1 Connected to: [0, 2, 3]
Node: 2 Connected to: [1]
Node: 3 Connected to: [1, 4]
Node: 4 Connected to: [3, 5]
Node: 5 Connected to: [4]
The Deepest Node:5
Final Answer: The Diameter of tree is: 4
Total cost of O(N)
```


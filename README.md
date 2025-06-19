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




```

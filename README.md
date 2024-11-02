# TicTacToe-Game-with-Smarter-AI
TicTacToe Game with Smarter AI By KaveeN

1
Final Examination
Total Marks: 100
Course Work
ITS1033 – Object Oriented Programming
Graduate Diploma in Software Engineering
2
Tic-Tac-Toe: Championship Edition
You MUST do this assignment individually and, unless otherwise specified, follow all the
general instructions and regulations for assignments. Please read this entire document
before starting.
Warm-up
In this assignment, your knowledge and development skills will be evaluated in the
following areas:
- Programming Fundamentals
- Matrices
- Concrete Classes, Abstract Classes, Interfaces, Nested Classes
- Enumerations
- Encapsulation, Inheritance, Polymorphism, Abstractions
- Java Bean Specification
- Access Modifiers
- Recursion
- UML Class Diagrams
- Simple Artificial Intelligence
Take 20 minutes to recap and refresh your knowledge of these topics before you begin.
Introduction
In this assignment, you will implement the logic behind the Tic-Tac-Toe game, including a
simple Artificial Intelligence for the computer player. If you've never played the game
before, familiarize yourself with it by visiting the following link:
https://en.wikipedia.org/wiki/Tic-Tac-Toe
The goal of the game is to form a horizontal, vertical, or diagonal line of three connected
pieces. We will use a 3x3 grid for this assignment.
Use Java FX to Implement the UI. The focus is solely on implementing the game logic using
object-oriented programming principles.
Prerequisites to complete this assignment
Ensure you have the following applications installed:
- Java 11 (Oracle JDK 11) or later
- Maven >= 3.8.1 or later
- Git
3
Step 1: Getting the class hierarchy ready (Marks: 30)
After opening the project in IntelliJ IDEA(or any IDE compatible with Java), you should create
a project structure. Then you should build the class hierarchy.
4
Key Components:
1. Main:
The Main class contains the main() method, which is the entry point for the
application. It controls the flow of the game, including player turns, reading user
input, and invoking methods to check the game state.
Key Methods:
main(String[] args): Starts the game loop, handling user input and
alternating turns between the human and AI players.
2. Board(Interface):
The Board interface defines the essential methods that any implementation of a TicTac-Toe board must provide.
3. BoardImpl:
The BoardImpl class represents the Tic-Tac-Toe board and handles game logic,
including validating moves, updating the board state, and checking for a winner.
Attributes:
Piece[][] pieces: A 2D array representing the Tic-Tac-Toe board (3x3 grid).
Key Methods:
• BoardImpl(): Initializes the board, filling all cells with Piece.EMPTY.
• initializeBoard(): Resets the board to an empty state.
• isLegalMove(int row, int col): Checks whether a move to the specified row
and column is valid.
• updateMove(int row, int col, Piece piece): Updates the board by placing a
piece (X or O) at the specified location.
• checkWinner(): Checks if there is a winner, returns the winning piece or
indicates a tie/no winner.
• printBoard(): Displays the current board state in the console.
5
4. Player (Abstract):
The Player class is an abstract base class for both human and AI players. It defines
the common interface for making moves.
Attributes:
BoardImpl board: The game board on which the player will make moves.
Key Methods:
move(int row, int col): Abstract method that must be implemented by
subclasses to execute a move.
5. HumanPlayer (Extends Player)
The HumanPlayer class implements the logic for human players, allowing them to
select a move by specifying a row and column.
Key Methods:
move(int row, int col): Implements the abstract method, placing an X on the
board at the specified location.
6. AiPlayer (Extends Player):
The AiPlayer class handles the AI player logic. Initially, the AI chooses moves
randomly. Later, it can be enhanced with algorithms like Minimax.
Attributes:
Random random: Generates random moves for the AI.
Key Methods:
move(int row, int col): Selects a random valid move on the board and places
an O in the corresponding location.
7. Piece (Enum):
The Piece enum represents the three possible states of a cell on the board.
Enum Values:
• X: Represents the human player's piece.
• O: Represents the AI player's piece.
6
• EMPTY: Represents an empty cell.
Step 2: Implementing game logic (Marks: 40)
After completing the class hierarchy, implement the logic for the Tic-Tac-Toe game. This
includes:
BoardImpl Class:
- Initialize a 3x3 grid to represent the board.
- Implement methods like:
- findNextAvailableSpot(): Return the next available cell in a row or column.
- isLegalMove(int row, int col): Check if a move is valid.
- updateMove(int row, int col, Piece piece): Update the board with the current move.
- findWinner(): Check if a player has won by forming a line of three pieces.
Step 3: Implementing smarter AI (Marks: 30)
While the game will work with random moves, we will improve the AI using a Minimax
algorithm to make the AI competitive.
Introduction to the Minimax Algorithm:
The Minimax algorithm is used to minimize the possible loss in a worst-case scenario. In the
context of this game:
- The AI player will try to maximize its chance of winning.
- It will simultaneously try to minimize the player's chance of winning.
Step 3.1 Minimax Algorithm
The Minimax algorithm is a popular decision-making algorithm used in AI for two-player
games like Tic-Tac-Toe. It assumes that both players are playing optimally and tries to
minimize the possible loss in a worst-case scenario, hence the name "Minimax" (minimizing
the maximum loss). The algorithm evaluates all possible moves and selects the one that
leads to the best possible outcome.
How Minimax Works
The idea is to simulate all possible moves for the AI and the human player, alternating turns
between them. The AI will try to maximize its score (maximize its chances of winning),
while the human player is assumed to minimize the AI's score (reduce the chances of AI
winning). The AI evaluates each potential move using a recursive process until it reaches a
terminal state (win, loss, or draw).
Key Concepts:
1. Maximizer (AI): The AI player tries to maximize the score, i.e., tries to win.
7
2. Minimizer (Human): The human player tries to minimize the AI's score by making
moves that reduce the AI's chances of winning.
3. Terminal States: The game ends when:
• The AI wins (Maximizer).
• The human player wins (Minimizer).
• The game is a draw.
Steps to Implement Minimax for Tic-Tac-Toe
1. Evaluate Terminal States
• Assign scores for terminal states:
o AI wins (Maximizer): +1
o Human wins (Minimizer): -1
o Draw: 0
2. Recursively Evaluate Possible Moves
• The algorithm explores all possible moves, simulating alternating turns between
the human player and the AI.
• For each possible move, simulate the opponent's best response and
backpropagate the results up the game tree.
3. Choose the Best Move
• The AI selects the move that maximizes its chances of winning (the move with
the highest score).
Minimax Algorithm in Action
The Minimax algorithm will explore the game tree as follows:
• For each possible move, it simulates the human's response (the "minimizing"
player).
• Then, it evaluates the outcome of the game based on that move, assigning scores:
• +1 for an AI win,
• -1 for a human win,
• 0 for a tie.
• The AI player (maximizer) selects the move that maximizes its chances of winning,
while assuming the human player will choose moves that minimize the AI's chances.
Step 4: Finishing off
By this point, your Tic-Tac-Toe game should be fully functional, and the AI should offer a
challenging opponent.
Congratulations!
8
General Instructions:
1. Pay attention to the details.
2. You are allowed to use the internet for help, except for directly searching for Minimax
implementations.
3. Include detailed comments, especially on the Minimax algorithm.
4. This assignment is individual.
5. Code only in the com.assignment.tictactoe.service package.
6. You are not allowed to create top-level classes beyond what's outlined here.

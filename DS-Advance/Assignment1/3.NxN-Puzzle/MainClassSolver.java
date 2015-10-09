import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClassSolver {

	private int minMoves; // minimum number of moves in solution
	private Stack<Board> solution; // sequence of boards in solution

	private class Node implements Comparable<Node> {
		private Board board;
		private int moves; // number of moves made so far
		private Node previous; // reference to the previous Node

		public Node(Board board, int moves, Node prev) {
			this.board = board;
			this.moves = moves;
			this.previous = prev;
		}

		public int compareTo(Node that) {

			int thisPriority = this.board.manhattan() + this.moves;
			int thatPriority = that.board.manhattan() + that.moves;

			return (thisPriority - thatPriority);
		}
	}

	public MainClassSolver(Board initial) {

		MinPriorityQueue<Node> pq = new MinPriorityQueue<Node>();
		solution = new Stack<Board>();

		// insert the initial search node
		Node n = new Node(initial, 0, null);
		pq.insert(n);

		minMoves = 0;

		while (true) {

			// dequeue node with minimum priority
			n = pq.deleteMin();

			// stop when we dequeue the goal board
			if (n.board.isGoal())
				break;

			// add all of dequeued node's neighbors to the priority queue
			for (Board b : n.board.neighbors()) {
				// critical optimization: disallow previous board
				if (n.previous == null || !(b.equals(n.previous.board)))
					pq.insert(new Node(b, n.moves + 1, n));
			}
		}

		// chase pointers back to find sequence of solution boards
		n = (n.previous == null) ? n : n.previous;
		minMoves = n.moves;
		while (n.previous != null) {
			solution.push(n.board);
			n = n.previous;
		}
		solution.push(initial);
	}

	/* Return no of moves */
	public int moves() {
		return minMoves;
	}

	/* Return Solution Board */
	public Iterable<Board> solution() {
		return solution;
	}

	public static void main(String[] args) {
		System.out.println("Enter Dimension N");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int N=0;
		try {
			 N = scanner.nextInt();
		}catch(InputMismatchException io)
		{
			System.out.println("Problem  Occuered");
			System.exit(1);
		}
		int blocks[][] = new int[N][N];
		int count=1;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				System.out.println("Enter Value "+(count++));
				try {
					blocks[i][j] = scanner.nextInt();
				}catch(InputMismatchException io)
				{
					System.out.println("Problem  Occuered");
					System.exit(1);
				}
			}
		Board initial = new Board(blocks);
		// check if puzzle is solvable; if so, solve it and output solution
		if (initial.isSolvable()) {
			MainClassSolver solver = new MainClassSolver(initial);
			System.out.println("Minimum number of moves = " + solver.moves());
			for (Board board : solver.solution())
				System.out.println(board);
		}

		// otherwise not solvable
		else
			System.out.println("Unsolvable puzzle");
	}

}

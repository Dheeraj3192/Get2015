public class Board {

	private int N; // N x N board size
	private int[][] board; // array representation of board
	private int inversions; // the number of inversions on this board
	private int rowBlank; // row of the blank tile
	private int columnBlank; // column of the blank tile
	private int Manhattan;

	public Board(int[][] blocks) {
		board = blocks;
		N = blocks.length;

		Manhattan = calcManhattan();
		inversions = countInversions();
	}

	public int size() {
		return N;
	}
	
	public int getColumnBlank() {
		return columnBlank;
	}

	public void setColumnBlank(int columnBlank) {
		this.columnBlank = columnBlank;
	}


	private int countInversions() {
		int inversion = 0;
		for (int row = 0; row < N * N - 1; row++) {
			for (int column = row + 1; column < N * N; column++) {

				// ignore the blank tile
				if (board[row / N][row % N] == 0 || board[column / N][column % N] == 0)
					continue;

				// count the number of inversions
				if (board[row / N][row % N] > board[column / N][column % N]) {
					inversion += 1;
				}
			}
		}
		return inversion;
	}

	private int calcManhattan() {

		int sum = 0;
		for (int row = 0; row < N; row++) {
			for (int column = 0; column < N; column++) {

				// don't include blank in calculations, but remember where it is
				if (board[row][column] == 0) {
					rowBlank = row;
					setColumnBlank(column);
				} else {
					int goalRow = (board[row][column] - 1) / N;
					int goalCol = (board[row][column] - 1) % N;

					sum += Math.abs(row - goalRow) + Math.abs(column - goalCol);

					// check for horizontal linear conflict
					if (row == goalRow) {
						for (int k = column + 1; k < N; k++)
							if (((board[row][k] - 1) / N) == row
							&& ((board[row][k] - 1) % N) < goalCol)
								sum += 2;
					}

					// check for vertical linear conflict
					if (column == goalCol) {
						for (int k = row + 1; k < N; k++)
							if (((board[k][column] - 1) % N) == column
							&& ((board[k][column] - 1) / N) < goalRow)
								sum += 2;
					}
				}
			}
		}
		return sum;
	}

	public int manhattan() {
		return Manhattan;
	}

	public boolean isGoal() {
		return (Manhattan == 0);
	}

	public boolean isSolvable() {
		// even board size
		if (N % 2 == 0)
			return ((inversions + rowBlank) % 2 == 1);

		// odd board size
		else
			return (inversions % 2 == 0);
	}

	public boolean equals(Object y) {
		// sanity checks
		if (y == this)
			return true;
		if (y == null)
			return false;
		if (y.getClass() != this.getClass())
			return false;

		Board that = (Board) y;
		return java.util.Arrays.deepEquals(this.board, that.board);
	}

	public Iterable<Board> neighbors() {

		Stack<Board> stack = new Stack<Board>();

		int row_blank = -1;
		int column_blank = -1;
		findBlank: for (int i = 0; i < this.N; i++) {
			for (int j = 0; j < this.N; j++) {
				if (this.board[i][j] == 0) {
					row_blank = i;
					column_blank = j;
					break findBlank;
				}
			}
		}

		// swap blank with tile to the left, if possible
		if (column_blank - 1 >= 0) {
			Board left = Copy(this);
			left.board[row_blank][column_blank] = this.board[row_blank][column_blank - 1];
			left.board[row_blank][column_blank - 1] = 0;
			stack.push(left);
		}

		// swap blank with tile to the right, if possible
		if (column_blank + 1 < this.N) {
			Board right = Copy(this);
			right.board[row_blank][column_blank] = this.board[row_blank][column_blank + 1];
			right.board[row_blank][column_blank + 1] = 0;
			stack.push(right);
		}

		// swap blank with tile above, if possible
		if (row_blank - 1 >= 0) {
			Board up = Copy(this);
			up.board[row_blank][column_blank] = this.board[row_blank - 1][column_blank];
			up.board[row_blank - 1][column_blank] = 0;
			stack.push(up);
		}

		// swap blank with tile below, if possible
		if (row_blank + 1 < this.N) {
			Board down = Copy(this);
			down.board[row_blank][column_blank] = this.board[row_blank + 1][column_blank];
			down.board[row_blank + 1][column_blank] = 0;
			stack.push(down);
		}

		return stack;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int row = 0; row < N; row++) {
			for (int column = 0; column < N; column++) {
				if (this.board[row][column] == 0)
					s.append("   ");
				else
					s.append(String.format("%2d ", this.board[row][column]));
			}
			s.append("\n");
		}
		return s.toString();
	}

	private Board Copy(Board source) {
		int[][] destination = new int[source.N][source.N];

		for (int i = 0; i < source.N; i++)
			for (int j = 0; j < source.N; j++)
				destination[i][j] = source.board[i][j];

		Board copy = new Board(destination);
		return copy;
	}


}

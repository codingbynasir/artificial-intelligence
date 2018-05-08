package back_tracking;

public class Main1 {
	public static void main(String[] args) {
		Bc1 backtracking=new Bc1();
		int graph[][]= {{0, 1, 1, 1, 0},
				{1, 0, 1, 0, 1},
				{1, 1, 0, 1, 0},
				{1, 0, 1, 0, 1},
				{1, 0, 1, 0, 0}
		}, color=5;
		backtracking.backtrack(color, graph);
	}
}

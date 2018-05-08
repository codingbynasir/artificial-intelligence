package back_tracking;
public class Bc1 {
	int color[], graph[][], V=5;
	public Bc1() {
		
	}
	void backtrack(int ncolor, int graph[][]) {
		color=new int[V];
		for (int i = 0; i < ncolor; i++) {
			color[i]=0;
		}
		if (!isColored(graph, ncolor, color, 0)) {
			System.out.println("No solution found!");
		}else {
			printSolution(color);
		}
	}
	boolean isColored(int graph[][], int ncolor, int color[], int vertices) {
		if (V==vertices) {
			return true;
		}
		for (int i = 0; i < ncolor; i++) {
			if (isSafe(vertices, graph, color, i)) {
				color[vertices]=i;
				if (isColored(graph, ncolor, color, vertices+1)) {
					return true;
				}
				color[vertices]=0;
			}
		}
		return false;
	}
	boolean isSafe(int v, int graph[][], int color[], int c) {
		for (int i = 0; i < graph.length; i++) {
			if (graph[v][i]==1&&c==color[i]) {
				return false;
			}
		}
		return true;
	}
	
	
	public void printSolution(int color[]) {
		
		for (int i = 0; i < color.length; i++) {
			System.out.println(color[i]+", ");
		}
	}
}

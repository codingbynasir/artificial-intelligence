package Lab8;

import java.util.ArrayList;

public class Node {
	String name;
	boolean minMax;
	boolean leaf;
	Node parent;
	ArrayList<Node>childs;
	int score;
	Node(){
		childs = new ArrayList<>();
	}
	public Node(String name, boolean minMax, boolean leaf, Node parent) {
		super();
		this.name = name;
		this.minMax = minMax;
		this.leaf = leaf;
		this.parent = parent;
		childs = new ArrayList<>();
	}
	public static int AlphaBeta(Node node, int depth, int alpha, int beta, boolean maximizingPlayer){
        if (depth==0||node.leaf){
            return node.score;
        }
        if (maximizingPlayer){
            node.score=Integer.MIN_VALUE;
            for (Node node1:node.childs){
                node.score=Math.max(node.score, AlphaBeta(node1, depth-1, alpha, beta, false));
                alpha=Math.max(alpha, node.score);
                if (beta<=alpha){
                    System.out.println("Cut off");
                    break;
                }
            }
            return node.score;
        }else{
            node.score=Integer.MAX_VALUE;
            for (Node nodel:node.childs){
                node.score=Math.min(node.score, AlphaBeta(nodel, depth-1, alpha, beta, true));
                beta=Math.min(beta, node.score);
                if (beta<=alpha){
                    System.out.println("Cut off");
                    break;
                }
            }
            return node.score;
        }
    }
}
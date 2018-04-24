package Lab8;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Node Root = new Node("A", true, false, null);
		LinkedList<Node>queue = new LinkedList<>();
		queue.add(Root);
		while(!queue.isEmpty()) {
			Node curr =  queue.poll();
			System.out.println("#Childs of "+curr.name+":");
			int cnt;
			boolean type;
			cnt = in.nextInt();
			System.out.println("Type of "+curr.name+":");
			type = in.nextBoolean();
			if(type) {
				for(int i = 0 ; i < cnt ; i++) {
					Node temp = new Node();
					System.out.println("Name of "+i+"th child of "+curr.name+":");
					temp.name = in.next();
					System.out.println("Value of "+i+"th child of "+curr.name+":");
					temp.score = in.nextInt();
					temp.leaf = type;
					temp.parent = curr;
					curr.childs.add(temp);
				}
			}else {
				for(int i = 0 ; i < cnt ; i++) {
					Node temp = new Node();
					System.out.println("Name of "+i+"th child of "+curr.name+":");
					temp.name = in.next();
					temp.leaf = type;
					temp.parent = curr;
					temp.minMax = !curr.minMax;
					curr.childs.add(temp);
					queue.add(temp);
				}
			}
		}
        System.out.println("Value: "+Node.AlphaBeta(Root, 10, Integer.MIN_VALUE, Integer.MAX_VALUE, true));
    }
}

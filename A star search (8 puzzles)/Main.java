package stermip.ai;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
	
	static int level = 5; //easy
	HashSet<State> uniqueStates;
	
	void letsSolve(State initialState) {
		Scanner in = new Scanner(System.in);
		int dum = 0;
		uniqueStates = new HashSet<>();
		uniqueStates.add(initialState);
		 StatePriorityComparator statePriorityComparator = new StatePriorityComparator();
		 PriorityQueue<State> pQueue = new PriorityQueue<>(10, statePriorityComparator);
		 State finalState = null;
		 pQueue.add(initialState);
		 while(!pQueue.isEmpty()) {
			 State currState = pQueue.poll();
			 if (currState.goal_test()) {
	                //finalPath = currState;
	            	finalState = currState;
	                break;
	            }
	            ArrayList<State> list = currState.apply_actions();

	    		for (State nextState : list) {
	    			if(dum==0) dum = in.nextInt();
	    			System.out.println(nextState);
	    			checkUniqueStates(uniqueStates, nextState, pQueue, currState);
	    		}
		 }
	            
		 if(finalState!=null) print(finalState);  
	}
	
	
	private void print(State finalState) {
		// TODO Auto-generated method stub
		 
		 if(finalState.par!=null) {
			 print(finalState.par);
			 System.out.println(finalState);
		 }else System.out.println("The Solution:");
		 
		
	}

	void checkUniqueStates(HashSet<State> uniqueStates, State toCheck, 
			PriorityQueue<State> pQueue, State parState) {
		
		for (State s : uniqueStates) {
		    if(s.equals(toCheck)) return;
		}
		uniqueStates.add(toCheck);
        pQueue.add(toCheck);
        toCheck.par = parState;
		
		/*
	        if (!uniqueStates.contains(toCheck)) {
	            uniqueStates.add(toCheck);
	            pQueue.add(toCheck);
	            toCheck.par = parState;
	        }*/
	    }

	static State genInitialState() {
		
		State initialState = new State();
		if(level==1) {
			initialState.tileHolder[0] = 1;
			initialState.tileHolder[1] = 3;
			initialState.tileHolder[2] = 4;
			initialState.tileHolder[3] = 8;
			initialState.tileHolder[4] = 6;
			initialState.tileHolder[5] = 2;
			initialState.tileHolder[6] = 7;
			initialState.tileHolder[7] = 0;
			initialState.tileHolder[8] = 5;
			initialState.setZeroPos();
			initialState.gn = 0;
			return initialState;
		}else if(level==2) {
			initialState.tileHolder[0] = 8;
			initialState.tileHolder[1] = 3;
			initialState.tileHolder[2] = 5;
			initialState.tileHolder[3] = 4;
			initialState.tileHolder[4] = 1;
			initialState.tileHolder[5] = 6;
			initialState.tileHolder[6] = 2;
			initialState.tileHolder[7] = 7;
			initialState.tileHolder[8] = 0;
			initialState.setZeroPos();
			initialState.gn = 0;
			return initialState;
		}else if(level==3) {
			initialState.tileHolder[0] = 2;
			initialState.tileHolder[1] = 8;
			initialState.tileHolder[2] = 1;
			initialState.tileHolder[3] = 0;
			initialState.tileHolder[4] = 4;
			initialState.tileHolder[5] = 3;
			initialState.tileHolder[6] = 7;
			initialState.tileHolder[7] = 6;
			initialState.tileHolder[8] = 5;
			initialState.setZeroPos();
			initialState.gn = 0;
			return initialState;
		}else if(level==4) {
			initialState.tileHolder[0] = 2;
			initialState.tileHolder[1] = 8;
			initialState.tileHolder[2] = 1;
			initialState.tileHolder[3] = 4;
			initialState.tileHolder[4] = 6;
			initialState.tileHolder[5] = 3;
			initialState.tileHolder[6] = 0;
			initialState.tileHolder[7] = 7;
			initialState.tileHolder[8] = 5;
			initialState.setZeroPos();
			initialState.gn = 0;
			return initialState;
		}else if(level==5) {
			initialState.tileHolder[0] = 5;
			initialState.tileHolder[1] = 6;
			initialState.tileHolder[2] = 7;
			initialState.tileHolder[3] = 4;
			initialState.tileHolder[4] = 0;
			initialState.tileHolder[5] = 8;
			initialState.tileHolder[6] = 3;
			initialState.tileHolder[7] = 2;
			initialState.tileHolder[8] = 1;
			initialState.setZeroPos();
			initialState.gn = 0;
			return initialState;
		}
		Random rnd= new Random();
		for(int i = 0; i<9; i++) {
			int  n = rnd.nextInt(9);
			while(!unique(initialState, i, n)) {
				n = rnd.nextInt(9);
			}
			
			initialState.tileHolder[i]=n;
		}
		
		initialState.gn = 0;
		initialState.setZeroPos();
		return initialState;
		
		//Easy: 1, 3, 4, 8, 6, 2, 7, 0, 5
		//|8 3 5|
        //|4 1 6|
        //|2 7 0|
	}
	
	private static boolean unique(State initialState, int indx, int n) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i< indx; i++) {
			if(initialState.tileHolder[i]==n) return false;
		}
		return true;
	}


	public static void main(String[] args) {

		State initialState = genInitialState();
		System.out.println("Initial State:");
		System.out.println(initialState);
		//initialState.apply_actions();
		new Main().letsSolve(initialState);
	}
	
	
}

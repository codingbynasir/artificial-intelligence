package Solution;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

	HashSet<State> uniqueStates;

	void letsSolve(State initialState) {
		 uniqueStates = new HashSet<>();

		 LinkedList<State> queue = new LinkedList<>();
	     queue.add(initialState);
	     State finalState = null;
	     while (!queue.isEmpty()) {
	            State currState = queue.poll();
	            if (currState.goal_test()) {
	                //finalPath = currState;
	            	finalState = currState;
	                break;
	            }
	            ArrayList<State> list = currState.apply_actions();

	    		for (State nextState : list) {
	    			checkUniqueStates(uniqueStates, nextState, queue, currState);
	    		}

	     }

	     if(finalState!=null) print(finalState);


	}

	 private void print(State finalState) {
		// TODO Auto-generated method stub

		 if(finalState.par!=null) {
			 print(finalState.par);
			 System.out.println(finalState);
		 }else System.out.println("Jug1-----Jug2");


	}

	void checkUniqueStates(HashSet<State> uniqueStates, State toCheck,
	            LinkedList<State> queue, State parState) {
	        if (!uniqueStates.contains(toCheck)) {
	            uniqueStates.add(toCheck);
	            queue.add(toCheck);
	            toCheck.par = parState;
	        }
	    }



	public static void main(String[] args) {

		State.set_parameters(3, 5, 4);
		State initialState = new State(0, 0);
		new Main().letsSolve(initialState);
	}


}

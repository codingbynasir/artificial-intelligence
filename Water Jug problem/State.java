package Solution;
import java.util.ArrayList;

public class State {

	static int cap1, cap2, target;

	int jug1, jug2;
	State par;

	public State(int j1, int j2) {
		// super();
		this.jug1 = j1;
		this.jug2 = j2;
		par = null;
	}

	public static void set_parameters(int c1, int c2, int t) {
		cap1 = c1;
		cap2 = c2;
		target = t;
	}



	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        State other = (State) obj;
	        if (jug1 != other.jug1) {
	            return false;
	        }
	        if (jug2 != other.jug2) {
	            return false;
	        }
	        return true;
	    }


	public State empty_jug1() {

		State successor = new State(0, jug2);

		return successor;
	}

	public State empty_jug2() {

		State successor = new State(jug1, 0);

		return successor;
	}

	public State fill_jug1() {
		State successor = new State(cap1, jug2);

		return successor;
	}

	public State fill_jug2() {
		State successor = new State(jug1, cap2);

		return successor;
	}

	public State transfer_1_to_2() {

		int transferAmount;

		if (jug2 + jug1 > cap2)
			transferAmount = cap2 - jug2;
		else
			transferAmount = jug1;

		State successor = new State(jug1 - transferAmount, jug2 + transferAmount);

		return successor;
	}

	public State transfer_2_to_1() {

		int transferAmount;

		if (jug1 + jug2 > cap1)
			transferAmount = cap1 - jug1;
		else
			transferAmount = jug2;

		State successor = new State(jug1 + transferAmount, jug2 - transferAmount);

		return successor;
	}

	public Boolean goal_test() {
		// return jug1 == target || jug2 == target;

		if (jug1 == target || jug2 == target)
			return true;

		return false;
	}

	public ArrayList<State> apply_actions() {

		ArrayList<State> successors = new ArrayList<>();
		State s;

		s = empty_jug1();
		successors.add(s);

		s = empty_jug2();
		successors.add(s);

		s = fill_jug1();
		successors.add(s);

		s = fill_jug2();
		successors.add(s);

		s = transfer_1_to_2();
		successors.add(s);

		s = transfer_2_to_1();
		successors.add(s);

		return successors;
	}

	public String toString() {
		return "( " + jug1 + "------" + jug2 + " )";
	}
}

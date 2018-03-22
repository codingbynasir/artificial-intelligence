package stermip.ai;
import java.util.ArrayList;

public class State {

	static int target[]= {1, 2, 3, 8, 0, 4, 7, 6, 5};

	int tileHolder[] = new int [9];
	int zeroPos;
	State par;
	
	/* A* Search */
	int gn; //g(n) = cost so far to reach n
	
	
	
	

	public State() {
		
		par = null;
	}
	
	public State(State other) {
		for(int i = 0; i<9; i++) {
			tileHolder[i] = other.tileHolder[i];
		}
		zeroPos  = other.zeroPos;
		par = other.par;
		gn = other.gn;
	}

	
	
	
	 @Override
	    public boolean equals(Object obj) {
		 	System.out.println("Hello from equals");
		 	//System.out.println(obj);
		 
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
	        
	        
	        for(int i = 0; i<9; i++) {
	        	if(tileHolder[i]!=other.tileHolder[i]) return false;
	        }
	        
	        if(gn != other.gn) return false;
	        System.out.println(obj);
	        return true;
	    }
	

	
	public Boolean goal_test() {
		for(int i = 0; i<9; i++) {
			if(target[i]!=tileHolder[i]) return false;
		}
		return true;
	}

	State moveUP() {
		State dup = new State(this);
		if(dup.zeroPos<3) return dup;
		dup.tileHolder[dup.zeroPos] = dup.tileHolder[dup.zeroPos-3];
		dup.zeroPos = dup.zeroPos-3;
		dup.tileHolder[dup.zeroPos] = 0;
		dup.gn++;
		//System.out.println("UP: \n"+dup);
		return dup;
		
	}
	
	State moveDOWN() {
		State dup = new State(this);
		if(dup.zeroPos>5) return dup;
		dup.tileHolder[dup.zeroPos] = dup.tileHolder[dup.zeroPos+3];
		dup.zeroPos = dup.zeroPos+3;
		dup.tileHolder[dup.zeroPos] = 0;
		dup.gn++;
		//System.out.println("Down: \n"+dup);
		return dup;
	}
	
	State moveLEFT() {
		State dup = new State(this);
		if(dup.zeroPos == 0 || dup.zeroPos == 3 || dup.zeroPos == 6) return dup;
		dup.tileHolder[dup.zeroPos] = dup.tileHolder[dup.zeroPos-1];
		dup.zeroPos = dup.zeroPos-1;
		dup.tileHolder[dup.zeroPos] = 0;
		dup.gn++;
		//System.out.println("Left: \n"+dup);
		return dup;
	}
	
	State moveRIGHT() {
		State dup = new State(this);
		if(dup.zeroPos == 2 || dup.zeroPos == 5 || dup.zeroPos == 8) return dup;
		dup.tileHolder[dup.zeroPos] = dup.tileHolder[dup.zeroPos+1];
		dup.zeroPos = dup.zeroPos+1;
		dup.tileHolder[dup.zeroPos] = 0;
		dup.gn++;
		//System.out.println("Right: \n"+dup);
		return dup;
	}
	
	
	public ArrayList<State> apply_actions() {

		ArrayList<State> successors = new ArrayList<>();
		//System.out.println("Original: \n"+this);

		successors.add(moveLEFT());
		successors.add(moveRIGHT());
		successors.add(moveUP());
		successors.add(moveDOWN());
		return successors;
	}

	
	int getTotalCost() {
		return gn+getFn();
	}
	
	int getFn() {
		//manhatton distance
		int difference = 0;
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if(tileHolder[i] == target[j]) {
					 difference = difference + ((Math.abs(i % 3 - j % 3)) + Math.abs(i / 3 - j / 3));
				}
			}
		}
		return difference;
	}
	
	void setZeroPos() {
		this.zeroPos = getZeroPos();
	}
	
	
	private int getZeroPos() {
		// TODO Auto-generated method stub
		for(int i = 0; i<9; i++) {
			if(tileHolder[i]==0) return i;
		}
		System.out.println("ERROR: No zero found\n");
		return -1;
	}

	public String toString() {
		
		String str="";
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				str=str+tileHolder[i*3+j]+" ";
			}
			str+="\n";
		}
		str+="g = "+gn+"  fn = "+getFn()+ "  tc = "+ getTotalCost()+"\n\n";
		return str;
	}
}

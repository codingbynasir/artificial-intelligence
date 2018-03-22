package Robot;

import java.util.ArrayList;

public class State {
    static int blockades[]={0,0,0,0,0,0,0,0,2,0,-1,-1,0,0,-1,-1,0,-1,0,0,0,0,0,0,0};
    int tileHolder[]= new int[25];
    int robotPos;
    int goal, gn=0;
    State par;
    public State() {
        par = null;
    }

    public State(State other) {
        for(int i = 0; i<25; i++) {
            blockades[i] = other.blockades[i];
        }
        robotPos  = other.robotPos;
        par = other.par;
        goal=other.goal;
        gn=other.gn;
    }

    public Boolean goal_test() {
        for(int i = 0; i<25; i++) {
            if(blockades[i]!=tileHolder[i]) return false;
        }
        return true;
    }
    State moveUP() {
        State dup = new State(this);
        if(dup.robotPos<5) {
            return dup;
        }
        int temp=dup.robotPos-5;
        if (tileHolder[temp]==-1){
            return dup;
        }
        dup.tileHolder[dup.robotPos] = dup.tileHolder[dup.robotPos-5];
        dup.robotPos = dup.robotPos-5;
        dup.tileHolder[dup.robotPos] = 0;
        gn++;
        //System.out.println("UP: \n"+dup);
        return dup;
    }
    State moveDOWN() {
        State dup = new State(this);
        if(dup.robotPos>5){
            return dup;
        }
        int temp=robotPos+5;
        if(tileHolder[temp]==-1){
            return dup;
        }
        dup.tileHolder[dup.robotPos] = dup.tileHolder[dup.robotPos+5];
        dup.robotPos = dup.robotPos+5;
        dup.tileHolder[dup.robotPos] = 0;
        dup.gn++;
        //System.out.println("Down: \n"+dup);
        return dup;
    }
    State moveLEFT() {
        State dup = new State(this);
        if(dup.robotPos == 0 || dup.robotPos == 5 || dup.robotPos == 10||dup.robotPos==15||dup.robotPos==20||dup.robotPos==24) {
            return dup;
        }
        int temp=robotPos-1;
        if (tileHolder[temp]==-1){
            return dup;
        }
        dup.tileHolder[dup.robotPos] = dup.tileHolder[dup.robotPos-1];
        dup.robotPos = dup.robotPos-1;
        dup.tileHolder[dup.robotPos] = 0;
        dup.gn++;
        //System.out.println("Left: \n"+dup);
        return dup;
    }
    State moveRIGHT() {
        State dup = new State(this);
        if(dup.robotPos == 4 || dup.robotPos == 9 || dup.robotPos == 15){
            return dup;
        }
        int temp=robotPos+1;
        if (tileHolder[temp]==-1){
            return dup;
        }
        dup.tileHolder[dup.robotPos] = dup.tileHolder[dup.robotPos+1];
        dup.robotPos = dup.robotPos+1;
        dup.tileHolder[dup.robotPos] = 0;
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
        for(int i = 0; i<25; i++) {
            for(int j = 0; j<25; j++) {
                if(tileHolder[i] == blockades[j]) {
                    difference = difference + ((Math.abs(i % 5 - j % 5)) + Math.abs(i / 5 - j / 5));
                }
            }
        }
        return difference;
    }
    void setZeroPos() {
        this.robotPos = getRobotPos();
    }
    private int getRobotPos() {
        // TODO Auto-generated method stub
        for(int i = 0; i<25; i++) {
            if(tileHolder[i]==2) return i;
        }
        System.out.println("ERROR: No zero found\n");
        return -1;
    }
    public String toString() {

        String str="";
        for(int i = 0; i<25; i++) {
            for(int j = 0; j<25; j++) {
                str=str+tileHolder[i*25+j]+" ";
            }
            str+="\n";
        }
        str+="g = "+gn+"  fn = "+getFn()+ "  tc = "+ getTotalCost()+"\n\n";
        return str;
    }
}
package Lab;

/**
 * Created by Administrator on 4/10/2018.
 */
public class State {
    int sackSize, totalItem, value[][];
    int currentHeuristic;
    int combination[], initialsack=0, totalWeight=0;
    public State(int s, int t, int v[][]){
        this.sackSize=s;
        this.totalItem=t;
        this.value=v;
    }
    public State(){
        super();
    }

    public int setHeuristic(int value[][], int combination[]){
        int temp=0, temp2=0, index=0;
        int x=0;
        int avg[]=new int[totalItem];
        for (int i=0;i<totalItem;i++){
            for (int j=0;j<combination.length;j++){
                if (i!=combination[j]){
                    avg[i]= value[i][0]/value[i][1];
                }
            }
        }
        for (int i=0;i<totalItem;i++){
            temp=avg[i];
            temp2=avg[i+1];
            if (temp>temp2){
                x=temp;
                index=i;
            }
        }
        currentHeuristic=x;
        return index;
    }
    public void lets_solve(){
        int i=0;
        while (true){
            if (initialsack<sackSize){
                if (!isTaken(i)){
                    combination[i]=setHeuristic(value, combination);
                    totalWeight+=value[i][0];
                    i++;
                }
            }else{
                break;
            }
        }
    }
    public boolean isTaken(int i){
        for (int j=0; j<combination.length;j++){
            if (i==j){
                return true;
            }
        }
        return false;
    }
    public void printSln(){
        System.out.println("Index of component: ");
        for (int i=0;i<combination.length;i++){
            System.out.println(combination[i]+" ");
        }
        System.out.println("Total weight: "+totalWeight);
    }
}

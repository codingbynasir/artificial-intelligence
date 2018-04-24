package Lab;

import java.util.Scanner;

/**
 * Created by Nasir Khan on 4/10/2018.
 */
public class Main {

    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        State st;
        int sackSize, totalItem;
        System.out.println("Enter Knapsack Size: ");
        sackSize=sc.nextInt();
        System.out.println("Enter total number of item: ");
        totalItem=sc.nextInt();
        int value[][]= new int[totalItem][2];
        System.out.println("Enter value and weight: ");
        for (int i=0;i<totalItem;i++){
            for (int j=0; j<2; j++){
                value[i][j]=sc.nextInt();
            }
        }
        st= new State(sackSize, totalItem, value);
        st.lets_solve();
        st.printSln();
    }
}
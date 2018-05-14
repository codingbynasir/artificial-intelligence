package lab11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Nasir on 5/8/2018.
 */
public class csvReader {
    public static void main(String[] args) {
    	Classify classify= new Classify();
        Scanner sc=new Scanner(System.in);
        ArrayList<Datasets> list= new ArrayList<Datasets>();
        String csvFile = "E:/Java/Artificial/src/lab11/test.csv";
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                
                // use comma as separator
                String[] dataset = line.split(cvsSplitBy);
                Datasets dset= new Datasets(Integer.valueOf(dataset[0]),Integer.valueOf(dataset[1]),Integer.valueOf(dataset[2]));
                list.add(dset);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("X: ");
        int nx=sc.nextInt();
        System.out.println("Y: ");
        int ny=sc.nextInt();


        for (int i=0; i<list.size(); i++){
            Datasets dset= new Datasets();
            Double a= (Double) Math.sqrt(Math.pow((nx-list.get(i).x), 2)+Math.pow((ny-list.get(i).y), 2));
            list.get(i).dist=a;
        }
        classify.objectClassify(list, 10);
    }
}

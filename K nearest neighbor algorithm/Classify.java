package lab11;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by Nasir on 5/8/2018.
 */
public class Classify {
	double cls0=0.0, cls1=0.0;
	public void objectClassify(ArrayList<Datasets> list, int k) {
		Collections.sort(list, new sorting());
		for (int i=0; i<k; i++){
			if (list.get(i).cls==0) {
				cls0+=list.get(i).dist;
			}else {
				cls1+=list.get(i).dist;
			}
			System.out.println("X: "+list.get(i).x+" Y: "+list.get(i).y+" Class: "+list.get(i).cls+ " distance: "+list.get(i).dist);
      }
		if ((cls0/k)<(cls1/k)) {
			System.out.println("Class is: 0");
		}else if ((cls0/k)>(cls1/k)) {
			System.out.println("Class is: 1");
		}
	}
}


class sorting implements Comparator<Datasets>{

	@Override
	public int compare(Datasets d1, Datasets d2) {
		if (d1.dist>d2.dist) {
			return 1;
		}else {
			return -1;	
		}
	}

	
}
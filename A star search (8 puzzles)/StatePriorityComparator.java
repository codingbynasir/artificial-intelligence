package stermip.ai;
import java.util.Comparator;


public class StatePriorityComparator implements Comparator<State>{
	@Override
    public int compare(State x, State y) {
        if (x.getTotalCost() < y.getTotalCost()) {
            return -1;
        }
        if (x.getTotalCost() > y.getTotalCost()) {
            return 1;
        }
        return 0;
    }
}



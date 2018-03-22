package Robot;

import java.util.Comparator;

public class StatePriorityComparator implements Comparator<State> {

    @Override
    public int compare(State o1, State o2) {
        if (o1.getTotalCost()<o2.getTotalCost())
            return -1;
        if (o1.getTotalCost()>o2.getTotalCost())
            return 1;
        return 0;
    }
}

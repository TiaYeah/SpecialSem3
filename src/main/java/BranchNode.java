import java.util.ArrayList;
import java.util.List;

public class BranchNode {
    List<Integer> partialOrder;
    int lowerBound;
    int upperBound;

    public BranchNode(List<Integer> partialOrder, int lowerBound, int upperBound) {
        this.partialOrder = new ArrayList<>(partialOrder);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
}

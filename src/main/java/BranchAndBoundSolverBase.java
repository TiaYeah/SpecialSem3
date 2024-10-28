import java.util.ArrayList;
import java.util.List;

public class BranchAndBoundSolverBase extends AbstractSolver{

    public BranchAndBoundSolverBase(DeliveryTask task) {
        super(task);
    }

    public int computeUpperBound(List<Integer> order) {
        List<Integer> localOrder = new ArrayList<>(order);

        List<Integer> remainingOrders = new ArrayList<>();
        for (int i = 1; i <= task.n; i++) {
            if (!order.contains(i)) {
                remainingOrders.add(i);
            }
        }

        int time = 0;
        int violations = 0;


        for (int i = 0; i < localOrder.size(); i++) {
            int deliveryTime = time + (i == 0 ? task.moveTimes[0][localOrder.get(i)] : task.moveTimes[localOrder.get(i - 1)][localOrder.get(i)]);
            if (deliveryTime > task.directiveTimes[localOrder.get(i) - 1]) {
                violations++;
            }
            time = deliveryTime;
        }

        List<Integer> noViolations;

        while (localOrder.size() != task.n) {
            noViolations = new ArrayList<>();
            for (int i = 0; i < remainingOrders.size(); i++) {
                int deliveryTime = time + (localOrder.isEmpty() ? task.moveTimes[0][remainingOrders.get(i)] : task.moveTimes[localOrder.getLast()][remainingOrders.get(i)]);
                if (deliveryTime <= task.directiveTimes[remainingOrders.get(i) - 1]) {
                    noViolations.add(remainingOrders.get(i));
                }
            }
            if (!noViolations.isEmpty()) {
                int min = Integer.MAX_VALUE;
                int minIndex = 0;

                for (int i = 0; i < noViolations.size(); i++) {
                    if (task.moveTimes[localOrder.getLast()][noViolations.get(i)] < min) {
                        min = task.moveTimes[localOrder.getLast()][noViolations.get(i)];
                        minIndex = i;
                    }
                }
                int finalMin = noViolations.get(minIndex);
                localOrder.add(finalMin);
                time += min;
                remainingOrders.removeIf(a -> a == finalMin);
            } else {
                time += task.moveTimes[localOrder.getLast()][remainingOrders.getFirst()];
                localOrder.add(remainingOrders.getFirst());
                remainingOrders.removeFirst();
                violations++;
            }
        }


        return violations;
    }

    public int computeLowerBound(List<Integer> order) {
        List<Integer> remainingOrders = new ArrayList<>();
        for (int i = 1; i <= task.n; i++) {
            if (!order.contains(i)) {
                remainingOrders.add(i);
            }
        }

        int time = 0;
        int violations = 0;


        for (int i = 0; i < order.size(); i++) {
            int deliveryTime = time + (i == 0 ? task.moveTimes[0][order.get(i)] : task.moveTimes[order.get(i - 1)][order.get(i)]);
            if (deliveryTime > task.directiveTimes[order.get(i) - 1]) {
                violations++;
            }
            time = deliveryTime;
        }

        for (int i = 0; i < remainingOrders.size(); i++) {
            int deliveryTime = time + (order.isEmpty() ? task.moveTimes[0][remainingOrders.get(i)] : task.moveTimes[order.getLast()][remainingOrders.get(i)]);
            if (deliveryTime > task.directiveTimes[remainingOrders.get(i) - 1]) {
                violations++;
            }
        }

        return violations;
    }


    public BranchNode branching(List<BranchNode> branchNodeList) {
        BranchNode bestNode = null;
        int minLowerBound = Integer.MAX_VALUE;

        for (BranchNode node : branchNodeList) {
            if (node.lowerBound < minLowerBound) {
                minLowerBound = node.lowerBound;
                bestNode = node;
            }
        }

        return bestNode;
    }
}

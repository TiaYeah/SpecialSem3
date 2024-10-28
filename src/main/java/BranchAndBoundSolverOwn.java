import java.util.ArrayList;
import java.util.List;

public class BranchAndBoundSolverOwn extends AbstractSolver {

    public BranchAndBoundSolverOwn(DeliveryTask task) {
        super(task);
    }

    @Override
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
                int max = Integer.MIN_VALUE;
                int minIndex = 0;

                for (int i = 0; i < noViolations.size(); i++) {
                    int taskIndex = noViolations.get(i);
                    //int difference = task.directiveTimes[taskIndex - 1] - time - task.moveTimes[localOrder.getLast()][taskIndex];
                    //double margin = (double) (task.directiveTimes[taskIndex - 1] - time) / task.moveTimes[localOrder.getLast()][taskIndex];

                    if (task.moveTimes[localOrder.getLast()][noViolations.get(i)] < min) {
                        min = task.moveTimes[localOrder.getLast()][noViolations.get(i)];
                        minIndex = i;
                    }
//                    if (difference < min) {
//                        min = difference;
//                        minIndex = i;
//                    }
                }
                int finalMin = noViolations.get(minIndex);
                localOrder.add(finalMin);
                time += min;
                //time += task.moveTimes[localOrder.getLast()][finalMin];
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

    @Override
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
        int orderViolations = violations;

        int minViolations = Integer.MAX_VALUE;

        for (int i = 0; i < remainingOrders.size(); i++) {
            violations = 0;
            int baseTime = time + (order.isEmpty() ? task.moveTimes[0][remainingOrders.get(i)] : task.moveTimes[order.getLast()][remainingOrders.get(i)]);
            if (baseTime > task.directiveTimes[remainingOrders.get(i) - 1]) {
                violations++;
            }

            if (remainingOrders.size() != 1) {
                for (int j = 0; j < remainingOrders.size(); j++) {
                    if (remainingOrders.get(i) != remainingOrders.get(j)) {
                        int deliveryTime = baseTime + (order.isEmpty() ? task.moveTimes[0][remainingOrders.get(j)] : task.moveTimes[remainingOrders.get(i)][remainingOrders.get(j)]);
                        if (deliveryTime > task.directiveTimes[remainingOrders.get(j) - 1]) {
                            violations++;
                        }
                    }
                }
            }
            if (violations < minViolations) {
                minViolations = violations;
            }
        }
        if (minViolations != Integer.MAX_VALUE) {
            return orderViolations + minViolations;
        } else {
            return orderViolations;
        }

    }

    @Override
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
//        BranchNode bestNode = null;
//        int minLength = Integer.MAX_VALUE;
//        for (BranchNode node : branchNodeList) {
//            if (node.partialOrder.size() < minLength) {
//                minLength = node.partialOrder.size();
//                bestNode = node;
//            }
//        }
//
//        return bestNode;
//        BranchNode bestNode = null;
//        int maxDiff = Integer.MIN_VALUE;
//
//        for (BranchNode node : branchNodeList) {
//            if (node.upperBound - node.lowerBound > maxDiff) {
//                maxDiff = node.upperBound - node.lowerBound;
//                bestNode = node;
//            }
//        }
//
//        return bestNode;
    }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractSolver {
    protected DeliveryTask task;

    public AbstractSolver(DeliveryTask task) {
        this.task = task;
    }

    public abstract int computeUpperBound(List<Integer> order);

    public abstract int computeLowerBound(List<Integer> order);

    public int solve() {
        int nodeCount = 0;
        List<BranchNode> branchNodes = new ArrayList<>();
        //branchNodes.add(new BranchNode(new ArrayList<>(), 0, Integer.MAX_VALUE));
        //int bestSolution = Integer.MAX_VALUE;
        int bestUpperBound = Integer.MAX_VALUE;
        BranchNode bestNode;
        List<Integer> bestOrder = null;

        for (int i = 1; i <= task.n; i++) {
            List<Integer> nodeOrder = List.of(i);
            branchNodes.add(new BranchNode(nodeOrder, computeLowerBound(nodeOrder), computeUpperBound(nodeOrder)));
            nodeCount++;
        }

        while (branchNodes.size() != 1 || branchNodes.getFirst().partialOrder.size() != task.n || branchNodes.getFirst().lowerBound != branchNodes.getFirst().upperBound) {
            BranchNode nodeToRemove = branching(branchNodes);
            branchNodes.remove(nodeToRemove);
            for (int i = 1; i <= task.n; i++) {
                if (!nodeToRemove.partialOrder.contains(i)) {
                    List<Integer> newOrder = new ArrayList<>(nodeToRemove.partialOrder);
                    newOrder.add(i);

                    BranchNode newNode = new BranchNode(newOrder, computeLowerBound(newOrder), computeUpperBound(newOrder));

                    branchNodes.add(newNode);
                    nodeCount++;
                }
            }

            bestUpperBound = Integer.MAX_VALUE;
            bestNode = null;

            for (BranchNode branchNode : branchNodes) {
                if (branchNode.upperBound <= bestUpperBound) {
                    bestUpperBound = branchNode.upperBound;
                    bestNode = branchNode;
                }
            }

            for (Iterator<BranchNode> it = branchNodes.iterator(); it.hasNext(); ) {
                BranchNode nextNode = it.next();
                if (nextNode.lowerBound >= bestUpperBound && nextNode != bestNode) {
                    it.remove();
                }
            }

        }

        bestOrder = branchNodes.getFirst().partialOrder;

        if (bestOrder != null) {
            System.out.println("Лучший порядок выполнения заказов: " + bestOrder);
            System.out.println("Минимальное количество нарушений: " + bestUpperBound);
        } else {
            System.out.println("Решение не найдено.");
        }

        return nodeCount;
    }

    public abstract BranchNode branching(List<BranchNode> branchNodeList);
}

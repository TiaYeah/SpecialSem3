public class Main {
    public static void main(String[] args) {
        int n = 3; // Число заказов
        int[] directiveTimes = {26, 29, 28}; // Директивные сроки для каждого заказа
        int[][] moveTimes = {
                {0, 15, 15, 5},
                {15, 0, 0, 15},
                {15, 0, 0, 15},
                {5, 15, 15, 0}
        }; // Время перемещения между пунктами назначения

        DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);
        BranchAndBoundSolverBase solver = new BranchAndBoundSolverBase(task);
        solver.solve();
//        System.out.println(solver.computeLowerBound(Arrays.asList(3)));
//        System.out.println(solver.computeUpperBound(Arrays.asList(3)));
    }
}

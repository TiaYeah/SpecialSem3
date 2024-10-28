import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestTask3 {
    Scanner scanner;
    static List<Double> times = new ArrayList<>();
    static List<Double> nodes = new ArrayList<>();

    @Test
    public void test00() {
        try {
            scanner = new Scanner(new File("src/main/resources/task_3_09_n50.txt"));
            int n = scanner.nextInt();
            int[] directiveTimes = new int[n];
            int[][] moveTimes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                directiveTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    moveTimes[i][j] = scanner.nextInt();
                }
            }

            DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);

            AbstractSolver baseSolver = new BranchAndBoundSolverBase(task);
            baseSolver.solve();

            AbstractSolver ownSolver = new BranchAndBoundSolverOwn(task);
            ownSolver.solve();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test01() {
        System.out.println("Тест 1");
        try {
            scanner = new Scanner(new File("src/main/resources/task_3_01_n3.txt"));
            int n = scanner.nextInt();
            int[] directiveTimes = new int[n];
            int[][] moveTimes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                directiveTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    moveTimes[i][j] = scanner.nextInt();
                }
            }

            long startBase, baseTime, startOwn, ownTime;
            int baseNodeUse, ownNodeUse;
            DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);

            startBase = System.nanoTime();
            AbstractSolver baseSolver = new BranchAndBoundSolverBase(task);
            baseNodeUse = baseSolver.solve();
            baseTime = System.nanoTime() - startBase;
            System.out.println("Базовое время " + baseTime);
            System.out.println("Базовое использование вершин " + baseNodeUse);

            startOwn = System.nanoTime();
            AbstractSolver ownSolver = new BranchAndBoundSolverOwn(task);
            ownNodeUse = ownSolver.solve();
            ownTime = System.nanoTime() - startOwn;
            System.out.println("Собственное время " + ownTime);
            System.out.println("Собственное использование вершин " + ownNodeUse);
            
            double tNorm = (double) (ownTime - baseTime) / baseTime;
            times.add(tNorm);
            double nodeNorm = (double) (ownNodeUse - baseNodeUse) / baseNodeUse;
            nodes.add(nodeNorm);


            System.out.println("Разница времен " + tNorm);
            System.out.println("Разница вершин " + nodeNorm);
            scanner.close();
        System.out.println("------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test02() {
        System.out.println("Тест 2");
        try {
            scanner = new Scanner(new File("src/main/resources/task_3_02_n3.txt"));
            int n = scanner.nextInt();
            int[] directiveTimes = new int[n];
            int[][] moveTimes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                directiveTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    moveTimes[i][j] = scanner.nextInt();
                }
            }

            long startBase, baseTime, startOwn, ownTime;
            int baseNodeUse, ownNodeUse;
            DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);

            startBase = System.nanoTime();
            AbstractSolver baseSolver = new BranchAndBoundSolverBase(task);
            baseNodeUse = baseSolver.solve();
            baseTime = System.nanoTime() - startBase;
            System.out.println("Базовое время " + baseTime);
            System.out.println("Базовое использование вершин " + baseNodeUse);

            startOwn = System.nanoTime();
            AbstractSolver ownSolver = new BranchAndBoundSolverOwn(task);
            ownNodeUse = ownSolver.solve();
            ownTime = System.nanoTime() - startOwn;
            System.out.println("Собственное время " + ownTime);
            System.out.println("Собственное использование вершин " + ownNodeUse);

            double tNorm = (double) (ownTime - baseTime) / baseTime;
            times.add(tNorm);
            double nodeNorm = (double) (ownNodeUse - baseNodeUse) / baseNodeUse;
            nodes.add(nodeNorm);


            System.out.println("Разница времен " + tNorm);
            System.out.println("Разница вершин " + nodeNorm);
            scanner.close();
        System.out.println("------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test03() {
        System.out.println("Тест 3");
        try {
            scanner = new Scanner(new File("src/main/resources/task_3_03_n10.txt"));
            int n = scanner.nextInt();
            int[] directiveTimes = new int[n];
            int[][] moveTimes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                directiveTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    moveTimes[i][j] = scanner.nextInt();
                }
            }

            long startBase, baseTime, startOwn, ownTime;
            int baseNodeUse, ownNodeUse;
            DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);

            startBase = System.nanoTime();
            AbstractSolver baseSolver = new BranchAndBoundSolverBase(task);
            baseNodeUse = baseSolver.solve();
            baseTime = System.nanoTime() - startBase;
            System.out.println("Базовое время " + baseTime);
            System.out.println("Базовое использование вершин " + baseNodeUse);

            startOwn = System.nanoTime();
            AbstractSolver ownSolver = new BranchAndBoundSolverOwn(task);
            ownNodeUse = ownSolver.solve();
            ownTime = System.nanoTime() - startOwn;
            System.out.println("Собственное время " + ownTime);
            System.out.println("Собственное использование вершин " + ownNodeUse);

            double tNorm = (double) (ownTime - baseTime) / baseTime;
            times.add(tNorm);
            double nodeNorm = (double) (ownNodeUse - baseNodeUse) / baseNodeUse;
            nodes.add(nodeNorm);


            System.out.println("Разница времен " + tNorm);
            System.out.println("Разница вершин " + nodeNorm);
            scanner.close();
        System.out.println("------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test04() {
        System.out.println("Тест 4");
        try {
            scanner = new Scanner(new File("src/main/resources/task_3_04_n10.txt"));
            int n = scanner.nextInt();
            int[] directiveTimes = new int[n];
            int[][] moveTimes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                directiveTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    moveTimes[i][j] = scanner.nextInt();
                }
            }

            long startBase, baseTime, startOwn, ownTime;
            int baseNodeUse, ownNodeUse;
            DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);

            startBase = System.nanoTime();
            AbstractSolver baseSolver = new BranchAndBoundSolverBase(task);
            baseNodeUse = baseSolver.solve();
            baseTime = System.nanoTime() - startBase;
            System.out.println("Базовое время " + baseTime);
            System.out.println("Базовое использование вершин " + baseNodeUse);

            startOwn = System.nanoTime();
            AbstractSolver ownSolver = new BranchAndBoundSolverOwn(task);
            ownNodeUse = ownSolver.solve();
            ownTime = System.nanoTime() - startOwn;
            System.out.println("Собственное время " + ownTime);
            System.out.println("Собственное использование вершин " + ownNodeUse);

            double tNorm = (double) (ownTime - baseTime) / baseTime;
            times.add(tNorm);
            double nodeNorm = (double) (ownNodeUse - baseNodeUse) / baseNodeUse;
            nodes.add(nodeNorm);


            System.out.println("Разница времен " + tNorm);
            System.out.println("Разница вершин " + nodeNorm);
            scanner.close();
        System.out.println("------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test05() {
        System.out.println("Тест 5");
        try {
            scanner = new Scanner(new File("src/main/resources/task_3_05_n10.txt"));
            int n = scanner.nextInt();
            int[] directiveTimes = new int[n];
            int[][] moveTimes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                directiveTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    moveTimes[i][j] = scanner.nextInt();
                }
            }

            long startBase, baseTime, startOwn, ownTime;
            int baseNodeUse, ownNodeUse;
            DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);

            startBase = System.nanoTime();
            AbstractSolver baseSolver = new BranchAndBoundSolverBase(task);
            baseNodeUse = baseSolver.solve();
            baseTime = System.nanoTime() - startBase;
            System.out.println("Базовое время " + baseTime);
            System.out.println("Базовое использование вершин " + baseNodeUse);

            startOwn = System.nanoTime();
            AbstractSolver ownSolver = new BranchAndBoundSolverOwn(task);
            ownNodeUse = ownSolver.solve();
            ownTime = System.nanoTime() - startOwn;
            System.out.println("Собственное время " + ownTime);
            System.out.println("Собственное использование вершин " + ownNodeUse);

            double tNorm = (double) (ownTime - baseTime) / baseTime;
            times.add(tNorm);
            double nodeNorm = (double) (ownNodeUse - baseNodeUse) / baseNodeUse;
            nodes.add(nodeNorm);


            System.out.println("Разница времен " + tNorm);
            System.out.println("Разница вершин " + nodeNorm);
            scanner.close();
        System.out.println("------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test06() {
        System.out.println("Тест 6");
        try {
            scanner = new Scanner(new File("src/main/resources/task_3_06_n15.txt"));
            int n = scanner.nextInt();
            int[] directiveTimes = new int[n];
            int[][] moveTimes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                directiveTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    moveTimes[i][j] = scanner.nextInt();
                }
            }

            long startBase, baseTime, startOwn, ownTime;
            int baseNodeUse, ownNodeUse;
            DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);

            startBase = System.nanoTime();
            AbstractSolver baseSolver = new BranchAndBoundSolverBase(task);
            baseNodeUse = baseSolver.solve();
            baseTime = System.nanoTime() - startBase;
            System.out.println("Базовое время " + baseTime);
            System.out.println("Базовое использование вершин " + baseNodeUse);

            startOwn = System.nanoTime();
            AbstractSolver ownSolver = new BranchAndBoundSolverOwn(task);
            ownNodeUse = ownSolver.solve();
            ownTime = System.nanoTime() - startOwn;
            System.out.println("Собственное время " + ownTime);
            System.out.println("Собственное использование вершин " + ownNodeUse);

            double tNorm = (double) (ownTime - baseTime) / baseTime;
            times.add(tNorm);
            double nodeNorm = (double) (ownNodeUse - baseNodeUse) / baseNodeUse;
            nodes.add(nodeNorm);


            System.out.println("Разница времен " + tNorm);
            System.out.println("Разница вершин " + nodeNorm);
            scanner.close();
            System.out.println("------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test07() {
        System.out.println("Тест 7");
        try {
            scanner = new Scanner(new File("src/main/resources/task_3_07_n15.txt"));
            int n = scanner.nextInt();
            int[] directiveTimes = new int[n];
            int[][] moveTimes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                directiveTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    moveTimes[i][j] = scanner.nextInt();
                }
            }

            long startBase, baseTime, startOwn, ownTime;
            int baseNodeUse, ownNodeUse;
            DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);

            startBase = System.nanoTime();
            AbstractSolver baseSolver = new BranchAndBoundSolverBase(task);
            baseNodeUse = baseSolver.solve();
            baseTime = System.nanoTime() - startBase;
            System.out.println("Базовое время " + baseTime);
            System.out.println("Базовое использование вершин " + baseNodeUse);

            startOwn = System.nanoTime();
            AbstractSolver ownSolver = new BranchAndBoundSolverOwn(task);
            ownNodeUse = ownSolver.solve();
            ownTime = System.nanoTime() - startOwn;
            System.out.println("Собственное время " + ownTime);
            System.out.println("Собственное использование вершин " + ownNodeUse);

            double tNorm = (double) (ownTime - baseTime) / baseTime;
            times.add(tNorm);
            double nodeNorm = (double) (ownNodeUse - baseNodeUse) / baseNodeUse;
            nodes.add(nodeNorm);


            System.out.println("Разница времен " + tNorm);
            System.out.println("Разница вершин " + nodeNorm);
            scanner.close();
        System.out.println("------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test08() {
        System.out.println("Тест 8");
        try {
            scanner = new Scanner(new File("src/main/resources/task_3_08_n50.txt"));
            int n = scanner.nextInt();
            int[] directiveTimes = new int[n];
            int[][] moveTimes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                directiveTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    moveTimes[i][j] = scanner.nextInt();
                }
            }

            long startBase, baseTime, startOwn, ownTime;
            int baseNodeUse, ownNodeUse;
            DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);

            startBase = System.nanoTime();
            AbstractSolver baseSolver = new BranchAndBoundSolverBase(task);
            baseNodeUse = baseSolver.solve();
            baseTime = System.nanoTime() - startBase;
            System.out.println("Базовое время " + baseTime);
            System.out.println("Базовое использование вершин " + baseNodeUse);

            startOwn = System.nanoTime();
            AbstractSolver ownSolver = new BranchAndBoundSolverOwn(task);
            ownNodeUse = ownSolver.solve();
            ownTime = System.nanoTime() - startOwn;
            System.out.println("Собственное время " + ownTime);
            System.out.println("Собственное использование вершин " + ownNodeUse);

            double tNorm = (double) (ownTime - baseTime) / baseTime;
            times.add(tNorm);
            double nodeNorm = (double) (ownNodeUse - baseNodeUse) / baseNodeUse;
            nodes.add(nodeNorm);


            System.out.println("Разница времен " + tNorm);
            System.out.println("Разница вершин " + nodeNorm);
            scanner.close();
        System.out.println("------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test09() {
        System.out.println("Тест 9");
        try {
            scanner = new Scanner(new File("src/main/resources/task_3_09_n50.txt"));
            int n = scanner.nextInt();
            int[] directiveTimes = new int[n];
            int[][] moveTimes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                directiveTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    moveTimes[i][j] = scanner.nextInt();
                }
            }

            long startBase, baseTime, startOwn, ownTime;
            int baseNodeUse, ownNodeUse;
            DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);

            startBase = System.nanoTime();
            AbstractSolver baseSolver = new BranchAndBoundSolverBase(task);
            baseNodeUse = baseSolver.solve();
            baseTime = System.nanoTime() - startBase;
            System.out.println("Базовое время " + baseTime);
            System.out.println("Базовое использование вершин " + baseNodeUse);

            startOwn = System.nanoTime();
            AbstractSolver ownSolver = new BranchAndBoundSolverOwn(task);
            ownNodeUse = ownSolver.solve();
            ownTime = System.nanoTime() - startOwn;
            System.out.println("Собственное время " + ownTime);
            System.out.println("Собственное использование вершин " + ownNodeUse);

            double tNorm = (double) (ownTime - baseTime) / baseTime;
            times.add(tNorm);
            double nodeNorm = (double) (ownNodeUse - baseNodeUse) / baseNodeUse;
            nodes.add(nodeNorm);


            System.out.println("Разница времен " + tNorm);
            System.out.println("Разница вершин " + nodeNorm);
            scanner.close();
        System.out.println("------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test10() {
        System.out.println("Тест 10");
        try {
            scanner = new Scanner(new File("src/main/resources/task_3_10_n50.txt"));
            int n = scanner.nextInt();
            int[] directiveTimes = new int[n];
            int[][] moveTimes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                directiveTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    moveTimes[i][j] = scanner.nextInt();
                }
            }

            long startBase, baseTime, startOwn, ownTime;
            int baseNodeUse, ownNodeUse;
            DeliveryTask task = new DeliveryTask(n, directiveTimes, moveTimes);

            startBase = System.nanoTime();
            AbstractSolver baseSolver = new BranchAndBoundSolverBase(task);
            baseNodeUse = baseSolver.solve();
            baseTime = System.nanoTime() - startBase;
            System.out.println("Базовое время " + baseTime);
            System.out.println("Базовое использование вершин " + baseNodeUse);

            startOwn = System.nanoTime();
            AbstractSolver ownSolver = new BranchAndBoundSolverOwn(task);
            ownNodeUse = ownSolver.solve();
            ownTime = System.nanoTime() - startOwn;
            System.out.println("Собственное время " + ownTime);
            System.out.println("Собственное использование вершин " + ownNodeUse);

            double tNorm = (double) (ownTime - baseTime) / baseTime;
            times.add(tNorm);
            double nodeNorm = (double) (ownNodeUse - baseNodeUse) / baseNodeUse;
            nodes.add(nodeNorm);


            System.out.println("Разница времен " + tNorm);
            System.out.println("Разница вершин " + nodeNorm);
            scanner.close();
            System.out.println("Среднее отклонение по времени: " + times.stream().mapToDouble(k -> k).average().getAsDouble());
            System.out.println("Среднее отклонение по количеству вершин: " + nodes.stream().mapToDouble(k -> k).average().getAsDouble());
        System.out.println("------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

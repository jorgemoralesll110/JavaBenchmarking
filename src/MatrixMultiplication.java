import java.util.Random;

public class MatrixMultiplication {

    // Method to perform matrix multiplication and measure time and memory usage
    public static void matrixMultiplication(int n) {
        Random rand = new Random();

        // Create matrices A, B, and C
        double[][] A = new double[n][n];
        double[][] B = new double[n][n];
        double[][] C = new double[n][n];

        // Initialize matrices A and B with random values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = rand.nextDouble();
                B[i][j] = rand.nextDouble();
            }
        }

        // Get the Runtime instance to measure memory usage
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();  // Call garbage collector before measuring memory

        // Measure initial memory usage
        long initialMemory = runtime.totalMemory() - runtime.freeMemory();

        // Measure the start time
        long startTime = System.nanoTime();

        // Perform matrix multiplication
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Measure the end time
        long endTime = System.nanoTime();

        // Measure final memory usage
        long finalMemory = runtime.totalMemory() - runtime.freeMemory();

        // Calculate time taken in seconds
        double executionTime = (endTime - startTime) / 1e9;

        // Calculate memory used in MB
        double memoryUsed = (finalMemory - initialMemory) / (1024.0 * 1024.0);

        // Print results for this matrix size
        System.out.println("\nMatrix size: " + n + "x" + n);
        System.out.printf("Execution time: %.6f seconds\n", executionTime);
        System.out.printf("Memory used: %.2f MB\n", memoryUsed);
    }

    public static void main(String[] args) {
        // Matrix sizes to test
        int[] matrixSizes = {10, 50, 150, 300, 450, 500, 650, 800, 1000};

        // Run the matrix multiplication for each size
        for (int size : matrixSizes) {
            matrixMultiplication(size);
        }
    }
}

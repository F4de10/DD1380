
/**
 * Author: Nils Olivier
 * Date: 2024-02-26
 * Course: DD1380
 */

import java.util.*;

/**
 * The FindPaths class represents a program that finds paths in a matrix.
 * It provides a main method as the entry point of the program, which reads
 * input from the user,
 * constructs a matrix based on the input, and calls the findPaths method to
 * find the paths in the matrix.
 * The findPaths method performs a depth-first search (DFS) on the matrix to
 * find paths from the top row to the bottom row.
 * The result is returned as a string representation of the paths found in the
 * matrix.
 */
public class FindPaths {
    /**
     * The main method is the entry point of the program.
     * It reads input from the user, constructs a matrix based on the input,
     * and calls the findPaths method to find the paths in the matrix.
     * Finally, it prints the result to the console.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            sc.nextLine();
            char[][] matrix = new char[M][N];
            for (int i = 0; i < M; i++) {
                matrix[i] = sc.nextLine().toCharArray();
            }

            String result = findPaths(matrix);
            System.out.println(result);
        }
    }

    /**
     * Finds paths in a matrix and returns a string representation of the result.
     *
     * @param matrix the matrix containing characters
     * @return a string representation of the paths found in the matrix
     */
    public static String findPaths(char[][] matrix) {
        Set<Character> result = new TreeSet<>();
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[][] visited = new boolean[M][N];

        for (int j = 0; j < N; j++) {
            char targetLetter = matrix[0][j];
            if (dfs(0, j, matrix, visited, result, targetLetter)) {
                result.add(targetLetter);
            }
        }

        if (result.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (char letter : result) {
                sb.append(letter);
            }
            return sb.toString();
        }

        return "0";
    }

    /**
     * Performs a depth-first search (DFS) on a matrix to find a path from the
     * starting position (i, j)
     * to the bottom row of the matrix.
     *
     * @param i            The row index of the current position in the matrix.
     * @param j            The column index of the current position in the matrix.
     * @param matrix       The matrix to search.
     * @param visited      A boolean matrix to keep track of visited positions.
     * @param result       A set to store the characters found along the path.
     * @param targetLetter The target letter to search for in the matrix.
     * @return True if a path is found, false otherwise.
     */
    private static boolean dfs(int i, int j, char[][] matrix, boolean[][] visited,
            Set<Character> result, char targetLetter) {
        int M = matrix.length;
        int N = matrix[0].length;

        if (i < 0 || i >= M || j < 0 || j >= N || matrix[i][j] != targetLetter || visited[i][j]) {
            return false;
        }

        if (i == M - 1) {
            return true;
        }

        visited[i][j] = true;

        boolean found = (dfs(i + 1, j, matrix, visited, result, targetLetter) ||
                dfs(i, j - 1, matrix, visited, result, targetLetter) ||
                dfs(i, j + 1, matrix, visited, result, targetLetter));

        return found;
    }
}

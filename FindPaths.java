import java.util.*;

/**
 * This class represents a program that finds paths in a matrix of characters.
 * It uses a depth-first search algorithm to explore neighboring cells and find
 * paths.
 */
public class FindPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine(); // Consume the newline after reading N
        char[][] matrix = new char[M][N];
        for (int i = 0; i < M; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }
        sc.close();

        // Find and print the result
        String result = findPaths(matrix);
        System.out.println(result);
    }

    public static String findPaths(char[][] matrix) {
        Set<Character> result = new TreeSet<>();
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[][] visited = new boolean[M][N];

        // Loop through the first row
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

    // dfs method (depth first search)
    private static boolean dfs(int i, int j, char[][] matrix, boolean[][] visited,
            Set<Character> result, char targetLetter) {
        int M = matrix.length;
        int N = matrix[0].length;

        // If we are outside the matrix or the cell does not contain the target letter,
        // or the cell has been visited, return false
        if (i < 0 || i >= M || j < 0 || j >= N || matrix[i][j] != targetLetter || visited[i][j]) {
            return false;
        }

        // If we are on the last row, return true
        if (i == M - 1) {
            return true;
        }

        visited[i][j] = true; // Mark the cell as visited

        // Explore neighboring cells (down, left, right)
        boolean found = (dfs(i + 1, j, matrix, visited, result, targetLetter) ||
                dfs(i, j - 1, matrix, visited, result, targetLetter) ||
                dfs(i, j + 1, matrix, visited, result, targetLetter));

        return found;
    }
}

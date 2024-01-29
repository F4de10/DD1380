import java.util.*;

public class FindPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner("6 6\n" + //
                "AACACD\n" + //
                "ABBABD\n" + //
                "ABAAAD\n" + //
                "ABABAD\n" + //
                "AAABAD\n" + //
                "BBBBBD\n" + //
                "");
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
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[][] visited = new boolean[M][N];
        Set<Character> result = new HashSet<>();

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j]) {
                    dfs(i, j, visited, matrix, result);
                }

        if (result.isEmpty()) {
            return "0";
        }

        // Convert set to sorted array and then to a string
        Character[] resultArray = result.toArray(new Character[0]);
        char[] resultChars = new char[resultArray.length];
        for (int i = 0; i < resultArray.length; i++) {
            resultChars[i] = resultArray[i];
        }

        return new String(resultChars);
    }

    // dfs method (depth first search)
    private static void dfs(int i, int j, boolean[][] visited, char[][] matrix, Set<Character> result) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
            return; // Out of bounds or already visited or empty cell
        }

        visited[i][j] = true;
        if (i == 0 || i == matrix.length - 1) {
            result.add(matrix[i][j]);
        }

        int[][] directions = { { 1, 0 }, { -1, 0 } };
        for (int[] dir : directions) {
            dfs(i + dir[0], j + dir[1], visited, matrix, result);
        }

    }
}

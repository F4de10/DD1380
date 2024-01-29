import java.util.*;

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
        Set<Character> result = new TreeSet<>(); // Använd TreeSet för att automatiskt sortera bokstäverna
        int N = matrix[0].length;

        // Loop genom översta raden
        for (int j = 0; j < N; j++) {
            char targetLetter = matrix[0][j];
            if (dfs(0, j, matrix, result, targetLetter)) {
                return Character.toString(targetLetter);
            }
        }
        return "0";
    }

    // dfs method (depth first search)
    private static boolean dfs(int i, int j, char[][] matrix, Set<Character> result, char targetLetter) {

        int N = matrix[0].length;
        int M = matrix.length;

        // If we are outside the matrix or the cell does not contain the target letter,
        // return false
        if (i < 0 || i >= M || j < 0 || j >= N || matrix[i][j] != targetLetter) {
            return false;
        }

        // Om vi är på nedersta raden, returnera true
        if (i == M - 1) {
            return true;
        }
        char temp = matrix[i][j];
        matrix[i][j] = '.'; // Markera att vi har besökt denna ruta

        // Utforska grannrutorna (ner, vänster, höger)
        boolean found = (dfs(i + 1, j, matrix, result, targetLetter) || dfs(i, j - 1, matrix, result, targetLetter)
                || dfs(i, j + 1, matrix, result, targetLetter));

        matrix[i][j] = temp; // Återställ rutan

        return found;
    }
}

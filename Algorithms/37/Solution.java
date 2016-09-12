//Sudoku Solver
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] arr = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        s.solveSudoku(arr);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    int[][] row;
    int[][] col;
    int[][] block;

    public void solveSudoku(char[][] board) {
        row = new int[9][9];
        col = new int[9][9];
        block = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int number = board[i][j] - '1';
                    row[i][number] = 1;
                    col[j][number] = 1;
                    block[i / 3 * 3 + j / 3][number] = 1;
                }
            }
        }
        int index = 0;
        while (board[index / 9][index % 9] != '.') index++;
        solve(board, index);
    }

    private boolean solve(char[][] board, int index) {
        if (index >= 81) return true;
        int i = index / 9;
        int j = index % 9;
        for (int k = 0; k < 9; k++) {
            if (row[i][k] > 0 || col[j][k] > 0 || block[i / 3 * 3 + j / 3][k] > 0) {
                continue;
            }
            row[i][k]++;
            col[j][k]++;
            block[i / 3 * 3 + j / 3][k]++;
            board[i][j] = (char) ('1' + k);
            index = i * 9 + j;
            while (++index < 81 && board[index / 9][index % 9] != '.') ;
            if (solve(board, index)) {
                return true;
            } else { //rollback
                row[i][k]--;
                col[j][k]--;
                block[i / 3 * 3 + j / 3][k]--;
                board[i][j] = '.';
            }
        }
        return false;
    }
}

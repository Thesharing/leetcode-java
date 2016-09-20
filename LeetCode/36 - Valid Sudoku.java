/*

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Boolean nums[] = new Boolean[9];
        int len = board.length;
        int i = 0;
        int j = 0;
        int k = 0;
        for(i = 0; i < len; i++){
            init(nums);
            for(j = 0; j < len; j++){
                k = board[i][j] - '1';
                if(k == -3)
                    continue;
                if(nums[k] != true)
                    nums[k] = true;
                else
                    return false;
            }
        }
        for(j = 0; j < len; j++){
            init(nums);
            for(i = 0; i < len; i++){
                k = board[i][j] - '1';
                if(k == -3)
                    continue;
                if(nums[k] != true)
                    nums[k] = true;
                else
                    return false;
            }
        }
        for(int p = 0; p < 3; p++){
            for(int q = 0; q < 3; q++){
                init(nums);
                for(i = 0; i < 3; i ++){
                    for(j = 0; j < 3; j++){
                        k = board[p * 3 + i][q * 3 + j] - '1';
                        if(k == -3)
                            continue;
                        if(nums[k] != true){
                            nums[k] = true;
                        }
                        else
                            return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void init(Boolean[] nums){
        for(int i = 0; i < 9; i++){
            nums[i] = false;
        }
    }
}

import java.util.LinkedList;

class SurroundedRegions {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        for(int i = 0; i < board.length; i++){
            fill(board, i, 0);
            fill(board, i, board[0].length-1);
        }
        for(int i = 0; i < board[0].length; i++){
            fill(board, 0, i);
            fill(board, board.length-1, i);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    public void fill(char[][] board, int x, int y){
        if(board[x][y] != 'O')
            return;
        
        LinkedList<Integer> fringe = new LinkedList<>();
        board[x][y] = '#';
        fringe.add(x*board[0].length + y);
        while(!fringe.isEmpty()){
            int pos = fringe.pop();
            int row = pos/board[0].length;
            int col = pos%board[0].length;
            
            if(row>0 && board[row-1][col] == 'O'){
                fringe.add((row-1)*board[0].length + col);
                board[row-1][col] = '#';
            }            
            if(col>0 && board[row][col-1] == 'O'){
                fringe.add(row*board[0].length + col-1);
                board[row][col-1] = '#';
            }
            if(row<board.length-1 && board[row+1][col] == 'O'){
                fringe.add((row+1)*board[0].length + col);
                board[row+1][col] = '#';
            }
            if(col<board[0].length-1 && board[row][col+1] == 'O'){
                fringe.add(row*board[0].length + col+1);
                board[row][col+1] = '#';
            }
        }
    }
}

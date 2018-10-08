import java.util.*;

class GameSquares {
    int size;
    char[][] squares;
    int i;
    int j;
    
    GameSquares(int k) {
        this.size = k;
        this.squares = new char[k][k];
        for (int i = 0;  i < this.size; i++)  {
            for (int j = 0; j < this.size; j++) {
                this.squares[i][j] = ' ';
            }
        }
        
        this.i = -1;
        this.j = -1;
    }
    
    boolean put(int player, int i, int j){
        if ( i < 0 || i >= this.size || j < 0 || j >= this.size) {
            return false;
        }
        
        if (squares[i][j] == 'o' || squares[i][j] == 'x' ) {
            return false;
        }
        
        if (player == 1) {
            squares[i][j] = 'o';
        } else if (player == 2) {
            squares[i][j] = 'x';
        } else {
            return false;
        }
        
        this.i = i;
        this.j = j;
        return true;
    }
    
    
    boolean hasWinner() {

        int i = 0;
        if (this.i < 0 || this.j < 0) {
            return false;
        }
        
        for (; i < this.size; i++) {
            if (this.squares[i][this.j] != this.squares[this.i][this.j]) {
                break;
            }
        }
        
        if (i == this.size) {
            return true;
        }
        
        i = 0;
        for (; i < this.size; i++) {
            if (this.squares[this.i][i] != this.squares[this.i][this.j]) {
                break;
            }
        }
        
        if (i == this.size) {
            return true;
        }       
        
        if (this.i == this.j) {
            i = 0;
            for (; i < this.size; i++) {
                if (this.squares[i][i] != this.squares[this.i][this.j]) {
                   break;
                }
            }
        
            if (i == this.size) {
                return true;
            }            
        }
        
        if (this.i + this.j == this.size - 1) {
            i = 0;
            for (; i < this.size; i++) {
                if (this.squares[i][this.size - 1 - i] != this.squares[this.i][this.j]) {
                   break;
                }
            }
        
            if (i == this.size) {
                return true;
            }           
        }
        
        return false;
    
    }
    
    
    boolean isStalemate() {
        if (hasWinner()) {
            return false;
        }
        
        for (int i = 0; i < this.size; i++ ) {
            for (int j = 0; j < this.size; j++) {
                if (this.squares[i][j] != 'o' && this.squares[i][j] != 'x') {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    void printBoard() {
        
        for (int j = 0; j < this.size; j++) {
            System.out.print("--");
        }
        System.out.println();

        for (int i = 0;  i < this.size; i++)  {
            System.out.print("|");
            for (int j = 0; j < this.size; j++) {
                System.out.print(this.squares[i][j] + "|");
            }
            System.out.println();
            for (int j = 0; j < this.size; j++) {
                System.out.print("--");
            }
            System.out.println();
        }
    }
    
}


class TicTacToe {
    
    GameSquares sq;
    int step;
    
    TicTacToe(int k) {
        this.sq = new GameSquares(k);
        this.step = 0;
    }


    boolean hasWinner() {
        return this.sq.hasWinner();
    }
    
    
    boolean isStalemate() {
        return this.sq.isStalemate();
    }
    
    
    int getCurrentPlayer() {
        return (this.step + 1)%2 + 1; //Player 1 and Player 2
    }
    
    
    int getNextPlayer() {
        return (this.step)%2 + 1; //Player 1 and Player 2
    }
    
    
    int getWinner() {
        if (hasWinner()) {
            return getCurrentPlayer();
        } else {
            return -1;
        }
    }
    
    
    boolean Move(int i, int j) { //assume i, j < k (size), assume (i, j) does not collide with already occupied cells
        this.step++;
        int player = getCurrentPlayer(); 
        boolean ret = this.sq.put(player, i, j);
        if (!ret) {
            this.step--;
        }
        
        return ret;
    }
    
    
    void printBoard() {
        this.sq.printBoard();
    }
    
    
    public static void main(String[] args) {
        
        TicTacToe game = new TicTacToe(80);
        Scanner scanner = new Scanner(System.in);
        int i, j;
        
        while (!game.hasWinner() && !game.isStalemate()) {
            game.printBoard();
            
            System.out.println("Player " + game.getNextPlayer() + " Enter i and j : ");
            i = scanner.nextInt(); 
            j = scanner.nextInt();
            while (!game.Move(i, j)) {
                System.out.println("Incorrect i, j. Reenter i and j :");
                i = scanner.nextInt(); 
                j = scanner.nextInt();
            }
        }
        
        System.out.println("--------------");
        System.out.println("Game Over.");
        if (game.hasWinner()) {
            System.out.println("Winner: " + game.getCurrentPlayer());
        } else {
            System.out.println("Tied");
        }
        
        //once finished
        scanner.close();
    }
    
    
}

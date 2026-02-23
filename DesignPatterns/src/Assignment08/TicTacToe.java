package Assignment08;

import java.util.Scanner;

public class TicTacToe extends Game{
    private char[][] board;
    int winner = -1;
    private int totalMove = 0;
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void initializeGame(int numberOfPlayers){
        board = new char[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] = '-';
            }
        }
        System.out.println("Welcome to Tic Tac Toe! ");
        printBoard();
    }

    @Override
    public boolean endOfGame(){
        return winner != -1 || totalMove == 9;
    }

    @Override
    public void playSingleTurn(int player){
        char mark = (player == 0)? 'X' : 'O';
        System.out.println("Player " + player + " (" + mark + "), enter row and column (0-2): ");
        // read user input
        int row, col;
        while(true){
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-'){
                board[row][col] = mark;
                break;
            } else {
                System.out.println("Invalid move!");
            }
        }
        totalMove++;
        printBoard();

        if (checkWinner(row, col, mark)){
            winner = player;
        }
    }

    @Override
    public void displayWinner(){
        if (winner != -1){
            System.out.println("Player "+ winner + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void printBoard(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkWinner(int r, int c, char m){
        if (board[r][0] == m && board[r][1] == m && board[r][2] == m) return true;
        if (board[0][c] == m && board[1][c] == m && board[2][c] == m) return true;
        if (board[0][0] == m && board[1][1] == m && board[2][2] == m) return true;
        if (board[0][2] == m && board[1][1] == m && board[2][0] == m) return true;
        return false;
    }
}

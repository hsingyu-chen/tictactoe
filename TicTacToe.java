/**
 * Tic-Tac-Toe game
 * @ Hsing Yu Chen 
 * @ Wilson Chiu
 * CIS 36B
 */

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    /**
     * Initializes the board by assigning all array elements the value of '-'
     * @param board the array representing the tic-tac-toe board
     */
    public static void initializeBoard(char board[]) {
        for (int i = 0; i < 9; i++) {
        		board[i] = '-';
        }
    }
    
    /**
     * Capitalizes the x or o entered by a player
     * Ignores already capitalized X and O
     * @param character the x or o
     * @return the capitalized X or O
     */
    public static char capitalize(String character) {
    	
        return character.toUpperCase().charAt(0);
    }
    
    /**
     * Prints the board to the console in the form of a grid,
     * including column and row numbers. Also prints
     * Tic-Tac-Toe Board above the board. For example:
     * Tic-Tac-Toe:
     *   1 2 3
     * 1 O - - 
     * 2 - X - 
     * 3 - - -
     * @param board the array representing the tic-tac-toe board
     */
    public static void printBoard(char board[]) {
        System.out.print("\nTic-Tac-Toe:\n ");
        System.out.print(" ");
        
        for (int i = 1; i <= 3; i++) {
        	System.out.print(i + " ");
        }
        System.out.println();
        
        for (int i = 0; i < 3; i++) {
        	for (int j = 0; j < 3; j++) {
        		if (j == 0) {
        			System.out.print((i + 1) + " ");
        		}
        		System.out.print(board[i*3+j] + " ");
        	}
        	System.out.println();
        }
    }
    
    /**
     * Converts the player choice of row and column
     * in the form of RC into the correct index of 
     * the board array.
     * Hint: Use integer division by 10 to extract the row
     * Hint: Use modulus by 10 to extract the column
     * @param rowCol the row and column, e.g. 12 or 33
     * @return the correct index of the array that 
     * corresponds to the row and column
     */
    public static int convertToIndex(int rowCol) {
    	int row = rowCol / 10;
    	int col = rowCol % 10;
    	int index = (row - 1) * 3 + (col - 1);
        return index;
    }
    
    /**
     * Determines whether a particular position 
     * on the board has already been taken.
     * @param board the array representing the game board
     * @param position the position to check
     * @return whether that position has already been taken
     */
    public static boolean alreadyTaken(char board[], int position) {
    	if (board[position] != '-') {
    		return true;
    	}
        return false;
    }
    
    /**
     * Places an X or O into the correct position on the board.
     * Called when either the player or computer makes its move.
     * @param board the array representing the tic-tac-toe board
     * @param position the position in the array at which to place the X or O
     * @param character either X or O
     */
    public static void makePlacement(char board[], int position, char character) {
        board[position] = character;
    }
    
    /**
     * Gives a random position on the board
     * Used for generating moves by the computer
     * @param size the length of the board array
     * @return a random index in the board array
     */
    public static int randomPosition(int size) {
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(size);
        
    }
    
    /**
     * Determines whether three characters are all Xs or all Os
     * Used as a helper method to the gameOver method
     * @param a the first character to compare, either X, O, or -
     * @param b the second character to compare, either X, O, or -
     * @param c the third character to compare, either X, O or -
     * @return whether the characters are all Xs or all Os
     */
    public static boolean threeInRow(char a, char b, char c) {
    	if (a == b && b == c) {
    		return true;
    	}
        return false;
    }
    
    /**
     * Determines whether the game is over 
     * due to one player winning, using
     * a series of if statements.
     * Calls the threeInRow method for each
     * possible row on the board.
     * @param board the tic-tac-toe game board
     * @return whether the game is over
     */
    public static boolean gameOverWinner(char board[]) {
    	char player = 'O';
    	if (threeInRow(board[0], board[1], board[2]) && board[2] == player || 
    		threeInRow(board[3], board[4], board[5]) && board[5] == player || 
    		threeInRow(board[6], board[7], board[8]) && board[8] == player) {
    		
    		return true;
    		
    	} if (threeInRow(board[0], board[3], board[6]) && board[6] == player || 
        	  threeInRow(board[1], board[4], board[7]) && board[7] == player || 
        	  threeInRow(board[2], board[5], board[8]) && board[8] == player) {
    		
        		return true;
        		
        }  if (threeInRow(board[0], board[4], board[8]) && board[8] == player || 
          	   threeInRow(board[2], board[4], board[6]) && board[6] == player) {
      		
          		return true;
          		
          	}
        
        player = 'X';
    	if (threeInRow(board[0], board[1], board[2]) && board[2] == player || 
    		threeInRow(board[3], board[4], board[5]) && board[5] == player || 
    		threeInRow(board[6], board[7], board[8]) && board[8] == player) {
    		
    		return true;
    		
    	} if (threeInRow(board[0], board[3], board[6]) && board[6] == player || 
        	  threeInRow(board[1], board[4], board[7]) && board[7] == player || 
        	  threeInRow(board[2], board[5], board[8]) && board[8] == player) {
    		
        		return true;
        		
        }  if (threeInRow(board[0], board[4], board[8]) && board[8] == player || 
          	   threeInRow(board[2], board[4], board[6]) && board[6] == player) {
      		
          		return true;
          		
          	}
        
        return false;
    }
    
    /**
     * Check if user or computer has two in the row
     * @param player of user or computer
     * @param board to check the placements
     * @return computer makes a placement randomly
     */
    public static boolean checkRowWin(char player, char board[]) {
    	
    		if (board[0] == player && board[1] == player || board[0] == player && board[2] == player ||
    				board[1] == player && board[2] == player) {
    			return true;
    		} else if (board[3] == player && board[4] == player || board[3] == player && board[5] == player ||
    				board[4] == player && board[5] == player) {
    			return true;
    		} else if (board[6] == player && board[7] == player || board[6] == player && board[8] == player ||
    				board[7] == player && board[8] == player) {
    			return true;
    		}
    	
    	return false;
    }
    
    /**
     * Check if user or computer has two in the column
     * @param player of user or computer
     * @param board to check the placements
     * @return computer makes a placement randomly
     */
    public static boolean checkColWin(char player, char board[]) {
    	
    	if (board[0] == player && board[6] == player || board[0] == player && board[3] == player ||
				board[3] == player && board[6] == player) {
			return true;
		} else if (board[1] == player && board[4] == player || board[1] == player && board[7] == player ||
				board[4] == player && board[7] == player) {
			return true;
		} else if (board[2] == player && board[5] == player || board[5] == player && board[8] == player ||
				board[2] == player && board[8] == player) {
			return true;
		}
	
	return false;
    }
    
    /**
     * Check if user or computer has two in the diagonal
     * @param player of user or computer
     * @param board to check the placements
     * @return computer makes a placement randomly
     */
    public static boolean checkDiaWin(char player, char board[]) {
    	
    	if (board[0] == player && board[4] == player || board[0] == player && board[8] == player ||
				board[4] == player && board[8] == player) {
			return true;
		} else if (board[2] == player && board[4] == player || board[4] == player && board[6] == player ||
				board[2] == player && board[6] == player) {
			return true;
		} 
	
	return false;
    }
    
    /**
     * Against if user has two in the row, column, or diagonal
     * @param board to check the placements
     * @param player1 user's movements
     * @param player2 computer's movements
     */
    public static void againstUser(char board[], char player1, char player2, int move) {
    	
    		if (board[0] == player1 && board[1] == player1 && !alreadyTaken(board, 2) ||
    				board[5] == player1 && board[8] == player1 && !alreadyTaken(board, 2) ||
    				board[4] == player1 && board[6] == player1 && !alreadyTaken(board, 2) ) {
    			board[2] = player2;
    		} else if (board[0] == player1 && board[2] == player1 && !alreadyTaken(board, 1) ||
    				board[4] == player1 && board[7] == player1 && !alreadyTaken(board, 1)) {
    			board[1] = player2;
    		} else if (board[1] == player1 && board[2] == player1 && !alreadyTaken(board, 0) ||
    				board[3] == player1 && board[6] == player1 && !alreadyTaken(board, 0) ||
    				board[4] == player1 && board[8] == player1 && !alreadyTaken(board, 0)) {
    			board[0] = player2;
    		} else if (board[3] == player1 && board[4] == player1 && !alreadyTaken(board, 5) ||
    				board[2] == player1 && board[8] == player1 && !alreadyTaken(board, 5)) {
    			board[5] = player2;
    		} else if (board[3] == player1 && board[5] == player1 && !alreadyTaken(board, 4) || 
    				board[1] == player1 && board[7] == player1 && !alreadyTaken(board, 4) ||
    				board[0] == player1 && board[8] == player1 && !alreadyTaken(board, 4) ||
    				board[2] == player1 && board[6] == player1 && !alreadyTaken(board, 4)) {
    			board[4] = player2;
    		} else if (board[4] == player1 && board[5] == player1 && !alreadyTaken(board, 3) ||
    				board[0] == player1 && board[6] == player1 && !alreadyTaken(board, 3)) {
    			board[3] = player2;
    		} else if (board[6] == player1 && board[7] == player1 && !alreadyTaken(board, 8) ||
    				board[2] == player1 && board[5] == player1 && !alreadyTaken(board, 8) ||
    				board[0] == player1 && board[4] == player1 && !alreadyTaken(board, 8)) {
    			board[8] = player2;
    		} else if (board[6] == player1 && board[8] == player1 && !alreadyTaken(board, 7) ||
    				board[1] == player1 && board[4] == player1 && !alreadyTaken(board, 7)) {
    			board[7] = player2;
    		} else if (board[7] == player1 && board[8] == player1 && !alreadyTaken(board, 6) ||
    				board[0] == player1 && board[3] == player1 && !alreadyTaken(board, 6) ||
    				board[2] == player1 && board[4] == player1 && !alreadyTaken(board, 6)) {
    			board[6] = player2;
    		} else {
    			makePlacement(board, move, player2);
    		}
    }
    
    /**
     * When computer has two in the row, it will make a placement to win the game
     * @param board to read the computer's 'X' or 'O'
     * @param player is computer's movements
     */
    public static void aiWin(char board[], char player, int move) {
    	if (board[0] == player && board[1] == player && !alreadyTaken(board, 2) || board[5] == player && board[8] == player && !alreadyTaken(board, 2) ||
				board[4] == player && board[6] == player && !alreadyTaken(board, 2)) {
			board[2] = player;
		} else if (board[0] == player && board[2] == player && !alreadyTaken(board, 1) || board[4] == player && board[7] == player && !alreadyTaken(board, 1) ) {
			board[1] = player;
		} else if (board[1] == player && board[2] == player && !alreadyTaken(board, 0) || board[3] == player && board[6] == player && !alreadyTaken(board, 0) ||
				board[4] == player && board[8] == player && !alreadyTaken(board, 0)) {
			board[0] = player;
		} else if (board[3] == player && board[4] == player && !alreadyTaken(board, 5) || board[2] == player && board[8] == player && !alreadyTaken(board, 5)) {
			board[5] = player;
		} else if (board[3] == player && board[5] == player && !alreadyTaken(board, 4) || board[1] == player && board[7] == player && !alreadyTaken(board, 4) ||
				board[0] == player && board[8] == player && !alreadyTaken(board, 4) || board[2] == player && board[6] == player && !alreadyTaken(board, 4)) {
			board[4] = player;
		} else if (board[4] == player && board[5] == player && !alreadyTaken(board, 3) || board[0] == player && board[6] == player && !alreadyTaken(board, 3)) {
			board[3] = player;
		} else if (board[6] == player && board[7] == player && !alreadyTaken(board, 8) || board[2] == player && board[5] == player && !alreadyTaken(board, 8) ||
				board[0] == player && board[4] == player && alreadyTaken(board, 8)) {
			board[8] = player;
		} else if (board[6] == player && board[8] == player && !alreadyTaken(board, 7) || board[1] == player && board[4] == player && !alreadyTaken(board, 7)) {
			board[7] = player;
		} else if (board[7] == player && board[8] == player && !alreadyTaken(board, 6) || board[0] == player && board[3] == player && !alreadyTaken(board, 6) ||
				board[2] == player && board[4] == player && !alreadyTaken(board, 6)) {
			board[6] = player;
		} else {
			makePlacement(board, move, player);
		}
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe!");
        char board[] = new char[9];
        char user, ai;
        
        System.out.print("Would you like to play as X or O: ");
        Scanner ans = new Scanner(System.in);
        char input = capitalize(ans.nextLine());
        
        if (input == 'X') {
        	user = 'X';
        	ai = 'O';
        } else {
        	user = 'O';
        	ai = 'X';
        }
        
        System.out.print("Would you like to play first (Y/N): ");
        Scanner ans2 = new Scanner(System.in);
        String input2 = ans2.next();
        
        initializeBoard(board);
        printBoard(board);
        Scanner number = new Scanner(System.in);
        
        int move;
        int numMoves = 0; //increments when player or game A.I. makes a move
        
        if (input2.equalsIgnoreCase("Y")) {
        while (true) {
        	while (true) {
        	
        	System.out.print("\nPlease enter your move: ");
        	move = number.nextInt();
        	move = convertToIndex(move);
        	
        	if (!alreadyTaken(board, move)) {
        		break;
        	} else {
        		System.out.println("That spot is already taken!");
        	}
        	}
   
        	makePlacement(board, move, user);
        	printBoard(board);
        	numMoves++;
        	
        	if (gameOverWinner(board)){
        		System.out.println("\n" + user + " Wins!!!");
        		break;
        		} else if (numMoves == 9 && !gameOverWinner(board)) {
    			System.out.println("\nIt's a tie!");
    			break;
    		}
        	
        	System.out.println("\nCounter move!");
        	
        	while(true){
        		move = randomPosition(9);
        		if (!alreadyTaken(board, move)) {
        			break;
        		} 
        	}
        	
        	if (checkRowWin(user, board) || checkColWin(user, board) ||
            		checkDiaWin(user, board) || checkRowWin(user, board) && checkColWin(user, board) ||
    				checkRowWin(user, board) && checkDiaWin(user, board) ||
    				checkColWin(user, board) && checkDiaWin(user, board)) {
    			againstUser(board, user, ai, move);
        		
        	} else if (checkRowWin(ai, board) || checkColWin(ai, board) || checkDiaWin(ai, board)) {
        		aiWin(board, ai, move);
    			
        	} else {
        		makePlacement(board, move, ai);
        		
        	}
        	
            	printBoard(board);
            	numMoves++;
            	if(gameOverWinner(board)){
            		System.out.println("\n" + ai + " Wins!!!");
            		break;
            		} else if (numMoves == 9 && !gameOverWinner(board)) {
            			System.out.println("\nIt's a tie!");
            			break;
            		}
        	}
        }
        
        if (input2.equalsIgnoreCase("N")) {
        	while (true) {
        		System.out.println("\nCounter move!");
            	
            	while(true){
            		move = randomPosition(9);
            		if (!alreadyTaken(board, move)) {
            			break;
            		} 
            	}
            	
            	if (checkRowWin(user, board) || checkColWin(user, board) ||
                		checkDiaWin(user, board) || checkRowWin(user, board) && checkColWin(user, board) ||
        				checkRowWin(user, board) && checkDiaWin(user, board) ||
        				checkColWin(user, board) && checkDiaWin(user, board)) {
        			againstUser(board, user, ai, move);
            		
            	} else if (checkRowWin(ai, board) || checkColWin(ai, board) || checkDiaWin(ai, board)) {
            		aiWin(board, ai, move);
        			
            	} else {
            		makePlacement(board, move, ai);
            		
            	}
            	
                	printBoard(board);
                	numMoves++;
                	if(gameOverWinner(board)){
                		System.out.println("\n" + ai + " Wins!!!");
                		break;
                		} else if (numMoves == 9 && !gameOverWinner(board)) {
                			System.out.println("\nIt's a tie!");
                			break;
                		}
                	
                	while (true) {
                    	
                    	System.out.print("\nPlease enter your move: ");
                    	move = number.nextInt();
                    	move = convertToIndex(move);
                    	
                    	if (!alreadyTaken(board, move)) {
                    		break;
                    	} else {
                    		System.out.println("That spot is already taken!");
                    	}
                    	}
               
                    	makePlacement(board, move, user);
                    	printBoard(board);
                    	numMoves++;
                    	if (gameOverWinner(board)){
                    		System.out.println("\n" + user + " Wins!!!");
                    		break;
                    		} else if (numMoves == 9 && !gameOverWinner(board)) {
                			System.out.println("\nIt's a tie!");
                			break;
                		}
        	}
        	
        }
        System.out.println("\n***Game Over***");
        ans.close();
        number.close();
    }
}
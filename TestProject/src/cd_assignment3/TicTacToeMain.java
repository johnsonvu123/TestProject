package cd_assignment3;

import java.util.Scanner;

public class TicTacToeMain {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		//Computer vs Computer - results in a tie
		TicTacToe game=new TicTacToe();
		for(int i=0;i<9;i++) {
			if(i%2==0) { //checks if it is player one's turn
				System.out.println("Player One move:");
				game.bestMoveX(); //player one moves
			} else {
				System.out.println("Player Two move:");
				game.bestMoveO(); //player two moves
			}
			game.printBoard(game.current); //prints the board
		}
		//checks if any wins or ties
		if(game.winner(game.current)==1) {
			System.out.println("Player one wins!");
		} else if(game.winner(game.current)==-1) {
			System.out.println("Player two wins!");
		} else {
			System.out.println("Tie!");
		}
		
		//Player vs. Computer - may result in a tie or loss for player
		TicTacToe game2=new TicTacToe();
		for(int i=0;i<9;i++) {
			if(i%2==0) { //checks if it is player one's turn
				System.out.println("Player One move:");
				System.out.println("Choose Row:");
				int a=scan.nextInt();
				if(a>2||a<0) { //if row is invalid, goes to do while loop
					do {
						System.out.println("Invalid Row, Please Try Again: ");
						a=scan.nextInt();
					}while(a>2||a<0);
				}
				System.out.println("Choose Column:");
				int b=scan.nextInt();
				if(b>2||b<0) { //if column is invalid, goes to do while loop
					do {
						System.out.println("Invalid Column, Please Try Again: ");
						b=scan.nextInt();
					}while(b>2||b<0);
				}
				game2.putMark(game2.current, a, b, game2.x); //marks X
				if(game2.winner(game2.current)==1||game2.winner(game2.current)==-1) { //checks for any wins
					game2.printBoard(game2.current);
					break;
				}
			} else {
				System.out.println("Player Two move:");
				game2.bestMoveO(); //player two moves
				if(game2.winner(game2.current)==1||game2.winner(game2.current)==-1) { //checks for any wins
					game2.printBoard(game2.current);
					break;
				}
			}
			game2.printBoard(game2.current);
		}
		if(game2.winner(game2.current)==1) {
			System.out.println("Player one wins!");
		} else if(game2.winner(game2.current)==-1) {
			System.out.println("Player two wins!");
		} else {
			System.out.println("Tie!");
		}

	}

}

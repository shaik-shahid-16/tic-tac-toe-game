package tic_tac_toe.main;

import tic_tac_toe.models.Player;
import tic_tac_toe.services.GameService;
import tic_tac_toe.exceptions.*;
import java.util.Scanner;

public class TicTacToeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Tic Tac Toe Game ---");
        System.out.print("Enter Player 1 Name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Player 2 Name: ");
        String name2 = scanner.nextLine();

        Player p1 = new Player(name1, 'X');
        Player p2 = new Player(name2, 'O');
        GameService game = new GameService(p1, p2);

        while (!game.isGameOver()) {
            Player current = game.getCurrentPlayer();
            System.out.println(current.getName() + " (" + current.getSymbol() + "), enter your move (row[0-2] and column[0-2]): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            try {
                game.makeMove(row, col);
            } catch (InvalidMoveException | GameAlreadyOverException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
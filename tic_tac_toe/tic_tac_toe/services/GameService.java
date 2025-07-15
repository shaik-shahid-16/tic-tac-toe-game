package tic_tac_toe.services;

import tic_tac_toe.models.Board;
import tic_tac_toe.models.Player;
import tic_tac_toe.exceptions.*;

public class GameService {
    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private boolean isGameOver;

    public GameService(Player p1, Player p2) {
        this.board = new Board();
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = p1;
        this.isGameOver = false;
    }

    public void makeMove(int row, int col) throws InvalidMoveException, GameAlreadyOverException {
        if (isGameOver) throw new GameAlreadyOverException("Game is already over.");
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || !board.isCellEmpty(row, col)) {
            throw new InvalidMoveException("Invalid move. Cell is occupied or out of bounds.");
        }
        board.placeMove(row, col, currentPlayer.getSymbol());
        board.display();

        if (board.checkWin(currentPlayer.getSymbol())) {
            System.out.println("Player " + currentPlayer.getName() + " wins!");
            isGameOver = true;
        } else if (board.isFull()) {
            System.out.println("It's a draw!");
            isGameOver = true;
        } else {
            switchPlayer();
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
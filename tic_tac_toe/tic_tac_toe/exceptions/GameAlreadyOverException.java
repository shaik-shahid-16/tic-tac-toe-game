package tic_tac_toe.exceptions;

public class GameAlreadyOverException extends Exception {
    public GameAlreadyOverException(String message) {
        super(message);
    }
}
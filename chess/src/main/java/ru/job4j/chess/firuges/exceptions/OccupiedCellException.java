package ru.job4j.chess.firuges.exceptions;

public class OccupiedCellException extends Exception {
    public OccupiedCellException(String msg) {
        super(msg);
    }
}
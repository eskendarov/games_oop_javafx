package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exceptions.FigureNotFoundException;
import ru.job4j.chess.firuges.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.exceptions.OccupiedCellException;

import java.util.Arrays;
public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        if (isFree(steps)) {
            figures[index] = figures[index].copy(dest);
            return true;
        }
        return false;
    }

    private boolean isFree(Cell[] steps) throws OccupiedCellException {
        for (Figure figure : figures) {
            if (figure != null && figure.position().equals(steps[steps.length - 1])) {
                throw new OccupiedCellException("Could not move to occupied cell");
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException("Figure not found");
    }
}
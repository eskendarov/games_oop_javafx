package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.exceptions.FigureNotFoundException;
import ru.job4j.chess.firuges.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.exceptions.OccupiedCellException;

public class LogicTest {
    private final Logic logic = new Logic();

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C2, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMove() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.C7);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenOccupiedCell() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.H6));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test()
    public void whenMove() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        logic.add(new BishopBlack(Cell.C1));
        Assert.assertTrue(logic.move(Cell.C1, Cell.H6));
    }
}
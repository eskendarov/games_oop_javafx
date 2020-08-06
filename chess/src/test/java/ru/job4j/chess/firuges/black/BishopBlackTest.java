package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void position() {
        Figure bbk = new BishopBlack(Cell.A1);
        Cell exp = Cell.A1;
        Assert.assertThat(bbk.position(), is(exp));
    }

    @Test
    public void way() throws ImpossibleMoveException {
        Figure bbk = new BishopBlack(Cell.C1);
        Cell[] exp = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertThat(bbk.way(Cell.G5), is(exp));
    }

    @Test
    public void copy() {
        Figure bbk = new BishopBlack(Cell.B2);
        Cell exp = Cell.G5;
        bbk = bbk.copy(Cell.G5);
        Assert.assertThat(bbk.position(), is(exp));
    }
}
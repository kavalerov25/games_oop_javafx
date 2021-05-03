package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.position(), is(Cell.A1));
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.copy(Cell.A3).position(), is(Cell.A3));
    }

    @Test
    public void testWay() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] array = bishopBlack.way(Cell.G5);
        Cell[] box = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(array, is(box));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWrongWay() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] array = bishopBlack.way(Cell.G7);
    }

    @Test
    public void testisDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean flag = bishopBlack.isDiagonal(bishopBlack.position(), Cell.G5);
        assertThat(flag, is(true));
    }
}
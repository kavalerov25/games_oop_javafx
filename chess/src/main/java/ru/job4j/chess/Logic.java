package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    public final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null)
                System.out.println(figures[i].position());
        }
        //System.out.println(steps.length);
        if (!free(steps)){
            throw new OccupiedCellException();
        };
        figures[index] = figures[index].copy(dest);
    }


    private boolean free(Cell[] steps) throws OccupiedCellException {
        System.out.println("figures.length = " + figures.length);
        System.out.println("steps.length = " + steps.length);
        for (int i = 0; i < figures.length; i++) {
            for (int j = 0; j < steps.length; j++) {
                if (figures[i] != null) {
                    System.out.println("i = " + i + " j = " + j);
                    if (figures[i].position().getX() == steps[j].getX() &&
                            figures[i].position().getY() == steps[j].getY()) {
                        return false;
                    }
                }
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
        throw new FigureNotFoundException();
    }
}

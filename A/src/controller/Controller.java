package controller;

import model.Grid;
import model.GridImpl;
import view.Gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public final class Controller extends Observable {
    private static boolean run;
    private static Timer timer;
    Toolkit toolkit;

    private static Grid grid = new GridImpl();

    public void startButton() {
        run = true;
        this.setChanged();
        this.notifyObservers();
    }

    public void stopButton() {
        run = false;
        this.setChanged();
        this.notifyObservers();
    }

    public void shapeComboBox() {


        /*
        for (Shape sh : shapes.getShapeCollection()) {
            if (token.matches(sh.getName())) {
                if (gol.getColumns() < sh.getShapeColumns()
                        || gol.getRows() < sh.getShapeRows()) {
                    error("The shape you tried to load does not "
                            + "fit on the grid! Please resize using "
                            + "the command: 'r "
                            + (sh.getShapeColumns() + 1) + " "
                            + (sh.getShapeRows() + 1) + "'");
                    return;
                }
                for (int[] coords : sh.getCoordinates()) {
                    int gameX = (gol.getColumns() - sh.getShapeColumns())
                            / 2 + coords[0];
                    int gameY = (gol.getRows() - sh.getShapeRows())
                            / 2 + coords[1];
                    gol.setAlive(gameX, gameY, true);
                }
                return;
            }
         */
        this.setChanged();
        this.notifyObservers();
    }

    public void threadComboBox() {
        this.setChanged();
        this.notifyObservers();
    }

    public void sizeComboBox() {
        this.setChanged();
        this.notifyObservers();
    }




    private class Run extends TimerTask {
        public Run() {
        }

        @Override
        public void run() {
            grid.next();
        }
    }
}
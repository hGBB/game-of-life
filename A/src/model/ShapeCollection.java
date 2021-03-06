package model;

import java.util.LinkedList;

/**
 * This class holds a collection of all model.Shape which can be used in the game.
 */
public class ShapeCollection {
    private LinkedList<Shape> shapeCollection;

    /**
     * The Getter method of the shape collection.
     *
     * @return A collection of model.Shape
     */
    public LinkedList<Shape> getShapeCollection() {
        return shapeCollection;
    }

    /**
     * This constructor creates a list of shapes with an unique name and
     * a unique array of coordinates of which each shape is made from.
     */
    public ShapeCollection() {
        shapeCollection = new LinkedList<>();
        int[][] block = {{0, 0}, {1, 0}, {0, 1}, {1, 1}};
        this.shapeCollection.add(new Shape("Block", block, 2, 2));
        int[][] boat = {{0, 0}, {1, 0}, {0, 1}, {2, 1}, {1, 2}};
        shapeCollection.add(new Shape("Boat", boat, 3, 3));
        int[][] blinker = {{0, 0}, {1, 0}, {2, 0}};
        shapeCollection.add(new Shape("Blinker", blinker, 3, 1));
        int[][] toad = {{1, 0}, {2, 0}, {3, 0}, {0, 1}, {1, 1}, {2, 1}};
        shapeCollection.add(new Shape("Toad", toad, 4, 2));
        int[][] glider = {{0, 0}, {1, 0}, {2, 0}, {0, 1}, {1, 2}};
        shapeCollection.add(new Shape("Glider", glider, 3, 3));
        int[][] spaceship = {{1, 0}, {4, 0}, {0, 1}, {0, 2},
                {4, 2}, {0, 3}, {1, 3}, {2, 3}, {3, 3}};
        shapeCollection.add(new Shape("Spaceship", spaceship, 5, 4));
        int[][] pulsar = {
                // upper half
                {2, 0}, {3, 0}, {9, 0}, {10, 0},
                {3, 1}, {4, 1}, {8, 1}, {9, 1},
                {0, 2}, {3, 2}, {5, 2}, {7, 2}, {9, 2}, {12, 2},
                {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 3},
                {7, 3}, {8, 3}, {10, 3}, {11, 3}, {12, 3},
                {1, 4}, {3, 4}, {5, 4}, {7, 4}, {9, 4}, {11, 4},
                {2, 5}, {3, 5}, {4, 5}, {8, 5}, {9, 5}, {10, 5},
                // bottom half
                {2, 7}, {3, 7}, {4, 7}, {8, 7}, {9, 7}, {10, 7},
                {1, 8}, {3, 8}, {5, 8}, {7, 8}, {9, 8}, {11, 8},
                {0, 9}, {1, 9}, {2, 9}, {4, 9}, {5, 9},
                {7, 9}, {8, 9}, {10, 9}, {11, 9}, {12, 9},
                {0, 10}, {3, 10}, {5, 10}, {7, 10}, {9, 10}, {12, 10},
                {3, 11}, {4, 11}, {8, 11}, {9, 11},
                {2, 12}, {3, 12}, {9, 12}, {10, 12}
        };
        shapeCollection.add(new Shape("Pulsar", pulsar, 13, 13));
        // some more shapes
        int[][] bipole = {{0, 0}, {1, 0}, {0, 1}, {3, 2}, {2, 3}, {3, 3}};
        shapeCollection.add(new Shape("Bipole", bipole, 3, 3));
        int[][] tripole = {{0, 0}, {1, 0}, {0, 1}, {2, 1},
                {2, 3}, {4, 3}, {3, 4}, {4, 4}};
        shapeCollection.add(new Shape("Tripole", tripole, 4, 4));
        int[][] rPentomino = {{1, 0}, {2, 0}, {0, 1}, {1, 1}, {1, 2}};
        shapeCollection.add(new Shape("r-Pentomino", rPentomino, 2, 2));
    }
}

import java.util.Collection;

public class ShapeCollection {

    private Collection<Shapes2> shapesCollection;

    private ShapeCollection() {
        int[][] block = {{0, 0}, {1, 0}, {1, 0}, {1, 1}};
        shapesCollection.add(new Shapes2("BLOCK", block));
        int[][] boat = {{0, 0}, {1, 0}, {0, 1}, {2, 1}, {1, 2}};
        shapesCollection.add(new Shapes2("BOAT", boat));
        int[][] blinker = {{0, 0}, {1, 0}, {2, 0}};
        shapesCollection.add(new Shapes2("BLINKER", blinker));
        int[][] toad = {{1, 0}, {2, 0}, {3, 0}, {0, 1}, {1, 1}, {2, 1}};
        shapesCollection.add(new Shapes2("TOAD", toad));
        int[][] glider = {{0, 0}, {1, 0}, {2, 0}, {0, 1}, {1, 2}};
        shapesCollection.add(new Shapes2("GLIDER", glider));
        int[][] spaceship = {{1, 0}, {4, 0}, {0, 1}, {0, 2}, {4, 2}, {0, 3}, {1, 3}, {2, 3}, {3, 3}};
        shapesCollection.add(new Shapes2("SPACESHIP", spaceship));
        int[][] pulsar = {
                //upper half
                {2, 0}, {3, 0}, {9, 0}, {10, 0},
                {3, 1}, {4, 1}, {8, 1}, {9, 1},
                {0, 2}, {3, 2}, {5, 2}, {7, 2}, {9, 2}, {12, 2},
                {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 3},
                {7, 3}, {8, 3}, {10, 3}, {11, 3}, {12, 3},
                {1, 4}, {3, 4}, {5, 4}, {7, 4}, {9, 4}, {11, 4},
                {3, 5}, {4, 5}, {6, 5}, {8, 5}, {9, 5}, {10, 5},
                //bottom half
                {2, 7}, {3, 7}, {4, 7}, {9, 7}, {10, 7}, {11, 7},
                {1, 8}, {3, 8}, {5, 8}, {7, 8}, {9, 8}, {11, 8},
                {0, 9}, {1, 9}, {2, 9}, {4, 9}, {5, 9},
                {7, 9}, {8, 9}, {10, 9}, {11, 9}, {12, 9},
                {0, 10}, {3, 10}, {5, 10}, {7, 10}, {9, 10}, {11, 10},
                {3, 11}, {4, 11}, {8, 11}, {9, 11},
                {2, 12}, {3, 12}, {9, 12}, {10, 12}
        };
        shapesCollection.add(new Shapes2("PULSAR", spaceship));
    }
}
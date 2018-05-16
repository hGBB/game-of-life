import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Shell {
    private Shell() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin
                = new BufferedReader(new InputStreamReader(System.in));
        execute(stdin);
    }

    private static void execute(BufferedReader stdin) throws IOException {
        boolean quit = false;
        int xAxis;
        int yAxis;
        GridImpl gol = null;
        ShapeCollection shapeCollection = new ShapeCollection();
        while (!quit) {
            System.out.println("gol> ");
            String input = stdin.readLine();
            if (input == null) {
                break;
            }
            String[] tokens = input.trim().split("\\s+");
            if (checkInput(tokens)) {

                switch (input.toLowerCase().charAt(0)) {
                    case 'n':
                        xAxis = Integer.parseInt(tokens[1]);
                        yAxis = Integer.parseInt(tokens[2]);
                        if (noNegativeGridSize(xAxis, yAxis)) {
                            gol = new GridImpl(xAxis, yAxis);
                        }
                        break;
                    case 'a':
                        if (initialized(gol)) {
                            xAxis = Integer.parseInt(tokens[1]);
                            yAxis = Integer.parseInt(tokens[2]);
                            if (chosenInputIsOnGrid(gol, xAxis, yAxis)) {
                                if (!gol.isAlive(xAxis, yAxis)) {
                                    gol.setAlive(xAxis, yAxis, true);
                                }
                            }
                        }
                        break;
                    case 'd':
                        if (initialized(gol)) {
                            xAxis = Integer.parseInt(tokens[1]);
                            yAxis = Integer.parseInt(tokens[2]);
                            if (chosenInputIsOnGrid(gol, xAxis, yAxis)) {
                                if (gol.isAlive(xAxis, yAxis)) {
                                    gol.setAlive(xAxis, yAxis, false);
                                }
                            }
                        }
                        break;
                    case 'g':
                        if (initialized(gol)) {
                            gol.next();
                            System.out.println("Generation: "
                                    + gol.getGenerations());
                        }
                        break;
                    case 'p':
                        if (initialized(gol)) {
                            System.out.println(gol.toString());
                        }
                        break;
                    case 'c':
                        if (initialized(gol)) {
                            gol.clear();
                        }
                        break;
                    case 'r':
                        xAxis = Integer.parseInt(tokens[1]);
                        yAxis = Integer.parseInt(tokens[2]);
                        if (initialized(gol)) {
                            if (noNegativeGridSize(xAxis, yAxis)) {
                                gol.resize(xAxis, yAxis);
                            }
                        }
                        break;
                    case 's':
                        if (initialized(gol)) {
                            gol.clear();
                            callShape(gol, tokens[1], shapeCollection);
                            // TODO WIP!
                        }
                        break;
                    case 'h':
                        // TODO: write help
                        break;
                    case 'q':
                        quit = true;
                        break;
                    default:
                        error("Not a valid command!");
                }


            }
        }
    }

    private static boolean checkInput(String[] tokens) {
        if (tokens.equals("")) {
            error("No command detected please insert Input or try 'Help'"
                    + "for additional information how to use this program.");
        } else if (tokens.length > 3 || tokens.length == 0) {
            error("Input has not the correct syntax. Try 'Help'.");
            return false;
        } else if (tokens.length == 3
                && (!tokens[0].substring(0, 1).matches("[nadrNADR]")
                || notANumber(tokens[1]) || notANumber(tokens[2]))) {
            error("Input has not the correct syntax. Command + number"
                    + " + number expected.");
            return false;
        } else if (tokens.length == 2
                && (!tokens[0].substring(0, 1).matches("[sS]"))) {
            error("Input has not the correct syntax. Command "
                    + "+ number expected.");
            return false;
        } else if (tokens.length == 1
                && !tokens[0].substring(0, 1).matches("[gpchqGPCHQ]")) {
            error("Input has not the correct syntax. Command expected.");
            return false;
        }
        return true;
    }

    private static boolean notANumber(String number) {
        try {
            //noinspection ResultOfMethodCallIgnored
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private static boolean initialized(GridImpl grid) {
        if (grid != null) {
            return true;
        } else {
            error("Grid hasn't been initialized yet! Try 'NEW + number "
                    + "+ number' to create a grid.");
            return false;
        }
    }

    private static boolean chosenInputIsOnGrid(Grid grid, int col, int row) {
        if (grid.getColumns() > col && grid.getRows() > row
                && col >= 0 && row >= 0) {
            return true;
        } else {
            error("The chosen Cell is out of bounds! Stay on the grid "
                    + "colums = " + grid.getColumns() + " and rows = "
                    + grid.getRows());
            return false;
        }
    }

    private static boolean noNegativeGridSize(int col, int row) {
        if (col >= 0 && row >= 0) {
            return true;
        } else {
            error("It is not possible to create a grid with negative "
                    + "numbers!");
            return false;
        }
    }

    private static void callShape(GridImpl gol, String token,
                                  ShapeCollection shapes) {
        for (Shapes2 sh : shapes.getShapesCollection()) {
            if (token.matches(sh.getName())) {
                if (gol.getColumns() < sh.shapeColums || gol.getRows() < sh.shapeRows) {
                    error("The shape you tried to load does not fit on the grid! Please resize using the command: 'r " +
                            (sh.shapeColums + 1) + " " + (sh.shapeRows + 1) + "'");
                    return;
                }
                for (int[] coords : sh.getCoordinates()) {
                    gol.setAlive(coords[0], coords[1], true);
                }
                return;
            }
        }
        error("The shape " + token + " is not in the collection! "
                + "Try Help for a list of valid shapes");
    }

    private static void error(String msg) {
        System.out.println("Error! " + msg);
    }
}

package view;

import controller.Controller;
import model.GridImpl;
import view.components.Grid;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Gui extends JFrame implements Observer {
    private int size;
    public JPanel contentPane;
    private JButton startButton;
    private JButton stopButton;
    private model.Grid gameOfLife;
    private SetPanelSize setPanelSize = new SetPanelSize();
    private SetShape setShape = new SetShape();
    private SetThreadSpeed setThreadSpeed = new SetThreadSpeed();
    private JPanel gridJPanel;
    private List<GridCell> cells;
    private Controller controller;

    @Override
    public void update(Observable o, Object arg) {

    }

    public Gui(Grid grid) {
        this.gameOfLife = grid;
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        contentPane.add(panel);


        this.addMenu();
        this.addGrid(20);


        controller = new Controller();
        controller.addObserver(this);

    }

    private void addMenu() {
        JPanel menu = new JPanel();
        contentPane.add(menu, BorderLayout.SOUTH);
        // add the combobox.
        String[] shapes = {"Clear", "Block", "Boat", "Blinker", "Toad", "Glider", "Spaceship", "Pulsar", "Bipole", "Tripole", "r-Pentomino"};
        JComboBox shapeComboBox = new JComboBox(shapes);
        shapeComboBox.setSelectedIndex(0);
        shapeComboBox.addActionListener(setShape);
        menu.add(shapeComboBox);
        // add start button
        JButton start = new JButton("Start");
        menu.add(start);
        // add stop button
        JButton stop = new JButton("Stop");
        menu.add(stop);
        // add size label
        JLabel dropownSize = new JLabel("Size:");
        menu.add(dropownSize);
        // add size comboBox.
        String[] size = {"Small", "Medium", "Large"};
        JComboBox sizeComboBox = new JComboBox(size);
        sizeComboBox.setSelectedIndex(1);
        menu.add(sizeComboBox);
        // add thread label
        JLabel dropdownThread = new JLabel("Thread:");
        menu.add(dropdownThread);
        // add thread comboBox.
        String[] thread = {"slow", "normal", "fast"};
        JComboBox threadComboBox = new JComboBox(thread);
        threadComboBox.setSelectedIndex(1);
        threadComboBox.addActionListener(setThreadSpeed);
        menu.add(threadComboBox);
    }

    private void addGrid(int size) {
        int height = gameOfLife.getRows();
        int width = gameOfLife.getColumns();
        gridJPanel = new JPanel();
        cells = new ArrayList<>();
        gridJPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                GridCell addCell = new GridCell(gameOfLife.isAlive(j, i));
                constraints.gridy = i;
                constraints.gridx = j;
                Border border = new MatteBorder(1, 1, (i == height - 1 ? 1 : 0), (j == width - 1 ? 1 : 0), Color.BLACK);
                addCell.setBorder(border);
                addCell.setSize(size);
                gridJPanel.add(addCell, constraints);
                cells.add(addCell);
            }
        }
        contentPane.add(gridJPanel, BorderLayout.CENTER);
    }

    public class SetShape implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> cb = (JComboBox<String>) e.getSource();
            assert cb.getSelectedItem() != null;
            if (cb.getSelectedItem().equals("Clear")) {
                gameOfLife.clear();
            } else {
                controller.shapeComboBox(cb.getSelectedItem().toString());
            }
        }
    }


    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Game of Life");

        frame.setContentPane(new Gui().contentPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(100, 100, 600, 400);
        frame.setMinimumSize(new Dimension(450, 200));
        frame.setVisible(true);
        //      Gui gui = new Gui();
        //      gui.setVisible(true);

    }


}

package bubble_shooter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 * a class to display the panel of settings and scores on the right
 * and handle the settings of the game
 * @author Barni
 *
 */
public class SettingsPanel extends JPanel {

    private MainFrame mainFrame;
    private JLabel scoreLabel;
    private JPanel lowerPanel;
    private JSpinner rowsSpinner;
    private JSpinner colorSpinner;
    private JButton newGameButton;
    private JButton stopGameButton;

    /**
     * constructor, initiates the panel and sets the parameter
     * as its mainframe
     * @param m mainframe to be set
     */
    public SettingsPanel(MainFrame m){
        setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.darkGray));
        setLayout(new BorderLayout());
        mainFrame = m;
    }

    /**
     * initiates the components of the panel and sets the look
     * and the actionlisteners
     */
    public void initComponents(){
       
        scoreLabel = new JLabel("0", SwingConstants.RIGHT);
        scoreLabel.setBackground(Color.pink);
        scoreLabel.setText("SCORE :");
        scoreLabel.setOpaque(true);
        scoreLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        scoreLabel.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X-Constants.FIELD_SIZE_X-5,50));
        scoreLabel.setFont(new Font(scoreLabel.getFont()
                .getName(), Font.PLAIN, 34));

        lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));

        JPanel rowsPanel = new JPanel();
        rowsPanel.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X-Constants.FIELD_SIZE_X-5,50));
        rowsPanel.setLayout(new BorderLayout());
        
        SpinnerModel rowsModel = new SpinnerNumberModel(7, 3, 15, 1);
        rowsSpinner = new JSpinner(rowsModel);

        JLabel rowsLabel = new JLabel("Initial rows :");

        rowsLabel.setBackground(Color.cyan);
        rowsLabel.setForeground(Color.BLACK);
        rowsLabel.setOpaque(true);
        rowsLabel.setFont(new Font("Courier",Font.BOLD, 14));
        rowsLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        rowsPanel.add(rowsLabel, BorderLayout.WEST);
        rowsPanel.add(rowsSpinner, BorderLayout.EAST);
        rowsPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X-Constants.FIELD_SIZE_X-5,50));
        colorPanel.setLayout(new BorderLayout());
        
        SpinnerModel colorModel = new SpinnerNumberModel(4, 3, 8, 1);
        colorSpinner = new JSpinner(colorModel);
        
        JLabel colorLabel = new JLabel("Initial colors :");
        colorLabel.setFont(new Font("Courier",Font.BOLD,14));
        colorLabel.setBackground(Color.cyan);
        colorLabel.setOpaque(true);
        colorLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        
        
        colorPanel.add(colorLabel, BorderLayout.WEST);
        colorPanel.add(colorSpinner, BorderLayout.EAST);
        colorPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        JPanel buttonPanel = new JPanel();
        newGameButton = new JButton("New game");
        newGameButton.setActionCommand("NEWGAME");
        newGameButton.addActionListener(mainFrame);
        newGameButton.setBackground(Color.GREEN);
        newGameButton.setForeground(Color.BLACK);
        newGameButton.setOpaque(true);

        stopGameButton = new JButton("Stop game");
        stopGameButton.setActionCommand("STOP GAME");
        stopGameButton.addActionListener(mainFrame);
        stopGameButton.setBackground(Color.RED);
        stopGameButton.setForeground(Color.RED);
        stopGameButton.setOpaque(true);
        buttonPanel.add(newGameButton);
        buttonPanel.add(stopGameButton);

        lowerPanel.add(rowsPanel);
        lowerPanel.add(colorPanel);
        lowerPanel.add(buttonPanel);
        
        JPanel spaceholder = new JPanel();
        spaceholder.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X-Constants.FIELD_SIZE_X-5,340));
        lowerPanel.add(spaceholder);
        add(scoreLabel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.CENTER);
    }

    /**
     * updates the score in the score counter field
     * @param score the score to be set
     */
    public void updateScore(long score){
        scoreLabel.setText((new Long(score).toString()));
    }

    /**
     * returns the selected number of rows
     * @return the selected number of rows on the spinner
     */
    public int getRow(){
        return (int) rowsSpinner.getValue();
    }

    /**
     * returns the selected number of colors
     * @return the selected number of colors on the spinner
     */
    public int getColor(){
        return (int) colorSpinner.getValue();
    }

}

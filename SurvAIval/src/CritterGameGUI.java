import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CritterGameGUI extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CritterGameGUI frame = new CritterGameGUI(10,10);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CritterGameGUI(int width, int height) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1005, 625);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel mainPanel = new JPanel();
        contentPane.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(new GridBagLayout());

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBounds(0, 0, 200, 600);
        mainPanel.add(optionsPanel);

        optionsPanel.setLayout(new GridLayout(10,1));

        JButton btnNewButton = new JButton("New button");
        optionsPanel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("New button");
        optionsPanel.add(btnNewButton_1);

        JSlider slider = new JSlider();
        optionsPanel.add(slider);

        JSlider slider_1 = new JSlider();
        optionsPanel.add(slider_1);

        JSlider slider_2 = new JSlider();
        optionsPanel.add(slider_2);

        JSlider slider_3 = new JSlider();
        optionsPanel.add(slider_3);

        JSlider slider_4 = new JSlider();
        optionsPanel.add(slider_4);

        JPanel mapPanel = new JPanel();
        mapPanel.setBounds(205, 0, 800, 600);
        mainPanel.add(mapPanel);
        mapPanel.setLayout(new GridLayout(width, height, 0, 0));


        ImageIcon dirt = new ImageIcon("SurvAIval/Assets/dirt.png");
        ImageIcon boulder = new ImageIcon("SurvAIval/Assets/boulder.png");
        ImageIcon tree = new ImageIcon("SurvAIval/Assets/tree.png");
        ImageIcon water = new ImageIcon("SurvAIval/Assets/water.png");
        ImageIcon critter = new ImageIcon("SurvAIval/Assets/critter.png");
        ImageIcon food = new ImageIcon("SurvAIval/Assets/food.png");


        TileMap tileMap = new TileMap(width,height,5,1,1,1);

        int size = width * height;
        int index = -1;

        for(int i = 0; i < size; i++) {
            index += height;
            if(index > size) {
                index %= size;
                index--;
            }
            if (tileMap.getTile(i).getType() == "dirt") {
                mapPanel.add(new JLabel(dirt));
            }else if (tileMap.getTile(i).getType() == "boulder") {
                mapPanel.add(new JLabel(boulder));
            }else if (tileMap.getTile(i).getType() == "tree") {
                mapPanel.add(new JLabel(tree));
            }else if (tileMap.getTile(i).getType() == "water") {
                mapPanel.add(new JLabel(water));
            }
        }


    }

}

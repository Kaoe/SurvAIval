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

        optionsPanel.setLayout(new GridLayout(13,1));

        JButton runsSimulationButton = new JButton("Run Simulation");
        JPanel runsSimulationPanel = new JPanel();
        runsSimulationPanel.add(runsSimulationButton);
        optionsPanel.add(runsSimulationPanel);

        JPanel panelCritterCount = new JPanel();
        optionsPanel.add(panelCritterCount);
        panelCritterCount.setLayout(new GridLayout(1,2));

        JLabel critterCountLabel = new JLabel("Critter Count:");
        panelCritterCount.add(critterCountLabel);

        JSlider critterSlider = new JSlider(0,20);
        panelCritterCount.add(critterSlider);

        JPanel panelFoodCount = new JPanel();
        optionsPanel.add(panelFoodCount);
        panelFoodCount.setLayout(new GridLayout(1,2));

        JLabel foodCountLabel = new JLabel("Food Count:");
        panelFoodCount.add(foodCountLabel);

        JSlider foodSlider = new JSlider(0,20);
        panelFoodCount.add(foodSlider);

        JLabel weightsLabel = new JLabel("Weights");
        weightsLabel.setHorizontalAlignment(JLabel.CENTER);
        weightsLabel.setVerticalAlignment(JLabel.CENTER);
        optionsPanel.add(weightsLabel);

        JPanel panelTreeWeight = new JPanel();
        optionsPanel.add(panelTreeWeight);
        panelTreeWeight.setLayout(new GridLayout(1,2));

        JLabel treeWeightLabel = new JLabel("Tree Weight:");
        panelTreeWeight.add(treeWeightLabel);

        JSlider treeSlider = new JSlider(0,1);
        panelTreeWeight.add(treeSlider);

        JPanel panelWaterWeight = new JPanel();
        optionsPanel.add(panelWaterWeight);
        panelWaterWeight.setLayout(new GridLayout(1,2));

        JLabel waterWeightLabel = new JLabel("Water Weight:");
        panelWaterWeight.add(waterWeightLabel);

        JSlider waterSlider = new JSlider(0,1);
        panelWaterWeight.add(waterSlider);

        JPanel panelBoulderWeight = new JPanel();
        optionsPanel.add(panelBoulderWeight);
        panelBoulderWeight.setLayout(new GridLayout(1,2));

        JLabel boulderWeightLabel = new JLabel("Boulder Weight:");
        panelBoulderWeight.add(boulderWeightLabel);

        JSlider boulderSlider = new JSlider(0,1);
        panelBoulderWeight.add(boulderSlider);

        JPanel panelDirtWeight = new JPanel();
        optionsPanel.add(panelTreeWeight);
        panelDirtWeight.setLayout(new GridLayout(1,2));

        JLabel dirtWeightLabel = new JLabel("Dirt Weight:");
        panelDirtWeight.add(dirtWeightLabel);

        JSlider dirtSlider = new JSlider(0,1);
        panelDirtWeight.add(dirtSlider);

        JPanel panelMapSize = new JPanel();
        optionsPanel.add(panelMapSize);
        panelMapSize.setLayout(new GridLayout(1,2));

        JLabel mapSizeLabel = new JLabel("Map Size:");
        panelMapSize.add(mapSizeLabel);

        JSlider mapSizeSlider = new JSlider(10,100);
        panelMapSize.add(mapSizeSlider);

        JButton generateMapButton = new JButton("Generate Map");
        JPanel generateMapPanel = new JPanel();
        generateMapPanel.add(generateMapButton);
        optionsPanel.add(generateMapPanel);

        JPanel panelLoadPreset = new JPanel();
        optionsPanel.add(panelLoadPreset);
        panelLoadPreset.setLayout(new GridLayout(1,2));

        JButton loadPresetButton = new JButton("Load Preset");
        JPanel presetButtonPanel = new JPanel();
        presetButtonPanel.add(loadPresetButton);
        panelLoadPreset.add(presetButtonPanel);

        JComboBox presetComboBox = new JComboBox();
        panelLoadPreset.add(presetComboBox);

        JButton savePresetButton = new JButton("Save Preset");
        JPanel savePresetPanel = new JPanel();
        savePresetPanel.add(savePresetButton);
        optionsPanel.add(savePresetPanel);

        JPanel currentPresetPanel = new JPanel();
        optionsPanel.add(currentPresetPanel);

        JLabel currentPresetLabel = new JLabel("Current Preset:");
        currentPresetPanel.add(currentPresetLabel);

        JTextField currentPresetName = new JTextField("placeHolder");
        currentPresetPanel.add(currentPresetName);

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

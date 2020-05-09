import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CritterGameGUI extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CritterGameGUI frame = new CritterGameGUI();
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
    public CritterGameGUI() {
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
        panelCritterCount.setLayout(new GridLayout(1,3));

        JLabel critterCountLabel = new JLabel("Critter Count:");
        panelCritterCount.add(critterCountLabel);

        JSlider critterSlider = new JSlider(0,20,5);
        panelCritterCount.add(critterSlider);

        JLabel critterCount = new JLabel(String.valueOf(critterSlider.getValue()));
        panelCritterCount.add(critterCount);
        critterCount.setHorizontalAlignment(JLabel.LEFT);

        JPanel panelFoodCount = new JPanel();
        optionsPanel.add(panelFoodCount);
        panelFoodCount.setLayout(new GridLayout(1,3));

        JLabel foodCountLabel = new JLabel("Food Count:");
        panelFoodCount.add(foodCountLabel);

        JSlider foodSlider = new JSlider(0,20);
        panelFoodCount.add(foodSlider);

        JLabel foodCount = new JLabel(String.valueOf(foodSlider.getValue()));
        panelFoodCount.add(foodCount);
        foodCount.setHorizontalAlignment(JLabel.LEFT);

        JLabel weightsLabel = new JLabel("Weights");
        weightsLabel.setHorizontalAlignment(JLabel.CENTER);
        weightsLabel.setVerticalAlignment(JLabel.CENTER);
        optionsPanel.add(weightsLabel);

        JPanel panelTreeWeight = new JPanel();
        optionsPanel.add(panelTreeWeight);
        panelTreeWeight.setLayout(new GridLayout(1,3));

        JLabel treeWeightLabel = new JLabel("Tree Weight:");
        panelTreeWeight.add(treeWeightLabel);

        JSlider treeSlider = new JSlider(0,100,25);
        panelTreeWeight.add(treeSlider);

        JLabel treeWeight = new JLabel(String.valueOf((double)treeSlider.getValue()/100));
        panelTreeWeight.add(treeWeight);
        treeWeight.setHorizontalAlignment(JLabel.LEFT);

        JPanel panelWaterWeight = new JPanel();
        optionsPanel.add(panelWaterWeight);
        panelWaterWeight.setLayout(new GridLayout(1,3));

        JLabel waterWeightLabel = new JLabel("Water Weight:");
        panelWaterWeight.add(waterWeightLabel);

        JSlider waterSlider = new JSlider(0,100,25);
        panelWaterWeight.add(waterSlider);

        JLabel waterWeight = new JLabel(String.valueOf(String.valueOf((double)waterSlider.getValue()/100)));
        panelWaterWeight.add(waterWeight);
        waterWeight.setHorizontalAlignment(JLabel.LEFT);

        JPanel panelBoulderWeight = new JPanel();
        optionsPanel.add(panelBoulderWeight);
        panelBoulderWeight.setLayout(new GridLayout(1,3));

        JLabel boulderWeightLabel = new JLabel("Boulder Weight:");
        panelBoulderWeight.add(boulderWeightLabel);

        JSlider boulderSlider = new JSlider(0,100,25);
        panelBoulderWeight.add(boulderSlider);

        JLabel boulderWeight = new JLabel(String.valueOf(String.valueOf((double)boulderSlider.getValue()/100)));
        panelBoulderWeight.add(boulderWeight);
        boulderWeight.setHorizontalAlignment(JLabel.LEFT);

        JPanel panelDirtWeight = new JPanel();
        optionsPanel.add(panelDirtWeight);
        panelDirtWeight.setLayout(new GridLayout(1,3));

        JLabel dirtWeightLabel = new JLabel("Dirt Weight:");
        panelDirtWeight.add(dirtWeightLabel);

        JSlider dirtSlider = new JSlider(0,100, 50);
        panelDirtWeight.add(dirtSlider);

        JLabel dirtWeight = new JLabel(String.valueOf(String.valueOf((double)dirtSlider.getValue()/100)));
        panelDirtWeight.add(dirtWeight);
        dirtWeight.setHorizontalAlignment(JLabel.LEFT);

        JPanel panelMapSize = new JPanel();
        optionsPanel.add(panelMapSize);
        panelMapSize.setLayout(new GridLayout(1,3));

        JLabel mapSizeLabel = new JLabel("Map Size:");
        panelMapSize.add(mapSizeLabel);

        JSlider mapSizeSlider = new JSlider(10,50,10);
        panelMapSize.add(mapSizeSlider);

        JLabel mapSize = new JLabel(String.valueOf(mapSizeSlider.getValue()) + "x" + String.valueOf(mapSizeSlider.getValue()));
        panelMapSize.add(mapSize);
        mapSize.setHorizontalAlignment(JLabel.LEFT);

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
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(presetComboBox);
        panelLoadPreset.add(comboBoxPanel);

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

        mapPanel.setLayout(new GridLayout(mapSizeSlider.getValue(), mapSizeSlider.getValue(), 0, 0));
        TileMap tileMap = new TileMap(mapSizeSlider.getValue(),mapSizeSlider.getValue(),1,0,0,0);
        mapPanel.setLayout(new GridLayout(mapSizeSlider.getValue(), mapSizeSlider.getValue(), 0, 0));

        ImageIcon dirt = new ImageIcon("SurvAIval/Assets/dirt.png");
        ImageIcon boulder = new ImageIcon("SurvAIval/Assets/boulder.png");
        ImageIcon tree = new ImageIcon("SurvAIval/Assets/tree.png");
        ImageIcon water = new ImageIcon("SurvAIval/Assets/water.png");
        ImageIcon critter = new ImageIcon("SurvAIval/Assets/critter.png");
        ImageIcon food = new ImageIcon("SurvAIval/Assets/food.png");
        ImageIcon white = new ImageIcon("SurvAIval/Assets/white.png");

        for(int i = 0; i < tileMap.getSize(); i++) {
            mapPanel.add(new JLabel(white));
        }


        runsSimulationButton.addActionListener(new ActionListener() {		//ACTION LISTENERS
            @Override
            public void actionPerformed(ActionEvent e) {
                //  TODO: add what happens when a simulation is ran.
            }
        });

        generateMapButton.addActionListener(new ActionListener() {		//ACTION LISTENERS
            @Override
            public void actionPerformed(ActionEvent e) {
                mapPanel.removeAll();
                TileMap tileMap = new TileMap(mapSizeSlider.getValue(),mapSizeSlider.getValue(),dirtSlider.getValue(),
                                                boulderSlider.getValue(),waterSlider.getValue(),treeSlider.getValue());
                int size = mapSizeSlider.getValue() * mapSizeSlider.getValue();
                int index = -1;

                for(int i = 0; i < size; i++) {
                    index += mapSizeSlider.getValue();  //  Increment by height of the map
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

                mapPanel.setLayout(new GridLayout(mapSizeSlider.getValue(), mapSizeSlider.getValue(), 0, 0));
                mapPanel.repaint();
            }
        });

        critterSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateSlider(critterSlider,critterCount);
            }
        });

        foodSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateSlider(foodSlider,foodCount);
            }
        });

        treeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateSliderDouble(treeSlider,treeWeight);
            }
        });

        waterSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateSliderDouble(waterSlider,waterWeight);
            }
        });

        boulderSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateSliderDouble(boulderSlider,boulderWeight);
            }
        });

        dirtSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateSliderDouble(dirtSlider,dirtWeight);
            }
        });

        mapSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                mapSize.setText(String.valueOf(mapSizeSlider.getValue()) + "x" + String.valueOf(mapSizeSlider.getValue()));
            }
        });















    }

    public static void updateSliderDouble(JSlider jSlider, JLabel jLabel) {
        jLabel.setText(String.valueOf((double)jSlider.getValue()/100));
    }

    public static void updateSlider(JSlider jSlider, JLabel jLabel) {
        jLabel.setText(String.valueOf(jSlider.getValue()));
    }


}

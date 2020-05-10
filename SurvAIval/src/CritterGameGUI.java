import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
        EventQueue.invokeLater(() -> {
            try {
                CritterGameGUI frame = new CritterGameGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
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
        GridBagConstraints optionsConstraints = new GridBagConstraints();
        optionsConstraints.ipadx = 200;
        optionsConstraints.weightx = 1;
        GridBagLayout mainLayout = new GridBagLayout();
        JPanel optionsPanel = new JPanel();
        mainLayout.setConstraints(optionsPanel,optionsConstraints);
        mainPanel.setLayout(mainLayout);


        optionsPanel.setBounds(0, 0, 200, 600);
        mainPanel.add(optionsPanel);
        optionsPanel.setLayout(new GridLayout(13,1));
//        optionsPanel.setMinimumSize(new Dimension(200,600));

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

        JLabel waterWeight = new JLabel(String.valueOf((double) waterSlider.getValue() / 100));
        panelWaterWeight.add(waterWeight);
        waterWeight.setHorizontalAlignment(JLabel.LEFT);

        JPanel panelBoulderWeight = new JPanel();
        optionsPanel.add(panelBoulderWeight);
        panelBoulderWeight.setLayout(new GridLayout(1,3));

        JLabel boulderWeightLabel = new JLabel("Boulder Weight:");
        panelBoulderWeight.add(boulderWeightLabel);

        JSlider boulderSlider = new JSlider(0,100,25);
        panelBoulderWeight.add(boulderSlider);

        JLabel boulderWeight = new JLabel(String.valueOf((double) boulderSlider.getValue() / 100));
        panelBoulderWeight.add(boulderWeight);
        boulderWeight.setHorizontalAlignment(JLabel.LEFT);

        JPanel panelDirtWeight = new JPanel();
        optionsPanel.add(panelDirtWeight);
        panelDirtWeight.setLayout(new GridLayout(1,3));

        JLabel dirtWeightLabel = new JLabel("Dirt Weight:");
        panelDirtWeight.add(dirtWeightLabel);

        JSlider dirtSlider = new JSlider(0,100, 75);
        panelDirtWeight.add(dirtSlider);

        JLabel dirtWeight = new JLabel(String.valueOf((double) dirtSlider.getValue() / 100));
        panelDirtWeight.add(dirtWeight);
        dirtWeight.setHorizontalAlignment(JLabel.LEFT);

        JPanel panelMapSize = new JPanel();
        optionsPanel.add(panelMapSize);
        panelMapSize.setLayout(new GridLayout(1,3));

        JLabel mapSizeLabel = new JLabel("Map Size:");
        panelMapSize.add(mapSizeLabel);

        JSlider mapSizeSlider = new JSlider(10,50,10);
        panelMapSize.add(mapSizeSlider);

        JLabel mapSize = new JLabel(mapSizeSlider.getValue() + "x" + mapSizeSlider.getValue());
        panelMapSize.add(mapSize);
        mapSize.setHorizontalAlignment(JLabel.LEFT);

        JButton generateMapButton = new JButton("Generate Map");
        JPanel generateMapPanel = new JPanel();
        generateMapPanel.add(generateMapButton);
        optionsPanel.add(generateMapPanel);

        //  UI for preset Map Configurations, they don't currently do anything right now.

//        JPanel panelLoadPreset = new JPanel();
//        optionsPanel.add(panelLoadPreset);
//        panelLoadPreset.setLayout(new GridLayout(1,2));
//
//        JButton loadPresetButton = new JButton("Load Preset");
//        JPanel presetButtonPanel = new JPanel();
//        presetButtonPanel.add(loadPresetButton);
//        panelLoadPreset.add(presetButtonPanel);
//
//        JComboBox presetComboBox = new JComboBox();
//        JPanel comboBoxPanel = new JPanel();
//        comboBoxPanel.add(presetComboBox);
//        panelLoadPreset.add(comboBoxPanel);
//
//        JButton savePresetButton = new JButton("Save Preset");
//        JPanel savePresetPanel = new JPanel();
//        savePresetPanel.add(savePresetButton);
//        optionsPanel.add(savePresetPanel);
//
//        JPanel currentPresetPanel = new JPanel();
//        optionsPanel.add(currentPresetPanel);
//
//        JLabel currentPresetLabel = new JLabel("Current Preset:");
//        currentPresetPanel.add(currentPresetLabel);
//
//        JTextField currentPresetName = new JTextField("placeHolder");
//        currentPresetPanel.add(currentPresetName);

        JPanel mapPanel = new JPanel();
        mapPanel.setBounds(205, 0, 800, 600);
        mainPanel.add(mapPanel);
        GridBagConstraints mapConstraints = new GridBagConstraints();
        mainLayout.setConstraints(mapPanel,mapConstraints);
        mapConstraints.fill = GridBagConstraints.BOTH;




        mapPanel.setLayout(new GridLayout(mapSizeSlider.getValue(), mapSizeSlider.getValue(), 0, 0));
        TileMap clear = new TileMap(mapSizeSlider.getValue(),mapSizeSlider.getValue(),1,0,0,0);
        mapPanel.setLayout(new GridLayout(mapSizeSlider.getValue(), mapSizeSlider.getValue(), 0, 0));



        ImageIcon dirt = new ImageIcon("SurvAIval/Assets/dirt.png");
        ImageIcon boulder = new ImageIcon("SurvAIval/Assets/boulder.png");
        ImageIcon tree = new ImageIcon("SurvAIval/Assets/tree.png");
        ImageIcon water = new ImageIcon("SurvAIval/Assets/water.png");
        ImageIcon critter = new ImageIcon("SurvAIval/Assets/critter.png");
        ImageIcon food = new ImageIcon("SurvAIval/Assets/food.png");

        for(int i = 0; i < clear.getSize(); i++) {
            mapPanel.add(new JLabel(white));
        }

//        Thread thread = new Thread(() -> {
//            while(true) {
//                // call simulator
//            }
//        });


        //ACTION LISTENERS
        runsSimulationButton.addActionListener(e -> {


        });

        generateMapButton.addActionListener(e -> {
            mapPanel.removeAll();
            mapPanel.setLayout(new GridLayout(mapSizeSlider.getValue(), mapSizeSlider.getValue(), 0, 0));

            TileMap tileMap = new TileMap(mapSizeSlider.getValue(),mapSizeSlider.getValue(),dirtSlider.getValue(),
                                            boulderSlider.getValue(),waterSlider.getValue(),treeSlider.getValue());
            tileMap.populateMapWithFood(foodSlider.getValue());
            tileMap.populateMapWithCritters(critterSlider.getValue());
            int size = mapSizeSlider.getValue() * mapSizeSlider.getValue();
            int index = -1;

            for(int i = 0; i < size; i++) {
                index += mapSizeSlider.getValue();  //  Increment by height of the map
                if(index > size) {
                    index %= size;
                    index--;
                }


                mapPanel.add(new JPanel());
                ((JPanel)(mapPanel.getComponent(i))).add(new JLabel());


                switch (tileMap.getTile(i).getType()) {
                    case "dirt":
//                        ((JPanel)(mapPanel.getComponent(i))).setBorder(null);
                        ((JLabel)((JPanel)mapPanel.getComponent(i)).getComponent(0)).setIcon(new ImageIcon(new ImageIcon("SurvAIval/Assets/dirt.png").getImage().getScaledInstance(getHeight()/mapSizeSlider.getValue(),getHeight()/mapSizeSlider.getValue(), Image.SCALE_SMOOTH)));
                        break;
                    case "boulder":
//                        ((JPanel)(mapPanel.getComponent(i))).setBorder(null);
                        ((JLabel)((JPanel)mapPanel.getComponent(i)).getComponent(0)).setIcon(new ImageIcon(new ImageIcon("SurvAIval/Assets/boulder.png").getImage().getScaledInstance(getHeight()/mapSizeSlider.getValue(),getHeight()/mapSizeSlider.getValue(), Image.SCALE_SMOOTH)));
                        break;
                    case "tree":
//                        ((JPanel)(mapPanel.getComponent(i))).setBorder(null);
                        ((JLabel)((JPanel)mapPanel.getComponent(i)).getComponent(0)).setIcon(new ImageIcon(new ImageIcon("SurvAIval/Assets/tree.png").getImage().getScaledInstance(getHeight()/mapSizeSlider.getValue(),getHeight()/mapSizeSlider.getValue(), Image.SCALE_SMOOTH)));
                        break;
                    case "water":
//                        ((JPanel)(mapPanel.getComponent(i))).setBorder(null);
                        ((JLabel)((JPanel)mapPanel.getComponent(i)).getComponent(0)).setIcon(new ImageIcon(new ImageIcon("SurvAIval/Assets/water.png").getImage().getScaledInstance(getHeight()/mapSizeSlider.getValue(),getHeight()/mapSizeSlider.getValue(), Image.SCALE_SMOOTH)));
                        break;
                    case "food":
                        iconPath = "SurvAIval/Assets/food.png";
                        break;
                    case "critter":
                        iconPath = "SurvAIval/Assets/critter.png";
                        break;
                }
            }



            mapPanel.updateUI();
        });

        critterSlider.addChangeListener(e -> updateSlider(critterSlider,critterCount));

        foodSlider.addChangeListener(e -> updateSlider(foodSlider,foodCount));

        treeSlider.addChangeListener(e -> updateSliderDouble(treeSlider,treeWeight));

        waterSlider.addChangeListener(e -> updateSliderDouble(waterSlider,waterWeight));

        boulderSlider.addChangeListener(e -> updateSliderDouble(boulderSlider,boulderWeight));

        dirtSlider.addChangeListener(e -> updateSliderDouble(dirtSlider,dirtWeight));

        mapSizeSlider.addChangeListener(e -> mapSize.setText(mapSizeSlider.getValue() + "x" + mapSizeSlider.getValue()));

    }

    public JPanel updateImageScale(String iconPath, JSlider mapSizeSlider) {
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JLabel jLabel = new JLabel();
        jPanel.add(jLabel);

        ImageIcon imageIcon = new ImageIcon(iconPath);

        int width = getHeight() / mapSizeSlider.getValue();
        int height = getHeight() / mapSizeSlider.getValue();
        ImageIcon scaledIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

        jLabel.setIcon(scaledIcon);

        return jPanel;
    }

    public static void updateSliderDouble(JSlider jSlider, JLabel jLabel) {
        jLabel.setText(String.valueOf((double)jSlider.getValue()/100));
    }

    public static void updateSlider(JSlider jSlider, JLabel jLabel) {
        jLabel.setText(String.valueOf(jSlider.getValue()));
    }
}

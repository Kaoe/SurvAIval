import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSlider;

public class CritterGameGUI extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CritterGameGUI frame = new CritterGameGUI(20,20);
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
        setBounds(100, 100, 750, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel mainPanel = new JPanel();
        contentPane.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(null);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBounds(0, 0, 200, 600);
        mainPanel.add(optionsPanel);
        optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

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
        mapPanel.setLayout(new GridLayout(width, 0, height, 0));


        int size = width * height;
        int index = -1;

        for(int i = 0; i < size; i++) {
            index += height;
            if(index > size) {
                index %= size;
                index--;
            }
            mapPanel.add(new JButton("yar"));
        }


    }

}

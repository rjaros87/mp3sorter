package pl.radoslawjaros;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Mp3Sorter {
    private JButton playButton;
    private JTextField mp3Path;
    private JPanel panelMain;
    private Mp3Player mp3Player;

    public Mp3Sorter() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
//                    BufferedImage img = ImageIO.read(this.getClass().getResource("/background.png"));

                    JFrame frame = new JFrame("MP3 Sorter");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    frame.setContentPane(new JLabel(new ImageIcon(img)));

                    frame.setLayout(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.REMAINDER;

                    mp3Path = new JTextField();
                    mp3Path.setPreferredSize(new Dimension(318, 20));
                    frame.add(mp3Path, gbc);

                    playButton = new JButton();
                    BufferedImage playImgButton = ImageIO.read(this.getClass().getResource("/play.png"));
                    playButton.setIcon(new ImageIcon(playImgButton));
                    playButton.setFocusable(false);
                    playButton.setBorder(null);
                    playButton.setBorderPainted(false);
                    playButton.setFocusPainted(false);
                    playButton.setOpaque(false);
//                    playButton.setContentAreaFilled(false);
                    playButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String mp3source = mp3Path.getText();
                            mp3Player = new Mp3Player();
                            try {
                                mp3Player.play(mp3source);

                            } catch (FileNotFoundException ex) {
                                JOptionPane.showMessageDialog(frame, "Bad file!");
                            }
                        }
                    });
                    frame.add(playButton);
                    JSlider jSlider = new JSlider(JSlider.VERTICAL, 0,100, 85);
                    jSlider.setMajorTickSpacing(20);
                    jSlider.setMinorTickSpacing(5);
                    jSlider.setPaintLabels(true);
                    jSlider.setPaintTicks(true);

                    jSlider.addChangeListener(new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            mp3Player.setGain(jSlider.getValue()/100.0);
                        }
                    });

                    frame.add(jSlider);
                    frame.setResizable(false);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        new Mp3Sorter();
    }
}

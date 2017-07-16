package pl.radoslawjaros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

class JImageButton extends JComponent implements MouseListener {
    private BufferedImage img = null;

    public JImageButton(BufferedImage img) {
        this.img = img;
        setMinimumSize(new Dimension(img.getWidth(), img.getHeight()));
        setOpaque(false);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        int width = img.getWidth();
        g.setClip(new Ellipse2D.Float(0, 0, width, width));
        g.drawImage(img, 0, 0, width, width, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}

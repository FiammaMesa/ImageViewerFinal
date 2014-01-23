package imageviewer.UserInterface;

import imageviewer.Control.ActionListenerFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    
    private ActionListenerFactory factory;
    private int index = 0;
    private ImageViewer imageViewer;

    public ImageViewer getImageViewer() {
        return imageViewer;
    }

    public ApplicationFrame(ActionListenerFactory factory) throws HeadlessException {
        super("Image Viewer");
        this.factory = factory;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1024, 800);
        this.createComponents();
    }

    private void createComponents() {
        this.add(createToolbarPanel(), BorderLayout.NORTH);
        this.add(createImagePanel());
    }

    private JButton createPrevButton() {
        JButton button = new JButton("Previous Image");
        button.addActionListener(factory.createActionListener("Previous Image"));
        button.setBackground(Color.WHITE);
        return button;
    }

    private JButton createNextButton() {
        JButton button = new JButton("Next Image");
        button.addActionListener(factory.createActionListener("Next Image"));
        button.setBackground(Color.WHITE);
        return button;
    }
    
    private JPanel createImagePanel() {
        ImagePanel panel = new ImagePanel();
        this.imageViewer = panel;
        return panel;
    }

    private JPanel createToolbarPanel() {
        JPanel panel = new JPanel();
        panel.add(createPrevButton());
        panel.add(createNextButton());
        panel.setBackground(Color.BLACK);
        return panel;
    }

}
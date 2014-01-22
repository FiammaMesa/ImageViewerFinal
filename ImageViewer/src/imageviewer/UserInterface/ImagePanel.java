package imageviewer.UserInterface;

import imageviewer.Model.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements ImageViewer{
    
    private Image image;
    private int offset;//mirarakdk
    
    public void show (Image image){
        this.image = image;
        repaint();
    }
    
    public ImagePanel(){
        this.offset = 0;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }
    
    @Override
    public void paint(Graphics graphics){
        if (image == null) return;
        super.paint(graphics);
        graphics.drawImage(getBitmap(), offset, 0, null);
        if (offset == 0) return;
        if (offset < 0) graphics.drawImage(getBufferedImage((SwingBitmap) image.getNext().getBitmap()), image.getBitmap().getWidth() + offset, 0, null);
        if (offset > 0) graphics.drawImage(getBufferedImage((SwingBitmap) image.getPrev().getBitmap()), offset - image.getBitmap().getWidth(), 0, null);   
    }
    
    public BufferedImage getBitmap(){
        if (image.getBitmap() instanceof SwingBitmap)
            return getBufferedImage((SwingBitmap) image.getBitmap());
        return null;
    }
    
    public BufferedImage getBufferedImage (SwingBitmap swingBitmap){
        return swingBitmap.getBufferedImage();
    }
}

package imageviewer.UserInterface;

import imageviewer.Model.Bitmap;
import java.awt.image.BufferedImage;

public class SwingBitmap implements Bitmap {
    
    private final BufferedImage bufferedImage;
 
    public SwingBitmap(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    
    @Override
    public int getHeight(){
        return bufferedImage.getHeight();
    }
    
    public int getWidth(){
        return bufferedImage.getWidth();
    }
    
}
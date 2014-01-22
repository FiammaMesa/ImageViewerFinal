package imageviewer.Persistence;

import imageviewer.Model.Bitmap;
import imageviewer.Model.Image;
import imageviewer.Model.RealImage;
import imageviewer.UserInterface.SwingBitmap;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImageLoader {
    
    String filename;

    public ImageLoader(String filename) {
        this.filename = filename;
    }
    
    public Image load(){
        return new RealImage(loadBitmap());
    }
    
    public Bitmap loadBitmap(){
        return new SwingBitmap(loadBufferedImage());
    }

    private BufferedImage loadBufferedImage() {
        try {
            return ImageIO.read(new File(filename));
        } catch (IOException ex) {
            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

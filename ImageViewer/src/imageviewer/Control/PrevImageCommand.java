package imageviewer.Control;

import imageviewer.UserInterface.ImageViewer;
import java.awt.event.ActionEvent;

public class PrevImageCommand implements Command {
    
    private final ImageViewer viewer;

    public PrevImageCommand(ImageViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void execute() {
        this.viewer.setImage(this.viewer.getImage().getPrev());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
    
}

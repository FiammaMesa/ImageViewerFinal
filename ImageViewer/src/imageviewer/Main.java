package imageviewer;

import imageviewer.Control.ActionListenerFactory;
import imageviewer.Control.Command;
import imageviewer.Control.NextImageCommand;
import imageviewer.Control.PrevImageCommand;
import imageviewer.Model.Image;
import imageviewer.Persistence.ImageSetLoader;
import imageviewer.UserInterface.ApplicationFrame;
import imageviewer.UserInterface.ImagePanel;
import imageviewer.UserInterface.ImageViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main {

    public static void main(String[] args) {
        new Main().execute();
    }
    private String filename = "C:\\Users\\Fiamma\\Pictures\\ImageViewer";
    private ApplicationFrame frame;
    private Map<String, Command> commandMap;

    public void execute() {
        List<Image> images = new ImageSetLoader(filename).load();
        frame = createApplicationFrame();
        frame.getImageViewer().setImage(images.get(0));
        createCommands();
        frame.setVisible(true);
    }

    public ImageViewer createImageViewer(Image image){
        ImageViewer viewer = new ImagePanel();
        viewer.setImage(image);
        return viewer;
    }
    
    public void createCommands() {
        commandMap = new HashMap<>();
        commandMap.put("Previous Image", new PrevImageCommand(frame.getImageViewer()));
        commandMap.put("Next Image", new NextImageCommand(frame.getImageViewer()));
        
    }

    public ApplicationFrame createApplicationFrame() {
            return new ApplicationFrame(new ActionListenerFactory() {

                @Override
                public ActionListener createActionListener(final String action) {
                    return new ActionListener(){

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Command command = commandMap.get(action);
                            if (command == null) return;
                            command.execute();
                        }
                        
                    };
                }
                
            });
    }
    
}

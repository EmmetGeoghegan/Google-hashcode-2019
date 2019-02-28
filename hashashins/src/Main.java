import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager("./hashashins/input");

        for (InputFile inputFile : inputManager.getInputFiles()) {
            List<Photo> photos = inputFile.generatePhotos();
            SlideshowGenerator slideshowGenerator = new SlideshowGenerator(photos);
            slideshowGenerator.generateSlideshow();
            inputFile.writeOutputFile(slideshowGenerator.getOutputText());
        }
    }

}

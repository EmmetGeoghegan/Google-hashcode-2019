import java.util.List;

public class Main {

    private static final int FILE_BF_TIME_SECONDS = 30;

    public static void main(String[] args) {
        InputManager inputManager = new InputManager("./input");

        InputFile[] inputFiles = inputManager.getInputFiles();

        while (true) {
            for (int i = 1; i < inputFiles.length; i++) {
                if (i == 2) {
                    // skip example
                    continue;
                }

                long startTime = System.currentTimeMillis();

                while (true) {
                    List<Photo> photos = inputFiles[i].getPhotos();
                    SlideshowGenerator slideshowGenerator = new SlideshowGenerator(photos);
                    slideshowGenerator.generateSlideshow();

                    if (slideshowGenerator.getScore() > inputFiles[i].getBestScore()) {
                        inputFiles[i].setBestScore(slideshowGenerator.getScore());
                        inputFiles[i].writeOutputFile(slideshowGenerator.getOutputText());

                        System.out.printf("Found better score for file %s: %s%n",inputFiles[i].getFileName(), inputFiles[i].getBestScore());
                    }

                    if (System.currentTimeMillis() > startTime + (FILE_BF_TIME_SECONDS * 1000)) {
                        System.out.printf("Switching to input file %s.%n", inputFiles[(i + 1) % inputFiles.length].getFileName());
                        break;
                    }
                }
            }
        }
    }

}

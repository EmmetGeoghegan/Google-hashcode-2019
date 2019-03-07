import java.io.File;

public class InputManager {
    private InputFile[] inputFiles;

    public InputManager(String dirPath) {
        parseAll(dirPath);
    }

    private void parseAll(String dirPath) {
        File[] files = new File(dirPath).listFiles();
        inputFiles = new InputFile[files.length];

        for (int i = 0; i < files.length; i++) {
            inputFiles[i] = new InputFile(files[i]);
        }
    }

    public InputFile[] getInputFiles() {
        return inputFiles;
    }

    public InputFile getInputFileByName(String fileName) {
        for (InputFile inputFile : inputFiles) {
            if (inputFile.getFileName().equals(fileName)) {
                return inputFile;
            }
        }

        System.err.printf("Could not find input file %s. Exiting...%n", fileName);
        System.exit(1);
        return null;
    }

}

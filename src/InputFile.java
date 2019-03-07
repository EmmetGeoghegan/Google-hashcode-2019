import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputFile {
    private File file;
    private String fileName;
    private int numSlides;
    private boolean[] isHorizontal;
    private int numTags;
    private String[][] tags;
    private int bestScore = -1;
    private List<Photo> photos;

    public InputFile(File file) {
        this.file = file;
        fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
        parse(file);
    }

    private void parse(File file) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));

            numSlides = Integer.parseInt(in.readLine());
            isHorizontal = new boolean[numSlides];
            tags = new String[numSlides][];
            for (int i = 0; i < numSlides; i++) {
                String[] parts = in.readLine().split(" ");
                isHorizontal[i] = parts[0].equals("H");
                tags[i] = new String[Integer.parseInt(parts[1])];

                for (int j = 2; j < parts.length; j++) {
                    tags[i][j - 2] = parts[j];
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Num slides: %d%n%n", numSlides));

        for (int i = 0; i < numSlides; i++) {
            System.out.printf("Image %d%n", i);
            System.out.printf("Horizontal: %s%n", (isHorizontal[i] ? "Yes" : "No"));
            System.out.println("Tags:");
            for (String s : tags[i]) {
                System.out.printf("%s, ", s);
            }
            System.out.print("\n\n");
        }

        return sb.toString();
    }

    public String getFileName() {
        return fileName;
    }

    public List<Photo> getPhotos() {
        List<Photo> photos = new ArrayList<>(numSlides);

        for (int i = 0; i < numSlides; i++) {
            Photo photo = new Photo(i, isHorizontal[i], tags[i]);
            photos.add(photo);
        }

        return photos;
    }

    public void writeOutputFile(String output) {
        File outputPath = new File("./output/" + fileName + "_out.txt");

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputPath)));
            out.println(output);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
}

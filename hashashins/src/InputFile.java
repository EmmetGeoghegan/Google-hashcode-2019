import java.io.*;

public class InputFile {
    private String fileName;
    private int numSlides;
    private boolean[] isHorizontal;
    private int numTags;
    private String[][] tags;

    public InputFile(File file) {
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

}

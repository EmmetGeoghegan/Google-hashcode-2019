import java.util.ArrayList;
import java.util.List;

public class SlideshowGenerator {
    private List<Photo> photosAvailable;
    private List<Slide> slides;

    public SlideshowGenerator(List<Photo> photos) {
        this.photosAvailable = photos;

        slides = new ArrayList<>(photos.size());
    }

    public void generateSlideshow() {
        for (Photo photo : photosAvailable) {
            if (photo.isHorizontal()) slides.add(new Slide(photo, null));
        }
    }

    public String getOutputText() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%d%n", slides.size()));

        for (Slide s : slides) {
            output.append(s.getOutputEntry());
        }

        return output.toString();
    }

}

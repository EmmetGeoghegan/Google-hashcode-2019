import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public int getScore() {
        int score = 0;

        for (int i = 0; i < slides.size() - 1; i++) {
            int aTags = slides.get(i).getCombinedTags().size();
            int bTags = slides.get(i + 1).getCombinedTags().size();
            Set<String> intersection = new HashSet<>(slides.get(i).getCombinedTags());
            intersection.retainAll(slides.get(i + 1).getCombinedTags());

            int subscore = Math.min(aTags, bTags);
            subscore = Math.min(subscore, intersection.size());

            score += subscore;
        }

        return score;
    }

}

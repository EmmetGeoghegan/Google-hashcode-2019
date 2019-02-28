import java.util.*;

public class SlideshowGenerator {
    private List<Photo> photosAvailable;
    private List<Slide> slides;

    public SlideshowGenerator(List<Photo> photos) {
        this.photosAvailable = photos;

        slides = new ArrayList<>(photos.size());
    }

    public void generateSlideshow() {
        Random random = new Random();
        List<Photo> verticalsAvailable = new ArrayList<>();
        List<Slide> verticalSlides = new ArrayList<>(verticalsAvailable.size() / 2 + 5);
        List<Slide> horizSlides = new ArrayList<>();
        for (Photo photo : photosAvailable) {
            if (!photo.isHorizontal()) {
                verticalsAvailable.add(photo);
            }
            else {
                horizSlides.add(new Slide(photo, null));
            }
        }

        while (verticalsAvailable.size() >= 2) {
            Photo photoA = verticalsAvailable.remove(random.nextInt(verticalsAvailable.size()));
            Photo photoB = verticalsAvailable.remove(random.nextInt(verticalsAvailable.size()));

            verticalSlides.add(new Slide(photoA, photoB));
        }

        List<Slide> slidesAvailable = new ArrayList<>();
        slidesAvailable.addAll(horizSlides);
        slidesAvailable.addAll(verticalSlides);

        while (!slidesAvailable.isEmpty()) {
            slides.add(slidesAvailable.remove(random.nextInt(slidesAvailable.size())));
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

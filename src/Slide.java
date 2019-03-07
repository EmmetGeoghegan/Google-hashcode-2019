import java.util.HashSet;
import java.util.Set;

public class Slide {
    private Photo photoA;
    private Photo photoB;

    public Slide(Photo photoA, Photo photoB) {
        this.photoA = photoA;
        this.photoB = photoB;
    }

    public String getOutputEntry() {
        if (photoA != null && photoB != null) {
            return String.format("%d %d%n", photoA.getId(), photoB.getId());
        }
        else if (photoA != null) {
            return String.format("%d%n", photoA.getId());
        }
        else {
            return String.format("%d%n", photoB.getId());
        }
    }

    public Photo getPhotoA() {
        return photoA;
    }

    public Photo getPhotoB() {
        return photoB;
    }

    public Set<String> getCombinedTags() {
        Set<String> tags = new HashSet<>();

        if (photoA != null) {
            tags.addAll(photoA.getTags());
        }

        if (photoB != null) {
            tags.addAll(photoB.getTags());
        }

        return tags;
    }
}

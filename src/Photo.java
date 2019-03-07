import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Photo {
    private int id;
    private boolean isHorizontal;
    private Set tags;

    public Photo(int id, boolean isHorizontal, String[] tags) {
        this.id = id;
        this.isHorizontal = isHorizontal;
        this.tags = new HashSet(Arrays.asList(tags));
    }

    public int getId() {
        return id;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public Set getTags() {
        return tags;
    }
}

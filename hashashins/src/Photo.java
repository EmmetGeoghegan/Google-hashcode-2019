public class Photo {
    private int id;
    private boolean orientation;
    private String[] tags;

    public Photo(int id, boolean orientation, String[] tags) {
        this.id = id;
        this.orientation = orientation;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public boolean isOrientation() {
        return orientation;
    }

    public String[] getTags() {
        return tags;
    }
}

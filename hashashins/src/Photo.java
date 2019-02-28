public class Photo {
    private int id;
    private boolean isHorizontal;
    private String[] tags;

    public Photo(int id, boolean isHorizontal, String[] tags) {
        this.id = id;
        this.isHorizontal = isHorizontal;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public String[] getTags() {
        return tags;
    }
}

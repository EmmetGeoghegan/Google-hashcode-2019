public class Slide {
    private Photo photoA;
    private Photo photoB;

    public Slide(Photo photoA, Photo photoB) {
        this.photoA = photoA;
        this.photoB = photoB;
    }

    public String getOutputEntry() {
        return String.format("%d %d%n", photoA.getId(), photoB.getId());
    }
}

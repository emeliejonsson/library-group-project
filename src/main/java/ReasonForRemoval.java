public enum ReasonForRemoval {
    DAMAGED("Skadad"), LOST("Saknas"), OUTDATED("Gammal upplaga");

    private String description;

    ReasonForRemoval(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}

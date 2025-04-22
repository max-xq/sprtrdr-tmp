package mi.sprtrdrd.model;

public record Team(String name) {

    @Override
    public String toString() {
        return this.name;
    }
}

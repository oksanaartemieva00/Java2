public abstract class Obstacles {
    private String name;
    public Obstacles(String name){
        this.name=name;
    }
    protected abstract boolean moving(Actions actions);

    public String getName() {
        return name;
    }
}

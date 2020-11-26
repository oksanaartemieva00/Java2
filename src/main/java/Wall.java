public class Wall extends Obstacles {
    int wallHeight;
    public Wall(String name,int wallHeight){
        super(name);
        this.wallHeight=wallHeight;
    }
    public int getWallHeight(){
        return wallHeight;
    }
    @Override
    protected boolean moving(Actions actions){
        System.out.println("Высота стены = "+this.wallHeight);
        actions.run();
        if (getWallHeight() <= actions.getRunDistance()) {
            System.out.println(". Смог перепрыгнуть");
            return true;
        } else {
            System.out.println(". Врезался в стену");
            return false;
        }
    }
}

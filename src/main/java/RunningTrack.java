public class RunningTrack extends Obstacles {
    int roadLength;
    public RunningTrack(String name, int roadLength){
        super(name);
        this.roadLength=roadLength;
    }
    public int getRoadLength(){
        return roadLength;
    }
    @Override
    protected boolean moving(Actions actions){
        System.out.println("Длина беговой дорожки= "+this.roadLength);
        actions.run();
        if (getRoadLength() <= actions.getRunDistance()) {
            System.out.println(". Пробежал удачно");
            return true;
        } else {
            System.out.println(". Упал");
            return false;
        }
    }
}


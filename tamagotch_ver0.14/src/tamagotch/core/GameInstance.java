package src.tamagotch.core;

public class GameInstance {
    public final int WINFRAME_W = 1920;
    public final int WINFRAME_Y = 1080;
    public int gameFrameSizX = 600;
    public int gameFrameSizY = 600;
    //전역변수 관리
    //싱글톤 패턴
    //델리게게이트는 인스턴스를 상속받은 자식클레스로 생성전달
    private static GameInstance instance;
    private World world;
    private GameInstanceThread git;

    private GameInstance() {
    }

    public static GameInstance getInstance() {
        if (instance == null) {
            instance = new GameInstance();
        }
        return instance;
    }

    public void setWorld(World world){
        this.world = world;
        git = new GameInstanceThread(this.world, 60);
        git.setDaemon(true);
        git.start();
    }

    public World getWorld(){
        return world;
    }
}

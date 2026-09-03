package src.tamagotch.core;

public class GameInstance {
    //전역변수 관리
    //싱글톤 패턴
    //델리게게이트는 인스턴스를 상속받은 자식클레스로 생성전달
    private static GameInstance instance;
    private World world;

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
        GameInstanceThread git = new GameInstanceThread(this.world, 60);
        git.isDaemon();
        git.start();
    }
}

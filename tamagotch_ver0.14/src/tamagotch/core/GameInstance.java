package src.tamagotch.core;

import src.tamagotch.core.GameThread.GameAnimThread;
import src.tamagotch.core.GameThread.GameMainThread;

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
    private GameMainThread git;
    private GameAnimThread gat;

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
        git = new GameMainThread(this.world, 60);
        gat = new GameAnimThread(this.world, 12);
        //데몬등 스레드 설정을 생성자로 옮겼습니다.
    }

    public World getWorld(){
        return world;
    }
}

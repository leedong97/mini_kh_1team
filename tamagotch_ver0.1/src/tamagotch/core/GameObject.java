package src.tamagotch.core;

public abstract class GameObject {
    GameInstance gameinstance;
    World world;
    boolean isPendingKill;

    public GameObject(){
        //모든 오브젝트가 단하나의 Gameinstance를 바라보게 설정
        gameinstance = GameInstance.getInstance();
    }

    /**
     * 게임 실행 시 초기화
     * World 클레스에서 실행중
    */
    public abstract void beginPlay();
    /**
     * 게임 중 매 Tick(deltatime)실행
     * World 클레스에서 실행중
     */
    public abstract void update();

    public void setWorld(World world){
        this.world = world;
    }

    public void destory(){
        this.isPendingKill = true;
    }

    public boolean isPendingKill(){
        return isPendingKill;
    }
}

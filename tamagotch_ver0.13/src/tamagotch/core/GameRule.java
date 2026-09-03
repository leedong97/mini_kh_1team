package src.tamagotch.core;

public class GameRule {
    //
    protected World world;
    public GameRule(){
        this.world = GameInstance.getInstance().getWorld();
    }
}

package src.tamagotch.core;

public class GameInstanceThread extends Thread{
    private World world;
    private int fps;

    GameInstanceThread(World world, int fps){
        this.world = world;
        this.fps = fps;
    }

    @Override
    public void run() {
        while(true){
            try {
                sleep(1000/fps);
            } catch (Exception e) {
                // TODO: handle exception
            }
            world.updateWorld();
        }
    }
}

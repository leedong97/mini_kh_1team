package src.tamagotch.core.GameThread;

import src.tamagotch.core.World;

public class GameMainThread extends Thread{
    private World world;
    private int fps;

    public GameMainThread(World world, int fps){
        this.world = world;
        this.fps = fps;

        setDaemon(true);
        start();
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

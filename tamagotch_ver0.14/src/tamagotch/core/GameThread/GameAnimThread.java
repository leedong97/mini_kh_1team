package src.tamagotch.core.GameThread;

import src.tamagotch.core.World;

public class GameAnimThread extends Thread{
    private World world;
    private int frame;

    public GameAnimThread(World world, int frame){
        this.world = world;
        this.frame = frame;

        setDaemon(true);
        start();
    }
    @Override
    public void run() {
        while(true){
            try {
                sleep(1000/frame);
            } catch (Exception e) {
                // TODO: handle exception
            }
            world.updateAnim();
        }
    }
}

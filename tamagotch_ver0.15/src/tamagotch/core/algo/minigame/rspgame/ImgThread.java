package src.tamagotch.core.algo.minigame.rspgame;

import javax.swing.*;

public class ImgThread extends Thread {

    private JLabel rsp;
    private int random;
    private boolean b;

    public ImgThread(JLabel rsp) {
        this.rsp = rsp;
        b = true;
    }

    public void setRandom(int random){
        this.random = random;
    }

    @Override
    public void run() {

        ImageIcon cp = new ImageIcon("tamagotch_ver0.1/src/minigame/imgMinigame/cp.png");
        ImageIcon cr = new ImageIcon("tamagotch_ver0.1/src/minigame/imgMinigame/cr.png");
        ImageIcon cs = new ImageIcon("tamagotch_ver0.1/src/minigame/imgMinigame/cs.png");

        while (b) {
            
            rsp.setIcon(cp); 
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                
            }

            rsp.setIcon(cr); 
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
           
            rsp.setIcon(cs); 
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }

    }

    public void setBoolean(boolean b){
        this.b = b;
    }
}

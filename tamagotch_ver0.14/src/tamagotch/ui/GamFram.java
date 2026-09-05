package src.tamagotch.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.tamagotch.core.GameInstance;

public class GamFram extends JFrame{
    GameInstance gameinstance;
    
    public GamFram(){
        gameinstance = GameInstance.getInstance();
        
        //최초 타이틀생성
        //프레임 중앙정렬
        int sizX = gameinstance.gameFrameSizX;
        int sizY = gameinstance.gameFrameSizY;
        int startX = gameinstance.WINFRAME_W/2 - sizX/2;
        int startY = gameinstance.WINFRAME_Y/2 - sizY/2;

        setBounds(startX, startY, sizX, sizY);

        //타이틀 접근
        TitleWorld tw = new TitleWorld(this);        
        add(tw);

        //-----------------------
        //디버깅용
        ImageIcon[] move = new ImageIcon[12];
        for (int i = 0; i < move.length; i++){
            move[i] = new ImageIcon("src/tamagotch/img/Pet01/move/00" + String.format("%02d",i+1) + ".png");
        }

        JLabel lb = new JLabel();
        lb.setBounds(100, 100, 100, 100);
        tw.add(lb, 0);
        //-----------------------

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }   
        });

        
        setVisible(true);

        Thread tr = new Thread(){
            int fp = 0;
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(1000/12);
                        lb.setIcon(move[fp%12]);
                        fp ++;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        };

        tr.setDaemon(true);
        tr.start();
        //gw.add(Pat.test);
    }
}

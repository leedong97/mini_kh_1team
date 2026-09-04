package src.tamagotch.ui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import src.tamagotch.core.CVector2D;
import src.tamagotch.core.GameInstance;
import src.tamagotch.entity.Pet;

public class GamFram extends Frame{
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

        

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }   
        });

        // gw.add(Pat.test);
        setVisible(true);
    }
}

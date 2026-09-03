package src.tamagotch.ui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

        TitleWorld tw = new TitleWorld(this);        
        add(tw);
        
        //게임 시작 버튼 누르면 tw종료 후 아래gw생성

        //타이틀에서 선택하면 gw생성 후 초기화
        // GameWorld gw = new GameWorld();
        // add(gw);

        //gw에서 사용될 오브젝트 소환 예시
        //Pet pat = gw.spawnActor(new Pet(), "pet");

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

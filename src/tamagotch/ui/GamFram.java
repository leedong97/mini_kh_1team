package src.tamagotch.ui;

import java.awt.*;

import src.tamagotch.core.GameInstance;
import src.tamagotch.core.World;
import src.tamagotch.entity.Food;

public class GamFram extends Frame{
    GameInstance gameinstance;
    //게임시작프레임
    //유아이세팅
    //오브젝트세팅
    //정보
    //밥주기
    //목욕
    //똥치우기
    //미니게임
    //ㄴ참참참 ㄴ가위바위보 
    //약
    //운동
    //전등
    //
    
    public GamFram(){
        gameinstance = GameInstance.getInstance();
        
        //최초 타이틀생성
        int sizX = 600;
        int sizY = 600;
        int startX = gameinstance.WINFRAME_W/2 - sizX/2;
        int startY = gameinstance.WINFRAME_Y/2 - sizY/2;
        setBounds(startX, startY, sizX, sizY);

        
        
        TitleWorld tw = new TitleWorld();
        
        
        add(tw);
        
        //게임 시작 버튼 누르면 tw종료 후 아래gw생성

        //타이틀에서 선택하면 gw생성 후 초기화
        // GameWorld gw = new GameWorld();
        // add(gw);

        //gw에서 사용될 오브젝트 소환 예시
        // Food food = gw.spawnActor(new Food());

        setVisible(true);
    }
}

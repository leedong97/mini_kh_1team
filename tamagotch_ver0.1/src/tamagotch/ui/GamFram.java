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
        setBounds(100, ABORT, WIDTH, HEIGHT);
        World world = new World();
        add(world);

        Food food = world.spawnActor(new Food());

        setVisible(true);
    }
}

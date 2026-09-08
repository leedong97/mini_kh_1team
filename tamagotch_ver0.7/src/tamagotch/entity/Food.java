package src.tamagotch.entity;

import java.util.Random;

import src.tamagotch.core.CVector2D;
import src.tamagotch.core.GameObject;

public class Food extends GameObject {

    public String name;
    public CVector2D location;
    private long createTime;

    public Food(String name){
        //this.objectName = objname;
        this.name = name;
        System.out.println(name + "이 생성돼었습니다.");
    }
    @Override
    public void beginPlay() {
        // TODO Auto-generated method stub
        setBody("🍚",50);

        Random rand = new Random();
        location = new CVector2D(rand.nextInt(300) + 200,rand.nextInt(300) + 200);
        setLocation((int)location.x, (int)location.y);
    }
    @Override
    public void update() {
        setLocation(x, y--);
        //System.out.println("?");
    }

    public void using(Pet pet){
        pet.hunger+=80;
        pet.restroom -= 30;
        System.out.println("펫의 배고픔 게이지가 업데이트 돼었습니다." + pet.hunger);
        this.destory();
    }
}

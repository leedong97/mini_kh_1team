package src.tamagotch.entity;

import src.tamagotch.core.GameObject;

public class Food extends GameObject {

    public String name;
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
    }
    @Override
    public void update() {
        setLocation(x, y--);
        //System.out.println("?");
    }

    public void using(Pet pet){
        pet.levelOfHunger+=80;
        System.out.println("펫의 배고픔 게이지가 업데이트 돼었습니다." + pet.levelOfHunger);
        this.destory();
    }
}

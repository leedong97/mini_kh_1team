package src.tamagotch.entity;

import src.tamagotch.core.GameObject;

public class Pet extends GameObject{
    
    //나이
    //성별
    //상태
    //진화단계
    //진화단계별 기능 아이디어
    //이미지
    private String name;
    public float levelOfHunger = 100;//기본 값 100(나이 먹으면 커지게?)

    public Pet(){
        // imag = new ImageIcon("");
        // test = new JLabel(imag);
        // test.setBounds(50, 50, 100, 100);
    }
    
    @Override
    public void beginPlay() {
        // TODO Auto-generated method stub
        //setBody("src/tamagotch/img/Pet01/Pet01.png",100, 100);
        setBody("🐙",70);
        
    }
    @Override
    public void update() {
        updateStat();//배고픔 관리 함수
        setLocation(x, y);
    }

    public void setName(String name){
        this.name = name;
    }

    private void updateStat(){
        levelOfHunger -= 0.01;
        if(levelOfHunger > 50){
        }else if(levelOfHunger > 0){
            System.out.println("배고파");

            if(world != null){
                Food food = world.getGameObject("Food");
                if(food != null){
                    food.using(this);
                }
            }
            // 
        }else {
            //펫사망?
            System.out.println("팻사망");
            destory();
        }
        //System.out.println(levelOfHunger);
    }

    public void feeding(Food food){
        switch(food.name){
            case "분유":
                levelOfHunger += -10;
                break;
            case "쌀":
                levelOfHunger += -10;
                break;
            case "고기":
                levelOfHunger += -15;
                break;
            case "과자":
                levelOfHunger += -5;
                break;
        }
        System.out.println(levelOfHunger);
        System.out.println(levelOfHunger);
    }
}

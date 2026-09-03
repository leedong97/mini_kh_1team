package src.tamagotch.entity;

import src.tamagotch.core.GameObject;

public class Pet extends GameObject{
    //팻
    //이름
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
        setBody("src/tamagotch/img/Pet01/Pet01.png",100, 100);
    }
    @Override
    public void update() {
        //test.setBounds(50,y--,100,100);
        updateStat();//배고픔 관리 함수
    }

    private void updateStat(){
        //levelOfHunger -= 0.01;
        levelOfHunger -= 0.1;
        if(levelOfHunger > 50){
        }else if(levelOfHunger > 0){
            System.out.println("배고파");
            //경식씨
            // world.getGameObject("Food");
            // feeding();

        }else {
            //펫사망?
            System.out.println("팻사망");
            destory();
        }
        System.out.println(levelOfHunger);
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

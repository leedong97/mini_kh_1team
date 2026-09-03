package src.tamagotch.entity;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import src.tamagotch.core.GameInstance;
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
    public int levelOfHunger = 100;//기본 값 100(나이 먹으면 커지게?)

    public ImageIcon imag;
    public JLabel test;

    public int y = 100;
    public Pet(){
        imag = new ImageIcon("src/tamagotch/img/Pet01/Pet01.png");
        test = new JLabel(imag);

        test.setBounds(50, 50, 100, 100);
    }
    
    @Override
    public void beginPlay() {
        // TODO Auto-generated method stub
    }
    @Override
    public void update() {
        test.setBounds(50,y--,100,100);
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
    }
}

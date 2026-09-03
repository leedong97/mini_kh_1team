package src.tamagotch.entity;

import src.tamagotch.core.GameObject;

public class Food extends GameObject {

    public String name;
    public Food(String name){
        this.name = name;
        // String[] names = {"분유", "고기", "쌀", "과자"};
        // int rnd = (int)Math.random() * 4;
        // name = names[rnd];
    }
    @Override
    public void beginPlay() {
        // TODO Auto-generated method stub
    }
    @Override
    public void update() {
        
    }
}

package src.tamagotch.entity;

import src.tamagotch.core.GameObject;

public class Food extends GameObject {

    int dd = 100;

    @Override
    public void beginPlay() {
        // TODO Auto-generated method stub
    }
    @Override
    public void update() {
        
        if(dd < 50){
            System.out.println("씻고싶어요.");
        }
        else
            System.out.println(dd--);
        // TODO Auto-generated method stub
    }
}

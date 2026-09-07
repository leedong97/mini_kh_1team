package src.tamagotch.entity;

import java.util.Random;

import src.tamagotch.core.GameObject;

public class Poop extends GameObject{
    @Override
    public void beginPlay() {
        setBody("💩", 30);
        Random rand = new Random();
        setLocation(rand.nextInt(300) + 200, rand.nextInt(300) + 200);
    }
    @Override
    public void update() {
        
    }
}

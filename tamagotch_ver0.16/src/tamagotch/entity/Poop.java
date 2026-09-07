package src.tamagotch.entity;

import java.util.Random;

import src.tamagotch.core.CVector2D;
import src.tamagotch.core.GameObject;

public class Poop extends GameObject{
    public CVector2D vector;
    
    public Poop(CVector2D vector){
        this.vector = vector;
    }
    @Override
    public void beginPlay() {
        setBody("💩", 30);

        setLocation((int)vector.x, (int)vector.y);
    }
    @Override
    public void update() {
        
    }
}

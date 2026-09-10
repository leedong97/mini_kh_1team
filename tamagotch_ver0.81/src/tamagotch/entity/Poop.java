package src.tamagotch.entity;

import java.util.Random;

import src.tamagotch.core.CVector2D;
import src.tamagotch.core.GameObject;

public class Poop extends GameObject{
    public CVector2D vector;
    private float liftime = 100;
    String[] typ = {"분유", "고기", "쌀", "과자"};
    
    public Poop(CVector2D vector){
        this.vector = vector;
    }
    @Override
    public void beginPlay() {
        setBody("src/tamagotch/img/poop/poop01.png", 30,30);

        
    }
    @Override
    public void update() {
        liftime -= 0.1;
        if(liftime <= 0){
            Random rnd = new Random();
            Food food = this.getWorld().spawnActor(new Food(typ[rnd.nextInt(typ.length)]), "Food");
            food.setLocation(body.getLocation().x, body.getLocation().y);
            int x = body.getLocation().x;
            System.out.println(x);
            this.destory();
        }
    }
}

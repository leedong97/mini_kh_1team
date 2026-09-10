package src.tamagotch.entity.petAlgo;

import src.tamagotch.entity.Poop;
import src.tamagotch.entity.petAlgo.petAlgoCore.PetAlgo;

public class UpdateRestRoom extends PetAlgo{
    @Override
    public void updateStat() {
        
        pet.restroom -= 0.3;
        float velue = pet.restroom;
        
        if(pet.restroomC != null){
            pet.restroomC.accept(velue);
        }

        if(velue < 0){
            pet.getWorld().spawnActor(new Poop(pet.mypos), "Poop").setLocation(pet.body.getLocation().x + 50, pet.body.getLocation().y + 50);
            pet.restroom = 100;
        }
    }
}

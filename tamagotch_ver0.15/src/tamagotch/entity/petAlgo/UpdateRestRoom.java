package src.tamagotch.entity.petAlgo;

import src.tamagotch.entity.Poop;
import src.tamagotch.entity.petAlgo.petAlgoCore.PetAlgo;

public class UpdateRestRoom extends PetAlgo{
    @Override
    public void updateStat() {
        pet.restroom -= 0.1;
        float velue = pet.restroom;
        
        if(pet.restroomC != null){
            pet.restroomC.accept(velue);
        }

        if(velue < 0){
            pet.getWorld().spawnActor(new Poop(), "Poop");
            pet.restroom = 100;
        }
    }
}

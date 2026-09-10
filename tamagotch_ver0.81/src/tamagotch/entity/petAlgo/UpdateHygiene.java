package src.tamagotch.entity.petAlgo;

import src.tamagotch.entity.Poop;
import src.tamagotch.entity.petAlgo.petAlgoCore.PetAlgo;

public class UpdateHygiene extends PetAlgo{
    @Override
    public void updateStat() {

        Poop poop = pet.getWorld().getGameObject("Poop");
        if(poop == null) return;
        
        pet.hygiene -= 0.01;
        if(pet.hygiene <= 0){
            pet.hygiene = 0;
        }
        if(pet.hygieneC != null)
            pet.hygieneC.accept(pet.hygiene);

        if(pet.hygiene < 30){
            pet.stress +=0.01;
            
        }
    }
}

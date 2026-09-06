package src.tamagotch.entity.petAlgo;

import src.tamagotch.entity.petAlgo.petAlgoCore.PetAlgo;

public class UpdateFun extends PetAlgo{
    @Override
    public void updateStat() {
        pet.fun -= 0.01;
        if(pet.funC!=null){
            pet.funC.accept(pet.fun);
        }
    }
}
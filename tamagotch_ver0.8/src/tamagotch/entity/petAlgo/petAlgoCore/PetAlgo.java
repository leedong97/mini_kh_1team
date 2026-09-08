package src.tamagotch.entity.petAlgo.petAlgoCore;

import src.tamagotch.entity.Pet;

public abstract class PetAlgo {
    protected Pet pet;

    // public PetAlgo(){
    // }

    public PetAlgo init(Pet pet){
        this.pet = pet;
        return this;
    }
    //Pet의 Update에서 작동중
    public abstract void updateStat();
}

package src.tamagotch.entity.petAlgo;

import src.tamagotch.entity.petAlgo.petAlgoCore.PetAlgo;

public class UpdateFun extends PetAlgo{
    @Override
    public void updateStat() {
        
        pet.fun -= 0.01;
        if(pet.fun <= 0){
            pet.fun = 0;
        }
        if(pet.funC!=null){
            pet.funC.accept(pet.fun);
        }

        if(pet.fun < 20){
            pet.stress -= 0.01;
            if(pet.stress <= 0){
                pet.stress = 0;
            }
            if(pet.stressC!=null){
                pet.stressC.accept(pet.stress);
            }
        }
    }
}
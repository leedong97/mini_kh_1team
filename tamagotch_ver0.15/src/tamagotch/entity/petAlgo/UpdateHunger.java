package src.tamagotch.entity.petAlgo;

import src.tamagotch.entity.Food;
import src.tamagotch.entity.petAlgo.petAlgoCore.PetAlgo;
import src.tamagotch.core.GameInstance;

public class UpdateHunger extends PetAlgo{
    
    public UpdateHunger(){
    }

    @Override
    public void updateStat(){
        pet.hunger -= 0.1;
        if(pet.hungerC != null){
            pet.hungerC.accept(pet.hunger);
        }
        if(pet.hunger > 50){
            if(pet.objCase.equals("hunger")){
                pet.setObjectCase("normal");
                if(pet.caseC != null)
                    pet.caseC.accept(pet.objCase);
            }

        }else if(pet.hunger > 0){
            //배고픔으로 상태전환
            if(pet.objCase.equals("normal")){
                pet.setObjectCase("hunger");
                if(pet.caseC != null)
                    pet.caseC.accept(pet.objCase);
            }

            if(GameInstance.getInstance().getWorld() != null){
                Food food = GameInstance.getInstance().getWorld().getGameObject("Food");
                if(food != null){
                    food.using(pet);
                }
            }
            // 
        }else {
            //펫사망?
            System.out.println("팻사망");
            pet.setObjectCase("death");
            if(pet.caseC != null)
                pet.caseC.accept(pet.objCase);
        }
        //System.out.println(levelOfHunger);
    }
}

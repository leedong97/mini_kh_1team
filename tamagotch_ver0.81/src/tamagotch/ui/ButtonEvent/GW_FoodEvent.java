package src.tamagotch.ui.ButtonEvent;

import java.awt.Button;
import java.awt.event.*;

import src.tamagotch.core.GameInstance;
import src.tamagotch.entity.Food;
import src.tamagotch.ui.ButtonEvent.btnE_Core.BtnECore;


public class GW_FoodEvent extends BtnECore{
    @Override
    public void btnEvent(){
        if(world.buttonsection == 2) return;//섹션이 같으면 반환, 버튼 중복생성 방지

        String[] meals = {"분유", "고기", "쌀", "과자", "닫기"}; // -> 이구조로 다른 것들도 짜면 좋을듯
        Button[] mealButtons = new Button[meals.length];

        int btnSizX = 50;
        int btnSizY = 30;

        for(int i = 0; i < meals.length; i++){
            mealButtons[i] = new Button(meals[i]);
            mealButtons[i].setBounds(
                GameInstance.getInstance().gameFrameSizX - btnSizX*2
                ,150+(btnSizY*i) + 20
                ,btnSizX
                ,btnSizY
            );

            mealButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String mealType = ((Button) e.getSource()).getLabel();
                    if(mealType.equals("닫기")){
                        for(int j = 0; j < mealButtons.length; j++){
                            world.remove(mealButtons[j]);
                            world.buttonsection = 0;
                        }
                    }else{
                        Food food = world.spawnActor(new Food(mealType), "Food");
                        food.randomLocation();
                    }
                }
            });

            world.buttonsection = 2;
            
            world.add(mealButtons[i],0);
        }
        System.out.println("밥주기 버튼 클릭됨");
    }
}

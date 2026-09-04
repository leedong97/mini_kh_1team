package src.tamagotch.ui.ButtonEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.tamagotch.core.GameRule;
import src.tamagotch.core.World;
import src.tamagotch.entity.Food;

public class FoodEvent extends GameRule implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // 버튼별로 처리할 로직 작성 예시
        // switch(index) {
        //     case 0:
        //         // 스테이터스 버튼 클릭시
        //         System.out.println("스테이터스 버튼 클릭됨");
        //         // 예: 상태 창 띄우기
        //         break;
        //     case 1:
        //         // 밥주기
        //         //foodEvent();
        //         new FoodEvent().Event();
        //         break;
        //     case 2:
        //         // 목욕
        //         System.out.println("목욕 버튼 클릭됨");
        //         break;
        //     case 3:
        //         // 똥치우기
        //         System.out.println("똥치우기 버튼 클릭됨");
        //         break;
        //     case 4:
        //         // 미니게임
        //         System.out.println("미니게임 버튼 클릭됨");
        //         break;
        //     case 5:
        //         // 약먹이기
        //         System.out.println("약먹이기 버튼 클릭됨");
        //         break;
        //     case 6:
        //         // 운동 시키기
        //         System.out.println("운동 시키기 버튼 클릭됨");
        //         break;
        //     case 7:
        //         // 취침
        //         System.out.println("취침 버튼 클릭됨");
        //         break;
        //     default:
        //         System.out.println("알 수 없는 버튼");
        
    }

    public void feedMe(){
        //world.spawnActor(new Food("고기"));
        System.out.println("밥을줬습니다.");
    }

    public void feedMe(String food){
        System.out.println(food + "을 먹었습니다");
    }
}
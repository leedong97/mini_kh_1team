package src.tamagotch.ui;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.tamagotch.core.GameInstance;
import src.tamagotch.core.GameObject;
import src.tamagotch.core.World;
import src.tamagotch.entity.Food;
import src.tamagotch.entity.Pet;
import src.tamagotch.ui.ButtonEvent.FoodEvent;

public class GameWorld extends World{
    private Button[] buttons;
    
    public GameWorld(){
        buttonSet();

    }

    private void buttonSet(){
        // 버튼 생성     
        String[] buttonNames= {"스테이터스","밥주기","목욕","똥치우기","미니게임",
        "약먹이기","운동 시키기","취침"};
        buttons = new Button[buttonNames.length];

        setLayout(null);
        //버튼 배치 윗줄
        for(int i =0; i<5; i++){
            buttons[i] = new Button(buttonNames[i]);
            buttons[i].setBounds(50+70*i,50,60,50);
            add(buttons[i]);
        }
    
        //버튼 배치 아랫줄
        for(int i =5; i<8; i++){
            buttons[i] = new Button(buttonNames[i]);
            buttons[i].setBounds(50+(i-5)*110,400,100,50);
            add(buttons[i]);
        }
    
        //버튼별로 실행시 감지자로 해당버튼 클릭시 원하는 이벤트를 출력 및 실행
        for(int i=0; i<buttonNames.length; i++){
            int index = i;
            buttons[i].addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 버튼별로 처리할 로직 작성 예시
                        switch(index) {
                            case 0:
                                // 스테이터스 버튼 클릭시
                                System.out.println("스테이터스 버튼 클릭됨");
                                // 예: 상태 창 띄우기
                                break;
                            case 1:
                                // 밥주기
                                //foodEvent();
                                new FoodEvent().Event();
                                break;
                            case 2:
                                // 목욕
                                System.out.println("목욕 버튼 클릭됨");
                                break;
                            case 3:
                                // 똥치우기
                                System.out.println("똥치우기 버튼 클릭됨");
                                break;
                            case 4:
                                // 미니게임
                                System.out.println("미니게임 버튼 클릭됨");
                                break;
                            case 5:
                                // 약먹이기
                                System.out.println("약먹이기 버튼 클릭됨");
                                break;
                            case 6:
                                // 운동 시키기
                                System.out.println("운동 시키기 버튼 클릭됨");
                                break;
                            case 7:
                                // 취침
                                System.out.println("취침 버튼 클릭됨");
                                break;
                            default:
                                System.out.println("알 수 없는 버튼");
        }}});}
    }

    public void foodEvent(){
        String[] meals = {"분유", "고기", "쌀", "과자"}; // -> 이구조로 다른 것들도 짜면 좋을듯
        Button[] mealButtons = new Button[meals.length];
        for(int i = 0; i < meals.length; i++){
            mealButtons[i] = new Button(meals[i]);
            mealButtons[i].setBounds(700,100+100*i,50,50);

            add(mealButtons[i]);
            //mealButtons[i].addActionListener(this);
        }

        //버튼 이름에 따라 Food 생성되게
        // Food food = GameInstance.getInstance().getWorld()
        // .spawnActor(new Food(버튼 이름 받아서 넣기));

        //각 버튼의 actionListener을 다시 설정해야함 -> 이 action에 버튼 관련 모두 담고 다른 곳으로 빼고 
        
        System.out.println("밥주기 버튼 클릭됨");
        // 버튼 클릭 시 실행될 코드
    };
}

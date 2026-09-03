package src.tamagotch.ui;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import src.tamagotch.core.GameInstance;
import src.tamagotch.core.World;
import src.tamagotch.entity.Food;

public class GamFram extends Frame {
    GameInstance gameinstance;
    // 게임시작프레임
    // 유아이세팅
    // 오브젝트세팅
    // 정보                 -1
    // 밥주기                -2
    // 목욕                 -3    
    // 똥치우기 -- 내가 작업할거   -4
    // 미니게임                 -5
    // ㄴ참참참 ㄴ가위바위보
    // 약                           -6
    // 운동                         -7
    // 전등                          -8
    //

    public GamFram() {
        gameinstance = GameInstance.getInstance();
        setBounds(100, 100, 500, 500);

        // 버튼 생성     
        String[] buttonNames= {"스테이터스","밥주기","목욕","똥치우기","미니게임",
        "약먹이기","운동 시키기","취침"};
        Button[] buttons = new Button[buttonNames.length];
        for(int i=0; i<buttonNames.length;i++){
            buttons[i]= new Button(buttonNames[i]);
        }

        //버튼 배치 윗줄
        for(int i =0; i<5; i++){
            buttons[i].setBounds(50+70*i,50,60,50);
        }
     
        //버튼 배치 아랫줄
        for(int i =5; i<8; i++){
            buttons[i].setBounds(50+(i-5)*110,400,100,50);
        }
      
        //버튼별로 실행시 감지자로 해당버튼 클릭시 원하는 이벤트를 출력 및 실행
        for(int i=0; i<buttonNames.length; i++){
            int index = i;
            buttons[i].addActionListener(new ActionListener() {             
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
                        System.out.println("밥주기 버튼 클릭됨");
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
                }
            }
            });
        }
        

        for (int i = 0; i < buttons.length; i++) {
            add(buttons[i]);
        }

        // TitleWorld tw = new TitleWorld();
        // add(tw);
        // 게임 시작 버튼 누르면 tw종료 후 아래gw생성

        // 타이틀에서 선택하면 gw생성 후 초기화
        GameWorld gw = new GameWorld();
        add(gw);

        // gw에서 사용될 오브젝트 소환 예시
        Food food = gw.spawnActor(new Food());

        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

}

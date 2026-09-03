package src.tamagotch.ui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.tamagotch.core.GameInstance;

public class StateFrame  { 
    GameInstance gameinstance;

    public StateFrame(){        
        Frame fr = new Frame();
        // 버튼 생성
        Button buttons[] = new Button[8];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(i+"번 버튼");
        }

        //버튼 배치 윗줄
        for(int i =0; i<5; i++){
            buttons[i].setBounds(50+70*i,50,60,50);
        }
     
        //버튼 배치 아랫줄
        for(int i =5; i<8; i++){
            buttons[i].setBounds(50+(i-5)*110,400,100,50);
        }
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("버튼 클릭됨");
            }
        });
       

        for (int i = 0; i < buttons.length; i++) {
            fr.add(buttons[i]);
        }


    }//생성자
}

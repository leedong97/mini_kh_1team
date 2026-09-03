package src.tamagotch.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import src.tamagotch.ui.ButtonEvent.SaveButtonEvent;

public class TitleWorld extends Panel{
    public Font font; //전역변수로 옮길 예정

    public TitleWorld(){
        font = new Font("맑은고딕", Font.BOLD, 30);
       
        //친구불러오기
        //ㄴ 저장날짜, 이름, 나이, 성별, 파일삭제

        //설정
        //ㄴ프레임설정, 윈도우크기설정, 소리(일단유아이만 구성)

        //크레딧(프로젝트 완료 후 내용 수정)
        
        //게임종료
        //타이틀 폰트 세팅
        setLayout(null);
        mainUI01();
        //btn_0_1_setpetname();
        
    }

    public void mainUI01(){
        
        Label titletext = new Label("즐거운타마고치");
        titletext.setFont(font);
        titletext.setBounds(150, 50, 300, 50);
        
        add(titletext);
        String[] titleStr = {
            "새친구선택", "친구불러오기", "설정", "크레딧"
        };

        int heigth = 100;
        List<Button> btnarray = new ArrayList<Button>();

        for(String str : titleStr){
            Button btn = new Button(str);
            btn.setBounds(50, heigth += 30, 100,30);
            add(btn);
            btnarray.add(btn);
        }

        //새게임 선택화면
        btnarray.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                btn_0_0_patList();//첫번째 버튼 이벤트 실행
            }
        });

        //설정 눌렀을때
        btnarray.get(2).addActionListener(new SaveButtonEvent());
    }

    public void btn_0_0_patList(){
        //ㄴ팻 종류 선택(이미지만변경)
        //이전메뉴
        Label title = new Label("팻 종류 선택");
        title.setFont(font);
        title.setBounds(150, 50, 300, 50);
        
        Label[] bodys = new Label[3];
        bodys[0] = new Label("펫 이미지 1");
        bodys[0].setBackground(Color.BLUE);
        bodys[1] = new Label("펫 이미지 2");
        bodys[1].setBackground(Color.ORANGE);
        bodys[2] = new Label("펫 이미지 3");
        bodys[2].setBackground(Color.RED);

        add(bodys[0]);
        for(Label l : bodys){
            l.setBounds(100, 125, 300, 300);
        }

        Button btnL = new Button("◀");
        Button btnC = new Button("선택완료");
        Button btnR = new Button("▶");
        btnL.setBounds(150,450,50,50);
        btnC.setBounds(210,450,70,50);
        btnR.setBounds(290,450,50,50);

        add(btnL);
        add(btnC);
        add(btnR);
        add(title);
    }

    public void btn_0_1_setpetname(){
        Label title = new Label("이름설정");
        title.setFont(font);
        title.setBounds(150, 50, 300, 50);
        add(title);
        Label setName = new Label("이름을 입력하세요");
        setName.setFont(font);
        setName.setBounds(100, 130, 300, 50);
        add(setName);

        Button btn = new Button("게임시작");
        btn.setBounds(150, 200, 300, 50);
        add(btn);
    }
}

package src.tamagotch.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

import src.tamagotch.core.CVector2D;
import src.tamagotch.core.GameInstance;
import src.tamagotch.core.World;
import src.tamagotch.core.algo.Algo;
import src.tamagotch.entity.Food;
import src.tamagotch.entity.Pet;
import src.tamagotch.ui.ButtonEvent.FoodEvent;

public class GameWorld extends World{
    private JButton[] buttons;
    private GamFram gf ;
    
    public GameWorld(GamFram gf){
        buttonSet();
        setLayout(null);
        this.gf = gf;

        Pet pet = spawnActor(new Pet(), "Pet");
        String rn = Algo.randomName();
        pet.setName(rn);

        setdisplay();
    }

    public GameWorld(GamFram gf, String petName){
        buttonSet();
        setLayout(null);
        this.gf = gf;

        Pet pet = spawnActor(new Pet(), "Pet");

        if(petName.equals("이름을 입력하세요.") || petName.equals("") || petName == null){
            String rn = Algo.randomName();
            pet.setName(rn);
        }else{
            pet.setName(petName);
        }

        setdisplay();
    }

    private void buttonSet(){
        // 버튼 생성     
        String[] buttonNames= {"😊","🍚","🛁","🚽","🎮","💊","🎾","💤"};
        buttons = new JButton[buttonNames.length];

        setLayout(null);
        //버튼 배치 윗줄

        int btnsiz = GameInstance.getInstance().gameFrameSizX/(buttonNames.length/2);

        for(int i = 0; i < buttonNames.length/2; i++){
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setFont(new Font("",Font.PLAIN,20));
            buttons[i].setBorderPainted(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBounds(btnsiz * i, 0, btnsiz, btnsiz/2);
            add(buttons[i]);
            setComponentZOrder(buttons[i], 100);
        }
    
        //버튼 배치 아랫줄
        for(int i = 0; i < buttonNames.length/2; i++){
            buttons[i + buttonNames.length/2] = new JButton(buttonNames[i + buttonNames.length/2]);
            buttons[i + buttonNames.length/2].setFont(new Font("",Font.PLAIN,20));
            buttons[i + buttonNames.length/2].setBorderPainted(false);
            buttons[i + buttonNames.length/2].setContentAreaFilled(false);
            buttons[i + buttonNames.length/2].setBounds(
                btnsiz * i
                , GameInstance.getInstance().gameFrameSizY - (btnsiz/2 + 30)
                , btnsiz
                , btnsiz/2
            );
            add(buttons[i + buttonNames.length/2]);
            setComponentZOrder(buttons[i + buttonNames.length/2], 100);
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
                                foodEvent();
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
                            GameWorld.this.remove(mealButtons[j]);
                        }
                    }else{
                        spawnActor(new Food(mealType), "Food");
                    }
                    // 여기서 실제 밥을 먹이는 처리를 넣을 수 있습니다.
                }
            });
            add(mealButtons[i]);
            setComponentZOrder(mealButtons[i], 100);
        }
        System.out.println("밥주기 버튼 클릭됨");
    };//

    //화면분할 함수
    public void setdisplay(){
        int sizX = GameInstance.getInstance().gameFrameSizX;
        int sizY = GameInstance.getInstance().gameFrameSizY;

        int n = 20;//화면분할갯수
        int dis = sizX/n;
        
        CVector2D[][] display = new CVector2D[n][n];
        
        for(int y = 0; y < n; y++){ 
            for(int x = 0; x < n; x++)
                display[y][x] = new CVector2D(dis*x, dis*y);
        }

        Random r = new Random();
        for(int i = 0; i < display.length; i++){
            for(int j = 0; j < display.length; j++){
                Label fr = new Label();
                int xx = (int)display[i][j].x;
                int yy = (int)display[i][j].y;
                fr.setSize(dis, dis);
                fr.setLocation(xx, yy);

                fr.setBackground(new Color(r.nextInt(255)
                    ,r.nextInt(255)
                    ,r.nextInt(255)
                ));
                add(fr, 0);
                setComponentZOrder(fr, 0);
            }
        }
    }
}

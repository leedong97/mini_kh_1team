package src.tamagotch.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import src.tamagotch.core.CVector2D;
import src.tamagotch.core.GameInstance;
import src.tamagotch.core.World;
import src.tamagotch.core.algo.Algo;
import src.tamagotch.entity.Pet;
import src.tamagotch.entity.PetClone;
import src.tamagotch.ui.ButtonEvent.GW_EndEvent;
import src.tamagotch.ui.ButtonEvent.GW_FitnessGame;
import src.tamagotch.ui.ButtonEvent.GW_FoodEvent;
import src.tamagotch.ui.ButtonEvent.GW_Medicine;
import src.tamagotch.ui.ButtonEvent.GW_PetInfoBE;
import src.tamagotch.ui.ButtonEvent.GW_bath;
import src.tamagotch.ui.ButtonEvent.GW_cleanMap;

public class GameWorld extends World{
    public JButton[] buttons;
    public GamFram gf;
    public CVector2D[][] display;

    public int buttonsection = 0; //버튼 섹션
    
    public GameWorld(GamFram gf){
        setLayout(null);
        setdisplay();
        buttonSet();
        this.gf = gf;

        Pet pet = spawnActor(new Pet(), "Pet");
        String rn = Algo.randomName();
        pet.setName(rn);
    }
    public GameWorld(GamFram gf, PetClone petClone){
        setLayout(null);
        setdisplay();
        buttonSet();
        this.gf = gf;

        Pet pet = spawnActor(new Pet(petClone),"Pet");
    }

    public GameWorld(GamFram gf, String petName){
        setLayout(null);
        setdisplay();
        buttonSet();
        this.gf = gf;
        
        Pet pet = spawnActor(new Pet(), "Pet");

        if(petName.equals("이름을 입력하세요.") || petName.equals("") || petName == null){
            String rn = Algo.randomName();
            pet.setName(rn);
        }else{
            pet.setName(petName);
        }
    }

    private void buttonSet(){
        // 버튼 생성     
        String[] buttonNames= {"😊 정보","🍚 밥","🛁 샤워","🚽 화장실 ","💊 약","🎾 운동","💤 취침", "⏻ 종료"};
        buttons = new JButton[buttonNames.length];

        setLayout(null);
        //버튼 배치 윗줄

        int btnsiz = GameInstance.getInstance().gameFrameSizX/(buttonNames.length/2);

        for(int i = 0; i < buttonNames.length/2; i++){
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setFont(new Font("",Font.BOLD,20));
            buttons[i].setBorderPainted(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBounds(btnsiz * i, 0, btnsiz, btnsiz/2);
            buttons[i].setForeground(Color.DARK_GRAY);
            add(buttons[i],1);
        }
    
        //버튼 배치 아랫줄
        for(int i = 0; i < buttonNames.length/2; i++){
            buttons[i + buttonNames.length/2] = new JButton(buttonNames[i + buttonNames.length/2]);
            buttons[i + buttonNames.length/2].setFont(new Font("",Font.BOLD,20));
            buttons[i + buttonNames.length/2].setBorderPainted(false);
            buttons[i + buttonNames.length/2].setContentAreaFilled(false);
            buttons[i + buttonNames.length/2].setBounds(
                btnsiz * i
                , GameInstance.getInstance().gameFrameSizY - (btnsiz/2 + 30)
                , btnsiz
                , btnsiz/2
            );

            buttons[i + buttonNames.length/2].setForeground(Color.DARK_GRAY);
            add(buttons[i + buttonNames.length/2],1);
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
                                // 캐릭터정보
                                new GW_PetInfoBE().btnEvent();
                                break;
                            case 1:
                                // 밥주기
                                new GW_FoodEvent().btnEvent();
                                break;
                            case 2:
                                // 목욕
                                new GW_bath().btnEvent();
                                break;
                            case 3:
                                // 화장실
                                new GW_cleanMap().btnEvent();
                                break;
                            case 4:
                                // 약
                                new GW_Medicine().btnEvent();
                                break;
                            case 5:
                                // 운동
                                new GW_FitnessGame().btnEvent();
                                break;
                            case 6:
                                //취침
                                JLabel endbrt = new JLabel();
                                endbrt.setBounds(0, 0, 700, 700);
                                endbrt.setBackground(Color.BLACK);
                                endbrt.setOpaque(true);
                                add(endbrt,1);
                                System.out.println("취침클릭");
                                revalidate();
                                for(JButton btn : buttons){
                                    btn.setForeground(Color.WHITE);
                                }
                                repaint();
                                break;
                            case 7:
                                // 종료
                                new GW_EndEvent().btnEvent();
                                
                                break;
                            default:
                                System.out.println("알 수 없는 버튼");
        }}});}
    }

    //화면분할 함수
    public void setdisplay(){
        ImageIcon[]img = new ImageIcon[6];

        img[0] = new ImageIcon("src/tamagotch/img/map/01.png");
        img[1] = new ImageIcon("src/tamagotch/img/map/02.png");
        img[2] = new ImageIcon("src/tamagotch/img/map/03.png");
        img[3] = new ImageIcon("src/tamagotch/img/map/04.png");
        img[4] = new ImageIcon("src/tamagotch/img/map/05.png");
        img[5] = new ImageIcon("src/tamagotch/img/map/06.png");
        

        int sizX = GameInstance.getInstance().gameFrameSizX;
        int sizY = GameInstance.getInstance().gameFrameSizY;

        int n = 7;//화면분할갯수
        int dis = sizX/n;
        
        display = new CVector2D[n][n];
        
        for(int y = 0; y < n; y++){ 
            for(int x = 0; x < n; x++)
                display[y][x] = new CVector2D(dis*x, dis*y);
        }

        Random r = new Random();
        for(int i = 0; i <= display.length; i++){
            for(int j = 0; j < display.length; j++){
                if(i == display.length){
                    JLabel fr = new JLabel(img[r.nextInt(6)]);
                    int xx = 700;
                    int yy = 700;
                    fr.setSize(dis, dis);
                    fr.setLocation(xx, yy);

                    fr.setOpaque(true);

                    add(fr,0);
                    return ;
                }
                JLabel fr = new JLabel(img[r.nextInt(6)]);
                int xx = (int)display[i][j].x;
                int yy = (int)display[i][j].y;
                fr.setSize(dis, dis);
                fr.setLocation(xx, yy);

                fr.setOpaque(true);

                add(fr,0);
            }
        }
    }
}

package src.tamagotch.ui.ButtonEvent;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;

import src.tamagotch.ui.ButtonEvent.btnE_Core.BtnECore;

public class GW_FitnessGame extends BtnECore {

    Label titleLabel;
    Label resultLabel;
    
    //버튼
    Button startBtn;
    Button resetBtn;

    //현재 게이지 값
    int gauge = 0;

    @Override
    public void btnEvent() {
    // Frame 설정
        Frame f = setFrame();
        f.setTitle("운동하기");

        //제목 Label
        titleLabel = new Label("클릭 게이지 게임", Label.CENTER);
        titleLabel.setBounds(
            f.getSize().width/2 - 100
            ,20
            ,200
            ,30
        );
        f.add(titleLabel);

        //게임시작 버튼
        startBtn = new Button("게임시작");
        startBtn.setBounds(
            f.getSize().width/2 - 100
            ,190,200,40);
        f.add(startBtn);

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gauge = 50;
                f.remove(startBtn);

                //게이지label
                Label gaugeLabel = new Label ("게이지 : "+gauge+"%", Label.CENTER);

                gaugeLabel.setBounds(
                    f.getSize().width/2 - 100
                    ,70,200,30);
                f.add(gaugeLabel);
                
                Button btn = new Button("클릭!" );
                btn.setBounds(60,130,100,40);
                f.add(btn);

                Button btn2 = new Button("운동종료" );
                btn2.setBounds(180,130,100,40);
                f.add(btn2);

                boolean tb = true;
                //게이지 감소 쓰레드
                Thread tr = new Thread(){
                    @Override
                    public void run() {
                        while(tb){
                            try {
                                sleep(1000/10);
                                gauge --;
                                gaugeLabel.setText("게이지: "+gauge+"%");
                                if(gauge < 0){
                                    gaugeLabel.setText("패배하였습니다");
                                    f.remove(btn);
                                    f.remove(btn2);
                                    gauge = 50;
                                    f.add(startBtn);
                                    interrupt();
                                }
                            } catch (Exception e) {
                                // TODO: handle exception
                                break;
                            }
                        }
                    }
                };

                tr.start();

                //게이지 차라!
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gauge ++;
                        gaugeLabel.setText("게이지: "+gauge+"%");
                        //승리시
                        if(gauge >= 100){
                            f.remove(btn);
                            f.remove(btn2);
                            gauge = 50;
                            f.add(startBtn);
                            tr.interrupt();
                            gaugeLabel.setText("승리!");
                        }
                    }
                });
                
                // 게임 종료
                btn2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.remove(btn);
                        f.remove(btn2);
                        f.remove(gaugeLabel);
                        gauge = 50;
                        f.add(startBtn);
                        tr.interrupt();
                    }
                });
            }
        });

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

        f.setVisible(true);
    }
}

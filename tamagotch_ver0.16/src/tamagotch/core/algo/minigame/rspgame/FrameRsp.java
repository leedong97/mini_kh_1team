package src.tamagotch.core.algo.minigame.rspgame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import javax.swing.*;

public class FrameRsp {

    public static void main(String[] args) {

        Frame f = new Frame("가위바위보");
        f.setBounds(700, 300, 700, 500);

        f.setLayout(null);

        // 제목
        Font font = new Font("맑은고딕", Font.BOLD, 20);
        Label label1 = new Label("가위 바위 보");
        label1.setFont(font);
        label1.setBounds(290, 50, 200, 30);

        // vs이미지
        ImageIcon vsimg = new ImageIcon("src/tamagotch/core/algo/minigame/imgMinigame/vs.jpg");

        JLabel vs = new JLabel(vsimg);
        vs.setBounds(280, 100, 150, 150);

        //가위바위보 이미지
        JLabel rsp = new JLabel();
        rsp.setBounds(100, 100, 130,130);

        // Thread
        ImgThread ts = new ImgThread(rsp);
        ts.start();

        // 결과
        Label lb = new Label();
        lb.setBounds(500, 180, 180, 100);
        lb.setFont(font);

        RspListener listener = new RspListener(ts);
        listener.setLb(lb);

        // 버튼
        Button btn1 = new Button("가위");
        Button btn2 = new Button("바위");
        Button btn3 = new Button("보");

        Button btn4 = new Button("다시하기");

        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);
        btn4.addActionListener(listener);

        btn1.setBounds(150, 280, 100, 80);
        btn2.setBounds(300, 280, 100, 80);
        btn3.setBounds(450, 280, 100, 80);

        btn4.setBounds(290, 380, 120, 50);

        f.add(label1);
        f.add(vs);
        f.add(rsp);
        f.add(lb);
        f.add(btn1);
        f.add(btn2);
        f.add(btn3);
        f.add(btn4);

        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }

}

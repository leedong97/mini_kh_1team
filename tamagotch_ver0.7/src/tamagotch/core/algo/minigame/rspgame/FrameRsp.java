/*package src.tamagotch.core.algo.minigame.rspgame;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FrameRsp {

    public static void main(String[] args) {

        // 가위바위보 테스트용 프레임
        Frame f = new Frame("가위바위보");
        f.setBounds(700, 300, 700, 500);
        f.setLayout(null);

        // 공통 폰트
        Font font = new Font("맑은고딕", Font.BOLD, 20);

        // 제목
        Label titleLabel = new Label("가위 바위 보");
        titleLabel.setFont(font);
        titleLabel.setBounds(290, 50, 200, 30);

        // VS 이미지
        ImageIcon vsImg = new ImageIcon(
                "src/tamagotch/core/algo/minigame/imgMinigame/vs.jpg");

        JLabel vs = new JLabel(vsImg);
        vs.setBounds(280, 100, 150, 150);

        // 플레이어 / 상대 이미지 영역
        JLabel player = new JLabel();
        JLabel enemy = new JLabel();

        player.setBounds(90, 100, 120, 120);
        enemy.setBounds(490, 100, 120, 120);

        // 준비 애니메이션 실행
        ImgThread ts = new ImgThread(player, enemy);
        ts.start();

        // 결과 문구 출력 영역
        Label resultLabel = new Label();
        resultLabel.setBounds(500, 180, 180, 100);
        resultLabel.setFont(font);

        // 버튼 이벤트 연결
        RspListener listener = new RspListener(ts);
        listener.setLb(resultLabel);

        // 가위바위보 버튼
        Button btnScissors = new Button("가위");
        Button btnRock = new Button("바위");
        Button btnPaper = new Button("보");
        Button btnRetry = new Button("다시하기");

        btnScissors.setBounds(150, 280, 100, 80);
        btnRock.setBounds(300, 280, 100, 80);
        btnPaper.setBounds(450, 280, 100, 80);
        btnRetry.setBounds(290, 380, 120, 50);

        btnScissors.addActionListener(listener);
        btnRock.addActionListener(listener);
        btnPaper.addActionListener(listener);
        btnRetry.addActionListener(listener);

        // 프레임에 컴포넌트 추가
        f.add(titleLabel);
        f.add(vs);
        f.add(player);
        f.add(enemy);
        f.add(resultLabel);
        f.add(btnScissors);
        f.add(btnRock);
        f.add(btnPaper);
        f.add(btnRetry);

        f.setVisible(true);

        // 창 닫기
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }
}*/
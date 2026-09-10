package src.tamagotch.ui.ButtonEvent;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.tamagotch.core.algo.minigame.rspgame.ImgThread;
import src.tamagotch.core.algo.minigame.rspgame.RspListener;
import src.tamagotch.ui.ButtonEvent.btnE_Core.BtnECore;

public class GW_bath extends BtnECore {

    @Override
    public void btnEvent() {

        // 목욕 미니게임 창 생성
        JFrame frame = setFrame();
        frame.getContentPane().setBackground(Color.WHITE);

        // 제목
        JLabel titleLabel = spawnJLabel("목욕 시키기");
        titleLabel.setFont(new Font("굴림체", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // 플레이어 / 상대 이미지 영역
        JLabel player = new JLabel();
        JLabel enemy = new JLabel();

        player.setBounds(35, 100, 95, 95);
        enemy.setBounds(200, 100, 95, 95);

        frame.add(player);
        frame.add(enemy);

        // VS 이미지
        ImageIcon vsImg = new ImageIcon(
                "src/tamagotch/core/algo/minigame/imgMinigame/vs.jpg");

        Image resizedVs = vsImg.getImage()
                .getScaledInstance(60, 60, Image.SCALE_SMOOTH);

        JLabel vs = new JLabel(new ImageIcon(resizedVs));
        vs.setBounds(145, 125, 45, 45);

        frame.add(vs);

        // 준비 애니메이션 실행
        ImgThread imgThread = new ImgThread(player, enemy);
        imgThread.start();

        // 가위바위보 결과 문구
        Label resultLabel = new Label();

        resultLabel.setBackground(Color.WHITE);
        resultLabel.setBounds(45, 270, 225, 40);
        resultLabel.setFont(new Font("굴림체", Font.BOLD, 15));
        resultLabel.setAlignment(Label.CENTER);

        frame.add(resultLabel);

        // 가위바위보 이벤트 연결
        RspListener listener = new RspListener(imgThread, pet);
        listener.setLb(resultLabel);

        // 가위 / 바위 / 보 / 다시하기 버튼
        Button btnScissors = new Button("가위");
        Button btnRock = new Button("바위");
        Button btnPaper = new Button("보");
        Button btnRetry = new Button("다시하기");

        btnScissors.setBounds(45, 335, 75, 45);
        btnRock.setBounds(120, 335, 75, 45);
        btnPaper.setBounds(195, 335, 75, 45);
        btnRetry.setBounds(45, 390, 225, 40);

        // 버튼 폰트
        Font buttonFont = new Font("굴림체", Font.BOLD, 15);

        btnScissors.setFont(buttonFont);
        btnRock.setFont(buttonFont);
        btnPaper.setFont(buttonFont);
        btnRetry.setFont(buttonFont);

        // 버튼 이벤트 등록
        btnScissors.addActionListener(listener);
        btnRock.addActionListener(listener);
        btnPaper.addActionListener(listener);
        btnRetry.addActionListener(listener);

        // 버튼을 프레임에 추가
        frame.add(btnScissors);
        frame.add(btnRock);
        frame.add(btnPaper);
        frame.add(btnRetry);

        // BtnECore에서 생성한 제목 위치 설정
        setJLabelUI(frame, 20);

        // 제목 위치 최종 조정
        titleLabel.setBounds(20, 30, 290, 40);

        // 모든 UI 구성이 끝난 후 창 표시
        frame.setVisible(true);
    }
}
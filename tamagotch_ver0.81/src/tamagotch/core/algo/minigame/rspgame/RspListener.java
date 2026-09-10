package src.tamagotch.core.algo.minigame.rspgame;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import src.tamagotch.entity.Pet;

public class RspListener implements ActionListener {

    // 컴퓨터의 가위바위보를 랜덤으로 정하기 위한 객체
    private Random rnd = new Random();

    // 준비 애니메이션과 결과 이미지를 제어하는 Thread
    private ImgThread imgThread;

    // 청결도 값을 변경할 Pet 객체
    private Pet pet;

    // 내가 낸 값
    // 0 = 가위, 1 = 바위, 2 = 보
    private int playerChoice = 0;

    // 결과 문구를 표시할 Label
    private Label resultLabel;

    // 한 판이 끝난 뒤 다시하기 전까지 추가 입력을 막기 위한 변수
    private boolean playing = true;

    // 테스트용 생성자
    public RspListener(ImgThread imgThread) {
        this.imgThread = imgThread;
    }

    // 실제 목욕 미니게임에서 사용하는 생성자
    public RspListener(ImgThread imgThread, Pet pet) {
        this.imgThread = imgThread;
        this.pet = pet;
    }

    // 결과 문구 Label 연결
    public void setLb(Label resultLabel) {
        this.resultLabel = resultLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 다시하기 버튼
        if (e.getActionCommand().equals("다시하기")) {
            imgThread.setPause(false);
            resultLabel.setText("");
            playing = true;
            return;
        }

        // 한 판이 끝난 상태라면
        // 다시하기를 누르기 전까지 가위바위보 버튼 무시
        if (!playing) {
            return;
        }

        // 컴퓨터 선택
        int computerChoice = rnd.nextInt(3);

        // 내가 누른 버튼에 따라 값 저장
        switch (e.getActionCommand()) {
            case "가위":
                playerChoice = 0;
                break;

            case "바위":
                playerChoice = 1;
                break;

            case "보":
                playerChoice = 2;
                break;
        }

        // 승리 판정
        if (playerChoice - computerChoice == 1
                || playerChoice - computerChoice == -2) {

            pet.hygiene += 50;
            resultLabel.setText("청결도 +50");

        } else {

            // 패배 또는 무승부
            pet.hygiene -= 5;
            resultLabel.setText("ㅋㅋㅋㅋㅋ  청결도 -5");
        }

        // 준비 애니메이션 정지 후 결과 이미지 표시
        imgThread.setPause(true);
        imgThread.showResult(playerChoice, computerChoice);

        // 다시하기를 누르기 전까지 추가 입력 막기
        playing = false;
    }
}
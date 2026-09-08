package src.tamagotch.core.algo.minigame.rspgame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImgThread extends Thread {

    // 플레이어와 상대 이미지를 표시할 JLabel
    private JLabel player;
    private JLabel enemy;

    // 쓰레드 실행 여부
    private boolean running = true;

    // 준비 애니메이션 일시정지 여부
    private volatile boolean pause = false;

    public ImgThread(JLabel player, JLabel enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public void run() {

        // 플레이어 준비 이미지
        ImageIcon player1 = new ImageIcon(
                "src/tamagotch/core/algo/minigame/imgMinigame/player_ready1.png");

        ImageIcon player2 = new ImageIcon(
                "src/tamagotch/core/algo/minigame/imgMinigame/player_ready2.png");

        ImageIcon player3 = new ImageIcon(
                "src/tamagotch/core/algo/minigame/imgMinigame/player_ready3.png");

        // 상대 준비 이미지
        ImageIcon enemy1 = new ImageIcon(
                "src/tamagotch/core/algo/minigame/imgMinigame/enemy_ready1.png");

        ImageIcon enemy2 = new ImageIcon(
                "src/tamagotch/core/algo/minigame/imgMinigame/enemy_ready2.png");

        ImageIcon enemy3 = new ImageIcon(
                "src/tamagotch/core/algo/minigame/imgMinigame/enemy_ready3.png");

        // 준비 이미지 크기 조절
        player1 = resizeImage(player1, 90, 90);
        player2 = resizeImage(player2, 90, 90);
        player3 = resizeImage(player3, 90, 90);

        enemy1 = resizeImage(enemy1, 90, 90);
        enemy2 = resizeImage(enemy2, 90, 90);
        enemy3 = resizeImage(enemy3, 90, 90);

        // 준비 애니메이션 반복
        while (running) {

            // 결과 화면일 때 준비 애니메이션 정지
            if (pause) {
                sleepThread(100);
                continue;
            }

            player.setIcon(player1);
            enemy.setIcon(enemy1);

            sleepThread(200);

            // 중간에 버튼을 눌렀는지 다시 확인
            if (pause) {
                continue;
            }

            player.setIcon(player2);
            enemy.setIcon(enemy2);

            sleepThread(200);

            if (pause) {
                continue;
            }

            player.setIcon(player3);
            enemy.setIcon(enemy3);

            sleepThread(200);
        }
    }

    // 준비 애니메이션 정지 / 재시작
    public void setPause(boolean pause) {
        this.pause = pause;
    }

    // 가위바위보 결과 이미지 표시
    public void showResult(int iam, int random) {

        String playerImg;
        String enemyImg;

        // 내가 낸 것
        if (iam == 0) {
            playerImg = "player_scissors.png";
        } else if (iam == 1) {
            playerImg = "player_rock.png";
        } else {
            playerImg = "player_paper.png";
        }

        // 상대가 낸 것
        if (random == 0) {
            enemyImg = "enemy_scissors.png";
        } else if (random == 1) {
            enemyImg = "enemy_rock.png";
        } else {
            enemyImg = "enemy_paper.png";
        }

        ImageIcon playerResult = new ImageIcon(
                "src/tamagotch/core/algo/minigame/imgMinigame/" + playerImg);

        ImageIcon enemyResult = new ImageIcon(
                "src/tamagotch/core/algo/minigame/imgMinigame/" + enemyImg);

        // 결과 이미지는 준비 이미지보다 조금 크게 표시
        playerResult = resizeImage(playerResult, 95, 95);
        enemyResult = resizeImage(enemyResult, 95, 95);

        player.setIcon(playerResult);
        enemy.setIcon(enemyResult);
    }

    // 이미지 크기 조절
    private ImageIcon resizeImage(ImageIcon image, int width, int height) {

        Image resizedImage = image.getImage()
                .getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(resizedImage);
    }

    // Thread.sleep 중복 코드 정리
    private void sleepThread(int time) {

        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }
}
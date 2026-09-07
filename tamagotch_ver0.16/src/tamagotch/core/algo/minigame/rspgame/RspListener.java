package src.tamagotch.core.algo.minigame.rspgame;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RspListener implements ActionListener {

    Random rnd = new Random();
    ImgThread it;

    private int win = 0;
    private int lose = 0;
    private int draw = 0;

    private int cnt = 0;
    private int iam = 0;

    //기록
    private Label record;

    public RspListener(ImgThread it){
        this.it = it;
    }
    public void setLb(Label record) {
        this.record = record;
    }

    //5번 연속 실행
    @Override
    public void actionPerformed(ActionEvent e) {

        int random = rnd.nextInt(3);

        switch (e.getActionCommand()) {

            case "가위":
                iam = 0;
                cnt++;
                break;

            case "바위":
                iam = 1;
                cnt++;
                break;

            case "보":
                iam = 2;
                cnt++;
                break;
            
        }

        if (iam - random == 1 || iam - random == -2) {
            win++;
            record.setText("이겼다");
        } else if (iam - random == 0) {
            draw++;
            record.setText("비겼다");
        } else {
            lose++;
            record.setText("졌다");
        }

        if(cnt == 5){
            record.setText(win + "win "  + draw + " draw "+ lose + " lose "  );
            cnt = 0;
        }

        switch (e.getActionCommand()) {
            case "다시하기":
                cnt = 0;
                win =0;
                lose = 0;
                draw = 0;
                record.setText("승 : " + win + " 패 : " + lose + " 무 : " + draw);
                break;
        }

        it.setBoolean(false);
    }
}

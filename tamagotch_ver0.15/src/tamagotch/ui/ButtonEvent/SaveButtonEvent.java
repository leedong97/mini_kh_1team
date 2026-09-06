package src.tamagotch.ui.ButtonEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.tamagotch.core.GameInstance;
import src.tamagotch.core.GameRule;

public class SaveButtonEvent extends GameRule implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        showInfoPopup();
    }

    public void showInfoPopup() {
        int sizX = 400;
        int sizY = 500;

        Frame dialog = new Frame();
        dialog.setBounds(
            GameInstance.getInstance().WINFRAME_W/2 - sizX/2
            ,GameInstance.getInstance().WINFRAME_Y/2 - sizY/2
            ,sizX,sizY
        );

        dialog.setLayout(null);
        Label name = new Label("이름 : 우리 다마고치");
        Label hp = new Label("체력 : 80");
        Label hunger = new Label("배고픔 : 60");
        Label level = new Label("레벨 : 3");

        // 라벨 위치
        name.setBounds(120, 80, 200, 30);
        hp.setBounds(120, 130, 200, 30);
        hunger.setBounds(120, 180, 200, 30);
        level.setBounds(120, 230, 200, 30);

        Button closeBtn = new Button("닫기");

        closeBtn.setBounds(150, 420, 100, 40);

        // 닫기 버튼
        closeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        dialog.add(name);
        dialog.add(hp);
        dialog.add(hunger);
        dialog.add(level);
        dialog.add(closeBtn);

        // 부모 프레임 가운데에 팝업 표시
        //dialog.setLocationRelativeTo(this);

        dialog.setVisible(true);
    }
}


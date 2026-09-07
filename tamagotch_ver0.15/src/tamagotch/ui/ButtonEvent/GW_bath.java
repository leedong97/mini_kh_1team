package src.tamagotch.ui.ButtonEvent;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.tamagotch.ui.ButtonEvent.btnE_Core.BtnECore;

public class GW_bath extends BtnECore{
    @Override
    public void btnEvent(){
        JFrame frame = setFrame();
        JLabel titleLabel = spawnJLabel("목욕시키기");
        titleLabel.setFont(new Font("",Font.BOLD,25));
        
        pet.hygiene = 100;//청결도 올리기

        frame.add(titleLabel);
        JButton eventBtn = spawnJButton("목욕시키기 버튼");
        frame.add(eventBtn);

        eventBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //여기 가위바위보 게임 구현

                //버튼 및 추가 예시
                Button btn = new Button("버튼");
                btn.setBounds(0, 300, 100, 100);
                frame.add(btn);
            }
        });

        setJLabelUI(frame, 20);
        frame.setVisible(true);
    }
}

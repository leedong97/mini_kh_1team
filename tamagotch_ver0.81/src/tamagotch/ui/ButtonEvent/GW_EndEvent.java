package src.tamagotch.ui.ButtonEvent;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.tamagotch.core.GameInstance;
import src.tamagotch.entity.PetClone;
import src.tamagotch.ui.GamFram;
import src.tamagotch.ui.GameWorld;
import src.tamagotch.ui.ButtonEvent.btnE_Core.BtnECore;

public class GW_EndEvent extends BtnECore{
    @Override
    public void btnEvent() {
        JFrame frame = setFrame();
        JLabel title = spawnJLabel("시스템");
        title.setFont(new Font("",Font.BOLD,30));

        JButton btn1 = spawnJButton("저장");
        JButton btn2 = spawnJButton("불러오기");
        JButton btn3 = spawnJButton("메인");
        JButton btn4 = spawnJButton("종료");

        setJLabelUI(frame, 20);
        frame.setVisible(true);

        //-------------
        //버튼 이벤트

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO: 여기에 저장 동작 코드를 구현하세요
                System.out.println("저장 버튼 클릭됨");
                PetClone petClone = new PetClone(GameInstance.getInstance().getWorld().getGameObject("Pet"));
                PetInfoWriter piw = new PetInfoWriter(petClone);
                piw.mkdir(petClone);
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameWorld gw = (GameWorld)GameInstance.getInstance().getWorld();
                GamFram gf = gw.gf;
                gf.getContentPane().removeAll();
                gf.fistSetting();
                frame.dispose();
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

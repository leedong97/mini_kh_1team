package src.tamagotch.ui.ButtonEvent;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.tamagotch.ui.ButtonEvent.btnE_Core.BtnECore;

public class GW_Medicine extends BtnECore{
    int clickindex = 0;
    int r;
    @Override
    public void btnEvent() {
        JFrame frame = setFrame();

        JLabel title = spawnJLabel("약을 먹여라!");
        title.setFont(new Font("",Font.BOLD,30));
        JLabel body = spawnJLabel("슬라임");
        JButton lbtn = spawnJButton("왼쪽");
        JButton cbtn = spawnJButton("가운데");
        JButton rbtn = spawnJButton("오른쪽");

        setJLabelUI(frame,20);
        frame.setVisible(true);
        //버튼이벤트
        
        lbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickindex = 0;
                gameresult();
            }
        });
        cbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickindex = 1;
                gameresult();
            }
        });
        rbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickindex = 2;
                gameresult();
            }
        });
    }
    
    private void gameresult(){
        Random rand = new Random();
        r = rand.nextInt(3);
        if(r == clickindex){
            System.out.println(pet.getName()+"에게 약을 먹였다!");
            pet.stress -= 30;
            if(pet.stressC != null){
                pet.stressC.accept(pet.stress);
            }
            pet.health += 50;
            if(pet.healthC != null){
                pet.healthC.accept(pet.health);
            }
        }else{
            System.out.println(pet.getName() + "이(가) 피했습니다.");
        }
    }
}

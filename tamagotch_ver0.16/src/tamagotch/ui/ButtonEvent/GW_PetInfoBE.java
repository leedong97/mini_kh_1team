package src.tamagotch.ui.ButtonEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import src.tamagotch.ui.ButtonEvent.btnE_Core.BtnECore;

//GameWorld Petinfo button event
public class GW_PetInfoBE extends BtnECore{

    public void btnEvent(){
        System.out.println("스테이터스 버튼 클릭됨");
        JFrame frame = setFrame();

        JLabel namelabel = spawnJLabel(pet.getName());
        namelabel.setFont(new Font("",Font.BOLD,25));
        JLabel caselabel = spawnJLabel("상태:"+pet.objCase);
        JLabel healthlabel = spawnJLabel("건강: ■■■■■■■■■■■");
        JLabel sleeplabel = spawnJLabel("수면:"+pet.objCase);
        JLabel stresslabel = spawnJLabel("정신: ");
        JLabel hungerlabel = spawnJLabel("허기: "+String.format("%.1f",pet.hunger));
        JLabel hygiene = spawnJLabel("청결: "+pet.hygiene);
        JLabel funlable = spawnJLabel("재미: "+pet.fun);
        JLabel restroomlable = spawnJLabel("배변: "+pet.restroom);

        //------Consumer를 통해 실시간 업데이트 함수
        pet.setHungerC(newint ->{
            hungerlabel.setText("허기: "+String.format("%.1f",pet.hunger));
        });

        pet.setHealthC(newint ->{
            int n = (int)pet.health / 10;
            String grf = "";
            for(int i = 0; i < n; i++){
                grf += "■";
            }
            healthlabel.setText("건강: " + grf);
        });
        pet.setStressC(newint -> {
            int n = (int)pet.stress / 10;
            String grf = "";
            if(n == 0){

            }else{
                for(int i = 0; i < n; i++){
                    grf += "■";
                }
            }
            stresslabel.setText("스트레스: " + grf);
        });

        pet.setHygieneC(newint ->{
            hygiene.setText("청결도: "+String.format("%.1f",pet.hygiene));
        });

        pet.setCaseC(newint ->{
            caselabel.setText("상태: " + pet.objCase);  
        });

        pet.setFunC(newint ->{
            funlable.setText("재미도: " + pet.fun);
        });

        pet.setRestRoom(newint ->{
            restroomlable.setText("화장실: " + pet.restroom);
        });

        //유아이 정렬
        setJLabelUI(frame, 20);

        //종료설정
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                pet.setHungerC(null);//람다종료
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }
}
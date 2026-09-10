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
        JLabel caselabel = spawnJLabel("상태 | "+pet.objCase);
        JLabel stresslabel = spawnJLabel("정신 | ");
        JLabel healthlabel = spawnJLabel("건강 | ■■■■■■■■■■■");
        
        JLabel sleeplabel = spawnJLabel("수면 | "+setGrap(pet.sleep));
        JLabel hungerlabel = spawnJLabel("허기 | "+String.format("%.1f",pet.hunger));
        JLabel hygiene = spawnJLabel("청결 | "+setGrap(pet.hygiene));
        JLabel funlable = spawnJLabel("재미 | "+pet.fun);
        JLabel restroomlable = spawnJLabel("배변 | "+pet.restroom);

        int sizX = frame.getSize().width;
        int x = frame.getLocation().x - sizX*3;
        int y = frame.getLocation().y;
        frame.setLocation(x,y);

        //------Consumer를 통해 실시간 업데이트 함수
        pet.setHungerC(newint ->{
            hungerlabel.setText("허기 | "+setGrap(pet.hunger));
        });

        pet.setHealthC(newint ->{
            healthlabel.setText("건강 | " + setGrap(pet.health));
        });
        pet.setStressC(newint -> {
            stresslabel.setText("정신 | " + setGrap(pet.stress));
        });

        pet.setHygieneC(newint ->{
            
            hygiene.setText("청결 | "+ setGrap(pet.hygiene));
        });

        pet.setCaseC(newint ->{
            caselabel.setText("상태 | " + pet.objCase);  
        });

        pet.setFunC(newint ->{
            funlable.setText("재미 | " + setGrap(pet.fun));
        });

        pet.setRestRoom(newint ->{
            restroomlable.setText("배변 | " + setGrap(pet.restroom));
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

    public String setGrap(float stat){
        int n = (int)stat / 10;
        String grf = "";
        if(n == 0){

        }else{
            for(int i = 0; i < n; i++){
                grf += "■";
            }
        }

        return grf;
    }
}
package src.tamagotch.ui.ButtonEvent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import src.tamagotch.core.GameInstance;
import src.tamagotch.entity.Pet;

//GameWorld Petinfo button event
public class GW_PetInfoBE extends JFrame{

    List<JLabel> labellist = new ArrayList<JLabel>();

    private int width;
    private int height;

    public void btnEvent(){
        System.out.println("스테이터스 버튼 클릭됨");
        JFrame frame = new JFrame();

        width = GameInstance.getInstance().gameFrameSizX/2;
        height = GameInstance.getInstance().gameFrameSizY;

        frame.setBounds(
            GameInstance.getInstance().WINFRAME_W/2 + GameInstance.getInstance().gameFrameSizX/2
            , GameInstance.getInstance().WINFRAME_Y/2 - GameInstance.getInstance().gameFrameSizY/2
            , width
            , height
        );

        Pet pet = GameInstance.getInstance().getWorld().getGameObject("Pet");

        JLabel namelabel = spawnJLabel(pet.getName());
        namelabel.setFont(new Font("",Font.BOLD,25));
        JLabel hungerlabel = spawnJLabel("허기: "+String.format("%.1f",pet.hunger));
        JLabel hygiene = spawnJLabel(""+pet.hygiene);
        spawnJLabel(""+pet.hygiene);
        spawnJLabel(""+pet.hygiene);

        //------Consumer를 통해 실시간 업데이트 함수
        pet.setHungerC(newint ->{
            hungerlabel.setText("허기: "+String.format("%.1f",pet.hunger));
        });

        pet.setHygieneC(newint ->{
            hygiene.setText("청결도: "+String.format("%.1f",pet.hygiene));
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

    public void setJLabelUI(JFrame frame, int margin){
        int y = margin;

        for(JLabel jb : labellist){
            int w = jb.getSize().width;
            int h = jb.getSize().height;

            if(w == 0) w = width - margin;
            if(h == 0) h = 30;

            jb.setBounds(margin, margin + y , w, h);
            
            y += h + margin;
            frame.add(jb);
            System.out.println(y);
        }
    }

    public JLabel spawnJLabel(String setText){
        JLabel jlb = new JLabel();
        jlb.setText(setText);
        labellist.add(jlb);
        return jlb;
    };

    public JLabel spawnJLabel(String setText, int x, int y){
        JLabel jlb = new JLabel();
        jlb.setText(setText);
        jlb.setLocation(x,y);
        labellist.add(jlb);
        return jlb;
    };
}
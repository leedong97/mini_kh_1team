package src.tamagotch.ui.ButtonEvent.btnE_Core;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.tamagotch.core.GameInstance;
import src.tamagotch.entity.Pet;
import src.tamagotch.ui.GameWorld;

public abstract class BtnECore {
    protected GameWorld world;
    protected List<JComponent> labellist = new ArrayList<JComponent>();
    protected int width;
    protected int height;
    protected Pet pet;

    public BtnECore(){
        world = (GameWorld)GameInstance.getInstance().getWorld();
        pet = GameInstance.getInstance().getWorld().getGameObject("Pet");
    }

    public abstract void btnEvent();

    public void setJLabelUI(JFrame frame, int margin){
        int y = margin;

        for(JComponent jb : labellist){
            int w = jb.getSize().width;
            int h = jb.getSize().height;

            if(w == 0) w = width - margin*2;
            if(h == 0) h = 30;

            jb.setBounds(margin, margin + y , w, h);
            
            y += h + margin;
            frame.add(jb);
            System.out.println(w);
        }
    }

    public JLabel spawnJLabel(String setText){
        JLabel jlb = new JLabel();
        jlb.setText(setText);
        jlb.setSize(0, 0);
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

    public JFrame setFrame(){
        JFrame frame = new JFrame();
        frame.setLayout(null);

        width = GameInstance.getInstance().gameFrameSizX/2;
        height = GameInstance.getInstance().gameFrameSizY;

        frame.setBounds(
            GameInstance.getInstance().WINFRAME_W/2 + GameInstance.getInstance().gameFrameSizX/2
            , GameInstance.getInstance().WINFRAME_Y/2 - GameInstance.getInstance().gameFrameSizY/2
            , width
            , height
        );

        return  frame;
    }

    public JButton spawnJButton(String setText){
        JButton jlb = new JButton();
        jlb.setText(setText);
        jlb.setSize(0, 0);
        labellist.add(jlb);
        return jlb;
    };
}

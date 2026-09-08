package src.tamagotch.ui.ButtonEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import src.tamagotch.core.GameInstance;
import src.tamagotch.core.GameRule;
import src.tamagotch.core.World;
import src.tamagotch.entity.PetClone;
import src.tamagotch.ui.GamFram;
import src.tamagotch.ui.GameWorld;
import src.tamagotch.ui.TitleWorld;

public class SaveButtonEvent extends GameRule implements ActionListener {

    // 경식------------------------
    PetClone petClone;
    List<PetClone> list = new ArrayList<>();
    String[] ids;
    String path = "C:/kh_miniproject/user"; // + String input + "/pet.save";
    File file = new File(path);
    PetInfoReader pir;
    Label[][] labels;
    Button[] start;
    Button[] delet;
    GamFram gf;
    World tw;

    public SaveButtonEvent(GamFram gf, World tw){
        this.gf = gf;
        this.tw = tw;
    }

    // ---------------------------------

    @Override
    public void actionPerformed(ActionEvent e) {
        showInfoPopup();
    }

    public void listUp() {

    }

    public void showInfoPopup() {

        // 경식------------------------------

        ids = file.list();
        if (ids == null) {
            System.out.println("아무것도 없어요");
            return;
        }

        for (String id : ids) {
            pir = new PetInfoReader();
            PetClone petClone = pir.getPetClone(id);
            if(petClone == null){
                System.out.println(id + "의 펫 정보를 불러오지 못했습니다.");
                continue;
            }
            list.add(petClone);
        }

        // ------------------------------------
        int sizX = GameInstance.getInstance().gameFrameSizX;
        int sizY = GameInstance.getInstance().gameFrameSizY;

        Frame dialog = new Frame();
        dialog.setBounds(
                GameInstance.getInstance().WINFRAME_W / 2 - sizX / 2,
                GameInstance.getInstance().WINFRAME_Y / 2 - sizY / 2, sizX, sizY);

        dialog.setLayout(null);
        labels = new Label[list.size()][2];
        start = new Button[list.size()];
        delet = new Button[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int index = i;
            start[i] = new Button("시작");
            delet[i] = new Button("삭제");
            start[i].setBounds(400,50+150*i,50,50);
            delet[i].setBounds(400,100+150*i,50,50);
            start[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tw.removeAll();
                GameWorld newWorld = new GameWorld(gf, list.get(index)); 
                gf.add(newWorld);
                gf.remove(tw);

                gf.revalidate();
                gf.repaint();

            }
            });
            dialog.add(start[i]);
            dialog.add(delet[i]);
            for (int j = 0; j < 2; j++) {
                labels[i][j] = new Label();
                labels[i][j].setBounds(150, 50 + 150 * i + 50 * j, 180, 50);
                switch (j) {
                    case 0:
                        labels[i][j].setText("name : " + list.get(i).getName());
                        break;
                    case 1:
                        labels[i][j].setText("saveTime : " + String.format("%s",list.get(i).getSaveDateTime()));
                        break;
                }
                dialog.add(labels[i][j]);
            }//inner

        }
        //------------------------------------

        Button closeBtn = new Button("닫기");

        closeBtn.setBounds(200, 600, 300, 40);

        // 닫기 버튼
        closeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        dialog.add(closeBtn);

        // 부모 프레임 가운데에 팝업 표시
        // dialog.setLocationRelativeTo(this);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.setVisible(true);
    }
}

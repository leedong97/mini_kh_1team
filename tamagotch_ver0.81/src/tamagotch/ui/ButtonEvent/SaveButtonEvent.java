package src.tamagotch.ui.ButtonEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.time.format.DateTimeFormatter;
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
    String[] ids;
    String path = "C:/kh_miniproject/user"; // + String input + "/pet.save";
    File file = new File(path);
    PetInfoReader pir;
    Label[][] labels;
    Button[] start;
    Button[] delet;
    GamFram gf;
    World tw;

    public SaveButtonEvent(GamFram gf, World tw) {
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
        List<PetClone> list = new ArrayList<>();

        // 경식------------------------------

        ids = file.list();
        if (ids == null) {
            System.out.println("아무것도 없어요");
            return;
        }

        for (String id : ids) {
            pir = new PetInfoReader();
            PetClone petClone = pir.getPetClone(id);
            if (petClone == null) {
                System.out.println(id + "의 펫 정보를 불러오지 못했습니다.");
                continue;
            }
            list.add(petClone);
        }

        // ------------------------------------
        int sizX = 400;
        int sizY = 480;

        Frame dialog = new Frame();
        dialog.setBounds(
                GameInstance.getInstance().WINFRAME_W / 2 - sizX / 2,
                GameInstance.getInstance().WINFRAME_Y / 2 - sizY / 2, sizX, sizY);

        dialog.setLayout(null);
        labels = new Label[list.size()][2];
        start = new Button[list.size()];
        delet = new Button[list.size()];
        ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);

        scrollPane.setBounds(20, 50, 350, 340);

        // 저장 슬롯 전체를 담는 Panel
        Panel panel = new Panel();

        panel.setLayout(null);

        // 펫 개수에 따라서 Panel 높이 결정
        int panelHeight = Math.max(340, list.size() * 110 + 20);

        panel.setPreferredSize(
                new Dimension(330, panelHeight));

        for (int j = 0; j < list.size(); j++) {
            int index = j;
            PetClone petClone = list.get(j);           
            Panel savePanel = new Panel() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);

                    g.drawRect(
                            0,
                            0,
                            getWidth() - 1,
                            getHeight() - 1);
                }
            };

            savePanel.setLayout(null);

            savePanel.setBounds(
                    10, 10 + (j * 100),300,90);


            Label name = new Label("펫 이름 : " + petClone.getName());

            name.setBounds(10,10,170,30);

            Label savedTime = new Label();  

            if (petClone.getSaveDateTime() != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                        "yyyy-MM-dd HH:mm:ss");

                        savedTime.setText(
                            "저장시간 : " + petClone.getSaveDateTime());

            } else {

                savedTime.setText("저장시간 : 없음");
            }

            savedTime.setBounds(
                    10,
                    40,
                    180,
                    30);

            Button startBtn = new Button("시작");

            startBtn.setBounds(
                    200,
                    10,
                    80,
                    30);

            startBtn.addActionListener(
                    new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            

                            GameWorld newWorld = new GameWorld(gf, petClone);

                            gf.getContentPane().removeAll();
                            gf.getContentPane().add(newWorld);
                            gf.revalidate();
                            gf.repaint();
                            dialog.dispose();
                        }
                    });

            Button deleteBtn = new Button("삭제");

            deleteBtn.setBounds(
                    200,
                    45,
                    80,
                    30);

            deleteBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 경식 추가----------------------------------------
                    PetInfoDelete pid = new PetInfoDelete(list.get(index));
                    pid.petDelete();
                    dialog.dispose(); // 현재 팝업 닫기
                    
                    // 다시 열기 전에 list를 비워야 데이터가 중복으로 쌓이지 않음!
                    list.clear();
                    showInfoPopup(); // 갱신된 목록으로 다시 열기
                }});

            savePanel.add(name);
            savePanel.add(savedTime);
            savePanel.add(startBtn);
            savePanel.add(deleteBtn);
            panel.add(savePanel);
        }

        scrollPane.add(panel);
        dialog.add(scrollPane);
        Button closeBtn = new Button("닫기");

        closeBtn.setBounds(150,400,100, 35);

        closeBtn.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        dialog.dispose();
                    }
                });

        dialog.add(closeBtn);
    
        dialog.addWindowListener(
                new WindowAdapter() {

                    @Override
                    public void windowClosing(
                            WindowEvent e) {

                        dialog.dispose();
                    }
                });

        dialog.setVisible(true);
    }
}
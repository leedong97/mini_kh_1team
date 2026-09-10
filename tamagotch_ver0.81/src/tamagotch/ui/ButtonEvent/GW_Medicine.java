package src.tamagotch.ui.ButtonEvent;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import src.tamagotch.ui.ButtonEvent.btnE_Core.BtnECore;

public class GW_Medicine extends BtnECore{
    private int clickindex = 0;
    private int r;
    private Thread tr;
    private boolean trb = true;

    private Button lbtn;
    private Button cbtn;
    private Button rbtn;
    private JFrame frame;
    private JLabel body;
    
    ImageIcon img01 = setIcon("src/tamagotch/img/chamcahmimg/01.png",100);
    ImageIcon img02 = setIcon("src/tamagotch/img/chamcahmimg/02.png",100);
    ImageIcon img03 = setIcon("src/tamagotch/img/chamcahmimg/03.png",100);
    ImageIcon img04 = setIcon("src/tamagotch/img/chamcahmimg/04.png",100);
    @Override
    public void btnEvent() {
        frame = setFrame();
        setGame();
    }

    public void setGame(){
        trb = true;
        frame.getContentPane().setBackground(Color.WHITE);
        JLabel title = spawnJLabel("약을 먹여라!");
        title.setFont(new Font("",Font.BOLD,30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        body = new JLabel(img03);
        body.setBounds(120,100,100,100);
        frame.add(body);
        setGameButton();
        setJLabelUI(frame,20);
        frame.setVisible(true);
        setTread(body);
    }
    
    private void gameresult(){
        Random rand = new Random();
        r = rand.nextInt(3);
        JLabel label = new JLabel();
        if(r == clickindex){
            label.setText(pet.getName()+"에게 약을 먹였다!");
            pet.stress -= 30;
            if(pet.stressC != null){
                pet.stressC.accept(pet.stress);
            }
            pet.health += 50;
            if(pet.healthC != null){
                pet.healthC.accept(pet.health);
            }
        }else{
            label.setText(pet.getName() + "이(가) 피했습니다.");
        }

        if(r == 0){
            body.setIcon(img02);
        } else{
            body.setIcon(img01);
        }

        tr.interrupt();
        trb = false;

        frame.remove(lbtn);
        frame.remove(cbtn);
        frame.remove(rbtn);

        Button regamebtn = new Button("다시하기");
        regamebtn.setBounds(70,240,200,50);
        frame.add(regamebtn);

        label.setBounds(70,290,200,50);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label);

        frame.revalidate();
        frame.repaint();

        regamebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                labellist.clear();
                frame.revalidate();
                frame.repaint();
                setGame();
            }
        });
    }

    public ImageIcon setIcon(String path, int size){
        ImageIcon img = new ImageIcon(path);
        Image oimg = img.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
        return new ImageIcon(oimg);
    }

    public void setGameButton(){
        lbtn = new Button("왼쪽");
        cbtn = new Button("가운데");
        rbtn = new Button("오른쪽");

        lbtn.setBounds(60, 240, 70, 50);
        cbtn.setBounds(140, 240, 70, 50);
        rbtn.setBounds(220, 240, 70, 50);

        frame.add(lbtn);
        frame.add(cbtn);
        frame.add(rbtn);

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

    public void setTread(JLabel body){
        tr = new Thread(){
            ImageIcon[] imges = new ImageIcon[2];
            public void run() {
                imges[0] = img03;
                imges[1] = img04;
                int indx = 0;
                while(trb){
                    try {
                        sleep(1000/4);
                        body.setIcon(imges[indx%2]);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    indx++;
                }
            };
        };

        tr.setDaemon(true);
        tr.start();
    }
}

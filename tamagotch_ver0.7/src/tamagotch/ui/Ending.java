package src.tamagotch.ui;


import java.awt.*;
import java.awt.event.WindowAdapter;

public class Ending extends Panel {
    public static void setPanel() {
        Frame f = new Frame();
        f.setBounds(500, 300, 600, 600);
        f.setBackground(Color.BLACK);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                f.dispose();
            }
        });

        Ending ep = new Ending();
        ep.setBackground(Color.BLACK);
        ep.setBounds(0, 500, 600, 1800);

        f.setLayout(null);
        f.add(ep);
        f.setVisible(true);
        ep.ts.start();

    }

    // INSERT_YOUR_CODE
    @Override
    public void paint(Graphics g) {

        g.setColor(Color.WHITE);

        String[] credits = {
                "TAMAGOTCHI",
                "ENDING CREDIT",
                "",
                "",
                "TEAM MEMBERS",
                "",
                "팀원1",
                "팀원2",
                "팀원3",
                "팀원4",
                "팀원5",
                "팀원6",
                "",
                "",
                "DEVELOPMENT",
                "",
                "GAME SYSTEM",
                "팀원1",
                "",
                "GAME SYSTEM 2",
                "팀원2",
                "",
                "GAME SYSTEM 3",
                "팀원3",
                "",
                "GAME SYSTEM 4",
                "팀원4",
                "",
                "GAME SYSTEM 5",
                "팀원5",
                "",
                "GAME SYSTEM 6",
                "팀원6",
                "",
                "",
                "",
                "",
                "",
                "",
                "",               
                "",               
                "",               
                "",               
                "",               
                "",               
                "",               
                "THANK YOU FOR PLAYING"

        };

        int y = 100;

        for (int i = 0; i < credits.length; i++) {
            g.setFont(new Font("", Font.ITALIC, 15));
            y += 30;
            if (credits[i].equals("TAMAGOTCHI")) {
                g.setFont(new Font("", Font.ITALIC, 20));
            } else if (credits[i].equals("ENDING CREDIT")) {
                g.setFont(new Font("", Font.ITALIC, 20));
            } else if (credits[i].equals("TEAM MEMBERS")) {
                g.setFont(new Font("", Font.ITALIC, 20));
            } else if (credits[i].equals("DEVELOPMENT")) {
                g.setFont(new Font("", Font.ITALIC, 20));
            } else if (credits[i].equals("THANK YOU FOR PLAYING")) {
                g.setFont(new Font("", Font.ITALIC, 20));
            } else if (credits[i].equals("GAME SYSTEM")
                    || credits[i].equals("GAME SYSTEM 2")
                    || credits[i].equals("GAME SYSTEM 3")
                    || credits[i].equals("GAME SYSTEM 4")
                    || credits[i].equals("GAME SYSTEM 5")
                    || credits[i].equals("GAME SYSTEM 6")) {
                g.setFont(new Font("", Font.ITALIC, 17));
            } else {
                g.setFont(new Font("", Font.ITALIC, 15));
            }
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(credits[i]);
            g.drawString(credits[i], 300 - textWidth / 2, y);

        }
    }

    Thread ts = new Thread() {
        @Override
        public void run() {

            int y = 500;
            while (y > -1200) {
                y--;
                setLocation(0, y);
                try {
                    Thread.sleep(5);
                } catch (Exception e) {

                }
            }

        }
    };
}

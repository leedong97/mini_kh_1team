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
            "ENDING CREDITS",
            "",
            "",
            "TEAM MEMBERS",
            "",
            "",
            "King Sik",
            "",
            "Lee Dong Hyeob",
            "",
            "Seon Seok Min",
            "",
            "Woo Gyeong Sik",
            "",
            "Kim Min Seo",
            "",
            "Lee na one",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "MADE WITH",
            "JAVA",
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
            "SPECIAL THANKS",
            "♥Jeong Yong hoon♥",
            "",
            "",
            "",
            "",
            "THANK YOU",
            "FOR PLAYING",
            "",
            "- THE END -",
            ""
        };

        int y = 100;

        for (int i = 0; i < credits.length; i++) {
            y += 30;
            if (i == 0) {
                g.setFont(new Font("", Font.ITALIC, 20));
            } else if (i == 1) {
                g.setFont(new Font("", Font.ITALIC, 20));
            } else if (i >= 2) {
                g.setFont(new Font("", Font.ITALIC, 20));
            } else if (i >= 5 ) {
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

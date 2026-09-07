import java.awt.*;
import java.awt.event.WindowAdapter;

public class EndingPanel extends Panel {
    public static void main(String[] args) {
        Frame f = new Frame();

        f.setBounds(500, 400, 300, 500);
        f.setBackground(Color.BLACK);
        f.setLayout(null);

        Font font = new Font("", Font.ITALIC, 20);
        
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {

                System.exit(0);
            }
        });

    }

}

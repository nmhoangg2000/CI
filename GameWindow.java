import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isRightPress;
    public static boolean isLeftPress;

    public GameWindow(){
        //bat su kien bam phim
        KeyAdapter keyHandler = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){
                    isUpPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_W){
                    isUpPress = false;
                }
                if(e.getKeyCode()== KeyEvent.VK_S){
                    isDownPress = false;
                }
                if(e.getKeyCode()== KeyEvent.VK_A){
                    isLeftPress = false;
                }
                if(e.getKeyCode()== KeyEvent.VK_D){
                    isRightPress = false;
                }
            }
        };
        addKeyListener(keyHandler);
    }
}

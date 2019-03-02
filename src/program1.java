import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class program1 {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
//        window.setSize(800, 600);
        window.setTitle("Game Touhou");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(800, 600));
        panel.setBackground(Color.CYAN);

        window.add(panel);
        window.pack();

        window.setVisible(true);

        panel.gameLoop();


//    ArrayList<String> strings = new ArrayList<>();
        //strings.add(): // them phan tu vao mang
        //strings.get(): //lay ra phan tu o index truyen vao
        //strings.size(: // lay ra kick thuoc mang
//        ArrayList<Vector2D> vectors = new ArrayList<>();
//        vectors.add(new Vector2D(1,1));
//        vectors.add(new Vector2D(3,7));
//        vectors.add(new Vector2D(3,1));
//        Vector2D maxLengthVector = null;
//        double maxLength= 0;
//        for (int i = 0; i< vectors.size(); i++){
//            Vector2D vector = vectors.get(i);
//            if(vector.getLength() > maxLength){
//                maxLengthVector = vector;
//                maxLength = vector.getLength();
//            }
//        }
//        System.out.println(maxLengthVector.x + "" + maxLengthVector.y);
    }
}



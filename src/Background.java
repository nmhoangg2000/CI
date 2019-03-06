import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    BufferedImage backgroundImage;

    Vector2D backgroundPosition;

    public Background(){
        backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
        backgroundPosition = new Vector2D(0, 600 - 3019);
    }
    public void render(Graphics g){
        g.drawImage(backgroundImage, (int) backgroundPosition.x, (int) backgroundPosition.y, null);
    }
    public void run(){
        backgroundMove();
    }
    private void backgroundMove(){
        backgroundPosition.add(0, 10);
        if (backgroundPosition.y > 0) {
//            backgroundPosition.y = 0
            backgroundPosition.set(backgroundPosition.x, 0);
        }
    }
}

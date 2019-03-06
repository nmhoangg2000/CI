import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class Enemy {
    BufferedImage image;
    Vector2D postion;
    Vector2D velocity;

    public Enemy() {
        image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        postion = new Vector2D();
        velocity = new Vector2D(0,3);
    }

    public void render(Graphics g) {
        g.drawImage(image, (int) postion.x, (int) postion.y, null);
    }

    public void run() {
        postion.add(velocity.x, velocity.y);
        changeDirection();
    }

    private void changeDirection() {
        if (postion.x > 384 - 28 && velocity.x > 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if (postion.x < 0 && velocity.x < 0) {
            velocity.set(-velocity.x, velocity.y);
        }
    }
}

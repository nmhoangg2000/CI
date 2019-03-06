import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerUlti{
    BufferedImage R;
    Vector2D position;
    Vector2D velocity;

    public PlayerUlti() {
        R = SpriteUtils.loadImage("assets/images/sphere/1.png");
        position = new Vector2D();
        velocity = new Vector2D(1, -5);
    }

    public void render(Graphics g) {
        g.drawImage(R, (int) position.x, (int) position.y, null);
    }

    public void run(){
        position.add(velocity.x, velocity.y);
        changeDirection();
    }

    private void changeDirection() {
        if (position.x > 384 - 28 && velocity.x > 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if (position.x < 0 && velocity.x < 0) {
            velocity.set(-velocity.x, velocity.y);
        }
    }
}

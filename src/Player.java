
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    BufferedImage image;
    Vector2D Position;
    ArrayList<PlayerBullet>bullets;
    ArrayList<PlayerUlti> ulti;
    Vector2D velocity;

    public Player(){
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        Position = new Vector2D(100, 100);
        bullets = new ArrayList<>();
        ulti = new ArrayList<>();
        velocity = new Vector2D(0,2);
    }
    public void render(Graphics g){
        g.drawImage(image, (int) Position.x, (int) Position.y, null);
//        for (int i = 0; i < bulletPositions.size(); i++) {
//            Vector2D bulletPosition = bulletPositions.get(i);
//            g.drawImage(bulletImage, (int) bulletPosition.x, (int) bulletPosition.y, null);
//        }
        for (int i =0; i <bullets.size();i++){
            PlayerBullet bullet = bullets.get(i);
            bullet.render(g);
        }
        for (int i = 0; i < ulti.size(); i++) {
            PlayerUlti R = ulti.get(i);
            R.render(g);
        }
    }
    public void run(){
        Move();
        Limit();
        Fire();
        Run();
        ultiRun();

    }
    private void Move(){
        int playerSpeed = 3;
        int vx = 0;
        int vy = 0;
        if (GameWindow.isUpPress) {
            vy -= playerSpeed;
        }
        if (GameWindow.isDownPress) {
            vy += playerSpeed;
        }
        if (GameWindow.isLeftPress) {
            vx -= playerSpeed;
        }
        if (GameWindow.isRightPress) {
            vx += playerSpeed;
        }


        Position.add(vx,vy);
    }
    private void Limit() {
        if (Position.x < 0) {
            Position.set(0, Position.y);
        }
        if (Position.x > 384 - image.getWidth()) {
            Position.set(384 - image.getWidth(), Position.y);
        }
        if (Position.y < 0) {
            Position.set(Position.x, 0);
        }
        if (Position.y > 600 - image.getHeight()) {
            Position.set(Position.x, 600 - image.getHeight());
        }
    }
    int fireCount;
    int loading;
    private void Fire(){
        fireCount++;
        loading++;
        if(GameWindow.isFirePress && fireCount > 20){
            for (int i = 0; i < 20; i++) {
                PlayerBullet bullet = new PlayerBullet();
                bullet.position.set(Position.x, Position.y);
                bullet.velocity.setAngle(-Math.PI / 3 - i * (Math.PI / 60));
                bullets.add(bullet);
            }
//            PlayerBullet bullet2 = new PlayerBullet();
//            bullet2.position.set(Position.x, Position.y);
//            bullet2.velocity.setAngle(-Math.PI / 3);
//            bullets.add(bullet2);
//
//            PlayerBullet bullet3 = new PlayerBullet();
//            bullet3.position.set(Position.x, Position.y);
//            bullet3.velocity.setAngle(-2 * Math.PI / 3);
//            bullets.add(bullet3);
            fireCount = 0;
        }
        if(loading > 80) {
            for (int i = 0; i < 9; i++) {
                PlayerUlti R = new PlayerUlti();
                R.position.set(Position.x, Position.y);
                R.velocity.setAngle(- 2 * Math.PI/5 - ( i * Math.PI / 4.5));
                ulti.add(R);
            }
            loading = 0;
        }
    }
    private void Run(){
//
        for (int i = 0; i < bullets.size();i++){
            PlayerBullet bullet = bullets.get(i);
            bullet.run();
        }
    }
    private void ultiRun() {
        for (int i = 0; i < ulti.size(); i++) {
            PlayerUlti R = ulti.get(i);
            R.run();
        }
    }
}

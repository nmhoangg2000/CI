package game.enemy;

import game.GameObject;
import game.Setting;
import tklibs.SpriteUtils;

import java.awt.*;
import java.util.ArrayList;

public class Enemy extends GameObject {
    ArrayList<EnemyBullet> enemyBullets;

    public Enemy() {
        image = SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png");
        velocity.set(0, 3);
        enemyBullets = new ArrayList<>();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

        for (int i = 0; i < enemyBullets.size(); i++) {
            EnemyBullet enemyBullet = enemyBullets.get(i);
            enemyBullet.render(g);
        }
    }

    @Override
    public void run() {
        super.run();
        changeDirection();
        autoFire();
        bulletRun();
    }

    public void bulletRun() {
        for (int i = 0; i < enemyBullets.size(); i++) {
            EnemyBullet enemyBullet = enemyBullets.get(i);
            enemyBullet.run();
        }
    }

    int fireCount;

    public void autoFire() {
        fireCount++;
        if (fireCount > 100) {
            EnemyBullet bullet = new EnemyBullet();
            bullet.position.set(position);
            enemyBullets.add(bullet);
            fireCount=0;
        }
    }

    private void changeDirection() {
        if (position.x > Setting.BACKGROUND_WIDTH - 28 && velocity.x > 0) {
            velocity.set(-velocity.x, velocity.y);
        }
        if (position.x < 0 && velocity.x < 0) {
            velocity.set(-velocity.x, velocity.y);
        }
    }
}

package game.player;

import game.GameObject;
import game.Renderer;
import game.enemy.Enemy;
import game.physics.BoxCollider;

public class PlayerBullet extends GameObject {
    int count;
    int damage;

    public PlayerBullet() {
        renderer = new Renderer("assets/images/player-bullets/a");
        velocity.set(0, -5);
        count = 0;
        hitBox = new BoxCollider(this, 24, 24);
        damage = 1;
    }

    @Override
    public void run() {
        super.run();
        checkDeactiveIfNeeded();
        checkIntersects();
    }

    private void checkIntersects() {
        Enemy enemy = GameObject.findIntersects(Enemy.class
                , this);
        if(enemy != null) {
            this.deactive();
//            enemy.deactive();
            enemy.takeDamage(damage);
        }
    }

    private void checkDeactiveIfNeeded() {
        if(this.position.y < -30) {
            this.deactive();
        }
    }
}
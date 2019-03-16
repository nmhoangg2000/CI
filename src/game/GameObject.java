package game;

import game.physics.BoxCollider;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Objects;

public class GameObject {
    // Quan li doi tuong
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject> E recycle(Class<E> cls){
        E result = null;
        //1. tìm kiếm phần tử bị deactive > reset > return

        //2. neu ko tim thay > tao moi > return
        for (int i = 0; i <objects.size();i++){
            GameObject object = objects.get(i);
            if(!object.active && object.getClass().isAssignableFrom(cls)){
                result = (E) object;
                break;
            }
        }
        if(result != null){
            result.reset();
            return result;
        }
        //2 neu ko tim thay > tao moi > return
        try {
            // cls = PlayerBullet.class
            result = cls.getConstructor().newInstance(); // result = new PlayerBullet()
            return result;

        } catch (Exception e) {
            return null;
        }
    }


    // find
    public static <E extends GameObject> E find(Class<E> cls) {
        // luot qua mang objects
        // kiem tra tung phan tu
        // neu phan tu thoa man >> return
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.getClass().isAssignableFrom(cls) && object.active) {
                return (E) object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E findIntersects(Class<E> cls, GameObject source){
        for (int i =0; i < objects.size(); i++){
            GameObject object = objects.get(i);
            if (object.getClass().isAssignableFrom(cls)&& object.active && object.intersects(source)){
                return (E) object;
            }
        }
        return null;
    }

    // Dinh nghia doi tuong
//    public BufferedImage image;
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public Vector2D anchor;
    public boolean active;
    public BoxCollider hitBox;



    public GameObject() {
        objects.add(this);
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.anchor = new Vector2D(0.5,0.5);
        this.active = true;
    }

    public void render(Graphics g) {
        if (renderer != null){
            renderer.render(g,this);
        }
    }

    public void run() {
        position.add(velocity.x, velocity.y);
    }

    public void deactive(){
        active = false;
    }

    public void reset(){
        active = true;
    }

    public boolean intersects(GameObject other){
        if(this.hitBox != null && other.hitBox != null){
            return this.hitBox.intersects(other.hitBox);
        }
        return false;
    }
}
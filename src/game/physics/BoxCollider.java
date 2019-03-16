package game.physics;

import game.GameObject;
import game.Rectangle;
import game.Vector2D;

public class BoxCollider {
    public Vector2D anchor;
    public Vector2D position;
    public int width;
    public int height;

    public BoxCollider(GameObject master, int width, int height){
        this.position = master.position;
        this.anchor = master.anchor;
        this.width = width;
        this.height = height;

    }
    public double top(){
        return this.position.y - this.anchor.y * this.height;
    }
    public double bot(){
        return this.top() + this.height;
    }
    public double left(){
        return this.position.x - this.anchor.x * this.width;
    }
    public double right(){
        return this.left() + this.width;
    }

    public boolean intersects(BoxCollider other){
        //kiem tra 2 hcn this vs other
        return other.right() > this.left() && other.left() <= this.right() && other.top() <= this.bot() && other.bot() >= this.top();
    }
}

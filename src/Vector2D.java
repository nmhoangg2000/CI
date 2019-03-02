public class Vector2D {
    public double x;
    public double y;

    public Vector2D() {
        this(0,0);
    }
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void add(double x, double y){
        this.x += x;
        this.y += y;
    }

    public void subtract(double x, double y){
        this.x -= x;
        this.y -= y;
    }

    public void scale(double rate){
        this.x *= rate;
        this.y *= rate;
    }

    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector2D clone(){
        return new Vector2D(this.x, this.y);
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }
    public void setLength(double length) {
        double currentLength = this.getLength();
        if(currentLength != 0) {
            this.x = this.y * length / currentLength;
            this.y = this.y * length / currentLength;
        }
    }

    public double getAngle(){
        return Math.atan(y / x);
    }

    public void setAngle(double angle) {
        double length = this.getLength();
        if(length != 0){
            this.x = length * Math.cos(angle);
            this.y = length * Math.sin(angle);
        }
    }

    public  static void main(String[] args){
        Vector2D v1 = new Vector2D(2,2);
        System.out.println(v1.getLength() + "" + (2*Math.sqrt(2)));
        System.out.println(v1.getAngle() + " " + (Math.PI/4));
        v1.setLength(5);
        System.out.println(v1.getLength() + " " + 5);
        v1.setAngle(Math.PI/6);
        System.out.println(v1.getAngle() + "" + (Math.PI/6));
    }


}



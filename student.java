public class student {
    // thuoc tinh
    String name;
    int id;
    String birthdate;
    String classroom;

    //hàm tạo
    public student() {
        name= "John";
        id = 1;
        birthdate = "28/03/95";
        classroom= "KTPM";
    }
    public student(String name, int id, String birthdate, String classroom) {
        this.name = name;
        this.id = id;
        this.birthdate = birthdate;
        this.classroom = classroom;
    }
    //phương thức
    public void eat() {
        System.out.println("Eating..");
    }
    public  void learn() {
        System.out.println("Learning..");
    }
}

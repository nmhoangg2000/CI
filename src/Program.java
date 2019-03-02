import java.io.OutputStream;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        student student1 = new student();
        System.out.println(student1.name);
        student student2 = new student( "Nam", 2,"21/01/91", "KTDH" );
        System.out.println(student2.name);




    }
}

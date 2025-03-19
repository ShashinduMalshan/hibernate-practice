import com.assignment.service.config.FactoryConfiguration;
import com.assignment.service.entity.Laptop;
import com.assignment.service.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Laptop laptop1 = new Laptop();
        laptop1.setLid(1);
        laptop1.setName("Del");

        Laptop laptop2 = new Laptop();
        laptop2.setLid(2);
        laptop2.setName("Hp");

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("kamal");
        student1.setAddress("colombo");

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("manula");
        student2.setAddress("galle");

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(laptop1);
        laptops.add(laptop2);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        laptop1.setStudents(students);
        laptop2.setStudents(students);
        student1.setLaptops(laptops);
        student2.setLaptops(laptops);

        session.persist(laptop1);
        session.persist(laptop2);
        session.persist(student1);
        session.persist(student2);



        transaction.commit();
        session.close();
    }
}

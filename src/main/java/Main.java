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
        laptop1.setName("Asus");

        Laptop laptop2 = new Laptop();
        laptop2.setLid(2);
        laptop2.setName("Mac");

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(laptop1);
        laptops.add(laptop2);

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("kamal");
        student1.setAddress("Colombo");
        student1.setLaptop(laptops);

        laptop1.setStudent(student1);
        laptop2.setStudent(student1);


        session.persist(laptop1);
        session.persist(laptop2);
        session.persist(student1);



        transaction.commit();
        session.close();
    }
}

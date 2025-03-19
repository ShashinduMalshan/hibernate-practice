import com.assignment.service.config.FactoryConfiguration;
import com.assignment.service.entity.Laptop;
import com.assignment.service.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        Laptop laptop = new Laptop();
        laptop.setLid(2);
        laptop.setName("samgsung");

        Student student = new Student();
        student.setId(2);
        student.setName("jeon");
        student.setAddress("panadura");
        student.setLaptop(laptop);


        // session.save(student);
        // session.update(student);
//        Student student =session.get(Student.class,1);
//        System.out.println(student.getName());

        session.persist(student);
        session.persist(laptop);


        transaction.commit();
        session.close();
    }
}

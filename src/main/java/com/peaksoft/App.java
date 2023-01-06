package com.peaksoft;

import com.peaksoft.entity.*;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee employee = new Employee("Bektur", "Ismanaliev", 25);
        Passport passport = new Passport();
        passport.setINN("FGDFG5+56+");
        Animal animal = new Animal("Cat",2);
        Transport transport = new Transport();
        transport.setName("car");
        employee.setTransport(transport);
        employee.setAnimal(animal);
        employee.setPassport(passport);

        Employee employee1 = new Employee("Aidai", "Mamatbekove", 18);
        Passport passport1= new Passport();
        passport1.setINN("dfasf564");
        Animal animal1 = new Animal("Dog", 5);
        Transport transport1 = new Transport();
        transport1.setName("Bus");
        employee1.setTransport(transport1);
        employee1.setPassport(passport1);
        employee1.setAnimal(animal1);


        Company company = new Company();
        company.setName("Google");
        company.addEmployeeToCompany(employee);
        company.addEmployeeToCompany(employee1);
        Transport transport2 = new Transport();
        transport2.setName("Bus");
        company.addTransportToCompany(transport2);

        Course course = new Course();
        course.setName("Java");

        Course course1 = new Course();
        course1.setName("English");

        List<Course> courses = new ArrayList<>();
        courses.add(course);
        courses.add(course1);

        employee.setCourses(courses);

        Create(company);

//        System.out.println(read());
//       update( 9l  ,"Aza", "Musagaliev", 18);
        //delete(9l);
//        read();
    }
    public static Long Create (Company c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(c);
        session.getTransaction().commit();
        session.close();
        return c.getId();
    }
    public static List<Employee> read(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery
                ("FROM Employee WHERE firstName = 'Aza' OR age > 20 ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + employees.size() + " employees");
        return employees;
    }
    public static void update( Long id, String firstName, String lastName, int age){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        session.update(employee);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully update");
    }
    public static void delete (Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction();
        Employee employee = session.get(Employee.class, id);
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted" + employee);
    }

}

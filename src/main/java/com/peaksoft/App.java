package com.peaksoft;

import com.peaksoft.entity.Employee;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee employee = new Employee();
        employee.setFirstName("Rayan");
        employee.setLastName("Garsiya");
        employee.setAge(24);
//        Create(employee);
//        System.out.println(read());
       update( 9l  ,"Aza", "Musagaliev", 18);
        //delete(9l);
//        read();
    }
    public static Long Create (Employee e){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        return e.getId();
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

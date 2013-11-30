/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

/**
 *
 * @author TATARAO
 */
import java.util.Iterator;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Client {
    
    public static void main(String[] args) {
        
        Session session=new Configuration().configure().buildSessionFactory().openSession();
    
        // Selecting complete object
  //       Query query=session.createQuery("from Employee e");
         
  //     selecting records based on salary
         
       Query query=session.createQuery("from Employee e where e.salary>:fa");
        query.setParameter("fa", new String("18000")); 
  
         
        List l=query.list();
        Iterator itr=l.iterator();
        
        while(itr.hasNext())
        {
   /*         Object r[]=(Object[])itr.next();
            System.out.println(r[0]+" "+r[1]); 
             
            Here i write this code becoz when i retrieve partial columns from DB it is showing error. so i type cast this into OBJect
   */
              Employee emp =(Employee)itr.next();
              System.out.println(emp.getEid()+" "+emp.getEname()+" "+emp.getSalary()); 
        }
        
        session.close();
    }
    
}

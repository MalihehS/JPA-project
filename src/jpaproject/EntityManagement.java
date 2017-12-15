package jpaproject;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntityManagement {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProjectPU");

    public EntityManagement() {

    }

    public void addCustomer(Customers cus) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(cus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

    }

    public void findByName(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("Select e FROM Customers e where e.customerName= :cname");

        q.setParameter("cname", name);
        List<Customers> cs = (List<Customers>) q.getResultList();

        for (Customers customers : cs) {
            System.out.println(customers);

        }

        em.getTransaction().commit();

    }

    public void findByCountry(String country) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("Select e FROM Customers e where e.country= :cname");
        q.setParameter("cname", country);
        List<Customers> cs = (List<Customers>) q.getResultList();

        for (Customers customers : cs) {
            System.out.println(customers);

        }

        em.getTransaction().commit();

    }

    public void findMaxCreditLimit() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("Select MAX(e.creditLimit) FROM Customers e");
        BigDecimal result = (BigDecimal) q.getSingleResult();
        System.out.println("Maximum of the credit limit is " + result);
        em.getTransaction().commit();
        em.close();

    }

    public void findMinCreditLimit() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select min(e.creditLimit) from Customers e");
        BigDecimal result = (BigDecimal) q.getSingleResult();
        System.out.println("Minimum creditLimit is " + result);
        em.getTransaction().commit();
        em.close();

    }

    public Double findAvgCreditLimit() {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Query q = em.createQuery("select AVG(e.creditLimit) from Customers e");
        Double result = (Double) q.getSingleResult();
        em.getTransaction().commit();
        em.close();
        
        return result;

    }

    public void NumberOfMembers() {

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT COUNT(a) FROM Customers a");
        long result = (long) q.getSingleResult();
        System.out.println("Number of members are :" + result);

        em.close();

    }

    public void deleteMember(int customerNumber) {

        EntityManager em = emf.createEntityManager();
        Customers c = em.find(Customers.class, customerNumber);

        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();

        em.close();

    }

    public void showAll() {

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select(a)from Customers a");
        List<Customers> c = q.getResultList();
        for (Customers customers : c) {
            System.out.println(customers);

        }
        em.close();
    }

    public void uppdate(int customerNumber, String newPhone) {
       
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customers c = em.find(Customers.class, customerNumber);
        c.setPhone(newPhone);
        em.getTransaction().commit();
        em.close();
     
       

    }
}

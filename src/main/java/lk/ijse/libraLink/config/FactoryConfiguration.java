/*
 * Author  : Mr.electrix
 * Project : hibernateMapping
 * Date    : 2/2/24

 */

package lk.ijse.libraLink.config;

import lk.ijse.libraLink.entity.Book;
import lk.ijse.libraLink.entity.Branch;
import lk.ijse.libraLink.entity.Transactions;
import lk.ijse.libraLink.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class).addAnnotatedClass(Branch.class).addAnnotatedClass(Transactions.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration==null)?factoryConfiguration=new FactoryConfiguration():factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}

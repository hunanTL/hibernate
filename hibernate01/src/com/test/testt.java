package com.test;

import com.tanlei.CstCustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import sun.applet.Main;

import java.io.Serializable;

/**
 * @author <a href="mailto:lei.tan@vtradex.net">谭磊/a>
 * @since 2019-10-22 14:13
 */
public class testt {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure();

        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        CstCustomerEntity c=new CstCustomerEntity();
        c.setCustName("谭磊");
        Serializable id=session.save(c);
        CstCustomerEntity cc=session.get(CstCustomerEntity.class, id);
        System.out.println(cc.toString());
        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}

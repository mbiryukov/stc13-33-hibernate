package ru.innopolis.stc13.hibernate.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc13.hibernate.db.entities.MobilePhone;

@Repository
public class MobilePhoneDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public MobilePhoneDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public MobilePhone getPhoneById(long id) {
        Session session = sessionFactory.openSession();
        MobilePhone mobilePhone = session.get(MobilePhone.class, id);
        session.close();
        return mobilePhone;
    }

    public void addPhone(MobilePhone mobilePhone) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(mobilePhone);
        mobilePhone.setCost(30000);
        session.getTransaction().commit();
        session.close();
    }

    public void updatePhone(MobilePhone mobilePhone) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(mobilePhone);
        session.getTransaction().commit();
        session.close();
    }

    public void deletePhoneById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        MobilePhone phone = session.get(MobilePhone.class, id);
        session.delete(phone);
        session.getTransaction().commit();
        session.close();

    }
}

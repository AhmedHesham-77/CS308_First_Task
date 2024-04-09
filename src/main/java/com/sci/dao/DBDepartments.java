package com.sci.dao;

import com.sci.criteria.FilterQuery;
import com.sci.criteria.Operator;
import com.sci.models.COUNTRIES;
import com.sci.models.Departments;
import com.sci.models.Employee;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DBDepartments {
    public List<Departments> get() {
        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            return session.createQuery("FROM Departments ").list();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }


    public Departments get(Integer dep_id) {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            return session.get(Departments.class, dep_id);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    public Integer insert(Departments dep) {

        Transaction transaction = null;
        Integer depId = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            depId = (Integer) session.save(dep);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return depId;
    }

    public void update(Departments dep) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.update(dep);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

    public void delete(Integer dep_Id) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            Departments del_dep = get(dep_Id);

            session.delete(del_dep);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }
}

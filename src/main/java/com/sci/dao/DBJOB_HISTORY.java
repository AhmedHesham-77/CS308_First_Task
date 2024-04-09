package com.sci.dao;

import com.sci.criteria.FilterQuery;
import com.sci.criteria.Operator;
import com.sci.models.COUNTRIES;
import com.sci.models.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.sci.models.Job_History;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class DBJOB_HISTORY {
    public List<Job_History> get() {
        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            return session.createQuery("FROM Job_History ").list();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }


    public List<Job_History> get(Integer employee_idd, String datee) {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            String queryString = "SELECT * FROM Job_History WHERE employee_id = :employee_idd AND to_char(start_date,'YYYY-MM-DD') = :datee";
            NativeQuery<Job_History> query = session.createNativeQuery(queryString, Job_History.class);
            query.setParameter("employee_idd", employee_idd);
            query.setParameter("datee", datee);
            return query.list();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    public void insert(Job_History History) {

        Transaction transaction = null;
//        Integer HistoryId = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.save(History);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

//        return HistoryId;
    }

    public void update(Job_History History) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.update(History);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

    public void delete(Integer employee_id, String start_date) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            List<Job_History> del_His = get(employee_id, start_date);

            for (Job_History jobHistory : del_His) {
                session.delete(jobHistory);
            }

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }
}

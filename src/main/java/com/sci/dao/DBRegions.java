package com.sci.dao;

import com.sci.criteria.FilterQuery;
import com.sci.criteria.Operator;
import com.sci.models.COUNTRIES;
import com.sci.models.Employee;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.sci.models.Jobs;
import com.sci.models.Regions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DBRegions {
    public List<Regions> get() {
        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            return session.createQuery("FROM Regions").list();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }


    public Regions get(Integer Region_id) {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            return session.get(Regions.class, Region_id);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    public Integer insert(Regions new_region) {

        Transaction transaction = null;
        Integer RegionId = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            RegionId = (Integer) session.save(new_region);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return RegionId;
    }

    public void update(Regions curr_region) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.update(curr_region);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

    public void delete(Integer RegionId) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            Regions del_region = get(RegionId);

            session.delete(del_region);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }
}

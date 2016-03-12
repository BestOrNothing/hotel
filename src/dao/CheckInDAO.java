package dao;

import java.util.Date;
import java.util.List;

import model.CheckIn;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CheckIn entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see model.CheckIn
 * @author MyEclipse Persistence Tools
 */
public class CheckInDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CheckInDAO.class);
	// property constants
	public static final String CUSTOMER1 = "customer1";
	public static final String CUSTOMER2 = "customer2";

	protected void initDao() {
		// do nothing
	}

	public void save(CheckIn transientInstance) {
		log.debug("saving CheckIn instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CheckIn persistentInstance) {
		log.debug("deleting CheckIn instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CheckIn findById(java.lang.String id) {
		log.debug("getting CheckIn instance with id: " + id);
		try {
			CheckIn instance = (CheckIn) getHibernateTemplate().get(
					"model.CheckIn", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CheckIn instance) {
		log.debug("finding CheckIn instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CheckIn instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CheckIn as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCustomer1(Object customer1) {
		return findByProperty(CUSTOMER1, customer1);
	}

	public List findByCustomer2(Object customer2) {
		return findByProperty(CUSTOMER2, customer2);
	}

	public List findAll() {
		log.debug("finding all CheckIn instances");
		try {
			String queryString = "from CheckIn";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CheckIn merge(CheckIn detachedInstance) {
		log.debug("merging CheckIn instance");
		try {
			CheckIn result = (CheckIn) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CheckIn instance) {
		log.debug("attaching dirty CheckIn instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CheckIn instance) {
		log.debug("attaching clean CheckIn instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CheckInDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CheckInDAO) ctx.getBean("CheckInDAO");
	}
}
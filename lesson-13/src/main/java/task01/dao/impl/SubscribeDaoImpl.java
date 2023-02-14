package task01.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import task01.dao.SubscribeDao;
import task01.domain.Subscribe;
import task01.shared.FactoryManager;

public class SubscribeDaoImpl implements SubscribeDao {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Subscribe create(Subscribe subscribe) {
		try {
			em.getTransaction().begin();
			em.persist(subscribe);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return subscribe;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subscribe> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Subscribe e");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return query.getResultList();
	}

	@Override
	public Subscribe read(Integer id) {
		Subscribe subscribe = null;
		try {
			subscribe = em.find(Subscribe.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return subscribe;
	}

	@Override
	public Subscribe update(Subscribe subscribe) {
		try {
			em.getTransaction().begin();
			em.merge(subscribe);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return subscribe;
	}

	@Override
	public void delete(Integer id) {
		try {
			Subscribe subscribe = read(id);
			em.getTransaction().begin();
			em.remove(subscribe);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
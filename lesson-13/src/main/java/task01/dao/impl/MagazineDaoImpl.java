package task01.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import task01.dao.MagazineDao;
import task01.domain.Magazine;
import task01.shared.FactoryManager;

public class MagazineDaoImpl implements MagazineDao {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Magazine create(Magazine magazine) {
		try {
			em.getTransaction().begin();
			em.persist(magazine);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return magazine;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Magazine> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Magazine e");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	public Magazine read(Integer id) {
		Magazine magazine = null;
		try {
			magazine = em.find(Magazine.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return magazine;
	}

	@Override
	public Magazine update(Magazine magazine) {
		try {
			// TODO: to be implemented
		} catch (Exception e) {
			e.printStackTrace();
		}

		return magazine;
	}

	@Override
	public void delete(Integer id) {
		try {
			// TODO: to be implemented
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
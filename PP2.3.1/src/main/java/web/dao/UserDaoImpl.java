package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> index() {
		return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	@Override
	public User show(long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void save(User user) {
		entityManager.persist(user);
	}

	@Override
	public void update(User personToBeUpdated) {
		entityManager.merge(personToBeUpdated);
	}

	@Override
	public void delete(long id) {
		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityManager.remove(user);
		}
	}

}
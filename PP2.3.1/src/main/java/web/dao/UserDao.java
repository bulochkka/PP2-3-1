package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
	public List<User> index();
	
	public User show(long id);
	
	public void save(User user);
	
	public void update(User personToBeUpdated);
	
	public void delete(long id);
}

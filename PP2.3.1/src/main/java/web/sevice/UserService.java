package web.sevice;

import web.model.User;

import java.util.List;

public interface UserService {
	List<User> index();
	
	User show(long id);
	
	void save(User user);
	
	void update(User personToBeUpdated);
	
	void delete(long id);
}

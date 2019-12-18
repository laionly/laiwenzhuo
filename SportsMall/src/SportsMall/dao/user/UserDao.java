package SportsMall.dao.user;

import java.util.List;

import SportsMall.entity.User;

public interface UserDao {
	public List<User> viewUser(int id);
	public List<User> listUser();
	public User selectUser(int id);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
	public User login(String username,String password);
}

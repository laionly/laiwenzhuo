package SportsMall.dao.admin;

import SportsMall.entity.Myadmin;

public interface AdminDao {
	public Myadmin adminmessage(String username,String password);
	public boolean updateAdmin(Myadmin admin);
	public boolean deleteAdmin(int id);
	
}

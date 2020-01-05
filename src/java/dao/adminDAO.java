package org.websparrow.dao;

import java.util.List;
import org.websparrow.model.User;
import org.websparrow.model.admin;
import org.websparrow.model.bid;
import org.websparrow.model.tender;
import org.websparrow.model.vendor;


public interface adminDAO {
	
	public int createVendor(vendor v);
	public int createUser(User user);
	public List<vendor> viewVendor();
	public List<vendor> deleteVendor(Integer deleteVid);
	public int createTender(tender tender);
	public List<tender> viewTender();
	public List<tender> deleteTender(Integer deleteTid);
	public List<bid> allBids(int tid);
	public int selectBid(int tid);
	public String login(admin admin);
	tender getTenderById(int id);
	int updateTender(tender tender);
	List<User> viewUsers();
	List<User> deleteUser(int id);

}

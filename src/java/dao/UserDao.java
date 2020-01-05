package org.websparrow.dao;

import java.util.List;

import org.websparrow.model.User;
import org.websparrow.model.tender;

public interface UserDao {

	

	public String loginUser(User user);
	
	public int createTender(tender tender);
	
	public int updateTender(tender tender);
	
	public List<tender> getTenderByCreator(String name);
	
	public List<tender> deleteTender(int id);

	public tender getTenderById(int id);
	
}

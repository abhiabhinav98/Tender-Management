package org.websparrow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.websparrow.config.connectionFactory;
import org.websparrow.model.User;
import org.websparrow.model.admin;
import org.websparrow.model.bid;
import org.websparrow.model.tender;
import org.websparrow.model.vendor;

public class adminDaoImpl implements adminDAO {
	private JdbcTemplate jdbcTemplate;
	Connection con=connectionFactory.getInstance().getConnection();
	PreparedStatement pst;
	ResultSet rs;
	String dbStatus;
	String msg="";
	
	public adminDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	@Override
	public String login(admin admin) {
		String sql = "SELECT name FROM admin WHERE admin_id=? AND password=?";
		String name = jdbcTemplate.queryForObject(sql, new Object[] {
				admin.getId(), admin.getPassword() }, String.class);	
		return name;
	}

	@Override
	public int createVendor(vendor v) {
		String sql = "insert into vendor(name,address,phone,email,password) values('"+v.getName()+"','"+v.getAddress()+"','"+v.getPhone()+"','"+v.getEmail()+"','"+v.getPassword()+"')";
		return jdbcTemplate.update(sql);	
	}

	@Override
	public List<vendor> viewVendor() {
		String sql = "select * from vendor";
		return jdbcTemplate.query(sql,new RowMapper<vendor>(){
			public vendor mapRow(ResultSet rs, int row) throws SQLException {
				vendor t = new vendor();
				t.setVid(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setAddress(rs.getString(3));
				t.setPhone(rs.getString(4));
				t.setEmail(rs.getString(5));
				return t;
			}
		});
	}

	@Override
	public List<User> viewUsers() {
		String sql = "select * from tendorer";
		return jdbcTemplate.query(sql,new RowMapper<User>(){
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User u = new User();
				u.setUserId(rs.getString(1));
				u.setName(rs.getString(2));
				u.setDepartment(rs.getString(3));
				u.setPhone(rs.getString(4));
				u.setEmail(rs.getString(5));
				return u;
			}
		});
	}
	
	@Override
	public List<vendor> deleteVendor(Integer deleteVid) {
	  List<vendor> vList;
		String sql="delete from vendor where vendor_id="+deleteVid+"";  
	    int result = jdbcTemplate.update(sql);
	    System.out.println(result);
		vList=viewVendor();	
		return vList;
	}

	@Override
	public int createTender(tender tender) {
		String sql = "insert into tenderdb(tname,opening,closing,minbid,tdesc,publisher) values('"+tender.gettName()+"','"+tender.getOpening()+"','"+tender.getClosing()+"','"+tender.getMinBid()+"','"+tender.gettDesc()+"','"+tender.getPublisher()+"')";
		return jdbcTemplate.update(sql);	
	}

	@Override
	public List<tender> viewTender() {
		String sql = "select * from tenderdb";
		return jdbcTemplate.query(sql,new RowMapper<tender>(){
			public tender mapRow(ResultSet rs, int row) throws SQLException {
				tender t = new tender();
				t.settId(rs.getInt(1));
				t.settName(rs.getString(2));
				t.setOpening(rs.getString(3));
				t.setClosing(rs.getString(4));
				t.setMinBid(rs.getDouble(5));
				t.settDesc(rs.getString(6));
				t.setPublisher(rs.getString(7));
				return t;
			}
		});
	}

	@Override
	public List<tender> deleteTender(Integer deleteTid) {
		List<tender> tList;
		String sql="delete from tenderdb where tender_id="+deleteTid+"";  
	    int result = jdbcTemplate.update(sql);
	    System.out.println(result);
	    tList = viewTender();
	    return tList;
	}

	@Override
	public tender getTenderById(int id) {
		String sql = "select * from tenderdb where tender_id = '"+id+"'";
		return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<tender>(tender.class));
	}
	
	@Override
	public List<bid> allBids(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectBid(int tid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createUser(User u) {
	String sql = "INSERT INTO TENDORER(NAME,DEPARTMENT,PHONE,EMAIL,PASSWORD) VALUES('"+u.getName()+"','"+u.getDepartment()+"','"+u.getPhone()+"','"+u.getEmail()+"','"+u.getPassword()+"')";
		return jdbcTemplate.update(sql);	
	}

	@Override
	public int updateTender(tender tender) {
			String sql = "update tender set tname = '"+tender.gettName()+"', opening = '"+tender.getOpening()+"', closing = '"+tender.getClosing()+"', minbid= '"+tender.getMinBid()+"', tdesc='"+tender.gettDesc()+"'";
			return jdbcTemplate.update(sql);		
	}
	
	@Override
	public List<User> deleteUser(int id) {
		List<User> uList;
		String sql="delete from tendorer where t_id="+id+"";  
	    int result = jdbcTemplate.update(sql);
	    System.out.println(result);
	    uList = viewUsers();
	    return uList;
	}
	

}

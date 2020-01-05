package org.websparrow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.websparrow.model.User;
import org.websparrow.model.tender;


public class UserDaoImpl implements UserDao {
	
	static String n;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	String dbStatus;
	String msg="";
	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	
	@Override
	public String loginUser(User user) {	
		String sql = "SELECT name FROM tendorer WHERE t_ID=? AND password=?";
			String name = jdbcTemplate.queryForObject(sql, new Object[] {
					user.getUserId(), user.getPassword() }, String.class);	
			return name;
	}


	@Override
	public int createTender(tender tender) {
			String sql = "insert into tenderdb(tname,opening,closing,minbid,tdesc,publisher) values('"+tender.gettName()+"','"+tender.getOpening()+"','"+tender.getClosing()+"','"+tender.getMinBid()+"','"+tender.gettDesc()+"','"+tender.getPublisher()+"')";
			return jdbcTemplate.update(sql);		
	}


	@Override
	public int updateTender(tender tender) {
			String sql = "update tenderdb set tname = '"+tender.gettName()+"', opening = '"+tender.getOpening()+"', closing = '"+tender.getClosing()+"', minbid= '"+tender.getMinBid()+"', tdesc='"+tender.gettDesc()+"'";
			return jdbcTemplate.update(sql);		
	}


	@Override
	public List<tender> getTenderByCreator(String name) {
		n = name;
		String sql = "select * from tenderdb where publisher = '"+name+"'";
		return jdbcTemplate.query(sql,new RowMapper<tender>(){
			public tender mapRow(ResultSet rs, int row) throws SQLException {
				tender t = new tender();
				t.settId(rs.getInt(1));
				t.settName(rs.getString(2));
				t.setOpening(rs.getString(3));
				t.setClosing(rs.getString(4));
				t.setMinBid(rs.getDouble(5));
				t.settDesc(rs.getString(6));
				return t;
			}
		});
}


	@Override
	public List<tender> deleteTender(int id) {
		List<tender> tList;
		String sql="delete from tenderdb where tender_id="+id+"";  
	    int result = jdbcTemplate.update(sql);
	    System.out.println(result);
	    tList = getTenderByCreator(n);
	    return tList;
	}


	@Override
	public tender getTenderById(int id) {
		String sql = "select * from tenderdb where tender_id =? ";
		return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<tender>(tender.class));
	}
}
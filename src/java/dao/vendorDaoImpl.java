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
import org.websparrow.model.bid;
import org.websparrow.model.tender;
import org.websparrow.model.vendor;

public class vendorDaoImpl implements vendorDAO {
	private JdbcTemplate jdbcTemplate;
	Connection con=connectionFactory.getInstance().getConnection();
	PreparedStatement pst;
	ResultSet rs;
	String dbStatus;
	String msg="";

	public vendorDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	@Override
	public List<tender> viewTenders() {
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
	public int placeBid(bid bid) {
		String sql = "insert into bid values('"+bid.getVendor_id()+"','"+bid.getTender_id()+"','"+bid.getBid_id()+"','"+bid.getBidAmount()+"','"+bid.getBidTime()+"','"+bid.getSelectBid()+"')";
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<bid> bidHistory(int vendor_id) {
		String sql = "select * from bid where vendor_id = '"+vendor_id+"'";
		return jdbcTemplate.query(sql,new RowMapper<bid>(){
			public bid mapRow(ResultSet rs, int row) throws SQLException {
				bid b = new bid();
				b.setVendor_id(rs.getInt(1));
				b.setTender_id(rs.getInt(2));
				b.setBid_id(rs.getInt(3));
				b.setBidAmount(rs.getDouble(4));
				b.setBidTime(rs.getTimestamp(5));
				b.setSelectBid(rs.getString(6));
				return b;
			}
		});
	}

	@Override
	public String login(vendor vendor) {
String sql = "SELECT name FROM vendor WHERE VENDOR_ID=? AND password=?";
				String name = jdbcTemplate.queryForObject(sql, new Object[] {
					vendor.getVid(), vendor.getPassword() }, String.class);
			return name;
	}

	@Override
	public tender viewTenderById(int t_id) {
		String sql = "select * from tenderdb where tender_id =?";
		return jdbcTemplate.queryForObject(sql, new Object[]{t_id},new BeanPropertyRowMapper<tender>(tender.class));
	}

	@Override
	public boolean hasBidPlaced(int tid, int vid) {
		boolean v=false;
		try {
		String sql = "select * from bid where vendor_id = '"+vid+"' and tender_id = '"+tid+"' ";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		if(rs.next())
			v = true;
		else
			v = false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}

}

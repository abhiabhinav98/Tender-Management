package org.websparrow.dao;

import java.util.List;


import org.websparrow.model.bid;
import org.websparrow.model.tender;
import org.websparrow.model.vendor;

public interface vendorDAO {

	public List<tender> viewTenders();
	public int placeBid(bid bid);
	public List<bid> bidHistory(int vendor_id);
	public String login(vendor vendor);
	public tender viewTenderById(int t_id);
	public boolean hasBidPlaced(int tid, int vid);
}

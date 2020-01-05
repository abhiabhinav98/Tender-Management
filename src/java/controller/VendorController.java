package org.websparrow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.websparrow.dao.vendorDAO;
import org.websparrow.model.bid;
import org.websparrow.model.tender;
import org.websparrow.model.vendor;

@Controller
public class VendorController {
	
	static String name;
	static int v1;
	@Autowired
	private vendorDAO vendorDao; 
	
	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/vendorLogin", method = RequestMethod.POST)
	public ModelAndView vendorLogin(@RequestParam("userId") int userId, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		System.out.println("in loginVendor before loginVendor");
		vendor v = new vendor();
		v1=userId;
		v.setVid(userId);
		v.setPassword(password);
		name = vendorDao.login(v);
		System.out.println("in login after vendor init");
		System.out.println(""+name);
		if (name != null) {
			mv.addObject("msg", "Welcome " + name);
			mv.setViewName("vendorWelcome");
		} else {
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("vendorLogin");
		}
		return mv;
	}
	
	/**
	 * @param m
	 * @return
	 */
	@RequestMapping("/viewTenderByVendor")
	public String viewTender(Model m) {
  		System.out.println("inview tender vendor controller");
		List<tender> tenders = vendorDao.viewTenders();
		m.addAttribute("tenders", tenders);
		m.addAttribute("vid",v1);
		System.out.println(""+tenders);
		return "viewTenderByVendor";
	}
	
	/**
	 * @param m
	 * @return
	 */
	@RequestMapping("/viewBidsVendor")
	public String viewBids(Model m) {
  		System.out.println("inview tender admin controller");
		List<bid> myBids = vendorDao.bidHistory(v1);
		m.addAttribute("myBids", myBids);
		System.out.println(""+myBids);
		return "viewBidsVendor";
	}
	
	/**
	 * @param tId
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/place/{tId}")  
    public String placeBid(@PathVariable int tId, Model m){  
         boolean ans = vendorDao.hasBidPlaced(tId, v1);
         tender tender = vendorDao.viewTenderById(tId);
         if(ans == true)
        	 return "error";
         else {
        	 m.addAttribute("command", tender);
        	 return "placeBid";
         }
    }
	
	
	
	
}

package org.websparrow.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.websparrow.dao.adminDAO;
import org.websparrow.model.User;
import org.websparrow.model.tender;
import org.websparrow.model.admin;
import org.websparrow.model.vendor;
@Controller
public class AdminController {
	static String name;
	@Autowired
	private adminDAO adminDao;
	
	
//admin login	
	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public ModelAndView adminLogin(@RequestParam("userId") String userId, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();
		System.out.println("in login user before loginAdmin");
		admin admin = new admin();
		admin.setId(Integer.parseInt(userId));
		admin.setPassword(password);
		name = adminDao.login(admin);
		System.out.println("in login after admin init");
		System.out.println(""+name);
		if (name != null) {
			mv.addObject("msg", "Welcome " + name);
			mv.setViewName("adminWelcome");
		} else {
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("adminLogin");
		}
		return mv;
	}
	
	
	//creating tender by admin
	/**
	 * @param t_name
	 * @param odate
	 * @param otime
	 * @param cdate
	 * @param ctime
	 * @param mbid
	 * @param desc
	 * @return
	 */
	@RequestMapping(value = "/createTender", method = RequestMethod.POST)
	public ModelAndView createTender(@RequestParam("tname") String t_name, @RequestParam("odate") String odate,@RequestParam("otime") String otime, @RequestParam("cdate") String cdate,@RequestParam("ctime") String ctime, @RequestParam("mbid") double mbid, @RequestParam("desc") String desc) {

		ModelAndView mv = new ModelAndView();
		System.out.println("after receiving ctender request");
		//System.out.println(""+opening+"     "+closing);
		tender tender = new tender();
		tender.settName(t_name);
		tender.setOpening(odate);
		tender.setClosing(cdate);
		tender.settDesc(desc);
		tender.setMinBid(mbid);
		tender.setPublisher(name);
		//tender.setPublisher(user.getUserId());
		System.out.println("before create tender");
		int result = adminDao.createTender(tender);
		System.out.println("in ctender after tender init");
		System.out.println(""+result);
		if(result != 0)
			mv.addObject("msg", "Tender successfully created.");
		else
			mv.addObject("msg", "Unable to create tender.");
		mv.setViewName("createTenderByAdmin");
		return mv;
	}
	
	
	//creating vendor by admin
	/**
	 * @param vname
	 * @param address
	 * @param phone
	 * @param email
	 * @param password
	 * @param password2
	 * @return
	 */
	@RequestMapping(value = "/createVendor", method = RequestMethod.POST)
	public ModelAndView createVendor(@RequestParam("vname") String vname, @RequestParam("address") String address,@RequestParam("phone") String phone, @RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("password2") String password2) {
		
		ModelAndView mv = new ModelAndView();
		vendor vendor = new vendor();
		if(password.equals(password2)) {
		vendor.setName(vname);
		vendor.setAddress(address);
		vendor.setEmail(email);
		vendor.setPhone(phone);
		vendor.setPassword(password);
		//tender.setPublisher(user.getUserId());
		System.out.println("before create tender");
		int result = adminDao.createVendor(vendor);
		System.out.println("in ctender after tender init");
		System.out.println(""+result);
		if(result != 0)
			mv.addObject("msg", "Vendor successfully created.");
		else
			mv.addObject("msg", "Unable to create Vendor.");
		}
		else {
			mv.addObject("msg", "Passwords didn't match.");
		}
		mv.setViewName("createVendor");
		return mv;
	}
	
	
	//creating user by admin
		/**
		 * @param uname
		 * @param department
		 * @param phone
		 * @param email
		 * @param password
		 * @param password2
		 * @return
		 */
		@RequestMapping(value = "/createUser", method = RequestMethod.POST)
		public ModelAndView createUser(@RequestParam("uname") String uname, @RequestParam("department") String department,@RequestParam("phone") String phone, @RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("password2") String password2) {
			
			ModelAndView mv = new ModelAndView();
			User user = new User();
			if(password.equals(password2)) {
				user.setName(uname);
				user.setDepartment(department);
				user.setEmail(email);
				user.setPhone(phone);
				user.setPassword(password);
			//tender.setPublisher(user.getUserId());
			System.out.println("before create tender");
			int result = adminDao.createUser(user);
			System.out.println("in ctender after tender init");
			System.out.println(""+result);
			if(result != 0)
				mv.addObject("msg", "User successfully created.");
			else
				mv.addObject("msg", "Unable to create Vendor.");
			}
			else {
				mv.addObject("msg", "Passwords didn't match.");
			}
			mv.setViewName("createUser");
			return mv;
		}
	
		
		
		
		/**
		 * @param m
		 * @return
		 */
		@RequestMapping("/viewTender")
		public String viewTender(Model m) {
	  		System.out.println("inview tender admin controller");
			List<tender> tenderAll = adminDao.viewTender();
			m.addAttribute("tenderAll", tenderAll);
			System.out.println(""+tenderAll);
			return "viewTender";
		}
		
		/*
	    @RequestMapping(value="/editTenderByAdmin/{id}")  
	    public String edit(@PathVariable int id, Model m){  
	        tender tender = adminDao.getTenderById(id);
	        m.addAttribute("command",tender);
	        return "#";  
	    }  */
	    
	    
	    /* It updates model object. */  
	    //@RequestMapping(value="/editsaveadmin",method = RequestMethod.POST)  
	   // public String editsave(@ModelAttribute("tender") tender tender){ 
	    	//adminDao.updateTender(tender);  
	       // return "redirect:/viewTender";  
	    //}  
	    
	    /**
	     * @param id
	     * @return
	     */
	    @RequestMapping(value="/deleteTenderByAdmin/{id}",method = RequestMethod.GET)  
	    public String delete(@PathVariable int id){  
	        adminDao.deleteTender(id);  
	        return "redirect:/viewTender";  
	    }
		
		
		/**
		 * @param m
		 * @return
		 */
		@RequestMapping("/viewVendor")
		public String viewVendor(Model m) {
	  		System.out.println("in view vendor admin controller");
			List<vendor> vendor = adminDao.viewVendor();
			m.addAttribute("vendor", vendor);
			return "viewVendor";
		}
		
		
		/**
		 * @param m
		 * @return
		 */
		@RequestMapping("/viewUsers")
		public String viewUsers(Model m) {
	  		System.out.println("in view users admin controller");
			List<User> users = adminDao.viewUsers();
			m.addAttribute("users", users);
			return "viewUsers";
		}
		
		/**
		 * @param userId
		 * @return
		 */
		@RequestMapping(value="/deleteUser/{userId}",method = RequestMethod.GET)  
	    public String deleteUser(@PathVariable int userId){  
	        adminDao.deleteUser(userId);  
	        return "redirect:/viewUsers";  
	    }
		
		/**
		 * @param userId
		 * @return
		 */
		@RequestMapping(value="/deleteVendor/{vid}",method = RequestMethod.GET)  
	    public String deleteVendor(@PathVariable int vid){  
	        adminDao.deleteVendor(vid);  
	        return "redirect:/viewVendor";  
	    }
		
		
		
		
	
	/**
	 * @param str
	 * @return
	 */
	public Timestamp stringToTimestamp(String str) {
		Timestamp ts = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date pDate = sdf.parse(str);
			ts = new Timestamp(pDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ts;
	}

	
}

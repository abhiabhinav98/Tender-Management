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
import org.websparrow.dao.UserDao;
import org.websparrow.model.User;
import org.websparrow.model.tender;

@Controller
public class UserLoginController {
	static String name;
	@Autowired
	private UserDao userDao;
	
	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("userId") String userId, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();
		System.out.print("in login user before loginUser");
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		name = userDao.loginUser(user);
		System.out.print("in login after user init");
		System.out.println(""+name);
		if (name != null) {
			mv.addObject("msg", "Welcome " + name);
			mv.setViewName("welcome");
		} 
		else {
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("login");
		}
		return mv;
	}

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
	@RequestMapping(value = "/ctender", method = RequestMethod.POST)
	public ModelAndView createTender(@RequestParam("tname") String t_name, @RequestParam("odate") String odate,@RequestParam("otime") String otime, @RequestParam("cdate") String cdate,@RequestParam("ctime") String ctime, @RequestParam("mbid") double mbid, @RequestParam("desc") String desc) {

		ModelAndView mv = new ModelAndView();
		System.out.println("after receiving ctender request");
		tender tender = new tender();
		tender.settName(t_name);
		tender.setOpening(odate);
		tender.setClosing(cdate);
		tender.settDesc(desc);
		tender.setMinBid(mbid);
		tender.setPublisher(name);
		System.out.println("before create tender");
		int result = userDao.createTender(tender);
		System.out.println("in ctender after tender init");
		System.out.println(""+result);
		if(result != 0)
			mv.addObject("msg", "Tender successfully created.");
		else
			mv.addObject("msg", "Unable to create tender.");
		mv.setViewName("ctender");
		return mv;
	}
	
	
	//callback for editTender from editTender.jsp 
     
 
  	/**
  	 * @param m
  	 * @return
  	 */
  	@RequestMapping("/viewTendersByUser")
	public String viewTender(Model m) {
  		System.out.println("in edit tender user controller");
		List<tender> tender = userDao.getTenderByCreator(name);
		m.addAttribute("tender", tender);
		System.out.println("in ctender after view tender");
		System.out.println(""+tender);
		return "viewTendersByUser";
	}
	
    @RequestMapping(value="/editTender/{id}")  
    public String edit(@PathVariable int id, Model m){  
        tender tender = userDao.getTenderById(id);
        m.addAttribute("command",tender);
        return "tenderEditForm";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("tender") tender tender){ 
    	userDao.updateTender(tender);  
        return "redirect:/viewTendersByUser";  
    }  
    
    @RequestMapping(value="/deleteTender/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        userDao.deleteTender(id);  
        return "redirect:/viewTendersByUser";  
    }

    
	
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

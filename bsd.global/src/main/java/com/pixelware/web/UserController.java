package com.pixelware.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pixelware.dao.UserDao;
import com.pixelware.model.User;

@Controller
public class UserController {
	
	
/**
 * Crear logger para mensajes de aplicacion 
 */
	
	private static final Logger LOG =
			LoggerFactory.getLogger(UserController.class);
	
	
	/**
	 * INyectar DAO
	 * 
	 */
	@Autowired
	private UserDao dao ;
	
	@RequestMapping(value= "/",method= RequestMethod.GET)
	public String index(Model model){
		LOG.debug("Sergio");
		List<User> users = dao.getAll(); 
		User userOne = dao.getByCode(1);
		User userEle = dao.getByName("Elena Sanz");
		model.addAttribute("users",users);
		model.addAttribute("userOne",userOne);
		model.addAttribute("userEle",userEle);
		
		return "index";
	}
}

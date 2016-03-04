package com.atm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atm.service.ATMService;

/**
 * This controller allow to show the list of atms
 * 
 * @author fduarte
 *
 */
@Controller
public class ListController {

	@Autowired 
	ATMService atmServiceImpl;

	@RequestMapping(value = "/web/atms")
	public ModelAndView index() {
        ModelAndView result = new ModelAndView("list");
        result.addObject("items", this.atmServiceImpl.getAllAtms());
        return result;
    }

}
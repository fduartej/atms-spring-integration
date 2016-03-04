package com.atm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller allow to show the main page in order to add new atm to our own list
 * also this page content two link one to see a json and the secon list page
 * 
 * @author fduarte
 *
 */
@Controller
public class IndexController {

  /**
   * Allow to call the main page
   * @return String
   */
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String index() {
    return "index";
  }

}
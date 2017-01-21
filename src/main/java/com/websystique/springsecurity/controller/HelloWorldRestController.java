package com.websystique.springsecurity.controller;

import com.websystique.springsecurity.model.User;
import com.websystique.springsecurity.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class HelloWorldRestController {

	@Autowired
	UserService service;
    
    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN') AND hasRole('DBA')")
    public ResponseEntity deleteUser(@PathVariable int id) {
        service.deleteUser(id);
		JSONObject obj = new JSONObject();
        return new ResponseEntity(obj, HttpStatus.OK);
    }

}
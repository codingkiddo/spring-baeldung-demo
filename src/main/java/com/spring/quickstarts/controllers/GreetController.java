package com.spring.quickstarts.controllers;

import javax.naming.NamingException;
import javax.naming.spi.NamingManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.quickstarts.services.GreetService;

@Controller
@RequestMapping("greet")
public class GreetController {

//    @RequestMapping(method = RequestMethod.GET)
//	Annotation for mapping HTTP GET requests onto specific handler methods.
//	Specifically, @GetMapping is a composed annotation that acts as a shortcut 
//	for @RequestMapping(method = RequestMethod.GET).
	
	
	@Autowired
	private JndiTemplate jndiTemplate;
	
	@Autowired
	private GreetService greetService;
	@RequestMapping(method = RequestMethod.GET)
//	@GetMapping("/")
    public String getInitialMessage() throws NamingException {
		
		System.out.println(jndiTemplate.getContext().getNameInNamespace());
		System.out.println(NamingManager.hasInitialContextFactoryBuilder());
		System.out.println(NamingManager.CPE);
		
		System.out.println(jndiTemplate.lookup("java:jboss/datasources/MySqlDS"));
		System.out.println(greetService.getGreet(null));
		
		jndiTemplate.bind("java:global/TEST-NAME", "test-value");
		
        return "greet";
    }

    @RequestMapping(method = RequestMethod.POST)
//	@PostMapping
    public String getGreeting(@RequestParam("username") String username) {    
        if (username != null) {
            return "hello";
        } else {
            return "No such user exists! Use 'emuster' or 'jdoe'";
        }
    }
}

package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.InsertTable;
import com.model.service.InsertService;


@Controller
public class MyController {
	
	@Autowired
    ServletContext servletContext;
	
	@Autowired
	InsertService insertService;

	 @ModelAttribute("insertTable")
	 public InsertTable inst()
	 {
		 return new InsertTable();
	 }
	
	 @RequestMapping(value={"/","index"}) 
	 public String check()
	 {
		 
		 return "index";
	 }
	 
	 
	 @RequestMapping("/register") 
	 public String insert(@ModelAttribute("insertTable")InsertTable insertTable)
	 {
		 insertService.addSupplier(insertTable);
		 return "register";
	 }
	 @RequestMapping(value="/login")	 
		public ModelAndView saveRecord(Model model,@RequestParam(required = false) String authfailed, String logout,String denied)
		{ 		
				
				
				System.out.println("in login  meth");
				model.addAttribute("pop",true);
				String message = "";
				message="Welcome Login to Continue";
				if (authfailed != null) {
					message = "Invalid username of password, try again !";
				} else if (logout != null) {
					message = "Logged Out successfully, login again to continue !";
				} else if (denied != null) {
					message = "Access denied for this user !";
				}
				
				model.addAttribute("no","notValid");
				 return new ModelAndView("login","message",message);
		}
		@RequestMapping(value={"/user"})
		public ModelAndView userIn(Model model)
				 {
			System.out.println("in controller");
	  return new ModelAndView("user");
		}

		 @RequestMapping(value="/upload",method=RequestMethod.POST)	 
	     public ModelAndView AdminRecord(@RequestParam("file") MultipartFile file,Model model,@RequestParam("name") String name)
		 {
			 if (!file.isEmpty()) {
					try {
						byte[] bytes = file.getBytes();

						// Creating the directory to store file
						String rootPath = servletContext.getRealPath("/");
						File dir = new File(rootPath + File.separator + "resources/images");
						if (!dir.exists())
							dir.mkdirs();

						// Create the file on server
						File serverFile = new File(dir + File.separator + name + ".txt");
						BufferedOutputStream stream = new BufferedOutputStream(
								new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();
						String Storee1 = name;
						System.out.println(serverFile);
						model.addAttribute("fileName",Storee1);
					}
					catch (Exception e) {
						model.addAttribute("message","You failed to upload " + name + " => " + e.getMessage());
						return new ModelAndView("user");
					}
					
		 }
			 return new ModelAndView("user");

}
		 
}
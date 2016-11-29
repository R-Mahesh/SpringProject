package com.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.Category;
import com.model.entity.User;
import com.model.service.AdminService;
/*import com.model.service.ProductService;*/

@Controller
public class MyController {

	@Autowired
    ServletContext servletContext;
	
	 
	 
	 @Autowired
	 private AdminService adminService;
	 
	 @ModelAttribute("category") 
	 public Category bindCategory()
	 {
		 return new Category();
	 }
	 
	/* @Autowired
	 private ProductService productService;*/
	 
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	 public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		 System.out.println("in login logout method");
	     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     if (auth != null){    
	         new SecurityContextLogoutHandler().logout(request, response, auth);
	     }
	     return "redirect: index?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	 }	 
	 
	 
	 
	 
		@RequestMapping(value={"/","index"})
		public ModelAndView showMessage(Model model)
				 {
			System.out.println("in controller");
	 model.addAttribute("homePage",true);
	  List categoryList = adminService.getAllCategory();
	  return new ModelAndView("index", "categoryList", categoryList);
		}
		
	   /* @RequestMapping("/register")
		 public ModelAndView registerUser(Model model) {
		  //empService.add(emp);
	    	 model.addAttribute("registerPage",true);
		  return new ModelAndView("index");
		 }*/

	    
	     
		 @ModelAttribute("user") 
		 public User bind(){
			 
			 return new User();
		 }
		/* @RequestMapping(value="/login")
		 public String getlogin()
		 {
			 System.out.println("in login get meth");
		 return "register";
		 }
		 j_spring_security_check"*/
	@RequestMapping(value="/login")	 
public ModelAndView saveRecord(Model modal,@RequestParam(required = false) String authfailed, String logout,String denied)
{ 		
		
		
		System.out.println("in login post meth");

		/*if (bindingResult.hasErrors())
		{
			return new ModelAndView("register");
} */
		modal.addAttribute("loginPage",true);
		String message = "";
		if (authfailed != null) {
			message = "Invalid username of password, try again !";
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue !";
		} else if (denied != null) {
			message = "Access denied for this user !";
		}
		return new ModelAndView("index", "message", message);
	
		
		/*model.addAttribute("homePage",true);
		//empService.add(emp);
		  model.addAttribute("homePage",true);
		*/  /*return new ModelAndView("redirect:index");
		  return new ModelAndView("redirect:list", "categoryList", categoryList);*/
} 
	
	 @RequestMapping(value="/user",method=RequestMethod.GET)
		public ModelAndView user(Model model)
				 {
		 model.addAttribute("homePage",true);
		 model.addAttribute("userPage",true);
			System.out.println("in user controller method");
			 List categoryList = adminService.getAllCategory();
			  return new ModelAndView("index", "categoryList", categoryList);
		}
		
	/* @RequestMapping("admin")
		public String geAdminPage() {
			return "Admin";
		}*/
	@RequestMapping("403page")
	public String ge403denied() {
		return "redirect:login?denied";
	}
	

	
	
	 /*@RequestMapping("list")
		 public ModelAndView getList() {
		  List employeeList = empService.getAllEmp();
		  return new ModelAndView("final", "employeeList", employeeList);
		 }
		

		 @RequestMapping("delete")
		 public ModelAndView deleteUser(@RequestParam int id) {
		  empService.delete(id);
		  System.out.println("in controller"+id);
		  return new ModelAndView("redirect:list");
		 }

		 @RequestMapping("update")
		 public ModelAndView updateUser(@Valid @ModelAttribute User emp,BindingResult result) {
			 if (result.hasErrors())
			 {
					return new ModelAndView("edit","emp",emp);
					}
		  empService.edit(emp);
		  return new ModelAndView("redirect:list");
		 }

		 
		 @RequestMapping("edit")
		 public ModelAndView editUser(@ModelAttribute User emp,@RequestParam int id) {
		  User employeeObject = empService.getEmp(id);
		  return new ModelAndView("edit", "employeeObject", employeeObject);
		 }

		 
		 @RequestMapping(value={"userDetails"})
			public String Details()
					 {
				System.out.println("in controller");
	
				  return "userDetails";
			}
			
		 
		 @RequestMapping("details")
		 public ModelAndView useDetails(@ModelAttribute User emp,@RequestParam int action) {
			 
		  User employeeObject = empService.getEmp(action);
		  return new ModelAndView("userDetails", "employeeObject", employeeObject);
		  }
		 */
		
		 
		/* @RequestMapping("upload")
			public ModelAndView Upload(@ModelAttribute("uploadedFile")UploadedFile uploadedFile,BindingResult result)
		 {
	System.out.println("in controller");
	return new ModelAndView("upload");

	}
		 @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
			public String uploadFileHandler(@RequestParam("name") String name,
					@RequestParam("file") MultipartFile file) {

				if (!file.isEmpty()) {
					try {
						byte[] bytes = file.getBytes();

						// Creating the directory to store file
						String rootPath = context.getRealPath("/");
						File dir = new File(rootPath + File.separator + "resources/images");
						if (!dir.exists())
							dir.mkdirs();

						// Create the file on server
						File serverFile = new File(dir + File.separator + name + ".jpg");
						BufferedOutputStream stream = new BufferedOutputStream(
								new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();

						System.out.println(serverFile);

						return "You successfully uploaded file=" + name;
					} catch (Exception e) {
						return "You failed to upload " + name + " => " + e.getMessage();
					}
				} else {
					return "You failed to upload " + name
							+ " because the file was empty."; 
				}
			}		 */
		 
		/* @RequestMapping(value="addProducts",method=RequestMethod.POST)	 
		    public ModelAndView AdminRecord(@Valid @ModelAttribute("products")Products products,BindingResult bindingResult,ModelMap m,@RequestParam("name") String name,@RequestParam("file") MultipartFile file)
		    { 
			  if (bindingResult.hasErrors())
				{
					return new ModelAndView("productsForm");
				}
		   	 if (!file.isEmpty()) {
						try {
							byte[] bytes = file.getBytes();

							// Creating the directory to store file
							String rootPath = servletContext.getRealPath("/");
							File dir = new File(rootPath + File.separator + "resources/images");
							if (!dir.exists())
								dir.mkdirs();

							// Create the file on server
							File serverFile = new File(dir + File.separator + products.getName() + ".jpg");
							BufferedOutputStream stream = new BufferedOutputStream(
									new FileOutputStream(serverFile));
							stream.write(bytes);
							stream.close();

							System.out.println(serverFile);
							m.addAttribute("message","You successfully uploaded file");
							productService.addProducts(products,name);
							m.addAttribute("img", products.getName());
							return new ModelAndView("productsForm");
						
						} catch (Exception e) {
							m.addAttribute("message","You failed to upload " + products.getName() + " => " + e.getMessage());
							return new ModelAndView("productsForm");
							return new ModelAndView("You failed to upload " + name + " => " + e.getMessage());
						}
					} else {
						m.addAttribute("message","You failed to upload " +products.getName() + " because the file was empty.");
						return new ModelAndView("productsForm");
						return new ModelAndView("You failed to upload " + name
								+ " because the file was empty."); 
					}
						
		    }
			
		 
		 
*/					}


		 
		 

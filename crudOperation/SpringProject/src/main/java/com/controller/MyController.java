package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.Category;
import com.model.entity.Products;
import com.model.entity.User;
import com.model.service.AdminService;
import com.model.service.EmpService;
/*import com.model.service.ProductService;*/

@Controller
public class MyController {

	@Autowired
    ServletContext servletContext;
	
	 @Autowired
	 private EmpService empService;
	 
	 
	 @Autowired
	 private AdminService adminService;
	 
	/* @Autowired
	 private ProductService productService;*/
	 
	 
	 
	 
	 
	 
		@RequestMapping(value={"/","index"})
		public ModelAndView showMessage(Model model)
				 {
			System.out.println("in controller");
	 model.addAttribute("homePage",true);
	  List categoryList = adminService.getAllCategory();
	  return new ModelAndView("index", "categoryList", categoryList);
		}
		
	     @RequestMapping("register")
		 public ModelAndView registerUser(Model model) {
		  //empService.add(emp);
	    	 model.addAttribute("registerPage",true);
		  return new ModelAndView("index");
		 }
		 

		
	     
		
		
		  
	     
	   
	    
	     
		 @ModelAttribute("emp") 
		 public User bind(){
			 
			 return new User();
		 }
	@RequestMapping(value="add",method=RequestMethod.POST)	 
public ModelAndView saveRecord(@Valid @ModelAttribute("emp")User emp,BindingResult bindingResult,Model model/*,@RequestParam(required = false) String authfailed, String logout,String denied*/)
{ 			

		if (bindingResult.hasErrors())
		{
			return new ModelAndView("register");
} 
		
		/*String message = "";
		if (authfailed != null) {
			message = "Invalid username of password, try again !";
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue !";
		} else if (denied != null) {
			message = "Access denied for this user !";
		}*/
		
		model.addAttribute("homePage",true);
		empService.add(emp);
		 List categoryList = adminService.getAllCategory();
		  model.addAttribute("homePage",true);
		 /* model.addAttribute("message",message);
*/		  return new ModelAndView("redirect:list", "categoryList", categoryList);
}  
		 @RequestMapping("list")
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
		 
	/*	 @RequestMapping("403page")
			public String ge403denied() {
				return "redirect:login?denied";
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


		 
		 

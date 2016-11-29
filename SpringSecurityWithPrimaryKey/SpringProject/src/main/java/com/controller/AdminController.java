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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.Category;
import com.model.entity.User;
import com.model.service.AdminService;
@Controller
public class AdminController {

	@Autowired
    ServletContext context;
	
	 @Autowired
	 private AdminService adminService;
	 
	 @ModelAttribute("category") 
	 public Category bind()
	 {
		 return new Category();
	 }
	 @ModelAttribute("user") 
	 public User bind3()
	 {
		 return new User();
	 }
	 
	  @RequestMapping("Admin")
	 public String admin(Model model) {
	  //empService.add(emp);
		  model.addAttribute("AdminPage",true);
	  return "index";
	 }
	 
	  @RequestMapping(value="addSuppliers",method=RequestMethod.POST)	 
	     public ModelAndView AdminRecord(@Valid @ModelAttribute("category")Category category,BindingResult bindingResult,ModelMap m,@RequestParam("name") String name,@RequestParam("file") MultipartFile file)
	     { 
		  if (bindingResult.hasErrors())
			{
				return new ModelAndView("Admin");
			}
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
						m.addAttribute("message","You successfully uploaded file");
						m.addAttribute("img",name);
						adminService.addSupplier(category,name);
						return new ModelAndView("Admin");
					
					} catch (Exception e) {
						m.addAttribute("message","You failed to upload " + name + " => " + e.getMessage());
						return new ModelAndView("Admin");
						/*return new ModelAndView("You failed to upload " + name + " => " + e.getMessage());*/
					}
				} else {
					m.addAttribute("message","You failed to upload " + name + " because the file was empty.");
					return new ModelAndView("Admin");
					/*return new ModelAndView("You failed to upload " + name
							+ " because the file was empty."); */
				}
					  
	    	 
	    	 
	    	 
	    	 
	    	/* MultipartFile file=category.getFile();
	    	 String fname="";
	    	 String src="";
	    	 
	     		if (bindingResult.hasErrors()) {
	     			return new ModelAndView("Admin");
	    }
	     		try
	     		{
	     			fname=file.getOriginalFilename();
	     			byte bytes[]=file.getBytes();
	     			BufferedOutputStream bw=new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\E Ravi\\Desktop\\eclipse work place\\SpringProject\\src\\main\\webapp\\resources\\images\\"+fname)));
	     			bw.write(bytes);
	     			bw.close();
	     			src=fname;
	     			System.out.println("image src="+src);
	     			m.addAttribute("imgsrc", src);
	     		}
	     		catch(Exception ex)
	     		{
	     			System.out.println("exception caught...."+ex);
	     		}
	     		Category file = (Category)category;
	     		MultipartFile multipartFile = file.getFile();
	    			//do whatever you want
	     		adminService.addSupplier(category,src);*/
	     		/*return new ModelAndView("Admin");*/
	     }

	  @RequestMapping("categorylist")
		 public ModelAndView getListCategory(@ModelAttribute("category")Category category,Model model) {
		  List categoryList = adminService.getAllCategory();
		  model.addAttribute("categoryPage",true);
		  return new ModelAndView("index", "categoryList", categoryList);
		 }
		/* 
	     @RequestMapping("category")
	     public ModelAndView getEditCategory(@ModelAttribute("category")Category category,Model model) {
			  List categoryList = adminService.getAllCategory();
			  model.addAttribute("homePage",true);
			  return new ModelAndView("category", "categoryList", categoryList);
			 }*/
	     
@RequestMapping("deleteCategory")
		 public ModelAndView deleteCategory(@RequestParam int sp) {
	    	 adminService.deleteCategory(sp);
		  return new ModelAndView("category");
		 }

		 @RequestMapping("updateCategory")
		 public ModelAndView updateCategory(@Valid @ModelAttribute Category category,BindingResult bindingResult,ModelMap m,@RequestParam("file") MultipartFile file) {
			
			 if (bindingResult.hasErrors())
				{
					return new ModelAndView("editCategory");
				}
			 if (!file.isEmpty()) {
					try {
						byte[] bytes = file.getBytes();

						// Creating the directory to store file
						String rootPath = context.getRealPath("/");
						File dir = new File(rootPath + File.separator + "resources/images");
						if (!dir.exists())
							dir.mkdirs();

						// Create the file on server
						File serverFile = new File(dir + File.separator + category.getImg() + ".jpg");
						BufferedOutputStream stream = new BufferedOutputStream(
								new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();

						System.out.println(serverFile);
						m.addAttribute("message","You successfully uploaded file");
						adminService.addSupplier(category,category.getImg());
						adminService.editCategory(category);
						  return new ModelAndView("redirect:categorylist");
					
					} catch (Exception e) {
						m.addAttribute("message","You failed to upload " + category.getImg()+ " => " + e.getMessage());
						return new ModelAndView("editCategory");
						/*return new ModelAndView("You failed to upload " + name + " => " + e.getMessage());*/
					}
				} else {
					m.addAttribute("message","You failed to upload " + category.getImg() + " because the file was empty.");
					return new ModelAndView("editCategory");
					/*return new ModelAndView("You failed to upload " + name
							+ " because the file was empty."); */
				}
		 }

		 	 
		 @RequestMapping("editCategory")
		 public ModelAndView editCategory(@RequestParam int sp,  @ModelAttribute Category category) {
			 Category categoryObject = adminService.getCategory(sp);
		  return new ModelAndView("editCategory", "categoryObject", categoryObject);
		 }

	  
	  
  
}

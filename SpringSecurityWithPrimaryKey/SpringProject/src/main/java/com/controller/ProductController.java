package com.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.Category;
import com.model.entity.Products;
import com.model.entity.User;
import com.model.service.AdminService;
import com.model.service.ProductService;
import com.model.service.ProductServiceImp;
import java.util.List;


import org.springframework.ui.Model;
@Controller
public class ProductController {

//	 @ModelAttribute("products")
//		public Products bind2()
//		{
//		return new Products();
//		}
	
	 @Autowired
    ServletContext servletContext;
	
	 @Autowired
	 private ProductService productService;
	 
	 @Autowired
	 private AdminService adminService;
	
	@ModelAttribute("products")
	public Products bind()
	{
	return new Products();
	}
	
	 @ModelAttribute("category") 
	 public Category bind3()
	 {
		 return new Category();
	 }

	@ModelAttribute("user")
	public User bind2()
	{
	return new User();
	}
	
	@RequestMapping("productsForm")
	public ModelAndView productFormPage(Model m)
	{
		m.addAttribute("productsForm",true);
		List categoryList = adminService.getAllCategory();
		 return new ModelAndView("index", "categoryList", categoryList);
	}

	
	 @RequestMapping(value="addProducts",method=RequestMethod.POST)	 
     public ModelAndView AdminRecord(@Valid @ModelAttribute("products")Products products,BindingResult bindingResult,ModelMap m,@RequestParam("file") MultipartFile file)
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
					List categoryList = adminService.getAllCategory();
					m.addAttribute( "categoryList", categoryList);
					productService.addProducts(products,products.getName());
					m.addAttribute("productDisplay",true);
					m.addAttribute("homePage",true);
					List productList = productService.getProductsByCategory(products.getCategory());
					return new ModelAndView("index","productList", productList);
				
				} catch (Exception e) {
					m.addAttribute("message","You failed to upload " + products.getName() + " => " + e.getMessage());
					return new ModelAndView("productsForm");
				}
			} else {
				m.addAttribute("message","You failed to upload " +products.getName() + " because the file was empty.");
				return new ModelAndView("productsForm");
			}
     }				  
    	 
    	 
    	 
    	 
    	
 /* @RequestMapping("productsList")
	 public ModelAndView getListCategory(@ModelAttribute("products")Products products,Model model) {
	  List categoryList = productService.getAllProducts();
	  model.addAttribute("homePage",true);
	  return new ModelAndView("products", "categoryList", categoryList);
	 }*/
	 
     @RequestMapping("productList")
     public ModelAndView getEditCategory(@ModelAttribute("products")Products products,Model model) {
		  List productList = productService.getAllProducts();
		  model.addAttribute("homePage",true);
		  return new ModelAndView("products", "productList", productList);
		 }
     
@RequestMapping("deleteProduct")
	 public ModelAndView deleteCategory(@RequestParam int id) {
	 productService.deleteProducts(id);
	  return new ModelAndView("redirect:productList");
	 }

	 @RequestMapping("updateProduct")
	 public ModelAndView updateCategory(@Valid @ModelAttribute Products products,BindingResult bindingResult,ModelMap m,@RequestParam("file") MultipartFile file) {
		
		 if (bindingResult.hasErrors())
			{
				return new ModelAndView("editProduct");
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
					m.addAttribute("message","You successfully uploaded file"+products.getName());
					productService.editProducts(products);
					  return new ModelAndView("redirect:productList");
				
				} catch (Exception e) {
					m.addAttribute("message","You failed to upload " + products.getName()+ " => " + e.getMessage());
					return new ModelAndView("editProduct");
				}
			} else {
				m.addAttribute("message","You failed to upload " + products.getName() + " because the file was empty.");
				return new ModelAndView("editProduct");
			}
	 }

	 	 
	 @RequestMapping("editProduct")
	 public ModelAndView editProduct(@RequestParam int id,  @ModelAttribute Products products ) {
		 Products productsObject = productService.getProducts(id);
	  return new ModelAndView("editProduct", "productsObject", productsObject);
	 }

}


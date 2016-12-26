package com.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.Carousal;
import com.model.entity.CategoryEntity;
import com.model.entity.MyCart;
import com.model.entity.Products;
import com.model.entity.User;
import com.model.service.AdminService;
import com.model.service.CartService;
import com.model.service.ProductService;
import java.util.List;

import org.springframework.ui.Model;
@Controller
public class ProductController {

static int cNo;
	
	 @Autowired
    ServletContext servletContext;
	
	 @Autowired
	 private ProductService productService;
	 
	 @Autowired
	 private AdminService adminService;
	 
	 @Autowired
		private CartService cartService;
	 
	
		

	
	@ModelAttribute("products")
	public Products bind()
	{
	return new Products();
	}
	
	 @ModelAttribute("categoryEntity") 
	 public CategoryEntity bind3()
	 {
		 return new CategoryEntity();
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
     public ModelAndView AdminRecord(@Valid @ModelAttribute("products")Products products,BindingResult bindingResult,ModelMap m,@RequestParam("file") MultipartFile file,Model model)
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
					 
				      
					CategoryEntity categy = new CategoryEntity();
					products.setCategories(categy);
					categy.setCategoryName(products.getCategory());
					
					boolean catgy = true;
				if(adminService.getAllCategory().isEmpty()==false){
					List<CategoryEntity> test = adminService.getAllCategory();
					for(CategoryEntity x:test)
					{
						
					if(products.getCategory().equals(x.getCategoryName())==true)
					{
						products.setCategories(x);	
						 catgy = false;
						 productService.addProducts(products,products.getName());
					break;}
				
					}
				}
				
				if(catgy)
				{
					adminService.addSupplier(categy);
					productService.addProducts(products,products.getName());
				}
				
				if(adminService.getAllCategory().isEmpty())
				{adminService.addSupplier(categy);
				productService.addProducts(products,products.getName());
				}
				
					
				 List<Carousal> crdl=adminService.getCarousalproducts();
				 for(Carousal cpdl:crdl)
					 
				 {
					 model.addAttribute("carousalProduct", cpdl);
				 }

					
					
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
    	 
    	
	 @RequestMapping("search")
	 public String productDetail(@RequestParam("Details")String Details,Model model)
	 {
	 		 List categoryList = adminService.getAllCategory();
	 		 model.addAttribute("categoryList", categoryList);
	 		 model.addAttribute("Details", Details);
	 		 model.addAttribute("quickSortPage",true);
	 return "index";
	 		 }

	 @RequestMapping("productList")
	 public String productDis2(Model model)
	 {
		 List<MyCart> cartItem = cartService.getAllCartItem();
			for (MyCart x : cartItem) { cNo= x.getCart_id();}
	 		 List categoryList = adminService.getAllCategory();
	 		 model.addAttribute("categoryList", categoryList);
	 		 model.addAttribute("quickSortPage",true);
	 		model.addAttribute("cNo",cNo);
	 return "index";
	 		 }

	 
	 @RequestMapping("/productLt")
     public  @ResponseBody  List<Products> getProd() {
		  
		  return productService.getAllProducts();
		 }
	 
    /* @RequestMapping("productList")
     public ModelAndView getEditCategory(@ModelAttribute("products")Products products,Model model) {
		  List productList = productService.getAllProducts();
		  List categoryList = adminService.getAllCategory();
    	  model.addAttribute("categoryList", categoryList);
		  model.addAttribute("homePage",true);
		  model.addAttribute("productPage",true);
		  return new ModelAndView("index", "productList", productList);
		 }
    */ 
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
						if(adminService.getAllCategory().isEmpty()==false){
							List<CategoryEntity> test = adminService.getAllCategory();
							for(CategoryEntity x:test)
							{
								
							if(products.getCategory().equals(x.getCategoryName())==true)
							{
								products.setCategories(x);	
							}
							}
						}
					
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

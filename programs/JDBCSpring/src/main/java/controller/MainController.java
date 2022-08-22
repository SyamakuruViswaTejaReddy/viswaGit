package controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.EProductDao;
import entity.EProductEntity;
@Controller
public class MainController {

	@Autowired
	EProductDao dao;

	
	@GetMapping("/listproduct")
	public String getAllProducts(ModelMap map) {
		
		
		List<EProductEntity> list= dao.getAllProducts();
		map.addAttribute("list", list);
		return "products";
		
	}
	
	@GetMapping("/details")
	public String getProduct(HttpServletRequest request,ModelMap map) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		EProductEntity entity=dao.getProductById(id);
		map.addAttribute("obj",entity);
		return "details";
	}
	

	@GetMapping("/update")
	public String upProduct(HttpServletRequest request,ModelMap map) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		BigDecimal price=new BigDecimal(Integer.parseInt(request.getParameter("price")));
		EProductEntity entity=dao.updateProduct(new EProductEntity(id,name,price));
		map.addAttribute("obj",entity);
		return "updateDetails";
	}

}

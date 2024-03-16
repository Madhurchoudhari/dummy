package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.ProductDTO;
@WebServlet("/addProduct")
public class productController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pName=req.getParameter("productName");
		double pPrice=Double.parseDouble(req.getParameter("productPrice"));
		String pCategory=req.getParameter("productCategory");
		int pQty=Integer.parseInt(req.getParameter("productQty"));
		
		
		
		ProductDTO p=new ProductDTO();
		p.setProductName(pName);
		p.setProductPrice(pPrice);
		p.setProductCategory(pCategory);
		p.setProductQty(pQty);
		
	Session session=new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(ProductDTO.class).buildSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(p);
		tx.commit();
		session.close();
		
		
	}

}

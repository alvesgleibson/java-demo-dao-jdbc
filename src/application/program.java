package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;



public class Program {
	
	public static void main(String[] args) {
		
		
		Department obj = new Department(1, "Tecnology");
		
		Seller seller = new Seller(22, "alvesgleibson@gmail.com","alvesgleibson@gmail.com", new Date(),5500.0, obj);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println(obj+"\n");
		System.out.println(seller);
		
		
		
		
		
	}

}

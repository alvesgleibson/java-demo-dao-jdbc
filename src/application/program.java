package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("================ Test 1: Seller FindById ================\n");
		Seller sellerSoftwareEngineer = sellerDao.findById(3);

		if (sellerSoftwareEngineer != null) {
			System.out.println(sellerSoftwareEngineer);
		} else
			System.out.println("Id procurado não encontrado no Seller");

		// End find seller by id

		System.out.println("\n\n================ Test 2: Seller FindByDepartment ================\n");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);

		for (Seller obj : list) {

			System.out.println(obj);

		}

		// End find seller by Department

		System.out.println("\n\n================ Test 3: Seller FindByAll ================\n");
		list = sellerDao.findAll();

		for (Seller obj : list) {

			System.out.println(obj);

		}

		// End find sellerAll

		System.out.println("\n\n================ Test 4: Insert Seller ================\n");
		
		Seller newSeller = new Seller(null, "Edmilson Junior", "edimilson@ondanetpe.com.br", new Date(), 4500.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted!!! new ID: "+newSeller.getId());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

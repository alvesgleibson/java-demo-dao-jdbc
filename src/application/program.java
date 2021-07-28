package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("########## Test 1: Seller FindById ###########\n");
		Seller sellerSoftwareEngineer = sellerDao.findById(3);

		if (sellerSoftwareEngineer != null) {
			System.out.println(sellerSoftwareEngineer);
		} else
			System.out.println("Id procurado não encontrado no Seller");
		
		//Fim Find seller by id

	}

}

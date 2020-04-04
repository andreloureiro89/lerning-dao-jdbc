package applications;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.creatSellerDao();

		System.out.println("\n=== TEST 1: seller findById ===\n");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		
		System.out.println("\n=== TEST 2: seller findByIdDepartment ===\n");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		
		System.out.println("\n=== TEST 3: seller findAll ===\n");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		
		
		System.out.println("\n=== TEST 4: seller insert ===\n");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);;
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		
		
		System.out.println("\n=== TEST 5: seller update ===\n");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		seller.setEmail("martha@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update completed");

	}

}

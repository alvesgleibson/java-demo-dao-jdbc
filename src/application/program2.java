package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDaoInterface = DaoFactory.createDepartmentDao();
		
		
		//departmentDaoInterface.deletebyId(5);
		//departmentDaoInterface.insert(new Department(10, "Finance"));
		
		
		//Department dep = departmentDaoInterface.findById(10);
		
		//System.out.println(dep);
		
		Department depUp = departmentDaoInterface.findById(100);
		depUp.setName("TI");
		departmentDaoInterface.update(depUp);

		
		System.out.println(depUp);
	}

}

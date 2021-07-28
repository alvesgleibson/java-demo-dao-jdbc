package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDaoInterface = DaoFactory.createDepartmentDao();
		
		Department dep = departmentDaoInterface.findById(3);
		
		System.out.println(dep);
		
		departmentDaoInterface.deletebyId(5);
		
		
		
		

	}

}
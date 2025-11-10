package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("\n=== TEST 1: department insert ====");
		Department newDepartment = new Department(null,"BarberShop");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		
		System.out.println("\n=== TEST 2: department update ====");
		Department department = departmentDao.findById(9);
		if (department != null) { 
		    department.setName("Games");
		    departmentDao.update(department);
		    System.out.println("Update completed");
		} else {
		    System.out.println("ATENÇÃO: Departamento não encontrado. Nenhuma atualização foi feita.");
		}
		
		
		System.out.println("\n=== TEST 3: department delete ====");
		System.out.println("Enter id for delete teste:");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");

		
		System.out.println("=== TEST 4: findById =======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 5: findAll =======");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		sc.close();
	}

}

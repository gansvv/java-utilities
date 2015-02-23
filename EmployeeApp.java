import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections4.comparators.ComparatorChain;

class Employee implements Comparable<Employee> {
	private int empId;
	private String empName;
	private double empSalary;

	public Employee(int empId, String empName, double empSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public int compareTo(Employee emp) {
		// asc empId
		return this.getEmpId() - emp.getEmpId();
		// desc empId
		// return emp.getEmpId() - this.getEmpId();
	}
}

class SortByEmployeeIdComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee emp1, Employee emp2) {
		// asc order of IDs
		return emp1.getEmpId() - emp2.getEmpId();
	}
}

class SortByEmployeeSalaryComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee emp1, Employee emp2) {
		// desc order of salaries
		return (int) (emp2.getEmpSalary() - emp1.getEmpSalary());
	}
}

public class EmployeeApp {
	public static void main(String[] args) {

		Employee e1 = new Employee(100, "Tom", 501);		
		Employee e2 = new Employee(102, "Harry", 5000);
		Employee e3 = new Employee(102, "Warne", 10.25);
		Employee e4 = new Employee(102, "Jane", 1000);
		Employee e5 = new Employee(101, "Dick", 101.50);		

		List<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		
		printList(empList);
		Collections.sort(empList);
		printList(empList);
		Collections.sort(empList, new SortByEmployeeSalaryComparator());
		printList(empList);
		
		ComparatorChain<Employee> ch = new ComparatorChain<Employee>();
		ch.addComparator(new SortByEmployeeIdComparator());
		ch.addComparator(new SortByEmployeeSalaryComparator());
		Collections.sort(empList, ch);
		printList(empList);
	}

	private static void printList(List<Employee> empList) {
		System.out.println("Employees: ");
		System.out.println(String.format("Id\tName\tSalary"));
		for (Employee emp : empList) {
			System.out.println(String.format("%d\t%s\t%.2f", emp.getEmpId(),
					emp.getEmpName(), emp.getEmpSalary()));
		}
	}
}


/*
Output:
Employees: 
Id	Name	Salary
100	Tom	501.00
102	Harry	5000.00
102	Warne	10.25
102	Jane	1000.00
101	Dick	101.50
Employees: 
Id	Name	Salary
100	Tom	501.00
101	Dick	101.50
102	Harry	5000.00
102	Warne	10.25
102	Jane	1000.00
Employees: 
Id	Name	Salary
102	Harry	5000.00
102	Jane	1000.00
100	Tom	501.00
101	Dick	101.50
102	Warne	10.25
Employees: 
Id	Name	Salary
100	Tom	501.00
101	Dick	101.50
102	Harry	5000.00
102	Jane	1000.00
102	Warne	10.25

*/

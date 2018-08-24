public class PayableInterfaceTest
{
	public static void main(String[] args)
	{
		Invoice invoice1 = new Invoice("01234", "seat", 2, 375.00);
		Invoice invoice2 = new Invoice("56789", "tire", 4, 79.95);
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);
		
		System.out.println("Invoices and Employees processed individually:");
		
		System.out.printf("%n%s%n%s: $%,.2f%n%n", invoice1, "earned", invoice1.getPaymentAmount());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", invoice2, "earned", invoice2.getPaymentAmount());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());
		
		Payable[] payableObjects = new Payable[6];
		payableObjects[0] = invoice1;
		payableObjects[1] = invoice2;
		payableObjects[2] = salariedEmployee;
		payableObjects[3] = hourlyEmployee;
		payableObjects[4] = commissionEmployee;
		payableObjects[5] = basePlusCommissionEmployee;
		
		System.out.println("Invoices and Employees processed polymorphically:");
		
		for (Payable currentPayable : payableObjects)
		{
			System.out.printf("%n%s %n", currentPayable.toString());
			
			if (currentPayable instanceof BasePlusCommissionEmployee)
			{
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee)currentPayable;
				
				employee.setBaseSalary(1.10 * employee.getBaseSalary());
				
				System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
			}
			
			System.out.printf("%s: $%,.2f%n", "payment due", currentPayable.getPaymentAmount());
		}
	}
}
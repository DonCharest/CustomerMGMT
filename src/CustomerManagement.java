import java.util.ArrayList;
import java.util.Scanner;

/***********************************************************************
 * 
 * @author Don Charest Date 02/02/17 Due: 01/31/17 CS342-B1 Spring 2017 Homework
 *         Assignment 1 CustomerManagement Class
 * 
 *         *********************************************************************
 */

public class CustomerManagement
{
	public static CustomerManagement mgmgt = new CustomerManagement();

	ArrayList<Customer> customers;

	/**
	 * CutomerManagement Constructor - declares new ArayList "customers". This
	 * will be the data structure where all customer objects are contained
	 */
	public CustomerManagement()
	{
		customers = new ArrayList<Customer>();
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		RunMenu();
	} // End method: Main

	/**
	 * Method to run the MainMunu(), this method loops until the user exits the
	 * program by choosing RunMenu() option "7". This
	 */
	public static void RunMenu()
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Choose an option:\n" + " \n1. Add a customer" + " \n2. Remove a customer"
				+ " \n3. Update age" + " \n4. Update income" + " \n5. Update credit score"
				+ " \n6. Display all customers" + " \n7. Exit" + " \n ");

		String input = keyboard.next();

		// Add new Customer Object
		if (input.equals("1"))
		{
			System.out.println("Enter Customer ID: ");
			// set new customer object unique "id" value.
			String customerID = keyboard.next();

			System.out.println("Enter Customer's first name: ");
			// set new customer object "first name" value.
			String firstName = keyboard.next();

			System.out.println("Enter Customer's last name: ");
			// set new customer object "last name" value.
			String lastName = keyboard.next();

			System.out.println("Enter Customer's age: ");
			// set new customer object initial "age" value.
			int age = keyboard.nextInt();

			System.out.println("Enter Customer's annual income: ");
			// set new customer object initial "income" value.
			double income = keyboard.nextInt();

			System.out.println("Enter Customer's credit score: ");
			// set new customer object initial "credit score" value.
			int creditScore = keyboard.nextInt();

			// store new customer object into customers data structure with
			// specified parameters.
			mgmgt.AddCustomer(customerID, firstName, lastName, age, income, creditScore);

			// loop RunMenu()
			RunMenu();
		}

		// Remove Customer object
		else
			if (input.equals("2"))
			{
				System.out.println("Enter Customer ID: ");
				// existing customer unique id
				String customerID = keyboard.next();

				// customer ID found.
				if (mgmgt.DoesExist(customerID))
				{
					// invokes RemoveCustomer() method & deletes customer
					// object.
					mgmgt.RemoveCustomer(customerID);
				}

				else
				{
					// customer not found error
					System.out.println("Customer ID invalid");
					System.out.println("\n" + "-------------------------" + "\n");
				}
				// loop RunMenu()
				RunMenu();
			}

			// Update Age --> locate by customerID
			else
				if (input.equals("3"))
				{
					System.out.println("Enter Customer ID : ");
					// existing customer unique id
					String customerID = keyboard.next();

					// customer ID found.
					if (mgmgt.DoesExist(customerID))
					{
						System.out.println("Enter new customer age: ");
						// new age value specified by user.
						int newAge = keyboard.nextInt();
						// UpdateAge() method invoked & age value updated.
						mgmgt.UpdateAge(customerID, newAge);
					}

					else
					{ // customer not found error
						System.out.println("Customer ID invalid");
						System.out.println("\n" + "-------------------------" + "\n");
					}
					// loop RunMenu()
					RunMenu();
				}

				else
					if (input.equals("4")) // Update Income --> locate by
											// customerID
					{
						System.out.println("Enter Customer ID : ");
						// existing customer unique id
						String customerID = keyboard.next();

						// customer ID found.
						if (mgmgt.DoesExist(customerID))
						{
							System.out.println("Enter new customer income: ");
							// new income value specified by user.
							int newIncome = keyboard.nextInt();
							// UpdateIncome() method invoked & income value
							// updated.
							mgmgt.UpdateIncome(customerID, newIncome);
						}

						else
						{ // customer not found error
							System.out.println("Customer ID invalid");
							System.out.println("\n" + "-------------------------" + "\n");
						}
						// loop RunMenu()
						RunMenu();
					}

					else
						if (input.equals("5")) // Update Credit Score --> locate
												// by customerID
						{
							System.out.println("Enter Customer ID : ");
							// existing customer unique id
							String customerID = keyboard.next();

							// customer ID found.
							if (mgmgt.DoesExist(customerID))
							{
								System.out.println("Enter new customer credit score: ");
								// new credit score value specified by user.
								int newCreditScore = keyboard.nextInt();
								// UpdateCreditScore() method invoked & credit
								// score value updated.
								mgmgt.UpdateCreditScore(customerID, newCreditScore);
							}

							else
							{ // customer not found error
								System.out.println("Customer ID invalid");
								System.out.println("\n" + "-------------------------" + "\n");
							}
							// loop RunMenu()
							RunMenu();
						}

						else
							if (input.equals("6")) // Display all Customer
													// objects on console.
							{
								// DisplayCustoemrs() method invoked & all
								// customer objects shown.
								mgmgt.DisplayCustomers();
							}

							else
								if (input.equals("7")) // Exit program
								{
									System.out.println("Bye");
									System.out.println("\n" + "-------------------------" + "\n");
									// Close Scanner class
									keyboard.close();
									// Exit program
									System.exit(0);
								}

								else // Invalid user entry --> Valid responses
										// are between "1" & "7".
								{
									System.out.println("Please choose a valid menu option");
									System.out.println("\n" + "-------------------------" + "\n");
								}
		// loop RunMenu()
		RunMenu();

	} // End Method: RunMenu()

	/**
	 * Method to add a new customer object to the data structure.
	 * 
	 * @param customerID
	 *            - Initial unique reference value linked to each customer
	 *            <entered by user>.
	 * @param firstName
	 *            - Initial Customer's first name value <entered by user>.
	 * @param lastName
	 *            - Initial Customer's last name value <entered by user>.
	 * @param age
	 *            - Initial Customer's age <entered by user>.
	 * @param income
	 *            - Initial Customer's income <entered by user>.
	 * @param creditScore
	 *            - Initial Customer's credit score value <entered by user>.
	 * @precondition User selects option "1" form the RunMenu() and enters in
	 *               the data fields specified in the the Customer Class
	 *               Constructor.
	 * @postcondition A new Customer object has been created with the specified
	 *                parameters.
	 */
	public void AddCustomer(String customerID, String firstName, String lastName, int age, double income,
			int creditScore)
	{
		Customer newCustomer = new Customer(customerID, firstName, lastName, age, income, creditScore);
		customers.add(newCustomer);

		System.out.println("\n" + "-------------------------" + "\n");
	} // End Method: AddCustomer()

	/**
	 * Method to remove a Customer object from the data structure.
	 * 
	 * @param customerID
	 *            - Unique reference linked to each customer <entered by user>.
	 * @Precondition Customer object already exists in data structure.
	 * @Postcondition Customers object will be removed.
	 */
	public void RemoveCustomer(String customerID)
	{
		// loop thru all customer id's to locate user specified.
		for (int i = 0; i < customers.size(); i++)
		{
			// DoesExist method has already verified that the unique customerID
			// exist.
			// Thus, this is the only path and will locate the customer by ID.
			if (customers.get(i).customerID.equals(customerID))
			{
				System.out.println("CustomerID: " + customers.get(i).customerID + " has been removed");
				System.out.println("\n" + "-------------------------" + "\n");
				// writes new customer object parameters into the customers data
				// structure.
				customers.remove(customers.get(i));
			}
		}
	} // End method: RemoveCustumer()

	/**
	 * Method to update a specified customer's age value.
	 * 
	 * @param customerID
	 *            - Unique reference linked to each customer <entered by user>.
	 * @param NewAge
	 *            - New value specified in "option 3" of the RunMenu() to
	 *            replace the initial income value.
	 * @Precondition Customer already exists with an initial age value.
	 * @Postcondition Customers initial age value will be replaced with NewAge
	 *                value.
	 */
	public void UpdateAge(String customerID, int newAge)
	{
		Customer found = null;
		// loop thru all customer id's to locate user specified.
		for (int i = 0; i < customers.size(); i++)
		{
			// DoesExist() method has already verified that the unique
			// customerID exist.
			// Thus, this is the only path and will locate the customer by ID.
			if (customers.get(i).customerID.equals(customerID))
			{
				found = customers.get(i);
				// rewrite existing field "age" with "NewAge".
				found.age = newAge;
			}
		}
		System.out.println("\n" + "-------------------------" + "\n");
	} // End method: UpdateAge()

	/**
	 * Method to update a specified customer's income value.
	 * 
	 * @param customerID
	 *            - Unique reference linked to each customer <entered by user>.
	 * @param NewIncome
	 *            - New value specified in "option 4" of the RunMenu() to
	 *            replace the initial income value.
	 * @Precondition Customer already exists with an initial income value.
	 * @Postcondition Customers initial income value will be replaced with
	 *                NewIncome value.
	 */
	public void UpdateIncome(String customerID, int NewIncome)
	{
		Customer found = null;
		// loop thru all customer id's to locate user specified.
		for (int i = 0; i < customers.size(); i++)
		{
			// DoesExist() method has already verified that the unique
			// customerID exist.
			// Thus, this is the only path and will locate the customer by ID.
			if (customers.get(i).customerID.equals(customerID))
			{
				found = customers.get(i);
				// rewrite existing field "income" with "NewIncome".
				found.income = NewIncome;
			}
		}
		System.out.println("\n" + "-------------------------" + "\n");
	} // End method: UpdateIncome()

	/**
	 * Method to update a specified customer's credit score value.
	 * 
	 * @param customerID
	 *            - Unique reference linked to each customer <entered by user>.
	 * @param NewCreditScore
	 *            - New value specified in "option 5" of the RunMenu() to
	 *            replace the initial creditScore value.
	 * @Precondition Customer already exists with an initial credit score value.
	 * @Postcondition Customers initial creditScore value will be replaced with
	 *                NewCreditScore value.
	 */
	public void UpdateCreditScore(String customerID, int NewCreditScore)
	{
		Customer found = null;
		// loop thru all customer id's to locate user specified.
		for (int i = 0; i < customers.size(); i++)
		{
			// DoesExist() method has already verified that the unique
			// customerID exist.
			// Thus, this is the only path and will locate the customer by ID.
			if (customers.get(i).customerID.equals(customerID))
			{
				found = customers.get(i);
				// rewrite existing field "creditScore" with "NewCreditScore".
				found.creditScore = NewCreditScore;
			}
		}
		System.out.println("\n" + "-------------------------" + "\n");
	} // End method: UpdateCreditScore()

	/**
	 * Method to display all customers in data structure on console
	 */
	public void DisplayCustomers()
	{
		// loop thru all customer object fields in customers data structure
		for (int i = 0; i < customers.size(); i++)
		{
			Customer c = customers.get(i);

			System.out.println("Customer ID: " + c.customerID + "\n" + "First Name: " + c.firstName + "\n"
					+ "Last Name: " + c.lastName + "\n" + "Age: " + c.age + "\n" + "Income: " + c.income + "\n"
					+ "Credit Score: " + c.creditScore + "\n");
		}
		System.out.println("\n" + "-------------------------" + "\n");
	} // Update method: DisplayCustomers()

	/**
	 * Method to check if a customer exist in the data structure.
	 * 
	 * @param customerID
	 *            - Unique reference linked to each customer <entered by user>.
	 * @return Returns true if the customer id entered exist in the the
	 *         customers data structure. Returns False is the customer id is not
	 *         found in the customers data structure.
	 */
	public boolean DoesExist(String customerID)
	{
		// loop thru all customers --> search for "customerID"
		for (int i = 0; i < customers.size(); i++)
		{
			// Customer ID found
			if (customers.get(i).customerID.equals(customerID))
				return true;
		}
		// Customer ID not found
		return false;
	} // End method: DoesExist()

	public class Customer
	{
		public String customerID;
		public String firstName;
		public String lastName;
		public int age;
		public double income;
		public int creditScore;

		/**
		 * Constructor for Customer Object.
		 * 
		 * @param customerID
		 *            - Unique reference linked to each customer <entered by
		 *            user>.
		 * @param firstName
		 *            - Customer's first name <entered by user>.
		 * @param lastName
		 *            - Customer's last name <entered by user>.
		 * @param age
		 *            - Customer's age <entered by user>.
		 * @param income
		 *            - Customer's income <entered by user>.
		 * @param creditScore
		 *            - Customer's credit score <entered by user>.
		 */
		public Customer(String customerID, String firstName, String lastName, int age, double income, int creditScore)
		{
			this.customerID = customerID;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.income = income;
			this.creditScore = creditScore;
		}
	} // End Customer Class

} // End CustomerManager Class
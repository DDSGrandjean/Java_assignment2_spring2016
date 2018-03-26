//DYLAN GRANDJEAN
//Assignment Java-A2
//Program designed to calculate the shipping price of an item

import java.util.Scanner;

public class ShippingCharge
{

	public static void main (String[] args)
	{
		//Variable declaration and initialization
		final String MYNAME = "DYLAN GRANDJEAN";
		final double ZONE_A_FEE = 0.6,
					 ZONE_C_FEE = 1.25,
					 ZONE_D_FEE = 1.4,
					 SERVICE_2_FEE = 10,
					 SERVICE_3_FEE = 25,
					 HAZARD_2_FEE = 0.1,
					 HAZARD_3_FEE = 0.25;

		double weight,
			   price;
		char zone;
		int serviceCode,
			hazardCode;
		String customerName;

		boolean error = false;

		//Scanner initialization
		Scanner userInput = new Scanner(System.in);

		//Print the programmer's name
		System.out.println(MYNAME + "\n");

		//Get the package's weight
		System.out.printf("%-20s", "Package weight:");
		weight = userInput.nextDouble();

		//Get the destination zone
		System.out.printf("%-20s", "Zone <A-D>:");
		zone = userInput.next().charAt(0);

		//Get the service code
		System.out.printf("%-20s", "Special Service:");
		serviceCode = userInput.nextInt();

		//Get the hazardous code
		System.out.printf("%-20s", "Hazardous Code:");
		hazardCode = userInput.nextInt();

		//Get the customer's name
		userInput.nextLine();
		System.out.printf("%-20s", "Customer:");
		customerName = userInput.nextLine();


		if (weight <= 0)
		{
			//Displays if the weight is invalid
			System.out.printf("\nPackage weight invalid: %.2f", weight);
			error = true;
		}

		//Determine the shipping area or zone
		switch (zone)
		{
			//Determine outcome for each zone based on user input
			case 'A':
			case 'a':
				price = weight * ZONE_A_FEE;
				break;

			case 'B':
			case 'b':
				price = weight;
				break;

			case 'C':
			case 'c':
				price = weight * ZONE_C_FEE;
				break;

			case 'D':
			case 'd':
				price = weight * ZONE_D_FEE;
				break;

			default:
				//Instantiate price to avoid error
				price = 0;

				//Displays error message for the wrong zone
				System.out.printf("\nZone <A-D> invalid: %s", zone);
				error = true;
				break;
		}

		//Determine the service based on user input
		if (serviceCode == 2)
			price += SERVICE_2_FEE;
		else if (serviceCode == 3)
			price += SERVICE_3_FEE;
		else
			if (serviceCode != 1)
			{
				//Displays error message if the service code is invalid
				System.out.printf("\nService Code <1-3> invalid: %d", serviceCode);
				error = true;
			}

		//Determine the hazardous code based on user input
		if (hazardCode == 2)
			price += (price * HAZARD_2_FEE);
		else if (hazardCode == 3)
			price += (price * HAZARD_3_FEE);
		else
			if (hazardCode != 1)
			{
				//Displays error message if the hazard code is invalid
				System.out.printf("\nHazard Code <1-3> invalid: %d", hazardCode);
				error = true;
			}

		if (!error)
		{
			System.out.printf("\n\nFor customer %s the cost is $%,.2f\n", customerName, price);
		}
		else
		{
			System.out.printf("\n\nFor customer %s the cost is not available.\n", customerName);
		}
	}
}

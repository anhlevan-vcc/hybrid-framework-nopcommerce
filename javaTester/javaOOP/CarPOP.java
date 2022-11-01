package javaOOP;

public class CarPOP {
	static String carCompany;
	static String carType;
	static String fuelType;
	static Float mileAge;
	static Double carPrice;

	public static void main(String[] args) {
		carCompany = "Honda";
		carType = "City";
		fuelType = "Petrol";
		mileAge = 200f;
		carPrice = 50000d;

		System.out.println("Car company = " + carCompany);
		System.out.println("Car Type = " + carType);
		System.out.println("Car fuel = " + fuelType);
		System.out.println("Car mile = " + mileAge);
		System.out.println("Car Price = " + carPrice);
	}

}

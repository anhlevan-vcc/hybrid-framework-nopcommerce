package javaOOP;

public class CarOOP {
	private String carCompany;
	private String carType;
	private String fuelType;
	private Float mileAge;
	private Double carPrice;

	protected CarOOP(String carCompany, String carType, String fuelType, Float mileAge, Double carPrice) {
		this.carCompany = carCompany;
		this.carType = carType;
		this.fuelType = fuelType;
		this.mileAge = mileAge;
		this.carPrice = carPrice;
	}

	protected String getCarCompany() {
		return carCompany;
	}

	protected void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	protected String getCarType() {
		return carType;
	}

	protected void setCarType(String carType) {
		this.carType = carType;
	}

	protected String getFuelType() {
		return fuelType;
	}

	protected void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	protected Float getMileAge() {
		return mileAge;
	}

	protected void setMileAge(Float mileAge) {
		this.mileAge = mileAge;
	}

	protected Double getCarPrice() {
		return carPrice;

	}

	protected void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}

	protected void showCarInfo() {
		System.out.println("Car company = " + carCompany);
		System.out.println("Car Type = " + carType);
		System.out.println("Car fuel = " + fuelType);
		System.out.println("Car mile = " + mileAge);
		System.out.println("Car Price = " + carPrice);
	}

	public static void main(String[] args) {
		CarOOP honda = new CarOOP("HonDa12", "City", "Pertol", 200f, 50000d);
		honda.showCarInfo();

		// Toyota
		CarOOP toyota = new CarOOP("Toyota", "camry", "hydro", 500f, 100000d);
		toyota.showCarInfo();
	}

}

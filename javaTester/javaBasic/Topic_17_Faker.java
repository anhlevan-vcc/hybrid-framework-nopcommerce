package javaBasic;

import java.util.Locale;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class Topic_17_Faker {

	public static void main(String[] args) {
		// US
		Faker faker = new Faker();
		faker.business().creditCardType();
		String firstNameEn = faker.address().firstName();
		String cityEn = faker.address().city();
		System.out.println(firstNameEn);
		System.out.println(cityEn);

		System.out.println(faker.finance().creditCard(CreditCardType.VISA));

		// VN
		Faker fakerVi = new Faker(new Locale("vi"));
		String firstName = fakerVi.address().firstName();
		String city = fakerVi.address().city();
		System.out.println(firstName);
		System.out.println(city);
	}

}

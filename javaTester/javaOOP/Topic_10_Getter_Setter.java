package javaOOP;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topic_10_Getter_Setter {
	private String personName;
	private int personAge;
	private int personPhone;
	private float personBankAccount;

	public Topic_10_Getter_Setter() {
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		if (personName == null || personName.isEmpty()) {
			throw new IllegalArgumentException("Tên ko đc rỗng");
		} else {
			this.personName = personName;
		}
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		if (personAge > 18 && personAge < 60) {
			throw new IllegalArgumentException("Tuổi không hợp lệ");
		} else {
			this.personAge = personAge;
		}
	}

	public int getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(int personPhone) {
		// Ép kiểu từ int qua String
		if (!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Phone phải bắt đầu bằng ");
		} else if (personPhone < 10 || personPhone > 11) {
			throw new IllegalArgumentException("Phone phải từ 10-11 số ");
		} else {
			this.personPhone = personPhone;
		}
	}

	public float getPersonBankAccount() {
		return personBankAccount;
	}

	public void setPersonBankAccount(float personBankAccount) {
		this.personBankAccount = personBankAccount;
	}

	public static void main(String[] args) {

	}

}

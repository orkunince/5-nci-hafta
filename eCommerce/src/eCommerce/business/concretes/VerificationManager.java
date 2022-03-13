package eCommerce.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.business.abstracts.VerificationService;

public class VerificationManager implements VerificationService {

	UserCheckManager userCheckManager;

	List<String> mailList = new ArrayList<String>();

	// sim�lasyon mail do�rulama
	@Override
	public void sendToVerifyMail(String mail) {
		mailList.add(mail);
		System.out.println(mail + " ba�ar�yla do�ruland�");

	}

	// sim�lasyon do�rulama maili g�nderme
	@Override
	public void verifyMail(String mail) {
		System.out.println(mail + " kullan�c�ya do�rulama maili g�nderldi ");

	}

	@Override
	public boolean checkVerifyAccount(String mail) {
		if (mailList.contains(mail)) {
			return true;
		}
		return false;
	}

}

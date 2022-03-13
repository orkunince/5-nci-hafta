package eCommerce.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import eCommerce.business.abstracts.UserCheckService;
import eCommerce.entities.concretes.User;

public class UserCheckManager implements UserCheckService {

	// Database'den mail listesi gelmi� gibi kontrol edece�iz.

	List<String> mailList = new ArrayList<String>();

	@Override
	public boolean checkFirstName(User user) {

		if (user.getFirstName().isEmpty()) {
			System.out.println("�sim bo� ge�ilemez..");
			return false;
		} else if (user.getFirstName().length() < 2) {
			System.out.println("�sim 2 karakterden k���k olamaz..");
			return false;
		}

		return true;
	}

	@Override
	public boolean checkLastName(User user) {

		if (user.getLastName().isEmpty()) {
			System.out.println("Soyisim bo� ge�ilemez..");
			return false;
		} else if (user.getLastName().length() < 2) {
			System.out.println("Soyisim 2 karakterden k���k olamaz..");
			return false;
		}

		return true;
	}

	@Override
	public boolean checkEmail(User user) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		if (user.getMail().isEmpty()) {
			System.out.println("Email alan� bo� b�rak�lamaz.");
			return false;
		} else if (pattern.matcher(user.getMail()).find() == false) {
			System.out.println("Girilen email adresi formata uygun de�il. �rnek: ornek@ornek.com");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPassword(User user) {

		if (user.getPassword().isEmpty()) {
			System.out.println("�ifre bo� ge�ilemez.");
			return false;
		} else if (user.getPassword().length() < 6) {
			System.out.println("Parola 6 karakterden k���k olamaz.");
			return false;
		}
		return true;

	}

	@Override
	public boolean uniqueEmail(User user) {

		if (mailList.contains(user.getMail())) {
			System.out.println("Bu mail adresi sistemde mevcut. Farkl� bir mail deneyiniz.");
			return false;
		}

		return true;
	}

	@Override
	public boolean isValid(User user) {
		
		if (checkFirstName(user) && checkLastName(user) && checkEmail(user) && checkPassword(user)
				&& uniqueEmail(user)) {
			return true;
		}
		
		return false;
	}

}

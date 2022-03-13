package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstratcs.UserDao;
import eCommerce.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	
	List<User> users=new ArrayList<User>();
	

	@Override
	public void add(User user) {
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate ile gŁncellendi. " +user.getFirstName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate ile silindi. " +user.getFirstName());
		
	}

	@Override
	public User get(int id) {
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public boolean getMail(String mail) {
		for (User user : users) {
			if(user.getMail()==mail) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getPassword(String password) {
		for (User user : users) {
			if(user.getPassword()==password) {
				return true;
			}
		}
		return false;
	}
	
	

}

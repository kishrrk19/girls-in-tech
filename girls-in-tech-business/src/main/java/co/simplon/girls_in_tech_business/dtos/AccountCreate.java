package co.simplon.girls_in_tech_business.dtos;

public record AccountCreate(String username, String password) {

	@Override
	public String toString() {
		return "AccountCreate [username=" + username + ", password=[PROTECTED]"  + "]";
	}
	
	

}

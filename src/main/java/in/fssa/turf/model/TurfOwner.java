package in.fssa.turf.model;

public class TurfOwner{

	private static int id;
	@Override
	public String toString() {
		return "TurfOwner [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	private String name;
	private String email;
	private String password;
	public static int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setActive(boolean boolean1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
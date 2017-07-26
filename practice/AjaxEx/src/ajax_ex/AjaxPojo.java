package ajax_ex;

import javax.jdo.annotations.*;

@PersistenceCapable
public class AjaxPojo {

	@Persistent
	private String fav_food;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String user_name;
	
	@Persistent
	private String email;
	
	public String getFav_food() {
		return fav_food;
	}
	public void setFav_food(String fav_food) {
		this.fav_food = fav_food;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Msg= [fav_food=" + fav_food + ", user_name=" + user_name + ", email=" + email + "]";
	}
	
	
	
	
}
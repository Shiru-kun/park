//package co.mz.cth.park.model;
//
//import java.util.Collection;
//
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.OneToOne;
//import co.mz.cth.park.model.enums.User_type;
//
//
//@Entity
//public class UserAccount {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private long id;
//	
//	@Enumerated(EnumType.STRING)
//	private User_type user_type;
//	
//	private String password;
//	private String username;
//	
//	@OneToOne(targetEntity=User.class)
//	private User user;
//	
//
//	@ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable( 
//        name = "users_roles", 
//        joinColumns = @JoinColumn(
//          name = "user_id", referencedColumnName = "id"), 
//        inverseJoinColumns = @JoinColumn(
//          name = "role_id", referencedColumnName = "id")) 
//    private Collection<Role> roles;
//	
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public User_type getUser_type() {
//		return user_type;
//	}
//
//	public void setUser_type(User_type user_type) {
//		this.user_type = user_type;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
//}

//package co.mz.cth.park.model;
//
//import java.util.Collection;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//
//@Entity
//public class Role{
//
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
// 
//    private String name;
//
//    @ManyToMany(mappedBy = "roles")
//    private Collection<UserAccount> usersAccounts;
//    @ManyToMany
//    @JoinTable(
//        name = "roles_privileges", 
//        joinColumns = @JoinColumn(
//          name = "role_id", referencedColumnName = "id"), 
//        inverseJoinColumns = @JoinColumn(
//          name = "privilege_id", referencedColumnName = "id"))
//    private Collection<Privilege> privileges;
//    public Role(String name) {
//		super();
//		this.setName(name);
//	}
//    
//    public Role() {
//		
//	}
//    
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//}

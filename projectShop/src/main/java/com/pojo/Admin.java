package com.pojo;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    
    @Id
    private int id; // Assuming id is of type int
    
    private String username;
    private String password;
    
    public Admin(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    public Admin() {
        super();
    }
    // Getters and setters for username, password, and id
    // Omitted for brevity
}

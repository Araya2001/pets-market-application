/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pets.market.domain;
import pets.market.dto.RoleType;

public class User {
    
    public String firstName;
    public String lastName;
    private String password;
    private Integer id;
    private RoleType roleType;
    
  

    // Constructor de la clase
    public User(String firstName, String lastName, String password, int id, RoleType roleType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.id = id;
        this.roleType = roleType;
    }

    // Métodos "get" y "set" para firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Métodos "get" y "set" para lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Métodos "get" y "set" para password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Métodos "get" y "set" para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos "get" y "set" para role
    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}

    
      


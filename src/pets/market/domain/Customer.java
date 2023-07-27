/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pets.market.domain;


public class Customer {
    
    public String fullName;
    public String email;
    private String id;
    
    
    // Constructor
    public Customer(String fullName, String email, String id) {
        this.fullName = fullName;
        this.email = email;
        this.id = id;
    }

    // Método "get" para fullName
    public String getFullName() {
        return fullName;
    }

    // Método "set" para fullName
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Método "get" para email
    public String getEmail() {
        return email;
    }

    // Método "set" para email
    public void setEmail(String email) {
        this.email = email;
    }

    // Método "get" para id
    public String getId() {
        return id;
    }

    // Método "set" para id
    public void setId(String id) {
        this.id = id;
    }
}
  
    


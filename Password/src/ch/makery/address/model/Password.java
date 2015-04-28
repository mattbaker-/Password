package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Password {
	private final StringProperty password;
	
	/**
     * Default constructor.
     */
    public Password() {
    	this(null);
    }
    
    public Password(String pw) {
    	this.password = new SimpleStringProperty(pw);
    }
    
    public String getPassword() {
        return password.get();
    }

    public void setFirstName(String Password) {
        this.password.set(Password);
    }

    public StringProperty firstNameProperty() {
        return password;
    }
}

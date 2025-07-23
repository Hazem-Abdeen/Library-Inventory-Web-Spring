package org.eastnets.bean;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.eastnets.model.User;
import org.eastnets.service.AuthService;
import java.io.Serializable;

@Named("loginBean")
@ViewScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private User user;

    private final AuthService authService = new AuthService();

    public String login() {

        user = authService.authenticate(username, password);
        if (user != null) {
            return "books.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid username or password", null));
            return null;
        }
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}

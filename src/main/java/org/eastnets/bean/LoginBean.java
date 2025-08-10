package org.eastnets.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.eastnets.model.User;
import org.eastnets.service.AuthService;
import java.io.Serializable;

@SessionScoped
@Named("loginBean")
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

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getFormattedUsername() {
        if (user != null && user.getUsername() != null && !user.getUsername().isEmpty()) {
            String name = user.getUsername();
            return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }
        return "";
    }
}
//last modified: 2025-08-10

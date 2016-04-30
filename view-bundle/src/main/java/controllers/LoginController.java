package controllers;

import api.LoginAPI;
import org.picketlink.Identity;
import org.picketlink.credential.DefaultLoginCredentials;
import quilifier.DBLogin;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ImadYamane on 29/04/16.
 */
@Named
public class LoginController {

    @Inject
    @DBLogin
    private LoginAPI loginAPI;

    @Inject
    private Logger logger;

    @Inject
    private FacesContext facesContext;

    /**
     * Login user
     * @return page to proceed
     */
    public String login() {
        if(loginAPI.login()){
            logger.log(Level.FINE, "login succeeded. userId:" + loginAPI.getCredentials().getUserId());
            return this.getHomePage();
        }
        else {
            logger.log(Level.WARNING, "login failed. userId:" + loginAPI.getCredentials().getUserId());
            //todo: multi language
            this.facesContext.addMessage("login-message", new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                    "Authentication was unsuccessful.  Please check your credentials."));
            return "";
        }
    }

    /**
     * Logout user
     * @return login home
     */
    public String logout() {
        if(this.getIdentity().isLoggedIn()){
            loginAPI.logout();
        }
        return this.getLoginPage();
    }

    /**
     * Login Credentials
     * @return user default Login Credentials
     */
    public DefaultLoginCredentials getCredentials() {
        return loginAPI.getCredentials();
    }

    /**
     * Login User Identity
     * @return user default Login Credentials
     */
    public Identity getIdentity() {
        return loginAPI.getIdentity();
    }

    public String getHomePage(){
        return "pretty:home";
    }

    public String getLoginPage(){
        return "pretty:login";
    }
}

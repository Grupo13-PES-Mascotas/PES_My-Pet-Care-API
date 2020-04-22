package org.pesmypetcare.usermanagerlib.datacontainers;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * @author Santiago Del Rey
 */
public class UserData {
    private String username;
    private String email;
    private String password;

    private List<String> groupSubscriptions;

    /**
     * Creates a UserData object with the specified username, email and password.
     * @param username The user's username
     * @param email The user's email
     * @param password The user's password
     */
    public UserData(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserData(String username, String email, String password, List<String> groupSubscriptions) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.groupSubscriptions = groupSubscriptions;
    }

    /**
     * Gets the user's username.
     * @return The user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's username.
     * @param username The user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the user's email.
     * @return The user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     * @param email The user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's password.
     * @return The user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     * @param password The user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Creates a user data JSONObject.
     * @return The JSONObject for the user data
     * @throws JSONException Thrown to indicate a problem with the JSON API
     */
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("email", email);
        json.put("password", password);
        return json;
    }

    public List<String> getGroupSubscriptions() {
        return groupSubscriptions;
    }

    public void setGroupSubscriptions(List<String> groupSubscriptions) {
        this.groupSubscriptions = groupSubscriptions;
    }

    @NonNull
    @Override
    public String toString() {
        return "UserData{" +
            "username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", groupSubscriptions=" + groupSubscriptions +
            '}';
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof UserData) {
            return ((UserData) obj).getUsername().equals(this.username)
                && ((UserData) obj).getEmail().equals(this.email)
                && ((UserData) obj).getPassword().equals(this.password)
                && ((UserData) obj).getGroupSubscriptions().equals(this.groupSubscriptions);
        }
        return false;
    }
}

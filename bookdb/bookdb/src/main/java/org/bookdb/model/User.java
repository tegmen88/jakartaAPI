package org.bookdb.model;

import java.util.UUID;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name="t_user")
public class User{

    private Long id;
    private UUID apiKey;
    private String userName;
    private String password;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UUID getApiKey() {
        return apiKey;
    }
    public void setApiKey(UUID apiKey) {
        this.apiKey = apiKey;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
package org.bookdb.model;

import java.util.List;
import java.util.UUID;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name="t_user")
public class User{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private UUID apiKey;
    private String userName;
    private String password;

    // Skapar en user-kolumn i t_book
    @OneToMany(mappedBy = "user")
    private List<Book> books;

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
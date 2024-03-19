package com.lucasmotta.todosimple.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "user.TABLE_NAME")
public class user {
    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Long id;

    @Column(name = "username",unique = true,length = 100,nullable = false)
    private String username;

    @Column(name = "password",length = 60,nullable = false)
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<task> tasks = new ArrayList<task>();


    public List<task> getTasks() {
        return this.tasks;
    }

    public void setTasks(List<task> tasks) {
        this.tasks = tasks;
    }


    public user() {
    }

    public user(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final user other = (user) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    
    
}

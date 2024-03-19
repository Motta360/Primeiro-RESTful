/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lucasmotta.todosimple.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = task.TABLE_NAME)
public class task {
    public static final String TABLE_NAME = "task";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,updatable = false)
    private user usuario;

    @Column(name = "description",length = 255,nullable = false)
    private String description;


    public task() {
    }

    public task(long id, user usuario, String description) {
        this.id = id;
        this.usuario = usuario;
        this.description = description;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public user getUsuario() {
        return this.usuario;
    }

    public void setUsuario(user usuario) {
        this.usuario = usuario;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public task id(long id) {
        setId(id);
        return this;
    }

    public task usuario(user usuario) {
        setUsuario(usuario);
        return this;
    }

    public task description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof task)) {
            return false;
        }
        task task = (task) o;
        return id == task.id && Objects.equals(usuario, task.usuario) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, description);
    }
    
}

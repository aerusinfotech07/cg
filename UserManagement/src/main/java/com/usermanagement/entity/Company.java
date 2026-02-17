package com.usermanagement.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "company")
public class Company implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "catch_phrase")
    private String catchPhrase;
    
    @Column(name = "bs")
    private String bs;
    
    public Company() {
    }
    
    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCatchPhrase() {
        return catchPhrase;
    }
    
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }
    
    public String getBs() {
        return bs;
    }
    
    public void setBs(String bs) {
        this.bs = bs;
    }
}

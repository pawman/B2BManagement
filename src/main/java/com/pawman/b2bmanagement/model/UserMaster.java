package com.pawman.b2bmanagement.model;

import javax.persistence.*;

@Entity
public class UserMaster implements Mastered{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public UserMaster() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}

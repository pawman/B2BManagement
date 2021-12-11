package com.pawman.b2bmanagement.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Iterated {
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_master_id", nullable = false)
    protected UserMaster userMaster;

    protected int version = 1;

    public UserMaster getUserMaster() {
        return userMaster;
    }

    public void setUserMaster(UserMaster userMaster) {
        this.userMaster = userMaster;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void increaseVersion() {
        this.version = version + 1;
    }
}
package com.adinfi.admaster.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.adinfi.admaster.util.ProfileNames;

@Entity
@Table(name = "PROFILE")
public class Profile {
	
	@Id
    @Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private ProfileNames name;

    @ManyToMany(mappedBy = "profiles", fetch = FetchType.LAZY)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfileNames getName() {
        return name;
    }

    public void setName(ProfileNames name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}

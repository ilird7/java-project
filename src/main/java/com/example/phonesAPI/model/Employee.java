package com.example.phonesAPI.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="employee")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"},
        allowGetters=true)
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nickname")
    private String nickname;

    @Column(name="name")
    private String name;

    @Column(name="workingyears")
    private int workingyears;

    public Employee(String nickname, String name, int workingyears) {
        this.nickname = nickname;
        this.name = name;
        this.workingyears = workingyears;
    }

    public Employee () {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkingyears() {
        return workingyears;
    }

    public void setWorkingyears(int workingyears) {
        this.workingyears = workingyears;
    }
}

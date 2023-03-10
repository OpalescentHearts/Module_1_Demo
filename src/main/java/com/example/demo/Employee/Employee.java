package com.example.demo.Employee;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String FirstName;
    private String LastName;
    private LocalDate Birthday;
    private String FavoriteItem;
    private String FavoriteFood;
    @Transient
    private Integer Age;

    public Employee() {
    }

    public Employee(Long id, String firstName,
                    String lastName,
                    LocalDate birthday,
                    String favoriteItem,
                    String favoriteFood) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        Birthday = birthday;
        FavoriteItem = favoriteItem;
        FavoriteFood = favoriteFood;
    }

    public Employee(String firstName,
                    String lastName,
                    LocalDate birthday,
                    String favoriteItem,
                    String favoriteFood) {
        FirstName = firstName;
        LastName = lastName;
        Birthday = birthday;
        FavoriteItem = favoriteItem;
        FavoriteFood = favoriteFood;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public LocalDate getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDate birthday) {
        Birthday = birthday;
    }

    public Integer getAge() {
        return Period.between(this.Birthday, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getFavoriteItem() {
        return FavoriteItem;
    }

    public void setFavoriteItem(String favoriteItem) {
        FavoriteItem = favoriteItem;
    }

    public String getFavoriteFood() {
        return FavoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        FavoriteFood = favoriteFood;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Birthday=" + Birthday +
                ", Age=" + Age +
                ", FavoriteItem='" + FavoriteItem + '\'' +
                ", FavoriteFood='" + FavoriteFood + '\'' +
                '}';
    }
}
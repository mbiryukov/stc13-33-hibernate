package ru.innopolis.stc13.hibernate.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "mobile")
public class MobilePhone {
    private Long id;
    private String model;
    private int cost;
    private String developer;

    public MobilePhone() {
    }

    public MobilePhone(String model, int cost, String developer) {
        this.model = model;
        this.cost = cost;
        this.developer = developer;
    }

    public MobilePhone(Long id, String model, int cost, String developer) {
        this.id = id;
        this.model = model;
        this.cost = cost;
        this.developer = developer;
    }

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                ", developer='" + developer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilePhone that = (MobilePhone) o;
        return cost == that.cost &&
                Objects.equals(id, that.id) &&
                Objects.equals(model, that.model) &&
                Objects.equals(developer, that.developer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, cost, developer);
    }
}

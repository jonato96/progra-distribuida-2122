package com.programacion.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owners")
@NamedQuery(name = "Owner.findAll", query = "SELECT o FROM Owner o ORDER BY o.id")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Column(name = "first_name")
    @Getter @Setter
    private String firtName;

    @Column(name = "last_name")
    @Getter @Setter
    private String lastName;

    @Column
    @Getter @Setter
    private String city;

    @Column
    @Getter @Setter
    private String address;

    @Column
    @Getter @Setter
    private String telephone;

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", firtName='" + firtName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", adress='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}

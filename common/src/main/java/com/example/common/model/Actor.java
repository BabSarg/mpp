package com.example.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String country;

    @Column
    private String description;

    @OneToOne
    private Image image;

    @ManyToMany
    @JoinTable(name = "actor_movie",
    joinColumns = @JoinColumn(name = "actor_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;



}

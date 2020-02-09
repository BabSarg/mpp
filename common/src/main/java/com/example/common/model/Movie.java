package com.example.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(name = "movie_multiCat",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "multiCat_id"))
    private List<MultiCat> multiCats;
//
//    @ManyToMany
//    @JoinTable(name = "movie_category",
//            joinColumns = @JoinColumn(name = "movie_id"),
//    inverseJoinColumns = @JoinColumn (name = "category_id"))
//    private List<Category> categories;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date year;
    @OneToOne
    private Image image;
    @Column
    private double rating;
    @Column
    private String comment;
    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;
    @Column
    private int view;
    @ManyToMany(mappedBy = "movies")
    private List<User> users;


}

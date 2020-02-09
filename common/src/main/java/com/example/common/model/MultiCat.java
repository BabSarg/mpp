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
@Table(name = "multi_cats")
public class MultiCat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "multiCats")
    private List<Category> categories;
    @ManyToMany(mappedBy = "multiCats")
    private List<Movie> movies;

}

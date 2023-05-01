package com.jlaffey.bugtrackersite.models;
import jakarta.persistence.*;


import lombok.*;


import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String name;


    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Project> projects;

}
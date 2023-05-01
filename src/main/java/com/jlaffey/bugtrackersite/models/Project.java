package com.jlaffey.bugtrackersite.models;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Bug> bugs;


}
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

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "project")
    private List<Bug> bugs;

    // No need for getters and setters, Lombok generates them for you
}
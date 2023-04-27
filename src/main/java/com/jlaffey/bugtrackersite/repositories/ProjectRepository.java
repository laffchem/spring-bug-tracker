package com.jlaffey.bugtrackersite.repositories;

import com.jlaffey.bugtrackersite.models.Organization;
import com.jlaffey.bugtrackersite.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByOrganization(Organization organization);

}


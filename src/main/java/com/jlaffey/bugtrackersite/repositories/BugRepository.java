package com.jlaffey.bugtrackersite.repositories;

import com.jlaffey.bugtrackersite.models.Bug;
import com.jlaffey.bugtrackersite.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {

    List<Bug> findByProject(Project project);



}


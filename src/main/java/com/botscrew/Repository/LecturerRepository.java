package com.botscrew.Repository;

import com.botscrew.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerRepository extends JpaRepository<Lector, Integer> {

    List<Lector> findByNameContainingOrSurnameContaining(String name, String surnameRegex);

}

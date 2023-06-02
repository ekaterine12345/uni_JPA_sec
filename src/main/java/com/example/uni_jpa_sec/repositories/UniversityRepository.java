package com.example.uni_jpa_sec.repositories;

import com.example.uni_jpa_sec.models.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Long>{

    List<University> getByAddressAndName(String address, String name);
    List<University> getByIdAndCreatedAt(Long Id, Date CreatedAt);
    Optional<University> findById(Long Id);
}

package com.jimjacob.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jimjacob.example.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {}

package com.student_crud_api.repository;

import com.student_crud_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select * from student where roll_no= ?1",nativeQuery = true)
    Student getByRollNo(String rollNo);
}

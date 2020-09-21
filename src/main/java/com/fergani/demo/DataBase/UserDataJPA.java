package com.fergani.demo.DataBase;

import com.fergani.demo.Models.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By ${
 * FERGANI DIA EL EDDINE
 * }  On
 * 19
 * sept.
 * 2020
 */
@Repository
public interface UserDataJPA extends JpaRepository<UserJPA,Integer> {


    @Query(value ="SELECT id ,first_name ,last_name FROM UserJPA  where first_name = :name",nativeQuery = true)
    List<UserJPA> GetUsersByName(@Param("name") String name);

}

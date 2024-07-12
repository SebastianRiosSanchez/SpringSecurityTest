package com.app.persistence.repository;

import com.app.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsername(String username); //Se crea la sentencia a partir del nombre del método.

    //Optional<UserEntity> findUserEntityByUsername(String username);
//
//    @Query("SELECT u FROM UserEntity u WHERE u.username = ?")
//        //Se crea la sentencia con la anotación QUERY
//    Optional<UserEntity> findUser(String username);

}

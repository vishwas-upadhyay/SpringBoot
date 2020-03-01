package com.vishwas.springsecurityjdbcauthenticator.repository;

import com.vishwas.springsecurityjdbcauthenticator.model.MyUsers;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<MyUsers,String> {

    Optional<MyUsers> findByUsername(String userName);

}

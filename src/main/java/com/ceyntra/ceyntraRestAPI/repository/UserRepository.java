package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.model.LoginModel;
import com.ceyntra.ceyntraRestAPI.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    @Query("SELECT a.userID from UserModel a where a.email = :email and a.hashedPassword = :password and a.userType = :userType")
    public List<String> getMatchingUserIdForCredential(@Param("email") String email, @Param("password") String password, @Param("userType") int userType);

    @Query("SELECT a.email from UserModel a where a.email = :email and a.userType = :userType")
    public List<String> getMatchingUserEmail(@Param("email") String email, @Param("userType") int userType);

    @Query("SELECT a.userID from UserModel a where a.hashedPassword = :password and a.userType = :userType")
    public List<String> getMatchingUserHashedPassword(@Param("password") String password, @Param("userType") int userType);
}

package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.UserContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT a.userID from UserEntity a where a.email = :email and a.hashedPassword = :password and a.userType = :userType")
    public List<String> getMatchingUserIdForCredential(@Param("email") String email, @Param("password") String password, @Param("userType") int userType);

    @Query("SELECT a.email from UserEntity a where a.email = :email and a.userType = :userType")
    public List<String> getMatchingUserEmail(@Param("email") String email, @Param("userType") int userType);

    @Query("SELECT a.userID from UserEntity a where a.hashedPassword = :password and a.userType = :userType")
    public List<String> getMatchingUserHashedPassword(@Param("password") String password, @Param("userType") int userType);

    @Query("select a.isLoggedIn from UserEntity a where a.userID = :userId")
    public List<String> checkLoginStatusOnUser(@Param("userId") int userId);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity a SET a.isLoggedIn = :#{#isLoggedIn} WHERE a.userID = :#{#userId}")
    public int updateUserLoggedInStatus(@Param("isLoggedIn") int isLoggedIn, @Param("userId") int userId);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity a SET a.hashedPassword = :#{#hashedPassword} WHERE a.email = :#{#email}")
    public int resetPassword(@Param("hashedPassword") String hashedPassword, @Param("email") String email);

    public UserEntity findByEmail(@RequestBody String email);

    @Query("SELECT email, telephone FROM UserEntity WHERE userID=?1")
    public List<String> getNeedData(int id);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity a SET a.email= :email, a.telephone= :telephone WHERE a.userID= :id")
    public int updateContactDetails(@Param("email") String email, @Param("telephone") String telephone, @Param("id") int id);

    @Query("SELECT a.hashedPassword from UserEntity a WHERE a.userID= :id")
    public String getPasswordById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity a SET a.hashedPassword= :newP WHERE a.userID= :id")
    public int updateNewPassword(@Param("newP") String newP, @Param("id") int id);
}

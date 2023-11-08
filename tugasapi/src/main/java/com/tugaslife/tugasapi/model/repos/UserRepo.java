package com.tugaslife.tugasapi.model.repos;




import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import com.tugaslife.tugasapi.model.entities.User;

// public interface UserRepo extends CrudRepository<User,Long> {
public interface UserRepo extends JpaRepository<User,Long> {
     List<User> findByfirstnameContains(String nameString);
    
}

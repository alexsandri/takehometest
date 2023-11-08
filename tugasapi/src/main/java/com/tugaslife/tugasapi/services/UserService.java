package com.tugaslife.tugasapi.services;




import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.tugaslife.tugasapi.model.entities.User;
import com.tugaslife.tugasapi.model.repos.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private  UserRepo userRepo;
    public User save(User user){
        return userRepo.save(user);
    }
    public User findOne(Long id){
        Optional<User> temp =userRepo.findById(id);
        if(!temp.isPresent()){
            return null;
        }
        return temp.get();
    }

    public Iterable<User> findAll(){
        return userRepo.findAll();
    }

    public void removeOne(Long id){
        userRepo.deleteById(id);
    }

    public Iterable<User> findByName(String nameString){
        return userRepo.findByfirstnameContains(nameString);
    }

    public List<User> sortBySomeField(String field){
        return userRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<User> getUserPagination(int offset,int PageSize){
        return userRepo.findAll(PageRequest.of(offset, PageSize));
    }

     public Page<User> getUserPaginationsSort(int offset,int PageSize, String field){
        return userRepo.findAll(PageRequest.of(offset, PageSize).withSort(Sort.by(Sort.Direction.ASC,field)));
    }


     


    
    

    
   


   
}

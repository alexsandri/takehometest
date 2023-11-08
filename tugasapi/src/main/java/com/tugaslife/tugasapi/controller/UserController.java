package com.tugaslife.tugasapi.controller;



import com.tugaslife.tugasapi.helper.BearerTokenWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tugaslife.tugasapi.dto.ResponseData;
import com.tugaslife.tugasapi.model.entities.User;
import com.tugaslife.tugasapi.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    
    @Autowired
    private UserService userService;

    @PostMapping
    // public User create(@Valid @RequestBody User user, Errors errors){
    public ResponseEntity<ResponseData<User>> create(@Valid @RequestBody User user, Errors errors){
        ResponseData <User> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                // System.err.println(error.getDefaultMessage());
                responseData.getMessage().add(error.getDefaultMessage());
            }
            // throw new RuntimeException("Validation Error");
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
         responseData.setStatus(true);
         responseData.setPayload(userService.save(user));
         return ResponseEntity.ok(responseData);
        // return userService.save(user);
    }

    @GetMapping
    public Iterable<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Long id){
        return userService.findOne(id);
    }

    @PutMapping
    // @PostMapping("update")
    // @RequestMapping(method = RequestMethod.PUT)
    public User update(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        userService.removeOne(id);
    }

    @GetMapping("/name/{name}")
    public Iterable<User> findByName(@PathVariable("name") String name){
        return userService.findByName(name);
    }

    @GetMapping("/short/{field}")
    public Iterable<User> shortByField(@PathVariable("field") String field){
        return userService.sortBySomeField(field);
    }

    @GetMapping("/pages/{offset}/{pageSize}")
    public Page<User> shortByField(@PathVariable("offset") int offset,@PathVariable("pageSize") int pageSize){
        return userService.getUserPagination(offset,pageSize);
    }

    @GetMapping("/pagessorting/{offset}/{pageSize}/{field}")
    public Page<User> paginationShortByField(@PathVariable("offset") int offset,@PathVariable("pageSize") int pageSize,@PathVariable("field") String field){
        return userService.getUserPaginationsSort(offset,pageSize,field);
    }


    // @GetMapping("/pagenation/{offSet}/{pageSize}/{field}")
    // public Iterable<User> pagenationandshort(@PathVariable("offSet") int offSet, @PathVariable("pageSize") int pageSize,@PathVariable("field")  String field){
    //     return userService.pagenationandshort(offSet,pageSize,field);
    // }

    private BearerTokenWrapper tokenWrapper;
    @GetMapping("/token")
    public String getToken() {
        System.out.println("token=" + tokenWrapper.getToken());

        return "tokenValue=" + tokenWrapper.getToken();
    }

}

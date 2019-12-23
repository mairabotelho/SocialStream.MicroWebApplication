package com.zipcode.socialStream.services;

import com.zipcode.socialStream.models.User;
import com.zipcode.socialStream.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User addUser(User user) throws Exception {
        if (repository.findByUsername(user.getUsername()) == null) {
            return repository.save(user);
        }

        throw new Exception("Username already exists!");
    }

    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

    public User updateUser(String username, User user){
        User ogUser = findByUsername(username);
        if(user.getFirstName() != null)
            ogUser.setFirstName(user.getFirstName());
        if(user.getLastName() != null)
            ogUser.setLastName(user.getLastName());
        if(user.getPassword() != null)
            ogUser.setPassword(user.getPassword());
        if(user.getEmailAddress() != null)
            ogUser.setEmailAddress(user.getEmailAddress());

        return repository.save(user);
    }

    public Iterable<User> findAll(){
        return repository.findAll();
    }

    public Boolean deleteByUsername(String username){
        User user = findByUsername(username);
        if(user != null) {
            repository.delete(user);
            return true;
        }

        return false;
    }

    public User login(String username) {
        User original = repository.findByUsername(username);
        original.setLoggedIn(true);
        return repository.save(original);
    }

    public User logout(String username) {
        User original = repository.findByUsername(username);
        original.setLoggedIn(false);
        return repository.save(original);
    }

}

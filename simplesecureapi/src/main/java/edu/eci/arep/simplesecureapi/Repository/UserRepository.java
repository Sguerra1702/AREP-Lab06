package edu.eci.arep.simplesecureapi.Repository;

import edu.eci.arep.simplesecureapi.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}


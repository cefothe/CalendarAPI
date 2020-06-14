package eu.stefanangelov.event.persistence.repository;

import eu.stefanangelov.event.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}

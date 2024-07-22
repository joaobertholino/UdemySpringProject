package com.joaobertholino.udemyspringproject.repositories;

import com.joaobertholino.udemyspringproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

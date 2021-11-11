package com.example.M06UF2.repository;

import com.example.M06UF2.domain.User;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.UUID;

    public interface UserRepository extends JpaRepository<User, UUID> {

        User findByUsername(String username);
    }

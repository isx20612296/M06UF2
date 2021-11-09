package com.example.M06UF2.repository;


import com.example.M06UF2.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {
}

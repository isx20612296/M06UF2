package com.example.M06UF2.controller;

import com.example.M06UF2.domain.File;
import com.example.M06UF2.repository.FileRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@RestController
@RequestMapping("/files")
public class FileController {

    FileRepository fileRepository;

    FileController(com.example.M06UF2.repository.MovieRepository movieRepository) {
        this.fileRepository = fileRepository;
    }

    @GetMapping("/{id}")
    public byte[] jajajajajajaj(PathVariable UUID id) {
        File file = fileRepository.getById(id);
        return file.data;
    }

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile uploadedFile) {
        try {
            System.out.println(uploadedFile.getOriginalFilename() + ", " + uploadedFile.getContentType());
            File file = new File();
            file.contenttype = uploadedFile.getContentType();
            file.data = uploadedFile.getBytes();

            return fileRepository.save(file).fileid.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    @GetMapping("/")
//    public List<File> talicual() {
//        return fileRepository.findAll();
//    }
}

package com.example.M06UF2.controller;

import com.example.M06UF2.domain.File;
import com.example.M06UF2.repository.FileRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileRepository fileRepository;
    FileController(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile uploadedFile) {
        try {
            File file = new File();
            file.contenttype = uploadedFile.getContentType();
            file.data = uploadedFile.getBytes();

            return fileRepository.save(file).fileid.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable UUID id) {
        File file = fileRepository.findById(id).orElse(null);

        if (file == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(file.contenttype))
                .contentLength(file.data.length)
                .body(file.data);
    }
}
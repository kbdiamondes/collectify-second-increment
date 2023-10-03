package com.capstone.kuhako.services;

import java.io.IOException;
import java.util.stream.Stream;

import com.capstone.kuhako.models.FileDB;
import com.capstone.kuhako.repositories.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;


@Service
public class FileStorageService {

    @Autowired
    private FileDBRepository fileDBRepository;


    public FileDB store(String base64Data, String fileName, String contentType) throws IOException {
        byte[] data = Base64.getDecoder().decode(base64Data);
        FileDB fileDB = new FileDB(fileName, contentType, data);
        return fileDBRepository.save(fileDB);
    }

    /*
    version 1--
    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

        return fileDBRepository.save(FileDB);
    }*/


    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }

    public FileDB getByFilename(String filename) {
        return fileDBRepository.findByFilename(filename);
    }

}
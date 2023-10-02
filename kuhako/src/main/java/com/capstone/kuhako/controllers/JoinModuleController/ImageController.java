package com.capstone.kuhako.controllers.JoinModuleController;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @PostMapping("/upload")
    public @ResponseBody byte[] uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        return file.getBytes();
    }
}

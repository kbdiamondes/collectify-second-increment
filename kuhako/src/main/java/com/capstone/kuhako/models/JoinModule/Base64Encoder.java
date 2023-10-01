package com.capstone.kuhako.models.JoinModule;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class Base64Encoder {
    public static void main(String[] args) throws Exception {
        // Load a binary file as bytes
        Path filePath = Path.of("path/to/your/file.png");
        byte[] fileBytes = Files.readAllBytes(filePath);

        // Encode the binary data to Base64
        String base64EncodedData = Base64.getEncoder().encodeToString(fileBytes);

        // Print the Base64 encoded data
        System.out.println(base64EncodedData);
    }
}

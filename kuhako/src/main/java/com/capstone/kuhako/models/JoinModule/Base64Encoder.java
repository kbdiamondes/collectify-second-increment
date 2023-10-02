package com.capstone.kuhako.models.JoinModule;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class Base64Encoder {
    public static void main(String[] args) throws Exception {
        // Load a binary file as bytes
        Path filePath = Path.of("path/to/your/file.png");
        // ^^^ Define the path to your file. Make sure to replace "path/to/your/file.png" with the actual file path.

        byte[] fileBytes = Files.readAllBytes(filePath);
        // ^^^ Read all bytes from the file specified in the 'filePath' variable.

        // Encode the binary data to Base64
        String base64EncodedData = Base64.getEncoder().encodeToString(fileBytes);
        // ^^^ Encode the 'fileBytes' as Base64 using the Java Base64 encoder.

        // Print the Base64 encoded data
        System.out.println(base64EncodedData);
        // ^^^ Print the resulting Base64 encoded data to the console.
    }
}
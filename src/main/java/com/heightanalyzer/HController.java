package com.heightanalyzer;


import com.heightanalyzer.service.PythonAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class HController {
    @Autowired
    private PythonAIService pythonAIService;

    @PostMapping("/analyze")
    public ResponseEntity<?> analyzeImage(@RequestParam("file") MultipartFile file) {
        try {
            System.out.println("Application entry.......");
            return ResponseEntity.ok(pythonAIService.sendImageToPython(file));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}

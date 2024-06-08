package biz.picosoft.demo.controller;


import biz.picosoft.demo.domain.Attachment;
import biz.picosoft.demo.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FilesController {
    @Autowired
    private FilesService filesService;
    @PostMapping("/uploadFilesIntoDB")
    public ResponseEntity<String> storeFilesIntoDB(@RequestParam("file") MultipartFile file) throws IOException {
        String response = filesService.storeFile(file);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getFileByName/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
        byte[] imageData = filesService.getFiles(fileName);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/PNG")).body(imageData);
    }

    @PostMapping("/uploadFilesIntoFileSystem")
    public ResponseEntity<String> uploadFileIntoFileSystem(@RequestParam("file") MultipartFile file) throws IOException {
        String response = filesService.storeDataIntoFileSystem(file);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getFilesFromFileSystem/{fileName}")
    public ResponseEntity<byte[]> downloadImageFromFileSystem(@PathVariable String fileName) {
        byte[] imageData = filesService.getFiles(fileName);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
    }
    @GetMapping("/getFilesByClassAndObject/{idClasse}/{idObject}")
    public ResponseEntity<List<Attachment>> getFilesByClassAndObject(
            @PathVariable Long idClasse, @PathVariable Long idObject) {
        List<Attachment> files = filesService.getFilesByIdClasseAndIdObject(idClasse, idObject);

        if (files.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(files, HttpStatus.OK);
    }
    @PostMapping("/addFile/{idClasse}/{idObject}")
    public ResponseEntity<String> addFile(
            @PathVariable Long idClasse, @PathVariable Long idObject,
            @RequestParam("file") MultipartFile file) {
        try {
            String message = filesService.addFile(idClasse, idObject, file);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("File upload failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
        // Retrieve the file content as byte array
        byte[] fileContent = filesService.getFileContent(fileName);

        // Set the appropriate content type for the file
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);

        // Return the file content as a response
        return ResponseEntity.ok()
                .headers(headers)
                .body(fileContent);
    }
    @DeleteMapping("/deleteFile/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        // Logic to delete the file with the given fileName
        boolean success = filesService.deleteFile(fileName);

        if (success) {
            return ResponseEntity.ok().body("File deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package biz.picosoft.demo.service;


import biz.picosoft.demo.domain.Attachment;
import biz.picosoft.demo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FilesService {
    @Autowired
    private FileRepository fileRepository;

    private final String FILE_PATH = "D:\\PFE\\code\\PFE_Front_GestionOpp\\src\\assets\\files\\";

    public String storeFile(MultipartFile file) throws IOException {
        Attachment files = Attachment.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(file.getBytes())
                .build();

        files = fileRepository.save(files);

        if (files.getId() != null) {
            return "File uploaded successfuly into database";
        }

        return null;
    }

    public byte[] getFiles(String fileName) {
        return fileRepository.findByName(fileName).getImageData();
    }

    public String storeDataIntoFileSystem(MultipartFile file) throws IOException {
        String filePath = FILE_PATH + file.getOriginalFilename();

        Attachment files = Attachment
                .builder()
                .name(file.getOriginalFilename())
                .path(filePath)
                .type(file.getContentType())
                .imageData(file.getBytes())
                .build();

        files = fileRepository.save(files);

        file.transferTo(new File(filePath));

        if (files.getId() != null) {
            return "File uploaded successfuly into database";
        }

        return null;
    }

    public byte[] downloadFilesFromFileSystem(String fileName) throws IOException {
        String path = fileRepository.findByName(fileName).getPath();

        // Create a Path object from the file path string
        Path filePath = Paths.get(path);

        return java.nio.file.Files.readAllBytes(filePath);
    }

}

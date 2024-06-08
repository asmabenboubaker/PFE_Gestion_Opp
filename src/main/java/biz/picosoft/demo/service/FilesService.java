package biz.picosoft.demo.service;


import biz.picosoft.demo.domain.Attachment;
import biz.picosoft.demo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public byte[] getFiles(String fileName) {
        return fileRepository.findByName(fileName).getImageData();
    }

    public String storeDataIntoFileSystem(MultipartFile file) throws IOException {
        String filePath = FILE_PATH + file.getOriginalFilename();

        Attachment files = Attachment
                .builder()
                .name(file.getOriginalFilename())
                .url(filePath)
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
        String path = fileRepository.findByName(fileName).getUrl();

        // Create a Path object from the file path string
        Path filePath = Paths.get(path);

        return java.nio.file.Files.readAllBytes(filePath);
    }
    @Transactional
    public List<Attachment> getFilesByIdClasseAndIdObject(Long idClasse, Long idObject) {
        return fileRepository.findByIdClasseAndIdObject(idClasse, idObject);
    }


    public String addFile(Long idClasse, Long idObject, MultipartFile file) throws IOException {
        String filePath = FILE_PATH + file.getOriginalFilename();

        Attachment attachment = Attachment.builder()
                .idClasse(idClasse)
                .idObject(idObject)
                .name(file.getOriginalFilename())
                .url(filePath)
                .type(file.getContentType())
                .imageData(file.getBytes())
                .build();

        attachment = fileRepository.save(attachment);

        file.transferTo(new File(filePath));

        if (attachment.getId() != null) {
            return "File uploaded successfully with idClasse and idObject";
        }

        return "File upload failed";
    }

    @Transactional
    public byte[] getFileContent(String fileName) {
        // Retrieve the Attachment entity by file name
        Optional<Attachment> optionalAttachment = Optional.ofNullable(fileRepository.findByName(fileName));

        // Check if the Attachment exists
        if (optionalAttachment.isPresent()) {
            // Extract the imageData (file content) from the Attachment entity
            Attachment attachment = optionalAttachment.get();
            return attachment.getImageData();
        } else {
            // If the file with the specified name does not exist, return null or throw an exception
            return null;
            // Alternatively, you can throw an exception to handle the case where the file does not exist
            // throw new FileNotFoundException("File not found: " + fileName);
        }
    }
}

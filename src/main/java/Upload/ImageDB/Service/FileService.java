package Upload.ImageDB.Service;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Upload.ImageDB.Repository.FileRepository;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public String storeFile1(MultipartFile file) throws IOException {
        Files files = Files.builder()
            .name(file.getOriginalFilename())
            .type(file.getContentType())
            .imageData(file.getBytes())
            .build();

        files = fileRepository.save(files);

        if (files.getId() != null) {
            return "File uploaded successfully";
        }

        return null;
    }

    public byte[] getFiles(String fileName) {
        Files file = fileRepository.findByName(fileName);
        if (file != null) {
            return file.getImageData();
        }
        return null;
    }
}
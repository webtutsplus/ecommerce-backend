package com.webtutsplus.ecommerce.service;

import com.webtutsplus.ecommerce.config.StorageProperties;
import com.webtutsplus.ecommerce.exceptions.StorageException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class FIleStoreService {
    private StorageProperties properties = new StorageProperties();
    Path rootLocation = Paths.get(properties.getLocation());

    /**
     * Used to save the file to the local storage.
     * @param file The file that we want to save.
     * @return The URL for where the file is saved.
     */
    public String store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }

            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            String uploadedFileName = UUID.randomUUID().toString() + "." + extension;

            Path destinationFile = rootLocation.resolve(
                    Paths.get(uploadedFileName))
                    .normalize().toAbsolutePath();

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);

                final String baseUrl =
                        ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

                return baseUrl+"/fileUpload/files/"+uploadedFileName;
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }

    /**
     * Used to load all the files currently saved.
     * @return a stream of all the paths to files.
     */
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        }
        catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    /**
     * Used to load a given file according to it's filename.
     * @param filename The name of the file we want to load.
     * @return Resource from the file name.
     */
    public Resource load(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}

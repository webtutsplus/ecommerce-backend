package com.webtutsplus.ecommerce.controller;

import com.webtutsplus.ecommerce.model.FileInfo;
import com.webtutsplus.ecommerce.service.FIleStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {
    @Autowired FIleStoreService fileStoreService;

    /**
     * Handles POST requests to /api/fileUpload/. Used to upload files.
     * @param file The file we want to upload.
     * @return The URL where we saved the file.
     */
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        return fileStoreService.store(file);
    }

    /**
     * Handles GET requests to /api/fileUpload/. Used to get a list of all files.
     * @return A list of all the files.
     */
    @GetMapping("/")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = fileStoreService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileUploadController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        Stream<Path> pathStream = fileStoreService.loadAll();
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    /**
     * Handles GET request to /api/fileUpload/files/{filename:.+}. Used to download a file.
     * @param filename The name of the file we want to download.
     * @return The file that we want to download.
     */
    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileStoreService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}

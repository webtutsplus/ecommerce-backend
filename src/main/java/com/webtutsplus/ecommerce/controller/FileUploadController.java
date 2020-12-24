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

    @Autowired
    FIleStoreService fileStoreService;

    //upload a file
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        return fileStoreService.store(file);
    }


    // get all the files
    @GetMapping("/")
    public ResponseEntity<List<FileInfo>> getListFiles() {

        // first get a stream of all file path present in root file directory
        Stream<Path> pathStream =  fileStoreService.loadAll();

        List<FileInfo> fileInfos = pathStream.map(path -> {
            // get file name
            String filename = path.getFileName().toString();

            // use function to get one file to build the URL
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileUploadController.class, "getFile", path.getFileName().toString()).build().toString();
            // make a fileinfo object  from filename and url
            return new FileInfo(filename, url);

        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    // get file by filename
    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileStoreService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}

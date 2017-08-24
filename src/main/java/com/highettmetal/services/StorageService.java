package com.highettmetal.services;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {

    void store(Path path, MultipartFile file);
}

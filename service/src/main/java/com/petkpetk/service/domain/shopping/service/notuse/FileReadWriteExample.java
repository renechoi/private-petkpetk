package com.petkpetk.service.domain.shopping.service.notuse;// package com.petkpetk.service.domain.shopping.service.notuse;
//
// import org.springframework.core.io.Resource;
// import org.springframework.core.io.ClassPathResource;
// import org.springframework.core.io.FileSystemResource;
// import org.springframework.util.FileCopyUtils;
//
// import java.io.File;
// import java.io.IOException;
//
// public class FileReadWriteExample {
//
//     public static void main(String[] args) throws IOException {
//         // Classpath 상의 파일 읽기
//         Resource classPathResource = new ClassPathResource("sample.txt");
//         byte[] classPathFileBytes = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
//
//         // 파일 시스템 상의 파일 읽기
//         Resource fileSystemResource = new FileSystemResource(new File("/path/to/sample.txt"));
//         byte[] fileSystemFileBytes = FileCopyUtils.copyToByteArray(fileSystemResource.getInputStream());
//
//         // 파일 쓰기
//         Resource outputFileResource = new FileSystemResource(new File("/path/to/output.txt"));
//         FileCopyUtils.copy(classPathFileBytes, outputFileResource.getOutputStream());
//     }
// }

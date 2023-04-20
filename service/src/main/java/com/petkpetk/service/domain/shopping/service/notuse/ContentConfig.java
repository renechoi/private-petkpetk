package com.petkpetk.service.domain.shopping.service.notuse;// package com.petkpetk.service.domain.shopping.service.notuse;
//
// import java.io.File;
// import java.io.IOException;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// @Configuration
// @EnableFilesystemStores
// public class ContentConfig {
//
//     @Bean
//     File filesystemRoot() {
//         try {
//             return new File("/path/to/content/root").getCanonicalFile();
//         } catch (IOException e) {
//             throw new RuntimeException(e);
//         }
//     }
//
//     @Bean
//     public ContentStore contentStore() {
//         return new FileSystemContentStore(filesystemRoot());
//     }
// }

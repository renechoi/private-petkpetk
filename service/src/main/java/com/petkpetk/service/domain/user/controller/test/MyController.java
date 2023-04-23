package com.petkpetk.service.domain.user.controller.test;// package com.petkpetk.service.domain.user.controller.test;
//
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.multipart.MultipartFile;
//
// @Controller
// public class MyController {
//
//     @GetMapping("/user/test")
//     public String showUploadForm(Model model) {
//         model.addAttribute("myForm", new MyForm());
//         return "user/user/uploadForm";
//     }
//
//     @PostMapping("/")
//     public String handleFileUpload(@ModelAttribute("myForm") MyForm myForm, BindingResult bindingResult) {
//         MultipartFile multipartFile = myForm.getMultipartFile();
//         // multipartFile을 사용하여 원하는 작업을 수행합니다.
//         return "redirect:/success";
//     }
// }

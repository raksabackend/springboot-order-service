package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@RequestMapping("/order")
@RestController
public class OrderController {

    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @GetMapping("/sayHi")
    public String sayHi() {
        return "Hello World From Order Service <3 hmmmm hmmmm";
    }

    @GetMapping("/")
    public String getOrders(){
        return "All Orders";
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable("id") int id){
        return "Order Id ng hah hahahahah: " + id;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        try {
            File dir = new File(UPLOAD_DIR);
            if(!dir.exists()){
                dir.mkdirs();
            }

            FileOutputStream fos = new FileOutputStream(new File(UPLOAD_DIR + file.getOriginalFilename()));
            fos.write(file.getBytes());
            fos.close();

            return "Nice " + file.getOriginalFilename() + "from order service ";

        } catch (Exception e) {
            return "File Upload Failed";
        }
    }

}

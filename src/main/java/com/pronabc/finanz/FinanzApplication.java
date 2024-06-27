package com.pronabc.finanz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.pronabc.finanz")
public class FinanzApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanzApplication.class, args);
    }
}



//package com.pronabc.finanz;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//
//@SpringBootApplication
//public class FinanzApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(FinanzApplication.class, args);
//
//    }
//
//
//}

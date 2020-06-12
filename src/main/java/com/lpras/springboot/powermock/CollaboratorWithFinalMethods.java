package com.lpras.springboot.powermock;

public class CollaboratorWithFinalMethods {
   // private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public CollaboratorWithFinalMethods() {
        System.out.println("===========================================================");
        System.out.println("Default Constructor");
        System.out.println("===========================================================");
       // logger.debug("Default Constructor");

    }

    public final String helloMethod() {
        return "Hello World!";
    }
}

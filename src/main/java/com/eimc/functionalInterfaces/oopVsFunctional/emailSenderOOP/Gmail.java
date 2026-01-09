package com.eimc.functionalInterfaces.oopVsFunctional.emailSenderOOP;

public class Gmail implements EmailSender {

    @Override
    public void send() {
        System.out.println("sending email using gmail...");
    }

}

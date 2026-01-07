package functionalInterfaces.oopVsFunctional.emailSenderFunctional;

import functionalInterfaces.oopVsFunctional.emailSenderOOP.EmailSender;

public class Main {

    public static void main(String[] args) {

        ///  Example 1: Anonymous Inner Class
        System.out.println("Example one: anonymous inner classes");

        EmailSender senderAnonymous = new EmailSender() {
            @Override
            public void send() {
                    System.out.println("sending email using anonymous inner class...");
            }
        };

        senderAnonymous.send();
        System.out.println();

        ///  Example 2: Anonymous Inner Class refactored to Lambda using type inference
        System.out.println("Example two: anonymous inner classes");

        EmailSender senderLambda = () -> System.out.println("sending email using lambda...");
        senderLambda.send();
        System.out.println();

        ///  Example 3: Behaviors over interfaces
        System.out.println("Example three: lambdas over interfaces");

        EmailSender hotmail = () -> System.out.println("Sending email using Hotmail");
        hotmail.send();

        EmailSender gmail = () -> System.out.println("Sending email using Gmail");
        gmail.send();

    }
}

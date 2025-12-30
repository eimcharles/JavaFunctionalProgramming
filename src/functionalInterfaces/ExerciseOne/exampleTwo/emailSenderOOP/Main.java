package functionalInterfaces.ExerciseOne.exampleTwo.emailSenderOOP;

public class Main {

    public static void main(String[] args) {

        /**
         *      Object-oriented approach
         *
         *      - Clear structure and strict contracts
         *        via the EmailSender interface.
         *
         *      - OOP requires a new class file
         *        for every behavior (Gmail.java, Hotmail.java).
         *
         * */

        EmailSender emailSender = new Gmail();
        emailSender.send();

    }
}

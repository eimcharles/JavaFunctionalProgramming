package functionalInterfaces.ExerciseOne.exampleTwo.emailSenderOOP;

public class Hotmail implements EmailSender {

    @Override
    public void send() {
        System.out.println("sending email using hotmail...");
    }

}

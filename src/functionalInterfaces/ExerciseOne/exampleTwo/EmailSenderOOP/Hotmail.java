package functionalInterfaces.ExerciseOne.exampleTwo.EmailSenderOOP;

public class Hotmail implements EmailSender {

    @Override
    public void send() {
        System.out.println("sending email using hotmail...");
    }

}

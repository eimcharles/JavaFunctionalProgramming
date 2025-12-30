package functionalInterfaces.ExerciseOne.exampleTwo.EmailSenderOOP;

@FunctionalInterface
public interface EmailSender {

    /**
     *      EmailSender is a Functional Interface:
     *
     *      Functional interfaces can contain exactly
     *      ONE abstract method.
     *
     *      Therefore, Java can automatically map a
     *      Lambda expression () -> {} to this specific method signature.
     *
     *      The @FunctionalInterface annotation prevents anyone from
     *      adding a second method and accidentally
     *      breaking your Lambda implementations.
     */

    void send();

}

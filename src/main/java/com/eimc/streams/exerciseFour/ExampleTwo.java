package com.eimc.streams.exerciseFour;

import java.util.List;

public class ExampleTwo {

    public static void main(String[] args) {

        String data = """
                    16,Fanchette,Williamson,fwilliamson0@github.com,FEMALE
                    26,Aleksandr,Matts,amatts1@webs.com,MALE
                    3,Maurie,Cordero,mcordero2@google.co.jp,MALE
                    45,Donnajean,Crowson,dcrowson3@google.com.hk,FEMALE
                    5,Ricardo,Gofton,rgofton4@nytimes.com,MALE
                    65,Gabie,Tregenna,gtregenna5@guardian.co.uk,FEMALE
                    37,Marjorie,Blumsom,mblumsom6@joomla.org,FEMALE
                    18,Lester,Huyghe,lhuyghe7@jugem.jp,MALE
                    39,Merrily,Stangoe,mstangoe8@tiny.cc,FEMALE
                    10,Reider,Karel,rkarel9@github.io,MALE
                    11,Dory,Jolliff,djolliffa@wufoo.com,FEMALE
                    32,Homerus,Averay,haverayb@skyrock.com,MALE
                    13,Alyda,Muglestone,amuglestonec@is.gd,FEMALE
                    14,Pinchas,Louca,ploucad@google.es,MALE
                    11,Cherin,Eltringham,celtringhame@parallels.com,FEMALE
                    2,Mufi,Rothert,mrothertf@dropbox.com,FEMALE
                    17,Jordana,Everex,jeverexg@ucla.edu,FEMALE
                    18,Belle,Rother,brotherh@gov.uk,FEMALE
                    19,Clevie,Sifflett,csiffletti@furl.net,MALE
                    20,Gretchen,Abell,gabellj@1688.com,FEMALE
                """;

        
        List<Person> people = data

                ///  Converts into 20 individual Strings
                .lines()
                ///  Remove trailing whitespace for every String
                .map(String::trim)
                ///  Map a string to a Person Object
                .map(ExampleTwo::mapToPerson)
                ///  Filter Person Object by gender
                .filter(person -> person.getGender() == Gender.MALE)
                ///  Filter Person Object by age
                .filter(person -> person.getAge() < 13)
                ///  Return a list based on pipeline conditions
                .toList();

        people.forEach(System.out::println);

    }

    private static Person mapToPerson(String line) {

        String[] splitAttributes = line.trim().split(",");

        int age = Integer.parseInt(splitAttributes[0]);
        String name = splitAttributes[1];
        String lastName = splitAttributes[2];
        String email = splitAttributes[3];
        Gender gender = Gender.valueOf(splitAttributes[4]);

        return new Person(name, lastName, email, age, gender);

    }

}

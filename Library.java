import javax.xml.stream.events.DTD;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Library {
    private static String libname;
    private static Date currentdate;
    private static DVD[] collection;

    public Library(String name, Date date, DVD[] entries) {
        libname = name;
        currentdate = date;
        collection = entries;
    }

    private static void addDVD(DVD dvd) {
        collection = Arrays.copyOf(collection, collection.length+1);
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] == null) {
                collection[i] = dvd;
            }
        }
        System.out.println("--> added to collection: " + dvd.title);
    }

    private static void removeDVD(String title) {
        DVD[] temp = new DVD[collection.length-1];
        for (int i = 0; i < collection.length; i++) {
            if (collection[i].title == title) {
                for (int j = 0; j < i; j++) {
                    temp[j] = collection[j];
                }
                for (int k = i + 1; k < collection.length; k++) {
                    temp[k-1] = collection[k];
                }
            }
        }
        collection = temp;
        System.out.println("--> removed from collection: " + title);
    }

    public static boolean doIOwn(DVD dvd) {
        boolean check = false;
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] == dvd) {
                check = true;
            }
        }
        return check;
    }

    public static void main(String args[]) {

        // creating directors
        Director michaelbay = new Director("Michael", "Bay", "17.02.1965");
        Director agnieszkaholland = new Director("Agnieszka", "Holland", "28.11.1948");
        Director hayaomiyazaki = new Director("Hayao", "Miyazaki", "05.01.1941");
        Director terryjonesdir = new Director("Terry", "Jones", "01.02.1942");
        Director steffenhaarsdir = new Director("Steffen", "Haars", "30.07.1980");

        // creating actors
        Actor seanconnery = new Actor("Sean", "Connery", "25.08.1930");
        Actor edharris = new Actor("Ed", "Harris", "28.11.1950");
        Actor davidmorse = new Actor("David", "Morse", "11.10.1953");
        Actor nicolascage = new Actor("Nicolas","Cage", "07.01.1964");
        Actor katemaberly = new Actor("Kate", "Maberly", "14.03.1982");
        Actor heydonprowse = new Actor("Heydon", "Prowse", "19.02.1982");
        Actor andrewknott = new Actor("Andrew", "Knott", "22.11.1979");
        Actor maggiesmith = new Actor("Maggie", "Smith", "28.12.1934");
        Actor terryjonesact = new Actor("Terry", "Jones", "01.02.1942");
        Actor grahamchapman = new Actor("Graham", "Chapman", "08.01.1941");
        Actor michaelpalin = new Actor("Michael", "Palin", "05.05.1943");
        Actor johncleese = new Actor("John", "Cleese", "28.10.1939");
        Actor ericidle = new Actor("Eric", "Idle", "29.03.1943");
        Actor terrygilliam = new Actor("Terry", "Gilliam", "22.11.1940");
        Actor huubsmit = new Actor("Huub", "Smit", "16.07.1978");
        Actor steffenhaarsact = new Actor("Steffen", "Haars", "30.07.1980");
        Actor timhaars = new Actor("Tim", "Haars", "06.11.1981");
        Actor flipvanderkuil = new Actor("Flip", "van der Kuil", "15.04.1980");
        Actor wesleyvangaalen = new Actor("Wesley", "van Gaalen", "1983");

        // creating Actorlists
        Actor[] therockfelsderentscheidungacts = {seanconnery,edharris,davidmorse,nicolascage};
        Actor[] dergeheimegarten1993acts = {katemaberly,heydonprowse,andrewknott,maggiesmith};
        Actor[] dasschlossimhimmelacts = {};
        Actor[] daslebendesbrianacts = {terryjonesact, grahamchapman, michaelpalin, johncleese, ericidle, terrygilliam};
        Actor[] newkidsturboacts = {huubsmit, steffenhaarsact, timhaars, flipvanderkuil, wesleyvangaalen};

        //creating DVDs
        DVD dergeheimegarten = new DVD("Der geheime Garten (1993)", "23-234", agnieszkaholland, dergeheimegarten1993acts);
        DVD therock = new DVD("The Rock - Fels der Entscheidung", "12-123", michaelbay, therockfelsderentscheidungacts);
        DVD dasschlossimhimmel = new DVD("Das Schloss im Himmel", "34-345", hayaomiyazaki, dasschlossimhimmelacts);
        DVD daslebendesbrian = new DVD("Das Leben des Brian", "45-456", terryjonesdir, daslebendesbrianacts);
        DVD newkidsturbo = new DVD("New Kids Turbo", "56-567", steffenhaarsdir, newkidsturboacts);

        // crating new library
        DVD[] emptyarray = {};
        Library MyLibrary = new Library("My DVD Collection", new Date(), emptyarray);

        System.out.println("");
        System.out.println("Name of library: " + libname);
        System.out.println("last updated: " + currentdate);
        System.out.println("DVDs in collection: " + Arrays.toString(collection));

        System.out.println("");
        System.out.println("adding DVDs to collection...");

        addDVD(dergeheimegarten);
        addDVD(therock);
        addDVD(dasschlossimhimmel);
        addDVD(daslebendesbrian);
        addDVD(newkidsturbo);

        System.out.println("");
        System.out.println("Name of library: " + libname);
        System.out.println("last updated: " + currentdate);
        System.out.println("New collection: ");
        for (int i = 0; i < collection.length; i++) {
            System.out.println(" // " + collection[i]);
        }

        System.out.println("");
        System.out.println("removing DVDs to collection...");

        removeDVD("The Rock - Fels der Entscheidung");
        removeDVD("New Kids Turbo");

        System.out.println("");
        System.out.println("Name of library: " + libname);
        System.out.println("last updated: " + currentdate);
        System.out.println("New collection: ");
        for (int i = 0; i < collection.length; i++) {
            System.out.println(" // " + collection[i]);
        }

        System.out.println("");
        System.out.println("Do I own: " + therock.title + "?");
        System.out.println(doIOwn(therock));

        System.out.println("");
        System.out.println("Do I own: " + dergeheimegarten.title + "?");
        System.out.println(doIOwn(dergeheimegarten));
    }

}

/*
Name of library: My DVD Collection
last updated: Thu Dec 09 19:58:42 CET 2021
DVDs in collection: []

adding DVDs to collection...
--> added to collection: Der geheime Garten (1993)
--> added to collection: The Rock - Fels der Entscheidung
--> added to collection: Das Schloss im Himmel
--> added to collection: Das Leben des Brian
--> added to collection: New Kids Turbo

Name of library: My DVD Collection
last updated: Thu Dec 09 19:58:42 CET 2021
New collection: 
 // DVD[Der geheime Garten (1993), 23-234, Director[Agnieszka, Holland, 28.11.1948], [Actor[Kate, Maberly, 14.03.1982], Actor[Heydon, Prowse, 19.02.1982], Actor[Andrew, Knott, 22.11.1979], Actor[Maggie, Smith, 28.12.1934]]
 // DVD[The Rock - Fels der Entscheidung, 12-123, Director[Michael, Bay, 17.02.1965], [Actor[Sean, Connery, 25.08.1930], Actor[Ed, Harris, 28.11.1950], Actor[David, Morse, 11.10.1953], Actor[Nicolas, Cage, 07.01.1964]]
 // DVD[Das Schloss im Himmel, 34-345, Director[Hayao, Miyazaki, 05.01.1941], []
 // DVD[Das Leben des Brian, 45-456, Director[Terry, Jones, 01.02.1942], [Actor[Terry, Jones, 01.02.1942], Actor[Graham, Chapman, 08.01.1941], Actor[Michael, Palin, 05.05.1943], Actor[John, Cleese, 28.10.1939], Actor[Eric, Idle, 29.03.1943], Actor[Terry, Gilliam, 22.11.1940]]
 // DVD[New Kids Turbo, 56-567, Director[Steffen, Haars, 30.07.1980], [Actor[Huub, Smit, 16.07.1978], Actor[Steffen, Haars, 30.07.1980], Actor[Tim, Haars, 06.11.1981], Actor[Flip, van der Kuil, 15.04.1980], Actor[Wesley, van Gaalen, 1983]]

removing DVDs to collection...
--> removed from collection: The Rock - Fels der Entscheidung
--> removed from collection: New Kids Turbo

Name of library: My DVD Collection
last updated: Thu Dec 09 19:58:42 CET 2021
New collection: 
 // DVD[Der geheime Garten (1993), 23-234, Director[Agnieszka, Holland, 28.11.1948], [Actor[Kate, Maberly, 14.03.1982], Actor[Heydon, Prowse, 19.02.1982], Actor[Andrew, Knott, 22.11.1979], Actor[Maggie, Smith, 28.12.1934]]
 // DVD[Das Schloss im Himmel, 34-345, Director[Hayao, Miyazaki, 05.01.1941], []
 // DVD[Das Leben des Brian, 45-456, Director[Terry, Jones, 01.02.1942], [Actor[Terry, Jones, 01.02.1942], Actor[Graham, Chapman, 08.01.1941], Actor[Michael, Palin, 05.05.1943], Actor[John, Cleese, 28.10.1939], Actor[Eric, Idle, 29.03.1943], Actor[Terry, Gilliam, 22.11.1940]]

Do I own: The Rock - Fels der Entscheidung?
false

Do I own: Der geheime Garten (1993)?
true

*/
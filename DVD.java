import java.util.Arrays;
import java.util.Date;

public class DVD {
    final String title;
    final String ISBN;
    final Director regisseur;
    final Actor[] headliner;

    public DVD(String dvdtitle, String dvdisbn, Director dvdregisseur, Actor[] actors) {
        title = dvdtitle;
        ISBN = dvdisbn;
        regisseur = dvdregisseur;
        headliner = actors;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "[" + title + ", " + ISBN + ", " + regisseur + ", " + Arrays.toString(headliner);
    }
}

import java.util.Date;

public class Director {
    final String prename;
    final String lastname;
    final String birthday;

    public Director(String dirpre, String dirlast, String dirdate) {
        prename = dirpre;
        lastname = dirlast;
        birthday = dirdate;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "[" + prename + ", " + lastname + ", " + birthday + "]";
    }
}

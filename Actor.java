import java.util.Date;

public class Actor {
    final String prename;
    final String lastname;
    final String birthday;

    public Actor(String actpre, String actlast, String actdate) {
        prename = actpre;
        lastname = actlast;
        birthday = actdate;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "[" + prename + ", " + lastname + ", " + birthday + "]";
    }
}
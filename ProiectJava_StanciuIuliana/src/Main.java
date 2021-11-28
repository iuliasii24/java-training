import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        int nr=3;
        Scanner in = new Scanner(System.in);
        Singleton[] db;
        db=new Singleton[nr];
        Random rand = new Random();
        DataBase[] user;
        user = new DataBase[nr];
        for(int i=0;i<= db.length-1;i++)
        {
            System.out.println("Please let us know your name:");
            String name = in.nextLine();
            db[i]= Singleton.getInstance();
            user[i]=new DataBase(name,(int) (Math. random() * 10000 + 1));
            System.out.println(user[i].getName()+", your validation code is: "+user[i].getCode()+".");
            db[i].getConnection();
        }

        System.out.println();
        for(int i=0;i<=user.length-1;i++)
            user[i].ShowDataBase();

        for(int i=0;i<=user.length-2;i++) {
            int c=0;
            for(int j=i+1;j<=user.length-1;j++)
                if(user[i]!=user[j])
                    c++;
            if(c!=nr-1)
                new ValidationNewUser("new");

        }
    }
}

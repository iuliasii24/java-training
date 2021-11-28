public class DataBase {
    private String Name;
    private int code;
    public boolean NewUser;
    DataBase(String Name, int code){
        if(ValidationName(Name))
            this.Name= Name;
        this.code=code;
    }
    boolean ValidationName(String s){
        if(s.matches("[a-zA-Z]+"))
            return true;
        else
            throw new IllegalArgumentException("This name doesn't respect our rules.");
    }
    void setName(String Name)
    {
        if(Name.matches("[a-zA-Z]+"))// only letters
            this.Name= Name;
        else
            throw new IllegalArgumentException("This name doesn't respect our rules.");

    }
    String getName()
    {
        return this.Name;
    }
    void setCode(int code)
    {
        this.code=code;
    }
    int getCode()
    {
        return this.code;
    }
    public void ShowDataBase()
    {
        System.out.println("User: " + getName() + " " + "Validation Code: " + getCode());
        System.out.println();
    }

    public static class Builder{}
}

import java.util.*;
public class User {
    public static void main(String[] args) {
        String username;
        String coname;
        int year,n,i=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of user u want to enter");
        n=sc.nextInt();
        System.out.println("enter username,company name , year of joinning");
        if(n>0){
            for(i=0;i<n;i++){
                sc.nextLine();
                username=sc.nextLine().trim();
                coname=sc.nextLine().trim();
                year=sc.nextInt();
                Test obj=new Test(username,coname,year);
                System.out.println("User:1"+(i+1));
                System.out.println("Email:"+obj.getcreategmail());
                System.out.println("password:"+obj.getcreatepassword());

            }
        }
    }
}
class Test{
    private String username;
    private String coname;
    private int year;
    private String gmail;
    private String password;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public Test(String username,String coname,int year){
        this.username=username;
        this.coname=coname;
        this.year=year;
        this.password=getcreatepassword();
        this.gmail=getcreategmail();
    }
    public String getcreategmail(){
        return username.toLowerCase()+"_"+year+"@"+coname.toLowerCase()+".com";
    }
    public String getcreatepassword(){
        StringBuilder sb= new StringBuilder();
        sb.append(generateRandomcharacter());
        for (int i = 0; i < 4; i++) {
            sb.append(generateRandomIntegerFromLimit(10));
        }
        sb.append(getfirst5character());
        sb.append(generateSymbol());
        return sb.toString();
    }
    private String getfirst5character(){
        if(getUsername().length()<5){
            int diff=5-getUsername().length();
            StringBuilder tempname=new StringBuilder(getUsername());
            for(int i=0;i<diff;i++){
                tempname.append("0");
            }
            return tempname.toString();
        }else{
            return getUsername().substring(0,5);
        }
    }
    private char generateSymbol(){
        char [] special={'!','@','#','%','^','&','*','(',')','{','}','[',']','\\',';',':','\'','\"','<','>',',','.','?','/'
        };
        int randomInteger= generateRandomIntegerFromLimit(special.length);
        return special[randomInteger];
    }
    private char generateRandomcharacter(){
        int randomnumberupto26=generateRandomIntegerFromLimit(26);
        return (char) ('a'+randomnumberupto26);
    }
    public int generateRandomIntegerFromLimit(int limit){
        return (int)(Math.random()*limit);
    }
}
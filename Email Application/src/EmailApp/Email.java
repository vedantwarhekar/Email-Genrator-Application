/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmailApp;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Email 
{
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity=500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "drgitr.com";
    
    // Constructor to recive firstname and lastname
    public Email(String firstName,String lastName)
    {
       this.firstName = firstName;
       this.lastName = lastName;
       
       // call a method-asking for department-return the department
       this.department = setDepartment();
       
       
       if(department !="Invalid Department Id")
       {
        // call a method that return a random password
       this.password = randomPassword(defaultPasswordLength);
       
       
       // combine elements to genrate email
       email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
       
       
       }    
    }
    
    // ask for department
    private String setDepartment(){
        System.out.println("Enter the Department\n1 For sale\n2 for Development\n3 for Accounting\n0 for none");
        Scanner in = new Scanner(System.in);
        System.out.print("YOUR DEPARTMENT: ");
        int depChoice = in.nextInt();
        if(depChoice ==1){return "sales";}
        else if(depChoice == 2){return "dev";}
        else if(depChoice == 3){return "accet";}
        else{return "Invalid Department Id";}
    }
    // genrate a random password
    private String randomPassword(int length)
    {
        String passwordSet ="ABCDEFGHIJKLMNOPRSTUVWXYZ123456789!@#$%";
        char[] password = new char[length];
        for(int i=0;i<length;i++)
        {
          int rand =(int) (Math.random() * passwordSet.length());
          password[i] =passwordSet.charAt(rand);
        }    
        return new String(password);
    }        
    // set the mailbox capacity
    public void setMailboxCapacity(int capacity)
    {
       this.mailboxCapacity = capacity;
    }        
    //set the alternative email
    public void setAlternateEmail(String altEmail)
    {
        this.alternateEmail = altEmail;
    }        
    // change the password
    public void changePassword(String password)
    {
       this.password = password;
    }
    
    public int getMailboxCapacity(){ return mailboxCapacity;}
    public String getAlternateEmail(){ return alternateEmail;}
    public String getPassword(){return password;}
    
    public String showInfo()
    {
        if(department !="Invalid Department Id")
        {
           return " DISPLAY NAME : " + firstName+" " +lastName+
            "\n COMPANY EMAIL: "+email+
            "\n password: "+password+ 
            "\n Mailbox CAPACITY: " + mailboxCapacity+"mb"+
            "\n DEPARTMENT: "+ department+
            "\nWELCOME INTO OUR ORGANIZATION "+firstName;
        }
        else{
          return "SORRY WE CANNOT PROCSSED YOUR INFORMATION"+
                 "\n INVALID DEPARTMENT";
        }
        
    }            
    
}

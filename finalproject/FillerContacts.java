/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;


import java.util.Random;
/**
 *
 * @author paiderm
 */
public class FillerContacts 
{
   public static void addDummyContacts()
   {
      ContactsList.addFamily("Peter", "Griffin", 
              Long.toString(randomNumberGenerator(10)), 
              "peteygrif@gmail.com", 
              createBirthday(randomNumberGenerator(1,12), randomNumberGenerator(1,29), randomNumberGenerator(1900, 2020)), 
              Long.toString(randomNumberGenerator(10)), 
              createWorkEmail("Peter", "Griffen", "Family Guy"), "3972 Prospect Street");
      
      ContactsList.addFamily("Stewie", "Griffin", 
              Long.toString(randomNumberGenerator(10)), 
              "authorBoi@gmail.com", 
              createBirthday(randomNumberGenerator(1,12), randomNumberGenerator(1,29), randomNumberGenerator(1900, 2020)), 
              Long.toString(randomNumberGenerator(10)), 
              createWorkEmail("Stewie", "Griffen", "Family Guy"), "3972 Prospect Street");
      
      ContactsList.addFamily("Brian", "Griffin", 
              Long.toString(randomNumberGenerator(10)), 
              "stewstew3@gmail.com", 
              createBirthday(randomNumberGenerator(1,12), randomNumberGenerator(1,29), randomNumberGenerator(1900, 2020)), 
              Long.toString(randomNumberGenerator(10)), 
              createWorkEmail("Brian", "Griffen", "Family Guy"), "3972 Prospect Street");
      
      
      ContactsList.addFriend("Cleveland", "Brown", 
              Long.toString(randomNumberGenerator(10)), 
              "mrbrown@gmail.com", "cleaver", "cle@v3r", "@cle@v3r", "123 Main St.", 
              "clevelandB@uwplatt.edu");
      
      ContactsList.addFriend("Stan", "Smith", 
              Long.toString(randomNumberGenerator(10)), 
              "stanSmith@gmail.com", "stanlee", "s+@nL33", "@StanLee", "1387 Oak St.", 
              "smithS@uwplatt.edu");
      
      ContactsList.addFriend("Homer", "Simpson", 
              Long.toString(randomNumberGenerator(10)), 
              "donutHome@gmail.com", "donut", "d0nu+", "@D0nut", "5443 Pine St.", 
              "simpsonH@uwplatt.edu");
      
      
      ContactsList.addColleague("Bob", "Belcher", 
              Long.toString(randomNumberGenerator(10)), 
              "burgerFlipper@outlook.com", 
              Long.toString(randomNumberGenerator(10)), 
              createWorkEmail("Bob", "Belcher", "Bobs Burgers"), "142 Apple Park");
      
      ContactsList.addColleague("Rick", "Sanchez", 
              Long.toString(randomNumberGenerator(10)), 
              "madScientist@icloud.com", 
              Long.toString(randomNumberGenerator(10)), 
              createWorkEmail("Rick", "Sanchez", "Rick and Morty"), "5498 Empire State Building");
      
      ContactsList.addColleague("Roger", "Smith", 
              Long.toString(randomNumberGenerator(10)), 
              "outtaThisWorld@spaceboi.com", 
              Long.toString(randomNumberGenerator(10)), 
              createWorkEmail("Roger", "Smith", "American Dad"), "5095 Apple Park");
   }
   
   public static String createWorkEmail(String firstName, String lastName, String cartoon)
   {
      return (lastName + firstName + "@" + cartoon + ".com").toLowerCase().replaceAll("\\s+", "");
   }
   
   public static long randomNumberGenerator(int length)
   {
      long random = 0;
      Random rand = new Random();
      long nextDigit;
      
      for (int i = length; i > 0; i--)
      {
         do
         {
         nextDigit = (long)((Math.random() * 9) * Math.pow(10, i-1));
         
         } while (i == length && nextDigit == 0L);
         
         random += nextDigit;
      }

      return random;
   }
   
   public static int randomNumberGenerator(int lowerBound, int upperBound)
   {
      return (int)(Math.random() * (upperBound-lowerBound)) + lowerBound;
   }
   
   public static String createBirthday (int month, int day, int year)
   {
      String birthday;
      if (month > 9 && day > 9)
         birthday = month + "" + day + "" + year;
      else if (month < 10 && day < 10)
         birthday = "0" + month + "0" + day + year;
      else if (month < 10 && day > 9)
         birthday = "0" + month + day + year;
      else
         birthday = month + "0" + day + year;
      
      return Family.formatBirthday(birthday);
   }
}

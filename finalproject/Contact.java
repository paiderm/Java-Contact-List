/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;

/**
 *
 * @author Marshall Paider
 */
public class Contact 
{
   private String firstName;
   private String lastName;
   private String phoneNumber;
   private String personalEmail;
   private String relation = "Other";
   
   public Contact (String firstName, String lastName, String phoneNumber, 
           String personalEmail, String relation)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNumber = formatNumber(phoneNumber);
      this.personalEmail = personalEmail;
      this.relation = relation;
   }
   
   public Contact ()
   {
      this.firstName = "";
      this.lastName = "";
      this.phoneNumber ="";
      this.personalEmail ="";
   }
   
   public static String formatNumber(String number)
   {
      ArrayList<Character> chars = new ArrayList<Character>();
      
      for (char c : number.toCharArray())
         chars.add(c);
      
      chars.add(0, '(');
      chars.add(4, ')');
      chars.add(5,' ');
      chars.add(9,'-');
      
      return chars.toString().replaceAll("[,\\s\\[\\]]", "");
   }
   
   public void setFirstName(String newFirstName)
   {
      this.firstName = newFirstName;
   }
   
   public void setLastName(String newLastName)
   {
      this.lastName = newLastName;
   }
   
   public void setPhoneNumber(String newPhoneNumber)
   {
      this.phoneNumber = formatNumber(newPhoneNumber);
   }
   
   public void setPersonalEmail(String newPersonalEmail)
   {
      this.personalEmail = newPersonalEmail;
   }
   
   public void setRelation(String newRelation)
   {
      this.relation = newRelation;
   }
   
   
   public String getFirstName()
   {
      return this.firstName;
   }
   
   public String getLastName()
   {
      return this.lastName;
   }
   
   public String getPhoneNumber()
   {
      return this.phoneNumber;
   }
   
   public String getPersonalEmail()
   {
      return this.personalEmail;
   }
   
   public String getRelation()
   {
      return this.relation;
   }
   
   public String toString()
   {
      return getFirstName() + " " + getLastName() + "\nPhone Number: " + getPhoneNumber()
              + "\nEmail: " + getPersonalEmail();
   }
}

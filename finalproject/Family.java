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
public class Family extends Contact
{
   String birthday;
   String workPhone;
   String workEmail;
   String workAddress;
   
   public Family(String firstName, String lastName, String phoneNumber, String personalEmail,
           String birthday, String workPhone, String workEmail, String workAddress)
   {
      super(firstName, lastName, phoneNumber, personalEmail, "Family");
      this.birthday = formatBirthday(birthday);
      this.workPhone = super.formatNumber(workPhone);
      this.workEmail = workEmail;
      this.workAddress = workAddress;
   }
   
   public Family ()
   {
      super();
      this.birthday = "";
      this.workPhone = "";
      this.workEmail = "";
      this.workAddress = "";
      
      super.setRelation("Family");
   }
   
   public static String formatBirthday (String birthday)
   {
      ArrayList<Character> chars = new ArrayList<Character>();
      
      for (char c : birthday.toCharArray())
         chars.add(c);
      
      chars.add(4, '/');
      chars.add(2, '/');
      
      return chars.toString().replaceAll("[,\\s\\[\\]]","");
   }
   
   public String getBirthday()
   {
      return birthday;
   }
   
   public String getWorkPhone()
   {
      return workPhone;
   }
   
   public String getWorkEmail()
   {
      return workEmail;
   }
   
   public String getWorkAddress()
   {
      return workAddress;
   }
   
   public void setWorkPhone(String newWorkPhone)
   {
      this.workPhone = newWorkPhone;
   }
   
   public void setWorkEmail(String newWorkEmail)
   {
      this.workEmail = newWorkEmail;
   }
   
   public void setWorkAddress (String newWorkAddress)
   {
      this.workAddress = newWorkAddress;
   }
   
   @Override
   public String toString()
   {
      return super.toString() + "\nBirthday: " + getBirthday() + "\nWork Phone: " +
              getWorkPhone() + "\nWork Email: " + getWorkEmail() + "\nWork Address: " +
              getWorkAddress();
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;
import static java.util.Collections.swap;

/**
 *
 * @author Marshall Paider
 */
public class ContactsList
{
   private static ArrayList<Contact> contacts = new ArrayList<Contact>();

   public static void addContact (String first, String last, String phone, 
           String email)
   {
       contacts.add(new Contact(first, last, phone, email, "Other"));
       selectionSort();
   }
   
   public static void addFamily (String first, String last, String number, 
           String email, String birthday, String workNumber, String workEmail, 
           String workAddress)
   {
      contacts.add(new Family(first, last, number, email, 
              birthday, workNumber, workEmail, workAddress));
      selectionSort();
   }
   
   public static void addFriend (String first, String last, String number, 
           String email, String gamerTag, String discord, String snapchat, 
           String address, String schoolEmail)
   {
      contacts.add(new Friend(first, last, number, email, 
              gamerTag, discord, snapchat, address, schoolEmail));
      selectionSort();
   }
   
   public static void addColleague (String first, String last, String number, 
           String email, String workPhone, String workEmail, String office)
   {
       contacts.add(new Colleague(first, last, number, 
               email, workPhone, workEmail, office));
       selectionSort();
   }
   
   public static ArrayList<Contact> getContacts()
   {
      return contacts;
   }
   
   public static void selectionSort()
   {
       int min;
       for (int i = 0; i < contacts.size()-1; i++)
       {
           min = i;
           for (int j = i; j < contacts.size(); j++)
           {
               if (contacts.get(j).getLastName().compareTo(contacts.get(min).getLastName()) < 0)
               {
                   swap(contacts, min, j);
               }
           }
       }
   }
   
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Marshall Paider
 */
public class Friend extends Contact
{
   private String gamerTag;
   private String discord;
   private String snapchat;
   private String address;
   private String schoolEmail;
   
   public Friend (String firstName, String lastName, String phoneNumber,
           String email, String gamerTag, String discord, String snapchat,
           String address, String schoolEmail)
   {
      super(firstName, lastName, phoneNumber, email, "Friend");
      this.gamerTag = gamerTag;
      this.discord = discord;
      this.snapchat = snapchat;
      this.address = address;
      this.schoolEmail = schoolEmail;
   }
   
   public Friend ()
   {
      super();
      this.gamerTag = "";
      this.discord = "";
      this.snapchat = "";
      this.address = "";
      this.schoolEmail = "";
      
      super.setRelation("Friend");
   }
   
   public String getGamerTag()
   {
      return gamerTag;
   }
   
   public String getDiscord()
   {
      return discord;
   }
   
   public String getSnapchat()
   {
      return snapchat;
   }
   
   public String getAddress()
   {
      return address;
   }
   
   public String getSchoolEmail()
   {
      return schoolEmail;
   }
   
   public void setGamerTag (String newGamerTag)
   {
      this.gamerTag = newGamerTag;
   }
   
   public void setDiscord (String newDiscord)
   {
      this.discord = newDiscord;
   }
   
   public void setSnapchat (String newSnapchat)
   {
      this.snapchat = newSnapchat;
   }
   
   public void setAddress (String newAddress)
   {
      this.address = newAddress;
   }
   
   public void setSchoolEmail (String newSchoolEmail)
   {
      this.schoolEmail = newSchoolEmail;
   }
   
   @Override
   public String toString()
   {
      return super.toString() + "\nGamertag: " + getGamerTag() + "\nDiscord: " +
              getDiscord() + "\nSnapchat: " + getSnapchat() + "\nAddress: " + 
              getAddress() + "\nSchool Email: " + getSchoolEmail();
   }
}

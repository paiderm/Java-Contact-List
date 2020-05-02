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
public class Colleague extends Contact
{
   private String workPhone;
   private String workEmail;
   private String office;
   
   public Colleague (String firstName, String lastName, String phoneNumber,
           String email, String workPhone, String workEmail, String office)
   {
      super(firstName, lastName, phoneNumber, email, "Colleague");
      this.workPhone = super.formatNumber(workPhone);
      this.workEmail = workEmail;
      this.office = office;
   }
   
   public Colleague ()
   {
      super();
      this.workPhone = "";
      this.workEmail = "";
      this.office = "";
   }
   
   public void setWorkPhone (String newWorkPhone)
   {
      this.workPhone = super.formatNumber(newWorkPhone);
   }
   
   public void setWorkEmail (String newWorkAddress)
   {
      this.workEmail = newWorkAddress;
   }
   
   public void setOffice (String newOffice)
   {
      this.office = newOffice;
   }
   
   public String getWorkPhone ()
   {
      return workPhone;
   }
   
   public String getWorkEmail ()
   {
      return workEmail;
   }
   
   public String getOffice()
   {
      return office;
   }
   
   @Override
   public String toString()
   {
      return super.toString() + "\nWork Phone: " + getWorkPhone() + "\nWork Email: "
              + getWorkEmail() + "\nOffice: " + getOffice();
   }
}

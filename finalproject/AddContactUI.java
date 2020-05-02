/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
//import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.ListView;

import javafx.scene.control.ChoiceBox;
//import javafx.scene.layout.Background;
/**
 *
 * @author paiderm
 */
public class AddContactUI extends Application
{   
   String First, Last, Email, Phone;
   String Contact;
   Button Add, Info, NewContact, Back;
   Label firstName, lastName, email, phoneNumber;   
   TextField firstNameValue, lastNameValue, 
             emailValue, phoneNumValue;
   ChoiceBox relation;
   ListView list;

   @Override      
   public void start(Stage primaryStage) throws Exception
   {
      GridPane pane = new GridPane();
      pane.setPadding(new Insets(15));
      pane.setStyle("-fx-background-color: #26262B;");
      pane.setPadding(new Insets(15));
      
      Scene mainScene = new Scene (pane, 420, 500);
  
      list = new ListView();
      list.setStyle("-fx-control-inner-background: #26262B;");
      
      for (int i = 0; i < ContactsList.getContacts().size(); i++)
      {
         list.getItems().add(ContactsList.getContacts().get(i).getFirstName() + " " + 
                 ContactsList.getContacts().get(i).getLastName());
      }
      
      Info = new Button("Info");
      NewContact = new Button("New Contact");
      
      primaryStage.setTitle("My Contacts");
      primaryStage.setScene(mainScene);
      primaryStage.show();
      
      pane.add(list, 0, 0);
      pane.add(Info, 0, 1);
      pane.add(NewContact, 1, 1);
      
      NewContact.setOnAction((ActionEvent e) -> {
         addContact(primaryStage);
      });
      Info.setOnAction((ActionEvent d) -> {
         displayInfo(primaryStage, ContactsList.getContacts().get(list.getSelectionModel().getSelectedIndex()));
      });
    
      
      
   }
   
   public static void main (String[] args)   
   {        
      FillerContacts.addDummyContacts();
      Application.launch(args);
   }
   
   public void addContact(Stage primaryStage)
   {
      GridPane pane = new GridPane();
      pane.setPadding(new Insets(15));
      pane.setStyle("-fx-background-color: #26262B;");
      pane.setPadding(new Insets(15));
      Scene mainScene = new Scene (pane, 400, 250);
      
      relation = new ChoiceBox();
   
      Add = new Button("+");
      Back = new Button("<-");

      firstName = new Label("First Name");
      firstName.setTextFill(Color.web("#ffffff"));
      firstNameValue = new TextField();
      
      lastName = new Label("Last Name");
      lastName.setTextFill(Color.web("#ffffff"));
      lastNameValue = new TextField();
      
      email = new Label("Email");
      email.setTextFill(Color.web("#ffffff"));
      emailValue = new TextField();
      
      phoneNumber = new Label("Phone Number");
      phoneNumber.setTextFill(Color.web("#ffffff"));
      phoneNumValue = new TextField();
      
      relation.getItems().addAll("Other", "Friend", "Family", "Colleague");
      relation.setValue("Other");
      
      primaryStage.setTitle("New Contact");
      primaryStage.setScene(mainScene);
      primaryStage.show();
      
      pane.add(firstName, 0, 0);
      pane.add(firstNameValue, 1, 0);
      
      pane.add(lastName, 0, 1);
      pane.add(lastNameValue, 1, 1);
      
      pane.add(email, 0, 2);
      pane.add(emailValue, 1, 2);
      
      pane.add(phoneNumber, 0, 3);
      pane.add(phoneNumValue, 1, 3);
      
      pane.add(relation, 1, 4);
      
      pane.add(Add, 10, 0);
      pane.add(Back, 10, 1);
      
      Back.setOnAction((ActionEvent d) ->
      {
         try
         {
         start(primaryStage);
         }
         catch (Exception ex)
         {
            System.out.println(ex);
         }
      });
      
      Add.setOnAction((ActionEvent e) -> 
      {
         
         First = firstNameValue.getText();
         Last = lastNameValue.getText();
         Email = emailValue.getText();
         Phone = phoneNumValue.getText();
         
         //printContact(First, Last, Email, Phone);
         if (!(firstNameValue.getText().isEmpty() || lastNameValue.getText().isEmpty() || emailValue.getText().isEmpty() || phoneNumValue.getText().isEmpty()))
         {
            if (relation.getValue().equals("Other"))
            {
                ContactsList.addContact(firstNameValue.getText(), lastNameValue.getText(), phoneNumValue.getText(), emailValue.getText());
                successLabel(true, pane, primaryStage);
            }
            if (relation.getValue().equals("Friend"))
            {
                addFriendUI(pane, primaryStage, Add);    
            }
            if (relation.getValue().equals("Family"))
            {
                addFamilyUI(pane, primaryStage, Add);    
            }
            if (relation.getValue().equals("Colleague"))
                addColleagueUI(pane, primaryStage, Add);
         }
         else
         {
             successLabel(false, pane, primaryStage);
         }
      });
   }
   
   public void successLabel(boolean status, GridPane pane, Stage primaryStage)
   {
       Label success = new Label();
       
       success.setFont(new Font("Arial", 20));
       if ( status )
       {
           success.setText("New Contact Created");
           success.setTextFill(Color.web("#00c400"));
       }
       else
       {
           success.setText("Error: Missing Content");
           success.setTextFill(Color.web("#ff0000"));
       }
       pane.add(success, 1, 10);
       
       for (int i = 0; i < ContactsList.getContacts().size(); i++)
       {
          System.out.println(ContactsList.getContacts().get(i) + "\n");
       }
       
       try
       {
         start(primaryStage);
       }
       catch (Exception ex)
       {
         System.out.println(ex);
       }
   }
   
   
   public void addFriendUI(GridPane pane, Stage primaryStage, Button add)
   {
      primaryStage.setHeight(400);
       
      Label gamerTag = new Label("Gamertag");
      gamerTag.setTextFill(Color.web("#ffffff"));
      TextField gamerTagValue = new TextField();
      
      Label discord = new Label("Discord");
      discord.setTextFill(Color.web("#ffffff"));
      TextField discordValue = new TextField();
      
      Label snapchat = new Label("Snapchat");
      snapchat.setTextFill(Color.web("#ffffff"));
      TextField snapchatValue = new TextField();
      
      Label address = new Label("Address");
      address.setTextFill(Color.web("#ffffff"));
      TextField addressValue = new TextField();
      
      Label schoolEmail = new Label("School Email");
      schoolEmail.setTextFill(Color.web("#ffffff"));
      TextField schoolEmailValue = new TextField();
      
      pane.add(gamerTag, 0, 5);
      pane.add(gamerTagValue, 1, 5);
      
      pane.add(discord, 0, 6);
      pane.add(discordValue, 1, 6);
      
      pane.add(snapchat, 0, 7);
      pane.add(snapchatValue, 1, 7);
      
      pane.add(address, 0, 8);
      pane.add(addressValue, 1, 8);
      
      pane.add(schoolEmail, 0, 9);
      pane.add(schoolEmailValue, 1, 9);
      
       add.setOnAction((ActionEvent e) -> 
       {
            if (!(gamerTagValue.getText().isEmpty() || discordValue.getText().isEmpty()
                || snapchatValue.getText().isEmpty() || addressValue.getText().isEmpty()
                || schoolEmailValue.getText().isEmpty()))
            {
                ContactsList.addFriend(firstNameValue.getText(), lastNameValue.getText(), 
                    phoneNumValue.getText(), emailValue.getText(), gamerTagValue.getText(),
                    discordValue.getText(), snapchatValue.getText(), addressValue.getText(),
                    schoolEmailValue.getText());
                successLabel(true, pane, primaryStage);
                
                for (int i = 0; i < ContactsList.getContacts().size(); i++)
                {
                   System.out.println(ContactsList.getContacts().get(i).toString() + "\n");
                }
            }
            else
                successLabel(false, pane, primaryStage);
        });
   }
   
   public void addFamilyUI(GridPane pane, Stage primaryStage, Button add)
   {
      primaryStage.setHeight(400);
       
      Label birthday = new Label("Birthday");
      birthday.setTextFill(Color.web("#ffffff"));
      TextField birthdayValue = new TextField();
      
      Label workPhone = new Label("Work Phone");
      workPhone.setTextFill(Color.web("#ffffff"));
      TextField workPhoneValue = new TextField();
      
      Label workEmail = new Label("Work Email");
      workEmail.setTextFill(Color.web("#ffffff"));
      TextField workEmailValue = new TextField();
      
      Label workAddress = new Label("Work Address");
      workAddress.setTextFill(Color.web("#ffffff"));
      TextField workAddressValue = new TextField();
      
      pane.add(birthday, 0, 5);
      pane.add(birthdayValue, 1, 5);
      
      pane.add(workPhone, 0, 6);
      pane.add(workPhoneValue, 1, 6);
      
      pane.add(workEmail, 0, 7);
      pane.add(workEmailValue, 1, 7);
      
      pane.add(workAddress, 0, 8);
      pane.add(workAddressValue, 1, 8);
      
       add.setOnAction((ActionEvent e) -> 
       {
            if (!(birthdayValue.getText().isEmpty() || workPhoneValue.getText().isEmpty()
                || workEmailValue.getText().isEmpty() || workAddressValue.getText().isEmpty()))
            {
                ContactsList.addFamily(firstNameValue.getText(), lastNameValue.getText(), 
                    phoneNumValue.getText(), emailValue.getText(), birthdayValue.getText(),
                    workPhoneValue.getText(), workEmailValue.getText(), workAddressValue.getText());
                successLabel(true, pane, primaryStage);
            }
            else
                successLabel(false, pane, primaryStage);
        });
   }
   
   public void addColleagueUI(GridPane pane, Stage primaryStage, Button add)
   {
      primaryStage.setHeight(400);
     
      Label workPhone = new Label("Work Phone");
      workPhone.setTextFill(Color.web("#ffffff"));
      TextField workPhoneValue = new TextField();
      
      Label workEmail = new Label("Work Email");
      workEmail.setTextFill(Color.web("#ffffff"));
      TextField workEmailValue = new TextField();
      
      Label office = new Label("Office");
      office.setTextFill(Color.web("#ffffff"));
      TextField officeValue = new TextField();

      pane.add(workPhone, 0, 5);
      pane.add(workPhoneValue, 1, 5);
      
      pane.add(workEmail, 0, 6);
      pane.add(workEmailValue, 1, 6);
      
      pane.add(office, 0, 7);
      pane.add(officeValue, 1, 7);
      
       add.setOnAction((ActionEvent e) -> 
       {
            if (!(workPhoneValue.getText().isEmpty()
                || workEmailValue.getText().isEmpty() || officeValue.getText().isEmpty()))
            {
                ContactsList.addColleague(firstNameValue.getText(), lastNameValue.getText(), 
                    phoneNumValue.getText(), emailValue.getText(),
                    workPhoneValue.getText(), workEmailValue.getText(), officeValue.getText());
                successLabel(true, pane, primaryStage);
                
                for (int i = 0; i < ContactsList.getContacts().size(); i++)
                {
                    System.out.println(ContactsList.getContacts().get(i).toString() + "\n");
                }
            }
            else
                successLabel(false, pane, primaryStage);
        });
   }
   
   public void displayInfo(Stage primaryStage, Contact person)
   {
      Button toMain = new Button("<-");
      Label fNameValue, lNameValue, eValue, phoneNumberValue;
      
      GridPane pane = new GridPane();
      pane.setPadding(new Insets(15));
      pane.setStyle("-fx-background-color: #26262B;");
      pane.setPadding(new Insets(15));
      Scene mainScene = new Scene (pane, 400, 250);
      
      fNameValue = new Label(person.getFirstName());
      fNameValue.setTextFill(Color.web("#ffffff"));
      fNameValue.setFont(new Font("Arial", 20));
      
      lNameValue = new Label(person.getLastName());
      lNameValue.setTextFill(Color.web("#ffffff"));
      lNameValue.setFont(new Font("Arial", 20));
      
      email = new Label("Email: ");
      email.setTextFill(Color.web("#ffffff"));
      eValue = new Label(person.getPersonalEmail());
      eValue.setTextFill(Color.web("#ffffff"));
      
      phoneNumber = new Label("Phone: ");
      phoneNumber.setTextFill(Color.web("#ffffff"));
      phoneNumberValue = new Label(person.getPhoneNumber());
      phoneNumberValue.setTextFill(Color.web("#ffffff"));
      
      primaryStage.setTitle(person.getFirstName() + " " + person.getLastName());
      primaryStage.setScene(mainScene);
      primaryStage.show();
      
      pane.add(fNameValue, 0, 0);
      pane.add(lNameValue, 1, 0);
      
      pane.add(email, 0, 1);
      pane.add(eValue, 1, 1);
      pane.add(phoneNumber, 0, 2);
      pane.add(phoneNumberValue, 1, 2);
      pane.add(toMain,0,10);
      
      if (person.getRelation().equals("Friend"))
         displayFriend(pane, primaryStage, (Friend)person);
      else if (person.getRelation().equals("Family"))
         displayFamily(pane, primaryStage, (Family)person);
      else if (person.getRelation().equals("Colleague"))
         displayColleague(pane, primaryStage, (Colleague)person);
      
      toMain.setOnAction((ActionEvent e) -> 
      {
         try
       {
         start(primaryStage);
       }
       catch (Exception ex)
       {
         System.out.println(ex);
       }
      });
   }
   
   public void displayFriend(GridPane pane, Stage primaryStage, Friend person)
   {
      Label gamerTag = new Label("Gamertag: ");
      Label discord = new Label("Discord: ");
      Label snapchat = new Label("Snapchat: ");
      Label address = new Label("Address: ");
      Label schoolEmail = new Label("School Email: ");
      
      Label gamerTagValue = new Label(person.getGamerTag());
      Label discordValue = new Label(person.getDiscord());
      Label snapchatValue = new Label(person.getSnapchat());
      Label addressValue = new Label(person.getAddress());
      Label schoolEmailValue = new Label(person.getSchoolEmail());
      
      gamerTag.setTextFill(Color.web("#ffffff"));
      gamerTagValue.setTextFill(Color.web("#ffffff"));
      
      discord.setTextFill(Color.web("#ffffff"));
      discordValue.setTextFill(Color.web("#ffffff"));
      
      snapchat.setTextFill(Color.web("#ffffff"));
      snapchatValue.setTextFill(Color.web("#ffffff"));
      
      address.setTextFill(Color.web("#ffffff"));
      addressValue.setTextFill(Color.web("#ffffff"));
      
      schoolEmail.setTextFill(Color.web("#ffffff"));
      schoolEmailValue.setTextFill(Color.web("#ffffff"));
      
      pane.add(gamerTag, 0, 3);
      pane.add(gamerTagValue, 1, 3);
      pane.add(discord, 0, 4);
      pane.add(discordValue, 1, 4);
      pane.add(snapchat, 0, 5);
      pane.add(snapchatValue, 1, 5);
      pane.add(address, 0, 6);
      pane.add(addressValue, 1, 6);
      pane.add(schoolEmail, 0, 7);
      pane.add(schoolEmailValue, 1, 7);
      

   }
   
   public void displayFamily(GridPane pane, Stage primaryStage, Family person)
   {
      Label birthday = new Label("Birthday: ");
      Label workPhone = new Label("Work Phone: ");
      Label workEmail = new Label("Work Email: ");
      Label workAddress = new Label("Work Address: ");
      
      Label birthdayValue = new Label(person.getBirthday());
      Label workPhoneValue = new Label(person.getWorkPhone());
      Label workEmailValue = new Label(person.getWorkEmail());
      Label workAddressValue = new Label(person.getWorkAddress());
     
      birthday.setTextFill(Color.web("#ffffff"));
      birthdayValue.setTextFill(Color.web("#ffffff"));
      
      workPhone.setTextFill(Color.web("#ffffff"));
      workPhoneValue.setTextFill(Color.web("#ffffff"));
      
      workEmail.setTextFill(Color.web("#ffffff"));
      workEmailValue.setTextFill(Color.web("#ffffff"));
      
      workAddress.setTextFill(Color.web("#ffffff"));
      workAddressValue.setTextFill(Color.web("#ffffff"));
 
      pane.add(birthday, 0, 3);
      pane.add(birthdayValue, 1, 3);
      pane.add(workPhone, 0, 4);
      pane.add(workPhoneValue, 1, 4);
      pane.add(workEmail, 0, 5);
      pane.add(workEmailValue, 1, 5);
      pane.add(workAddress, 0, 6);
      pane.add(workAddressValue, 1, 6);
   }
   
   public void displayColleague(GridPane pane, Stage primaryStage, Colleague person)
   {
      Label workPhone = new Label("Work Phone: ");
      Label workEmail = new Label("Work Email: ");
      Label office = new Label("Office: ");
      
      Label workPhoneValue = new Label(person.getWorkPhone());
      Label workEmailValue = new Label(person.getWorkEmail());
      Label officeValue = new Label(person.getOffice());
     
      workPhone.setTextFill(Color.web("#ffffff"));
      workPhoneValue.setTextFill(Color.web("#ffffff"));
      
      workEmail.setTextFill(Color.web("#ffffff"));
      workEmailValue.setTextFill(Color.web("#ffffff"));
      
      office.setTextFill(Color.web("#ffffff"));
      officeValue.setTextFill(Color.web("#ffffff"));
 
      pane.add(workPhone, 0, 3);
      pane.add(workPhoneValue, 1, 3);
      pane.add(workEmail, 0, 4);
      pane.add(workEmailValue, 1, 4);
      pane.add(office, 0, 5);
      pane.add(officeValue, 1, 5);
   }
}   

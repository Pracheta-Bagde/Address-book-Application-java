package AddressBook;
import java.util.Scanner;
import java.util.ArrayList;

public class AddressBookApplication{
    static Scanner s = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();
 // static -> it belongs to class itself not to an instance
 // Contact -> dataType
 // contacts -> initialise to new ArrayList instance

    public static void main(String[] args) {
        System.out.println("Enter your Choice:");
        while(true){
            System.out.println("1.Add\n2.View\n3.Search\n4.Delete\n5.Edit\n6.Exit\n");
            int choice = s.nextInt();
            s.nextLine();
            switch(choice){
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    editContact();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice Try again!");
            }
        }
    }


    public static void addContact(){ // perform actions but does not return any value na!
        System.out.println("Enter Name: ");
        String name = s.nextLine();
        System.out.println("Enter Address: ");
        String address = s.nextLine();
        System.out.println("Enter phone No: ");
        long phNo = s.nextLong();
        s.nextLine();
        System.out.println("Enter email: ");
        String email = s.nextLine();

        Contact c = new Contact(name,address,phNo,email);
        contacts.add(c);
        System.out.println("Added Successfully!");

    }
    public static void viewContact(){
        if(contacts.isEmpty()){
            System.out.println("Contact is empty");
        }else {
            for (Contact c : contacts) {
                System.out.println(c);
            }
        }
    }
    public static void searchContact(){
        System.out.println("Enter name to search");
        String name = s.nextLine();
        boolean found = false;
        for(Contact c: contacts){
            if(c.getName().equalsIgnoreCase(name)){
                System.out.println(c);
                found = true;
            }

        }if(!found){
            System.out.println("Not in Contact! try again ");
        }

    }
    public static void editContact(){
        viewContact();
        s.nextLine();
        System.out.println("Enter index to edit the contact");
        int index = s.nextInt();
        s.nextLine();
        if(index >= 1 && index<=contacts.size()){
            index = index-1; // for out of bound index!
            System.out.println("Enter new name");
            String name = s.nextLine();
            System.out.println("Enter new address:");
            String address = s.nextLine();
            System.out.println("Enter new phone no: ");
            long phNo = s.nextInt();
            s.nextLine();
            System.out.println("Enter new email: ");
            String email = s.nextLine();
            Contact uc = new Contact(name,address,phNo,email);
            contacts.set(index,uc);

        }else{
            System.out.println("invalid! try again");
        }


    }
    public static void deleteContact(){
        System.out.println("Enter a name to delete");
        String name = s.nextLine();
        boolean found = false;
        Contact toRemove = null;
        for(Contact c : contacts){
            if(c.getName().equalsIgnoreCase(name)){
                found = true;
                toRemove = c;
                break;
            }
        }
        if(found){
            contacts.remove(toRemove);
            System.out.println("Deleted!!");
        }else{
            System.out.println("Contact not found!");
        }
    }
}
class Contact{
    private String name; // for encapsulation
    private String address;
    private long phNo;
    private String email;

    public Contact(String name, String address, long phNo, String email) {
        this.name = name;
        this.address = address;
        this.phNo = phNo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public long getPhNo() {
        return phNo;
    }

    public String getEmail() {
        return email;
    }


    // when an object contact is called it will print-> this
    // if toString !(used) -> it will show contact in the format -> contact@123465
    @Override
    public String toString(){
        return "Name: " +name+ " Address: " + address + " Phone No: " + phNo + " Email: "+ email;
    }

}

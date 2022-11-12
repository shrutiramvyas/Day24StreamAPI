
import java.util.*;
import java.util.stream.Collectors;

public class ContactPerson {
    public String first_name,last_name,address,city,state,email;
    public long phoneNumber;
    public int zip;
    Scanner scan = new Scanner(System.in);

    ArrayList<AdressBookClass> c;
    HashMap<String, ArrayList> addressBooks = new HashMap<String, ArrayList>();

    public void create(){
        System.out.println("In which address book you want to add contact: ");
        String chooseAddressBook=scan.nextLine();
        if(addressBooks.containsKey(chooseAddressBook)){
            this.c = addressBooks.get(chooseAddressBook);
            System.out.println("Number Of Contact Person You want to add: ");
            int num = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < num; i++) {
                insert();
            }
        }
        else{
            System.out.println("Address Book not found");
            addAddressBook();
        }

    }
    public void readuser() {
        ContactPerson add = new ContactPerson();
        System.out.println("Enter First Name :");
        first_name = scan.next();
        scan.nextLine();
        System.out.println("Enter Last Name :");
        last_name = scan.nextLine();
    }
    public void readdetail(){
        System.out.println("Enter address :");
        address = scan.nextLine();
        System.out.println("Enter city :");
        city = scan.next();
        System.out.println("Enter state :");
        state = scan.next();
        System.out.println("Enter email :");
        email = scan.next();
        scan.nextLine();
        System.out.println("Enter Phone Number :");
        phoneNumber = scan.nextLong();
        scan.nextLine();
        System.out.println("Enter Zip :");
        zip = scan.nextInt();
    }
    public void insert(){
        readuser();
        readdetail();
        AdressBookClass adressBookClass = new AdressBookClass(first_name, last_name, address, city, state, email, phoneNumber, zip);
        boolean isAddressBookFound = false;
//        for( int i = 0; i < c.size(); i++ ){
//            if(c.get(i).equals(adressBookClass)){
//                System.out.println("Already have a registered contact");
//                isAddressBookFound = true;
//                break;
//            }
//        }
        isAddressBookFound = c.stream().anyMatch(tempAddressBook -> tempAddressBook.equals(adressBookClass));
        if(! isAddressBookFound ){
            this.c.add(adressBookClass);
        }
        else{
            System.out.println("Already have a registered contact");
        }
   
        

    }

    public void deleteRecord(){
        boolean found=false;
        System.out.println("Write the name which you want to delete: ");
        String name=scan.next();
        System.out.println("--------------------------------------");
        Iterator<AdressBookClass> i=c.iterator();
        while(i.hasNext()){
            AdressBookClass a=i.next();
            // if(Objects.equals(a.getFirst_name(), name)){
            if(a.getFirst_name().equals(name)){
                i.remove();
                found=true;
            }
        }
        if(!found){
            System.out.println("Record not found");
        }
        else{
            System.out.println("Record deleted successfully");
        }
    }

    public void display(){
        System.out.println("==============================================");
        Iterator<AdressBookClass> i=c.iterator();
        while(i.hasNext()){
            AdressBookClass e=i.next();
            System.out.println(e);
        }
        System.out.println("==============================================");
    }
    public void addAddressBook(){
        System.out.println("Enter name for new Address Book : ");
        String newAddress =scan.nextLine();
        ArrayList<AdressBookClass> contact= new ArrayList<AdressBookClass>();
        addressBooks.put(newAddress,contact);

    }
    public void update(){
        boolean found=false;
        System.out.println("Write the name which you want to edit: ");
        String name=scan.next();
        System.out.println("--------------------------------------");
        Iterator<AdressBookClass> i=c.iterator();
        while(i.hasNext()){
            AdressBookClass a=i.next();
            if(Objects.equals(a.getFirst_name(), name)){
                readuser();
                a.setFirst_name(first_name);
                a.setLast_name(last_name);
                a.setAddress(address);
                a.setCity(city);
                a.setState(state);
                a.setEmail(email);
                a.setPhoneNumber(phoneNumber);
                a.setZip(zip);
                found=true;
            }
        }

        if(!found){
            System.out.println("Record not found");
        }
        else{
            System.out.println("Record updated successfully");
        }
    }

    public void searchByCity(){
        System.out.println("Enter city or state name");
        String searchCity = scan.nextLine();
        List<AdressBookClass> searchedCity = c.stream().filter(tempAddressBook -> tempAddressBook.getCity().equals(searchCity) || tempAddressBook.getState().equals(searchCity)).collect(Collectors.toList());
        System.out.println(searchedCity);
        Hashtable<String , ArrayList> printCity = new Hashtable<String, ArrayList>();
        for( int i = 0; i < c.size(); i++ ){
            AdressBookClass temp = c.get(i);
            if(printCity.containsKey(temp.getCity())){
                ArrayList<AdressBookClass> cityList = printCity.get(temp.getCity());
                cityList.add(temp);
                printCity.put(temp.city, cityList);
            }
            else{
                ArrayList<AdressBookClass> cityList = new ArrayList<>();
                cityList.add(temp);
                printCity.put(temp.city, cityList);
            }
        }
    }
    public void ask() {
        int choose;
        do {
            System.out.println("1 for create new contact \n 2 for search contact \n 3 for delete \n 4 for display\n 5 for update\n 6 for add new Address Book\n 7 for search contact person according to city or state :  ");
            choose = scan.nextInt();
            scan.nextLine();
            switch (choose) {
                case 1:
                    create();
                    break;
                case 2:
//                    search();
                    break;
                case 3:
                    deleteRecord();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                    addAddressBook();
                    break;
                case 7:
                    searchByCity();
                    break;
            }
        }while(choose!=0);
    }

    public static void main(String[] args) {
        ContactPerson co = new ContactPerson();
        co.ask();
    }
}

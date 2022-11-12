public class AdressBookClass {
    public String first_name,last_name,address,city,state,email;
    public long phoneNumber;
    public int zip;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        if(first_name != "")this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        if(last_name != "")this.last_name = last_name;
    }

    public void setAddress(String address) {
        if(address != "") this.address = address;
    }

    public void setCity(String city) {
        if(city != "")this.city = city;
    }

    public void setState(String state) {
        if(state != "")this.state = state;
    }

    public void setEmail(String email) {
        if(email != "")this.email = email;
    }

    public void setPhoneNumber(long phoneNumber) {
        if(String.valueOf(phoneNumber) != "") {
            this.phoneNumber = phoneNumber;
        }
    }

    public void setZip(int zip) {
        if(String.valueOf(zip)!= ""){
            this.zip = zip;
        }
    }

    public String getLast_name() {
        return last_name;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getEmail() {
        return email;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public int getZip() {
        return zip;
    }
    public String toString(){
        return "First Name = "+first_name +" \n"+ "Last Name = " +last_name +" \n" + "Address = "+ address +" \n" + "City =" + city+" \n"+"State = " + state+" \n"+ "Email ="+email+" \n"+ "Phone Number ="+phoneNumber+" \n" + "Zip Code = "+zip+" \n\n"+"------------------";
    }
    AdressBookClass(String first_name,String last_name,String address,String city,String state,String email,long phoneNumber,int zip){
        this.first_name=first_name;
        this.last_name=last_name;
        this.address=address;
        this.city=city;
        this.state=state;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.zip=zip;
    }

    @Override
    public boolean equals(Object obj) {
        AdressBookClass anotherAddressbook = (AdressBookClass) obj;
        return anotherAddressbook.first_name.equals(this.first_name) && anotherAddressbook.last_name.equals(this.last_name);
    }
}

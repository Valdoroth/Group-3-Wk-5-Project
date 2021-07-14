public class UserAccounts {
    String userName;
    String Password;
    String firstName;
    String lastName;
    String booksCheckedOut;

    public UserAccounts(String s, String s1, String s2, String s3, String s4) {
        this.userName = s;
        this.Password = s1;
        this.firstName = s2;
        this.lastName = s3;
        this.booksCheckedOut = s4;
    }


    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return Password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBooksCheckedOut() {
        return booksCheckedOut;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBooksCheckedOut(String booksCheckedOut) {
        this.booksCheckedOut = booksCheckedOut;
    }


}

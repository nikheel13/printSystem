package sample;

public class ModelAlias {
    String studentid, firstname, lastname, username, email;

    public ModelAlias(String studentid, String firstname, String lastname, String username, String email) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;

    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


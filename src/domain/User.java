package domain;

public class User {
   private String username;
   private Integer id;
   private String password;
   private String tephone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTephone() {
        return tephone;
    }

    public void setTephone(String tephone) {
        this.tephone = tephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", tephone='" + tephone + '\'' +
                '}';
    }
}

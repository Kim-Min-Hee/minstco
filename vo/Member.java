package vo;

public class Member {
    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private char grade;
    private String joinDate;
    private int total;

public Member(String id , String password, String name , String email, String phoneNumber , String gender, char grade , int total){
    this.id = id;
    this.password = password;
    this.name=name;
    this.email = email;
    this.phoneNumber=phoneNumber;
    this.gender = gender;
    this.grade = grade;
    this.total = total;

    System.out.println("member : "+id+"\t"+password+"\t"+name+"\t"+email+"\t"+phoneNumber+"\t"+gender+"\t"+grade+"\t"+total);
}



    public char getGrade() {
        return grade;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public int getTotal() {
        return total;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

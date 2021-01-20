package vo;

public class User {
    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private char grade;
    private String joinDate;
    private int total;
    private double discount;


    public String UserInfo(){
//        if(grade=='A'){
//            discount=0.1;
//        }else if(grade=='B'){
//            discount= 0.05
//        }else if(grade=='C'){
//            discount=0.03;
//        }else{
//            discount=0;
//        }
        return "User infomation "+"id : "+id+"\t"+"name : "+name+"\t"+"email : "+email+"\t"+"phoneNumber : "+phoneNumber+"\t"+"gender : "+gender+
                "\t"+"grade : "+grade+"\t"+"total : "+total+"\t"+"discount : "+discount;
    }



    public User(String id , String password, String name , String email, String phoneNumber , String gender, char grade , int total, double discount){
        this.id = id;
        this.password = password;
        this.name=name;
        this.email = email;
        this.phoneNumber=phoneNumber;
        this.gender = gender;
        this.grade = grade;
        this.total = total;
        this.discount = discount;

        System.out.println("User : "+id+"\t"+password+"\t"+name+"\t"+email+"\t"+phoneNumber+"\t"+gender+"\t"+grade+"\t"+total+"\t"+discount);
    }

    public double getDiscount() {
        return discount;
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

    public String getGender() {
        return gender;
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

    public void setGender(String gender) {
        this.gender = gender;
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

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

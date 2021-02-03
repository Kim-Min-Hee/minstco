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
    private int discount;
    private  double discountRate;



    public Member(String id , String password, String name , String email, String phoneNumber , String gender, char grade ,double discountRate,
                  int total, int discount){
    this.id = id;
    this.password = password;
    this.name=name;
    this.email = email;
    this.phoneNumber=phoneNumber;
    this.gender = gender;
    this.grade = grade;
    this.discountRate = discountRate;
    this.total = total;
    this.discount= discount;

    System.out.println("member : "+"id : "+id+"\t"+"password : "+password+"\t"+"name : "+name+"\t"+"email : "+email+
            "\t"+"phoneNumber : "+phoneNumber+"\t"+"gender : "+gender+"\t"+"grade : "+grade+"\t" +"discountRate : "+discountRate+
            "total : "+total+"\t"+"discount : "+discount);
}
public String getInfo(){
    return "member infomation  "+"id : "+id+"\t"+"name : "+name+"\t"+"email : "+email+"\t"+"phoneNumber : "+phoneNumber+"\t"+
            "gender : "+gender+"\t"+"grade : "+ grade+"\t"+"discountRate : "+discountRate+"total : "+total;
}

    public int getDiscount() {
        return discount;
    }

    public char getGrade() {

        return grade;
    }
    public double getDiscountRate() {
        return discountRate;
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

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setDiscountRate(double discountRate) {
       this.discountRate = discountRate;
    }
}

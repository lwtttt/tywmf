package com.four.entity;

import java.util.Date;

public class User {

    private int userId;
    private String idPic;
    private String conduction;
    /*------------------------------注册信息------------------------------*/
    private String gender;          //性别
    private Date birthday;          //出生
    private String workplace;       //工作地区
    private String maritalStatus;   //婚姻状况
    private String height;          //身高
    private String education;       //学历
    private String income;          //月收入
    private String phone;           //手机
    private String password;

    /*------------------------------基本资料------------------------------*/
    private String userName;        //昵称

    /*------------------------------详细资料------------------------------*/
    private String nativePlace;     //籍贯
    private String weight;          //体重
    private String jobClass;        //职业类别
    private String house;           //买房情况
    private String car;             //买车情况
    private String smoke;           //是否吸烟
    private String drink;           //是否喝酒
    private String nation;          //民族

    /*------------------------------用户权限等------------------------------*/
    private int roleCode;           //身份码（1表示管理员，2表示用户）
    private int accountStatus;      //账号状态0表示封禁，1表示正常
    private int starLevel;          //星级特权，默认0数字越大级别越高
    private int beViewNum;          //被浏览量，默认0

    /*------------------------------数据库没有的数据------------------------------*/
    private int age;

    /*------------------------------构造器------------------------------*/
    public User(int userId, String idPic, String conduction, String gender, Date birthday, String workplace, String maritalStatus, String height, String education, String income, String phone, String password, String userName, String nativePlace, String weight, String jobClass, String house, String car, String smoke, String drink, String nation, int roleCode, int accountStatus, int starLevel, int beViewNum) {
        this.userId = userId;
        this.idPic = idPic;
        this.conduction = conduction;
        this.gender = gender;
        this.birthday = birthday;
        this.workplace = workplace;
        this.maritalStatus = maritalStatus;
        this.height = height;
        this.education = education;
        this.income = income;
        this.phone = phone;
        this.password = password;
        this.userName = userName;
        this.nativePlace = nativePlace;
        this.weight = weight;
        this.jobClass = jobClass;
        this.house = house;
        this.car = car;
        this.smoke = smoke;
        this.drink = drink;
        this.nation = nation;
        this.roleCode = roleCode;
        this.accountStatus = accountStatus;
        this.starLevel = starLevel;
        this.beViewNum = beViewNum;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", idPic='" + idPic + '\'' +
                ", conduction='" + conduction + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", workplace='" + workplace + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", height='" + height + '\'' +
                ", education='" + education + '\'' +
                ", income='" + income + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", weight='" + weight + '\'' +
                ", jobClass='" + jobClass + '\'' +
                ", house='" + house + '\'' +
                ", car='" + car + '\'' +
                ", smoke='" + smoke + '\'' +
                ", drink='" + drink + '\'' +
                ", nation='" + nation + '\'' +
                ", roleCode=" + roleCode +
                ", accountStatus=" + accountStatus +
                ", starLevel=" + starLevel +
                ", beViewNum=" + beViewNum +
                '}';
    }

    /*------------------------------getter/setter------------------------------*/
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }

    public int getBeViewNum() {
        return beViewNum;
    }

    public void setBeViewNum(int beViewNum) {
        this.beViewNum = beViewNum;
    }

    public String getIdPic() {
        return idPic;
    }

    public void setIdPic(String idPic) {
        this.idPic = idPic;
    }

    public String getConduction() {
        return conduction;
    }

    public void setConduction(String conduction) {
        this.conduction = conduction;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

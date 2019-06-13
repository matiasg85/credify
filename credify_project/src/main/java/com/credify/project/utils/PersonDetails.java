package com.credify.project.utils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.RandomStringUtils;

public class PersonDetails {

     private String firstName;
     private String lastName;
     private String streetAddress;
     private String city;
     private String state;
     private String zipCode;
     private String DOB;
     private String annualIncome;
     private String additionalIncome;
     private String email;
     private String password;

    public PersonDetails(){
        setFirstName(this.randomNameGenerator());
        setLastName(this.randomNameGenerator());
        setStreetAddress(this.randomStreetGenerator());
        setCity("City of " + this.randomNameGenerator());
        setState("CA");
        setZipCode(this.randomZipCodeGenerator());
        setDOB(this.randomDateGenerator());
        setAnnualIncome(this.randomIncomeGenerator());
        setAdditionalIncome(this.randomAdditionalIncomeGenerator());
        setEmail("mcaria"+ this.randomNumberGenerator()+"@upgrade-challenge.com");
        setPassword(this.randomPasswordGenerator(8));
    }

    public String randomNameGenerator(){
        return RandomStringUtils.random(10, true, false);
    }
    public String randomDateGenerator(){
        Random random = new Random();
        int minDay = (int) LocalDate.of(1930, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(1999, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate localDate = LocalDate.ofEpochDay(randomDay);
String date = localDate.format(DateTimeFormatter.ofPattern("MM dd yyyy"));

        return date;
    }

    public String randomStreetGenerator(){
        Random rand = new Random();
        int number = rand.nextInt(999);
            return String.valueOf(number) + " " + RandomStringUtils.random(15, true, false);
        }

        public String randomIncomeGenerator(){
        return String.valueOf(ThreadLocalRandom.current().nextLong(120000,200000));
        }

    public String randomAdditionalIncomeGenerator(){
        return String.valueOf(ThreadLocalRandom.current().nextLong(5000,100000));
    }
    public String randomZipCodeGenerator() {
        Random rand = new Random();
        return String.valueOf(ThreadLocalRandom.current().nextInt(10000, 99999));
    }
        public String randomNumberGenerator(){
            Random rand = new Random();
            return String.valueOf(ThreadLocalRandom.current().nextInt(10000,9999999));
    }

    public String randomPasswordGenerator (int length) {

        if (length < 8) {
            length = 9;
        }

        final char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
        final char[] numbers = "0123456789".toCharArray();
        final char[] allAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789".toCharArray();


        Random random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length-3; i++) {
            password.append(allAllowed[random.nextInt(allAllowed.length)]);
        }

        //Ensure password policy is met by inserting required random chars in random positions
        password.insert(random.nextInt(password.length()), lowercase[random.nextInt(lowercase.length)]);
        password.insert(random.nextInt(password.length()), uppercase[random.nextInt(uppercase.length)]);
        password.insert(random.nextInt(password.length()), numbers[random.nextInt(numbers.length)]);
        return password.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getAdditionalIncome() {
        return additionalIncome;
    }

    public void setAdditionalIncome(String additionalIncome) {
        this.additionalIncome = additionalIncome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

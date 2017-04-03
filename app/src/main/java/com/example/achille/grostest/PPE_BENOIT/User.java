package com.example.achille.grostest.PPE_BENOIT;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


/**
 * Created by YANIS on 12/10/2016.
 */

public class User {

    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String birthday;
    private int weight;
    private int height;
    private String origins;
    private String gender; //M ou F
    //Tableau de à deux entrée avec date + heures avec ce que le client à consommer en dynamique
    private ArrayList<Historic> historicDate = new ArrayList<Historic>();
    private double alcoholLevel; //live alcohol level of the user
    //On stocke la photodePRofile sur le drawable et on récupère après le nom de la photo pour pouvoir l'afficher.
    private String profilePictureURL;
    ///PLUS TARD ON VA PEUT ETRE RAJOUTER UN RESEAU SOCIAL + SAM.
    private Password password;

    private static final int ITERATIONS_NUMBER = 100;
    private static final int KEY_LENGTH = 256;

    //Faire le constructeur + les get et set(si il y a modification dans settings).

    public User ()
    {
        this.email = "";
        this.username ="";
        this.firstName ="";
        this.lastName = "";
        this.birthday = "";
        this.weight = 0;
        this.height=0;
        this.origins = "";
        this.gender = "";
        this.historicDate=null;
        this.profilePictureURL="";
        this.alcoholLevel=0;
    }
    public User(String email, String username, String firstName, String lastName, String birthday,
                int weight, int height, String origins, String gender, String profilePictureURL, ArrayList<Historic> historicDate,
                double alcool,String psw){

        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.weight = weight;
        this.height=height;
        this.origins = origins;
        this.gender = gender;
        this.alcoholLevel=alcool;
        if (profilePictureURL!=null)
        {
            this.profilePictureURL = profilePictureURL;
        }
        else{
            this.profilePictureURL="";
        }
        if (historicDate==null)
        {
            this.historicDate=null;
        }
        else{
            this.historicDate = historicDate;
        }
        this.password=new Password(psw);
    }

    public User(String email, String username, String firstName, String lastName, String birthday,
                int weight, int height, String origins, String gender, String profilePictureURL, ArrayList<Historic> historicDate,
                double alcool,byte[] hashed, byte[]salt ){

        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.weight = weight;
        this.height=height;
        this.origins = origins;
        this.gender = gender;
        this.alcoholLevel=alcool;
        if (profilePictureURL!=null)
        {
            this.profilePictureURL = profilePictureURL;
        }
        else{
            this.profilePictureURL="";
        }
        if (historicDate==null)
        {
            this.historicDate=null;
        }
        else{
            this.historicDate = historicDate;
        }
        this.password= new Password(hashed, salt);
    }

    public void addHistoric(){

    }

    //SETTER FOR USER CLASS\\


    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setOrigins(String origins) {
        this.origins = origins;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setHistoricDate(ArrayList<Historic> historicDate) {
        this.historicDate = historicDate;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }

    // A rajouter quand nous allons modifier la bdd
    public void setAlcoholLevel(float actualAlcoholLevel){
        this.alcoholLevel = actualAlcoholLevel;
    }

    //GETTER FOR USER CLASS\\
    public String getProfilePictureURL (){
        return profilePictureURL;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getBirthday(){
        return birthday;
    }

    public int getWeight(){
        return weight;
    }

    public int getHeight(){
        return height;
    }

    public String getOrigins(){
        return origins;
    }

    public String getGender(){ return gender; }

    public double getAlcoholLevel() { return alcoholLevel; }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    //REFAIRE LE GET
    public int ageCalculator(){
        int age=0;

        return age;
    }

    public static class timeDate {
        int h;
        int mn;
        int s;



        public timeDate(int h, int m, int s){
            this.h=h;
            this.mn=m;
            this.s=s;

        }

        public timeDate(String s){
            String[] splitted=s.split(":");
            this.h=Integer.parseInt(splitted[0]);
            this.mn=Integer.parseInt(splitted[1]);;
            this.s=Integer.parseInt(splitted[2]);;

        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getMn() {
            return mn;
        }

        public void setMn(int mn) {
            this.mn = mn;
        }

        public String toString(){
            return " "+this.h+":"+this.mn+":"+this.mn;
        }


        public String saveDBToFile(){
            return +this.h+":"+this.mn+":"+this.mn;
        }
    }

    public static class Date{
        timeDate t;
        int day;
        int month;
        int year;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public timeDate getT() {
            return t;
        }

        public void setT(timeDate t) {
            this.t = t;
        }

        public Date(timeDate T, int D, int M, int Y)
        {
            this.day=D;
            this.month=M;
            this.year=Y;
            this.t=T;
        }

        public Date(String s)
        {
            String[]splitted = s.split("[ /]");
            this.day=Integer.parseInt(splitted[0]);
            this.month=Integer.parseInt(splitted[1]);
            this.year=Integer.parseInt(splitted[2]);
            this.t= new timeDate(splitted[3]);
        }

        public String toString(){
            return this.day+"/"+this.month+"/"+this.day+" "+this.t.toString();
        }

        public String saveDBToFile(){
            return this.day+"/"+this.month+"/"+this.day+" "+this.t.toString();
        }


    }

    public static class Historic{
        Date date;
        int mesure;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public int getMesure() {
            return mesure;
        }

        public void setMesure(int mesure) {
            this.mesure = mesure;
        }

        public Historic( Date d, int m)
        {
            this.date=d;
            this.mesure=m;
        }

        public Historic( String d, int m)
        {
            this.date= new Date(d);
            this.mesure=m;
        }

        public Historic( String str)
        {
            String[]splitted = str.split("-");
            this.date= new Date(splitted[0]);
            this.mesure=Integer.parseInt(splitted[1]);
        }

        public String toString(){
            return  this.date.toString()+ "-"+this.mesure;
        }

        public String saveDBToFile(){
            return  this.date.saveDBToFile()+ "-"+this.mesure+"\n";
        }
    }

    public static class Password{
        private byte[] hashedPassword;
        private byte[] salt;

        public Password(String psw){
            char[] pswd=psw.toCharArray();
            Random random = new SecureRandom();
            byte[] salt = new byte[32];
            random.nextBytes(salt);
            int itr = ITERATIONS_NUMBER;
            int keyLength = KEY_LENGTH;
            byte[] res = hashPassword(pswd,salt,itr, keyLength  );
            this.hashedPassword=res;
            this.salt=salt;
        }

        public Password(byte[] hP, byte[] s){
            this.setHashedPassword(hP);
            this.setSalt(s);
        }

        public byte[] getHashedPassword() {
            return hashedPassword;
        }

        public void setHashedPassword(byte[] hashedPassword) {
            this.hashedPassword = hashedPassword;
        }

        public byte[] getSalt() {
            return salt;
        }

        public void setSalt(byte[] salt) {
            this.salt = salt;
        }
    }

    public String toString()
    {
        String res ;
        res = " ID : "+this.getEmail();
        res += " UserName : "+this.getUsername();
        res += " FirstName : "+this.getFirstName();
        res += " LaststName : "+this.getLastName();
        res += " Height : "+this.getHeight();
        res += " Weight : "+this.getWeight();
        res += " Origins : "+this.getOrigins();
        res += " Birthday : "+this.getBirthday();
        res += " HashedPassword : "+ new String (this.password.getHashedPassword());
        //res += " Salt : "+ Arrays.toString(this.password.getSalt());

        if(this.historicDate!=null)
        {
            Iterator itr = this.historicDate.iterator();
            while(itr.hasNext())
            {
                Historic aux = (Historic) itr.next();
                res += aux.toString();
            }
        }
        else{
            res +="No Historic Alcool";
        }

        return res;


    }

    public String saveDBToFile()
    {
        String res ;
        res = this.getEmail()+"\n";
        res += this.getUsername()+"\n";
        res += this.getFirstName()+"\n";
        res +=this.getLastName()+"\n";
        res +=this.getHeight()+"\n";
        res +=this.getWeight()+"\n";
        res +=this.getOrigins()+"\n";
        res+=this.getGender()+"\n";
        res +=this.getBirthday()+"\n";
        res +=this.getAlcoholLevel()+"\n";
        res += this.password.getHashedPassword()+"\n";
        res += this.password.getSalt()+"\n";
        if (this.historicDate!=null){
            res+=this.historicDate.size();
            for (int i=0; i<this.historicDate.size();i++)
            {
                Iterator itr = this.historicDate.iterator();
                while (itr.hasNext())
                {
                    Historic aux = (Historic) itr.next();
                    res+=aux.toString();
                }
            }
        }
        else{
            res+="0\n";
        }

        if(this.historicDate!=null)
        {
            Iterator itr = this.historicDate.iterator();
            while(itr.hasNext())
            {
                Historic aux = (Historic) itr.next();
                res += aux.saveDBToFile();
            }
        }

        return res;
    }

    public void addMeasureToUser(String s){
        String[] splittedHistoric=s.split("-");
        String date = splittedHistoric[0];
        int mes = Integer.parseInt(splittedHistoric[1]);

        Historic h =new Historic(date,mes);
        this.historicDate.add(h);
    }

    public static byte[] hashPassword( final char[] password, final byte[] salt, final int iterations, final int keyLength ) {

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA1" );
            PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
            SecretKey key = skf.generateSecret( spec );
            byte[] res = key.getEncoded( );
            return res;

        } catch( NoSuchAlgorithmException | InvalidKeySpecException e ) {
            throw new RuntimeException( e );
        }
    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class Patient{
    private String name;
    private double bodytemp;
    private double oxygenlevels;
    private int age;
    private double uniqueid;
    private boolean admission;
    private String hospital;
    private int recoverydays;
    private boolean deleted; // false meaning the account is not deleted, true means the account is deleted

    public Patient(String name, double bodytemp , double oxygenlevels , int age , boolean admission , String hospital , int recoverydays , boolean deleted){
        this.name = name;
        this.bodytemp = bodytemp;
        this.oxygenlevels = oxygenlevels;
        this.age = age;
        this.admission = admission;
        this.hospital = hospital;
        this.recoverydays = recoverydays;
        this.deleted = deleted;
    }

    public String getName(){
        return name;
    }

    public double getbodytemp(){
        return bodytemp;
    }

    public double getoxygenlevels(){
        return oxygenlevels;
    }

    public int getage(){
        return age;
    }

    public boolean getadmission(){
        return admission;
    }

    public void setadmission(Boolean admission){
        this.admission = admission;
    }

    public void sethospital(String hospital){
        this.hospital = hospital;
    }

    public String gethospital(){
        return hospital;
    }

    public int getrecoverydays(){
        return recoverydays; 
    }

    public void setrecoverydays(int number){
        this.recoverydays = number;
    }

    public boolean getdeleted(){
        return deleted;
    }

    public void setdeleted(Boolean deleted){
        this.deleted = deleted;
    }
}
class HealthCareInstitute {
    private String name;
    private String tempcriteria;
    private String oxygencriteria;
    private int availablebeds;
    private boolean admissionstatus;

    public HealthCareInstitute(){

    }
    public HealthCareInstitute(String name , String tempcriteria , String oxygencriteria ,int availablebeds , boolean admissionstatus){
        this.name = name;
        this.tempcriteria = tempcriteria;
        this.oxygencriteria = oxygencriteria;
        this.availablebeds = availablebeds;
        this.admissionstatus= admissionstatus;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name = name;
    }

    public String gettempcriteria(){
        return tempcriteria;
    }
    public void settempcriteria(String tempcriteria){
        this.tempcriteria = tempcriteria;
    }
    public String getoxygencriteria(){
        return oxygencriteria;
    }
    public void setoxygencriteria(String oxygencriteria){
        this.oxygencriteria = oxygencriteria;
    }
    public int getavailablebeds(){
        return availablebeds;
    }
    public void setavailablebeds(int availablebeds){
        this.availablebeds = availablebeds;
    }
    public boolean getadmissionstatus(){
        return admissionstatus;
    }
    public void setadmissionstatus(boolean admissionstatus){
        this.admissionstatus = admissionstatus;
    }
}
public class hospital {
        
    static Map < String , HealthCareInstitute > hospitalList = new HashMap< String, HealthCareInstitute>();

    static Map < Integer, Patient > patientList = new HashMap<Integer, Patient>(); // for query 8

    static Map < Integer, Patient > updateddetails = new HashMap<Integer, Patient>(); // for query 

    static Map < Integer, Patient > hospitaladmitted = new HashMap<Integer, Patient>(); // for query 

    static Map < Integer, Patient > removedaccounts = new HashMap<Integer, Patient>(); // for query 2

    public static void main(String[] args){
        int a , b;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of patients :");
        int data= sc.nextInt();

        for(int unique_id = 1 ; unique_id <= data ; unique_id++){

            Patient patient = new Patient( sc.next() , sc.nextDouble() , sc.nextDouble() , sc.nextInt() , false, null , 0 , false);

            patientList.put(unique_id,patient);

        }

        Map mainList = new HashMap<Integer,Patient>(patientList);

        System.out.println("Enter your query:");
        int query = sc.nextInt();
        while(patientList.size()>0){
            if(query > 9){
                System.out.println("Please Enter Valid Query");
                System.out.println("Enter Your Query :");
                query = sc.nextInt();
            }
            else{
                if(query == 1){
                    queryone();
                    System.out.println("Enter Your Query :");
                    query = sc.nextInt();
                }
                if(query == 6){
                    querysix();
                    System.out.println("Enter Your Query :");
                    query = sc.nextInt();
                }
                if(query == 8){
                    queryeight();
                    System.out.println("Enter Your Query :");
                    query = sc.nextInt();
                }
                if(query == 2){
                    querytwo();
                    System.out.println("Enter Your Query :");
                    query = sc.nextInt();
                }
                if(query == 3){
                    querythree();
                    System.out.println("Enter Your Query :");
                    query = sc.nextInt();
                }
                if(query == 4){
                    queryfour();
                    System.out.println("Enter Your Query :");
                    query = sc.nextInt();
                }
                if(query == 5){
                    queryfive();
                    System.out.println("Enter Your Query :");
                    query = sc.nextInt();
                }
                if(query == 7){
                    queryseven();
                    System.out.println("Enter Your Query :");
                    query = sc.nextInt();
                }
                if(query == 9){
                    querynine();
                    System.out.println("Enter Your Query :");
                    query = sc.nextInt();
                }
            }
        }
    }
    static void queryone(){
        for(int i = 0 ; i < 1 ; i++){
            HealthCareInstitute l = new HealthCareInstitute();
            Scanner sc1 = new Scanner(System.in);
            System.out.println(" Enter name of the hospital :");
            String xy = sc1.next();
            l.setname(xy);
            System.out.println(" Enter Temperature Criteria for the hospital :");
            int a = sc1.nextInt();
        
            System.out.println(" Enter Oxygen levels Criteria for the hospital :");
            int b = sc1.nextInt();
            if(b<90 || b>100){
                System.out.println("Enter Valid Oxygen Levels Again, Oxygen Levels must be between 90 and 100 :");
                b = sc1.nextInt();
            }

            Iterator<Entry<Integer, Patient>> it = patientList.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<Integer, Patient> set = (Map.Entry<Integer, Patient>) it.next();

                    Patient n = (Patient) set.getValue();
                    if((n.getbodytemp() < a || n.getbodytemp() == a) && ( n.getoxygenlevels() >b || n.getoxygenlevels() == b)){
                        Integer key = (Integer)set.getKey(); 
                        n.sethospital(l.getname());
                        n.setadmission(true);
                        n.setrecoverydays(0);
                        Patient patient = new Patient( n.getName() , n.getbodytemp() , n.getoxygenlevels() , n.getage() , n.getadmission(), n.gethospital() , n.getrecoverydays() , false);
                        System.out.println(key + " " + n.getName() + " " + n.getbodytemp() + " " + n.getoxygenlevels() + " " + n.getage() + " " + n.getadmission() + " " + n.gethospital() );
                        hospitaladmitted.put(key,patient);
                    }
            }
            Integer.toString(b);
            System.out.println("Oxygen Criteria - " + b); 
            l.setoxygencriteria("Oxygen levels should be >=" + " "+ b );

            Integer.toString(a);
            System.out.println("Temperature Criteria - " + a);         
            l.settempcriteria("Temperature should be <=" + " " + a)  ;

            System.out.println("Number of availablebeds"); 
            int ab = sc1.nextInt();
            l.setavailablebeds(ab);

            System.out.println(" Admission status of the hospital ( OPEN / CLOSED) "); 
            if( l.getavailablebeds() > 0){
                l.setadmissionstatus(true);
                System.out.println("OPEN");
            }
            else{
                l.setadmissionstatus(false);
                System.out.println("CLOSED");
            }

            Iterator<Entry<Integer, Patient>> itt = patientList.entrySet().iterator();
            int count = 0;
            while (itt.hasNext()){
                Map.Entry<Integer, Patient> set = (Map.Entry<Integer, Patient>) itt.next();
                if(count == ab){
                    break;
                }
                else{
                    Patient n = (Patient) set.getValue();
                    Integer key = (Integer)set.getKey(); 
                    System.out.println("Recovery days for admitted patient " + Integer.toString(key) + " " + "-");
                    int rd = sc1.nextInt();
                    n.setrecoverydays(rd);
                    n.setdeleted(true);
                    Patient patient = new Patient( n.getName() , n.getbodytemp() , n.getoxygenlevels() , n.getage() , n.getadmission(), n.gethospital() , n.getrecoverydays() , n.getdeleted());
                    System.out.println( Integer.toString(key) + " " + n.getName() + " " + n.getbodytemp() + " " + n.getoxygenlevels() + " " + n.getage() + " " + n.getadmission() + " " + n.gethospital() + " " + n.getrecoverydays());
                    updateddetails.put(key,patient);
                    patientList.remove(key,patient);
                    count++;
                }
            }   

            if(count == l.getavailablebeds()){
                l.setavailablebeds(0); 
                HealthCareInstitute hospital = new HealthCareInstitute( l.getname() , l.gettempcriteria() , l.getoxygencriteria(),  l.getavailablebeds(), false);
                hospitalList.put(l.getname(),hospital);       
            }
            else if( count<l.getavailablebeds()){
                int data = l.getavailablebeds() - count;
                l.setavailablebeds(data);
                HealthCareInstitute hospital = new HealthCareInstitute( l.getname() , l.gettempcriteria() , l.getoxygencriteria(),  l.getavailablebeds(),  true);
                hospitalList.put(l.getname(),hospital);       
            }

            //Display the Name of the hospital
            String a1 = l.getname();
            System.out.println(a1);               //////////////

            //Display the temperature criteria of the hospital
            String a2 = l.gettempcriteria();
            System.out.println(a2);       //////////////

            //Display the oxygen criteria of the hospital
            String a3 = l.getoxygencriteria();
            System.out.println(a3);

            //Display the number of available beds
            int a4 = l.getavailablebeds();
            System.out.println("Number of Available Beds : " + a4);      //////////////

            //Display the number of admission status of the particular patient
            boolean a5 = l.getadmissionstatus();
            if( a5 == true){
                System.out.println("OPEN");    //////////////
            }
            else{
                System.out.println("CLOSED");    //////////////
            }
        }
    }

    static void querytwo(){
    //     System.out.println("Account ID removed of admitted patients");
    //     for(Entry<Integer,Patient> set : updateddetails.entrySet()){
    //             Integer key = (Integer)set.getKey(); 
    //     }    
        Iterator<Entry<Integer, Patient>> it = updateddetails.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Patient> set = (Map.Entry<Integer, Patient>) it.next();
            Integer key = (Integer)set.getKey();
            System.out.println("Patient ID :" + key);
            patientList.remove(key);
        }
    }
    static void queryfour(){
        int count = 0;
        for(Entry<Integer,Patient> set : patientList.entrySet()){
                Patient a = (Patient) set.getValue();
                if(a.getdeleted() == false){
                    count++;
                }
                else{
                    continue;
                }
            }
            System.out.println(count);
        }

    static void queryfive(){
        int count = 0;
        for(Entry<String,HealthCareInstitute> set : hospitalList.entrySet()) {
            HealthCareInstitute a = (HealthCareInstitute) set.getValue();
            if(a.getadmissionstatus() == true){
                count++;
            }
        }
        System.out.println(count);
    }

    static void querysix(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Hospital :");
        String hospitalname = sc.next();
        for(Entry<String,HealthCareInstitute> set : hospitalList.entrySet() ){
            HealthCareInstitute a = (HealthCareInstitute) set.getValue();
            if(a.getname().equals(hospitalname)){
                System.out.println(a.gettempcriteria());
                System.out.println(a.getoxygencriteria());
                System.out.println("Number of availablebeds :" + a.getavailablebeds());
                if(a.getadmissionstatus() == true){
                    System.out.println("Admission Status - OPEN");
                }
                else{
                    System.out.println("Admission Status - CLOSED");
                }
            }
            else{
                continue;
            }
        }
    }

    static void queryeight(){
        for(Entry<Integer,Patient> set : patientList.entrySet() ){
            Patient a = (Patient) set.getValue();
            if(a.getdeleted() == false){
                System.out.println( set.getKey() + " " + a.getName());
            }
            else{
                System.out.println("Paitent removed");
                continue;
            }
        }
    }

    static void queryseven(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the Patient :");
        int id = sc.nextInt();
        for(Entry<Integer,Patient> set : updateddetails.entrySet() ){
            Patient a = (Patient) set.getValue();
            if(set.getKey() == id){
                System.out.println(a.getName());
                System.out.println("Temperature is " + a.getbodytemp());
                System.out.println("Oxygen levels are " + a.getoxygenlevels());
                if(a.getadmission() == true){
                    System.out.println("Admission Status – Admitted");
                }
                System.out.println("Admitting Institute - " + a.gethospital());
            }
        }
    }
    
    static void querynine(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the hospital :");
        String hospitalname = sc.next();
        for(Entry<String,HealthCareInstitute> set : hospitalList.entrySet()){
            String key = set.getKey();
            if(key.equals(hospitalname)){
                for(Entry<Integer,Patient> entry : updateddetails.entrySet()){
                    Patient a = (Patient) entry.getValue();
                    if(a.gethospital().equals(hospitalname)){
                        System.out.println(a.getName() + " recovery time is " + a.getrecoverydays());
                    }
                    else{
                        continue;
                    }
                }
                break;
            }
            else{
                continue;
            }
        }
    }  
    static void querythree(){
        for(Entry<String,HealthCareInstitute> set : hospitalList.entrySet() ){
            HealthCareInstitute a = (HealthCareInstitute) set.getValue();
            if( a.getavailablebeds() == 0){
                String sc = a.getname();
                System.out.println(sc);
            }

        }
    }
}
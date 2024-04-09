package com.sci;

import com.sci.dao.*;
import com.sci.models.*;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class HrApp {
    //    Objects from tables classes
    public static DBCOUNTRIES dbcountries = new DBCOUNTRIES();
    public static DBEmployee dbemployees = new DBEmployee();
    public static DBJOBS dbjobs = new DBJOBS();
    public static DBRegions dbregions = new DBRegions();

    public static DBJOB_HISTORY dbJH = new DBJOB_HISTORY();

    public static DBDepartments dbdep = new DBDepartments();

    public static DBLocations dblocations = new DBLocations();


    //Country table
    public static void getAllCountries() {
        List<COUNTRIES> co = dbcountries.get();
        for (COUNTRIES i : co) System.out.println(i);
    }

    public static void getCountry(String id) {
        COUNTRIES x = dbcountries.get(id);
        System.out.println(x);
    }

    public static void insert_country(COUNTRIES country) {
        String co = dbcountries.insert(country);
        System.out.println(co);
    }

    public static void update_country(COUNTRIES country) {
        dbcountries.update(country);
    }

    public static void delete_country(String country_id){
        dbcountries.delete(country_id);
    }
/*------------------------------------------------------------------------------*/

    // Jobs table
    public static void getAllJobs() {
        List<Jobs> J = dbjobs.get();
        for (Jobs i : J) System.out.println(i);
    }

    public static void getJob(String id) {
        Jobs job = dbjobs.get(id);
        System.out.println(job);
    }

    public static void insert_job(Jobs job) {
        String in_job = dbjobs.insert(job);
        System.out.println(in_job);
    }

    public static void update_job(Jobs job) {
        dbjobs.update(job);
    }

    public static void delete_job(String job_id){
        dbjobs.delete(job_id);
    }

    /*------------------------------------------------------------------------------*/

    // Regions table
    public static void getAllRegions() {
        List<Regions> J = dbregions.get();
        for (Regions i : J) System.out.println(i);
    }

    public static void getRegion(Integer id) {
        Regions region = dbregions.get(id);
        System.out.println(region);
    }

    public static void insert_region(Regions region) {
        Integer in_region = dbregions.insert(region);
        System.out.println(in_region);
    }

    public static void update_region(Regions reg) {
        dbregions.update(reg);
    }

    public static void delete_region(Integer id){
        dbregions.delete(id);
    }

    /*------------------------------------------------------------------------------*/

    // Job_History table
    public static void getAllJH() {
        List<Job_History> J = dbJH.get();
        for (Job_History i : J) System.out.println(i);
    }

    public static void getJH(Integer id,String date) {
        List<Job_History> JobHis = dbJH.get(id,date);
        System.out.println(JobHis);
    }

    public static void insert_JH(Job_History job) {
         dbJH.insert(job);
        System.out.println(job.getEMPLOYEE_ID());
    }

    public static void update_JH(Job_History job) {
        dbJH.update(job);
    }

    public static void delete_JH(Integer id,String date){
        dbJH.delete(id,date);
    }

//    Locations table
    public static void getAllLoc() {
        List<Locations> co = dblocations.get();
        for (Locations i : co) System.out.println(i);
    }

    public static void getLoc(Integer id) {
        Locations x = dblocations.get(id);
        System.out.println(x);
    }

    public static void insert_Loc(Locations Loc) {
        Integer Locy = dblocations.insert(Loc);
        System.out.println(Locy);
    }

    public static void update_Loc(Locations Loc) {
        dblocations.update(Loc);
    }


    public static void delete_Loc(Integer Loc_id){
        dblocations.delete(Loc_id);
    }
    //    Departments table
    public static void getAllDep() {
        List<Departments> co = dbdep.get();
        for (Departments i : co) System.out.println(i);
    }

    public static void getDep(Integer id) {
        Departments x = dbdep.get(id);
        System.out.println(x);
    }

    public static void insert_dep(Departments dep) {
        Integer depp = dbdep.insert(dep);
        System.out.println(depp);
    }

    public static void update_dep(Departments dep) {
        dbdep.update(dep);
    }

    public static void delete_dep(Integer dep_id){
        dbdep.delete(dep_id);
    }

    public static void main(String[] args) {
        getAllCountries();
        System.out.println("---------------------------------------");
        getCountry("BE");
        System.out.println("---------------------------------------");
        COUNTRIES country = new COUNTRIES("ZA", "ZALABYA", 2);
        insert_country(country);
        System.out.println("---------------------------------------");
        country.setCOUNTRY_NAME("ZALABYA_2");
        update_country(country);
        getAllCountries();
        System.out.println("---------------------------------------");
        delete_country("ZA");
        getCountry("ZA");
        System.out.println("---------------------------------------");
        getAllJobs();
        System.out.println("---------------------------------------");
        getJob("AD_PRES");
        System.out.println("---------------------------------------");
        Jobs new_job = new Jobs("DE_MAN","Data Engineer Manager",50000,150000);
        insert_job(new_job);
        System.out.println("---------------------------------------");
        new_job.setMIN_SALARY(75000);
        update_job(new_job);
        System.out.println("---------------------------------------");
        delete_job("DE_MAN");
        getJob("DE_MAN");
        System.out.println("---------------------------------------");

        getAllRegions();
        System.out.println("---------------------------------------");
        getRegion(2);
        System.out.println("---------------------------------------");
        Regions new_region = new Regions(5,"Egypt");
        insert_region(new_region);
        System.out.println("---------------------------------------");
        new_region.setRegion_Name("Kwait");
        update_region(new_region);
        System.out.println("---------------------------------------");
        delete_region(5);
        getRegion(5);
        System.out.println("---------------------------------------");

        getAllJH();
        System.out.println("---------------------------------------");
        getJH(101,"1997-09-21");
        System.out.println("---------------------------------------");
        Job_History JH = new Job_History(150,"1990-05-05","1990-10-09","lala",150);
        insert_JH(JH);
        System.out.println("---------------------------------------");
        JH.setEND_DATE("1990-10-05");
        update_JH(JH);
        getAllCountries();
        System.out.println("---------------------------------------");
        delete_JH(150,"1990-05-05");
        getJH(150,"1990-05-05");

        System.out.println("---------------------------------------");

        getAllDep();
        System.out.println("---------------------------------------");
        getDep(60);
        System.out.println("---------------------------------------");
        Departments d = new Departments();
        insert_dep(d);
        System.out.println("---------------------------------------");
        d.setMANAGER_ID(500);
        update_dep(d);
        System.out.println("---------------------------------------");
        delete_dep(d.getDEPARTMENT_ID());
        System.out.println("---------------------------------------");

        System.out.println("---------------------------------------");

        getAllLoc();
        System.out.println("---------------------------------------");
        getLoc(1000);
        System.out.println("---------------------------------------");
        Locations l = new Locations();
        insert_Loc(l);
        System.out.println("---------------------------------------");
        l.setCITY("cairo");
        update_Loc(l);
        System.out.println("---------------------------------------");
//        delete_Loc(l.getLocation_id());
        System.out.println("---------------------------------------");

        DBConfig.shutdown();
    }
}

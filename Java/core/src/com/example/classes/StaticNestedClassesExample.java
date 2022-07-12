package com.example.classes;

public class StaticNestedClassesExample {
    public static void main(String[] args) {
        System.out.println("\n\n***********Static Inner Class*************");
        //University Object is not been created.
        //Benefit of using static nested class is that it doesn't have a reference of parent class.
        //means better garbage collection
        BackgroundClass.NetworkHit apiHitHome = new BackgroundClass.NetworkHit("HomeAPI");
        apiHitHome.setAPIAttempt(8);

        BackgroundClass.NetworkHit apiHitDashboard = new BackgroundClass.NetworkHit("DashboardAPI");
        apiHitDashboard.setAPIAttempt(4);

        System.out.println("\nGetting API Name: "+apiHitHome.getAPIName());
        System.out.println("Getting # of Attempts: "+apiHitHome.getNumberOfAttempts());

        System.out.println("\nGetting API Name: "+apiHitDashboard.getAPIName());
        System.out.println("Getting # of Attempts: "+apiHitDashboard.getNumberOfAttempts());


        System.out.println("------------------------------------------------------");
    }
}

class BackgroundClass {

    BackgroundClass(){
        System.out.println("BackgroundClass Created!!");
    }

    public static class NetworkHit{
        String name;
        int numberOfAttempts;
        NetworkHit(){
            System.out.println("NetworkHit Created!!");
        }
        public NetworkHit(String ApiName){
            name = ApiName;
            System.out.println("NetworkHit Created: "+name);
        }

        public void setAPIAttempt(int attempts){
            numberOfAttempts = attempts;
            System.out.println("Setting # of Attempts: "+numberOfAttempts);
        }

        public String getAPIName(){
            return name;
        }

        public int getNumberOfAttempts(){
            return numberOfAttempts;
        }
    }
}

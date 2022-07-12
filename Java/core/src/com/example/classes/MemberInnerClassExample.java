package com.example.classes;

public class MemberInnerClassExample {
    public static void main(String[] args) {
        Print printDocument = new Print("Document");
        //parent ka function call kar k oski inner class ko access kia
        System.out.println("\n\n***********Inner Class or Member Inner Class*************");
        System.out.println("\n------Accessing Directly from MemberInnerClass.Print Class----------");
        printDocument.setSlidesToPrint(12);
        printDocument.printTheFile();
        System.out.println("------------------------------------------------------");



        //Same Example, but from different approach.
        System.out.println("\n-------Accessing from outside World---------");
        Print printPicture = new Print("Picture", "awein");
        //reference parent.inner class ka rakha - lekin parent k object sy inner class ko initiate kia
        Print.PrinterSettings printSettingsPicture = printPicture.new PrinterSettings();
        printSettingsPicture.setSlidesToPrint(6);
        printSettingsPicture.printTheFile();
        System.out.println("------------------------------------------------------");
    }
}

//Outer class
class Print {
    PrintPreview printPreview;
    private String printType;
    private int totalPagesToPrint;

    public Print(String printType){
        this.printType  = printType;
        //Composition
        printPreview = new PrintPreview();
    }

    public Print(String printType, String method){
        this.printType  = printType;
    }

    public void setSlidesToPrint(int pagesToPrint){
        if(printPreview!=null){
            printPreview.setSlidesToPrint(pagesToPrint);
        }
    }

    public void printTheFile(){
        if(printPreview!=null){
            printPreview.printTheFile();
        }
    }

    //It can access private members and private methods of MemberInnerClass.Print class.
    //Not accessible out of this class.
    //Inner Class
    private class PrintPreview{

        void setSlidesToPrint(int pagesToPrint){
            totalPagesToPrint = pagesToPrint;
            System.out.println("Pages to MemberInnerClass.Print: "+totalPagesToPrint);
        }

        void printTheFile(){
            System.out.println("Printing your "+printType);
        }
    }

    //It can access private members and private methods of MemberInnerClass.Print class
    //This class is accessible from anywhere from the package/ folder's class due to its access modifier.
    //Inner Class
    public class PrinterSettings{
        public void setSlidesToPrint(int pagesToPrint){
            totalPagesToPrint = pagesToPrint;
            System.out.println("Pages to MemberInnerClass.Print: "+totalPagesToPrint);
        }

        public void printTheFile(){
            System.out.println("Printing your "+printType);
        }
    }
}
package jpaproject;

import static jpaproject.Utilities.*;

public class Main {

    static EntityManagement em = new EntityManagement();

    public static void main(String[] args) {

        Start start = new Start();
        int option = start.Choice();
        switch (option) {
            case 1:
                Customers cs = new Customers(nextInt("Please enter Customer Number"), nextLine("Please enter customer name"), nextLine("Please enter contact last name"), nextLine("Please enter contact first name"), nextLine("Please Enter phone number"), nextLine("Please Enter first address"), nextLine("Please Enter city"), nextLine("Please Enter country"));
                EntityManagement en = new EntityManagement();
                en.addCustomer(cs);

                em.showAll();
                System.out.println(" ");
                System.out.println("New customer added ");
                break;
            case 2:
                em.findByName(nextLine("Please enter customer name"));
                break;
            case 3:
                em.findByCountry(nextLine("Please enter country name"));
                break;
            case 4:
                em.findMaxCreditLimit();
                break;
            case 5:
                em.findMinCreditLimit();
                break;
            case 6:
                Double avg=em.findAvgCreditLimit();
                System.out.println("Average of credit limit = " +avg);
                break;
            case 7:
                em.NumberOfMembers();
                break;
            case 8:
                em.deleteMember(nextInt("Please enter Customer Number"));
                System.out.println(" Deleted successfully");
                break;
            case 9:
                em.showAll();
                break;
            case 10:
                em.showAll();
                em.uppdate(nextInt("Please enter Customer Number"), nextLine("Please enter new phone number"));
                System.out.println("Done!");
                break;
            
            default :
                System.out.println("please choose a valid number");
             break;
             
                  
        }

    }

}

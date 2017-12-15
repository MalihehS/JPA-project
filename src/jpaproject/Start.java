
package jpaproject;




public class Start{
    public Start(){
        
        System.out.println("1: Add customer to the database");
        System.out.println("2: Find by name");
        System.out.println("3: Find by country");
        System.out.println("4: Max creadit limit");
        System.out.println("5: Min creadit limit");
        System.out.println("6: Average of credits");
        System.out.println("7: Number of members");
        System.out.println("8: Delete a member");
        System.out.println("9: Show list of members");
        System.out.println("10: Uppdate PhoneNumber");
    }
    public int Choice(){
        Utilities u=new Utilities();
        System.out.println(" ");
        int choice= u.nextInt("Please choose an option");
        return choice;
    
    }
      
    
}

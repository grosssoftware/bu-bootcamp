import java.util.Scanner; 

public class Greeting { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("What is your name? "); 
        String name = scanner.nextLine(); 
        System.out.print("What is your role? "); 
        String role = scanner.nextLine(); 
        System.out.println("Hello, " + name + "! As a " + role + ", you are in the right place!."); 
        scanner.close(); 
    } 
}

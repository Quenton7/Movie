/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author quent
 */
public class Movies {

    /**
     * @param args the command line arguments
     */
    public void insert()
    {
        Scanner sc = new Scanner(System.in);
        
        String mov_name,actor,actress,director,mov_year;
        System.out.println("Enter the movie name: ");
        mov_name = sc.next();
        System.out.println("Enter the actor name: ");
        actor = sc.next();
        System.out.println("Enter the actress name: ");
        actress = sc.next();
        System.out.println("Enter the director name: ");
        director = sc.next();
        System.out.println("Enter the movie release year: ");
        mov_year = sc.next();
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","Quenton77Rebello");
            Statement st = con.createStatement();
            if(mov_name.isEmpty() == false && actor.isEmpty() == false && actress.isEmpty() == false && director.isEmpty() == false && mov_year.isEmpty() == false)
            {
                st.executeUpdate("insert into movie1 values ('"+mov_name+"','"+actor+"','"+actress+"','"+director+"','"+mov_year+"')");
                System.out.println("Details succesfully inserted");
            }
            else
            {
             System.out.println("Null Details entered");       
            }
            

            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
        }
    }                             
    public void select()
    {
        System.out.println("The Details are..");
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","Quenton77Rebello");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from movie1");
            while(rs.next())
            {
                String mov_name = rs.getString("mov_name");
                String actor = rs.getString("actor");
                String actress = rs.getString("actress");
                String director = rs.getString("director");
                String mov_year = rs.getString("mov_year");
                
                System.out.println("Movie Name: "+ mov_name);
                System.out.println("Actor Name: "+ actor);
                System.out.println("Actress Name: "+ actress);
                System.out.println("Director Name: "+ director);
                System.out.println("Movie Year: "+ mov_year);
                System.out.println("---------------------------------------");
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
    }
    public void mselect()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the movie name: ");
        String mov_name = sc.next();
        System.out.println("The Details are..");
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","Quenton77Rebello");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from movie1 where mov_name = '"+mov_name+"'");
            while(rs.next())
            {
                String actor = rs.getString("actor");
                String actress = rs.getString("actress");
                String director = rs.getString("director");
                String mov_year = rs.getString("mov_year");
                
                System.out.println("Movie Name: "+ mov_name);
                System.out.println("Actor Name: "+ actor);
                System.out.println("Actress Name: "+ actress);
                System.out.println("Director Name: "+ director);
                System.out.println("Movie Year: "+ mov_year);
                System.out.println("---------------------------------------");
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int choice;
        Scanner sc = new Scanner(System.in);
        Movies m = new Movies();
        
        System.out.println("----Menu----");
        System.out.println("1. Insert into Table");
        System.out.println("2. Retrieve Values");
        System.out.println("3. Retrieve Values based on Movie Title");
        System.out.println("4. Exit");
        System.out.println("----XXXX----");
        
        do{
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1: m.insert();
                        break;
                case 2: m.select();
                        break;
                case 3: m.mselect();
                        break;
                case 4: System.out.println("Exited....");
                		System.exit(0);
                        break;
                default: System.out.println("Invalid Option!!");
            }
        }while(choice != 4);
    }
    
}

package com.example.individual_project;

import java.sql.*;

public class SQL_Controller {

    //----------------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------
    //-- ATTENSION:
    //-- THE CODE FOR Write_Data() and Get_Data() already was made in my IN2018 group project
    //----------------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------

    public void Write_Data(String Query) throws SQLException { // This code sends off SQL Statements that alter table
        Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/adbt068", "adbt068", "200007269");
        Statement s = con.createStatement();
        s.executeUpdate(Query);
    }

    public ResultSet Get_Data(String Query) throws SQLException { // This code sends off SQL Statements and returns the results.
        Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/adbt068", "adbt068", "200007269");
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(Query);
        return rs;
    }

    public boolean Check_SQL_Injection(String Data){
        if (Data.toUpperCase().contains("SELECT ")){
            return false;
        }
        else if (Data.toUpperCase().contains("UPDATE ")) {
            return false;
        }
        else if (Data.toUpperCase().contains("DROP ")) {
            return false;
        }
        else if (Data.toUpperCase().contains("INSERT ")) {
            return false;
        }
        else if (Data.toUpperCase().contains("DELETE ")) {
            return false;
        }
        else if (Data.toUpperCase().contains("CASE ")) {
            return false;
        }
        else if (Data.toUpperCase().contains("CREATE ")) {
            return false;
        }
        else if (Data.toUpperCase().contains("BACKUP ")) {
            return false;
        }
        else if (Data.toUpperCase().contains("ALTER ")) {
            return false;
        }
        else if (Data.toUpperCase().contains(" 1=1 ")) {
            return false;
        }
        else if (Data.toUpperCase().contains(" OR ")) {
            return false;
        }
        else if (Data.toUpperCase().contains(" @")) {
            return false;
        }
        else if (Data.toUpperCase().contains("\"")) {
            return false;
        }
        else{
            return true;
        }
    }
}


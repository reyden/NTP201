/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author New User
 */
public class Accessors {
    
public String DirectoryName(int employee_id){
    String employee_firstname="";
    String employee_num="";
    PreparedStatement ps = null;
    ResultSet rs=null;
    Connection con=null;
    String pstmt = "SELECT DISTINCT e.firstname, e.employee_no FROM TB_employee e WHERE e.employee_id = ?";
    try{
        con=DBConnect();
        ps = con.prepareStatement(pstmt);
        ps.setInt(1, employee_id);
        rs = ps.executeQuery();
        while(rs.next()){
            employee_firstname = rs.getString(1);
            employee_num = rs.getString(2);
        }
        JOptionPane.showMessageDialog(null, employee_firstname);
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Error creating directory name  "+e);
    }finally{
        try{
        ps.close();
        rs.close();
        con.close();  
        }catch(Exception e){
            
        }
    }
    return employee_firstname + employee_num;
}


public Connection DBConnect(){
        Connection con=null;
            try{
		Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:C:\\JavaProj\\NTP201\\src\\ntp201\\db\\ntp201.db");		
                }
                catch(ClassNotFoundException | SQLException e)
                {
                       
			JOptionPane.showMessageDialog(null, "Error in getConnection: "+e);
		}
                
		return con;
}
}

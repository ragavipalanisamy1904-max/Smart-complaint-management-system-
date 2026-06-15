import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ComplaintManager {

public static void main(String[] args) {  

    String fullname = "Ragavi Palanisamy";  
    String email = "ragavi@example.com";  
    String complaintType = "Electricity Issue";  
    String description = "Street lights are not working";  

    try {  

        Class.forName("com.mysql.cj.jdbc.Driver");  

        Connection con = DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/complaint_db",  
                "root",  
                "password");  

        String query = "INSERT INTO complaints(fullname,email,complaint_type,description,status) VALUES(?,?,?,?,?)";  

        PreparedStatement ps = con.prepareStatement(query);  

        ps.setString(1, fullname);  
        ps.setString(2, email);  
        ps.setString(3, complaintType);  
        ps.setString(4, description);  
        ps.setString(5, "Pending");  

        int result = ps.executeUpdate();  

        if(result > 0) {  
            System.out.println("Complaint Submitted Successfully!");  
        }  

        con.close();  

    } catch(Exception e) {  
        e.printStackTrace();  
    }  
}

}


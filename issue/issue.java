package library_management.issue;
import java.sql.*;
import library_management.connection.connection;
import java.io.*;
public class issue extends connection {
    String book_id;
    public void issuebook() {
        String query = "update book set book_available =(book_available-1) where book_id=? ";
        String query2 = "insert into issued (book_id, book_name) select book_id,book_name from book where book_id=? ";

        try {
            Connection connection = connect();
            PreparedStatement ptm = connection.prepareStatement(query);
            PreparedStatement ptm2 = connection.prepareStatement(query2);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter the book id :");
            book_id = br.readLine();
            ptm.setString(1, book_id);
            ptm2.setString(1, book_id);

            ptm.executeUpdate();
            ptm2.executeUpdate();
            System.out.println("BOOK ISSUED SUCCESSFULLY!\n Have a Nice Day Ahead ");

            connection.close();
            ptm.close();
            ptm2.close();
        } catch (Exception e) {
            System.out.println(e); 
        }
    }
}

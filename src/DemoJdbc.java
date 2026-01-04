import java.sql.*;

public class DemoJdbc {
    public static void main (String[] args) throws Exception {

        /*
            import package
            load and register
            create connection
            create statement
            execute statement
            process the results
            close
        */

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "0000";
        String sql = "select * from student";

//        Class.forName("org.postgresql.Driver"); // optional
        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection Established");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
//        System.out.println(rs.next());

//        rs.next();
//        String name = rs.getString("sname");
//        System.out.println("Name of a student is " + name);

        while (rs.next()){
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3));
        }

        con.close();
        System.out.println("Connection Closed");




    }
}

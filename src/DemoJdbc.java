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

        int sid = 102;
        String sname = "Max";
        int marks = 52;

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "0000";
//        String sql = "insert into student values (" + sid + ", '" + sname + "', " + marks +")";
        String sql = "insert into student values (?,?,?)";

//        Class.forName("org.postgresql.Driver"); // optional
        Connection con = DriverManager.getConnection(url, uname, pass);
//        System.out.println("Connection Established");
//        Statement st = con.createStatement();

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, marks);

        /*ResultSet rs = st.executeQuery(sql);
//        System.out.println(rs.next());

//        rs.next();
//        String name = rs.getString("sname");
//        System.out.println("Name of a student is " + name);

        while (rs.next()){
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3));
        }*/

        /*boolean status = st.execute(sql);
        System.out.println(status);*/

//        st.execute(sql);
        st.execute();

        con.close();
//        System.out.println("Connection Closed");




    }
}

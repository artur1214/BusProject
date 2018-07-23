package Servlets;
import java.sql.*;
import java.util.ArrayList;

public class EasyDB {
    private Connection conn;
    private Statement[] statements;
    public EasyDB(String dbName, String pass, String user) throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/" + dbName;
            String login = user;
            String password = pass;
            Connection con = DriverManager.getConnection(url, login, password);
            if(con != null){
                this.conn = con;
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        public ArrayList MakeQuerry(String sql) throws SQLException {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return getRsDAta(rs);
        }

    private ArrayList getRsDAta(ResultSet rs) throws SQLException {
        int cols =  rs.getMetaData().getColumnCount();
        int rows = rs.getRow();
        ArrayList result = new ArrayList();

        while (rs.next()){
            ArrayList row = new ArrayList();
            for (int i=1; i <= cols; i++){
                row.add(rs.getObject(i).toString());
            }
            result.add(row);
        }
        return result;
    }

    }



package addr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.support.JdbcUtils;

public class DaoImpl implements Dao {
   private DataSource dataSource;
   private Connection con;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
   }
   
   @Override
   public Member select(int num) {
      Statement stmt = null;
      ResultSet rs = null;
      
      Member m = null;
      String sql = "SELECT num, name, tel, address FROM addr WHERE num = " + num;
      
      try {
         con = dataSource.getConnection();
         stmt = con.createStatement();
         rs = stmt.executeQuery(sql);
         
         if(rs.next()) {
            m = new Member();
            m.setNum(rs.getInt("num"));
            m.setName(rs.getString("name"));
            m.setTel(rs.getString("tel"));
            m.setAddress(rs.getString("address"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JdbcUtils.closeConnection(con);
      }
      
      return m;
   }

   @Override
   public List<Member> selectAll() {
      Statement stmt = null;
      ResultSet rs = null;
      List<Member> list = null;
      String sql = "SELECT num, name, tel, address FROM addr";
      
      try {
         con = dataSource.getConnection();
         stmt = con.createStatement();
         rs = stmt.executeQuery(sql);
         list = new ArrayList<Member>();
         
         while(rs.next()) {
            Member m = new Member();
            m = new Member();
            m.setNum(rs.getInt("num"));
            m.setName(rs.getString("name"));
            m.setTel(rs.getString("tel"));
            m.setAddress(rs.getString("address"));
            list.add(m);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {

         JdbcUtils.closeConnection(con);
      }
      
      return list;
   }

   @Override
   public void insert(Member m) {
      PreparedStatement pStmt = null;
      String sql = "INSERT INTO addr(num, name, tel, address) VALUES(SEQ_ADDR.NEXTVAL, ?, ?, ?)";
      
      try {
         con = dataSource.getConnection();
         pStmt = con.prepareStatement(sql);
         pStmt.setString(1, m.getName());
         pStmt.setString(2, m.getTel());
         pStmt.setString(3, m.getAddress());
         pStmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JdbcUtils.closeConnection(con);
      }
   }

   @Override
   public void update(Member m) {
      PreparedStatement pStmt = null;
      String sql = "UPDATE addr SET num = ?, name = ?, tel = ?, address = ? WHERE num = ?";
      
      try {
         con = dataSource.getConnection();
         pStmt = con.prepareStatement(sql);
         pStmt.setInt(1, m.getNum());
         pStmt.setString(2, m.getName());
         pStmt.setString(3, m.getTel());
         pStmt.setString(4, m.getAddress());
         pStmt.setInt(5, m.getNum());
         pStmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if(pStmt != null) {
            try {
               pStmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         
         JdbcUtils.closeConnection(con);
      }
   }

   @Override
   public void delete(int num) {
      Statement stmt = null;
      String sql = "DELETE FROM addr WHERE num = " + num;
      
      try {
         con = dataSource.getConnection();
         stmt = con.createStatement();
         stmt.executeUpdate(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if(stmt != null) {
            try {
               stmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         
         JdbcUtils.closeConnection(con);
      }
   }

}
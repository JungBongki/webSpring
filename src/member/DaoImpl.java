package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.support.JdbcUtils;

import addr.Member;

public class DaoImpl implements Dao {
	private DataSource dataSource;
	private Connection conn;
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Join j) {
		String sql = "insert into join values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, j.getId());
			pstmt.setString(2, j.getPwd());
			pstmt.setString(3, j.getName());
			pstmt.setString(4, j.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
	}

	@Override
	public Join select(String id) {
		Join j = null;
		ResultSet rs = null;
		String sql = "select * from join where id = ?";
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, num);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				j = new Join(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return j;
	}

	@Override
	public void update(Join j) {
		String sql = "update join set pwd=?, name=?, email=?";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, j.getPwd());
			pstmt.setString(2, j.getName());
			pstmt.setString(3, j.getEmail());	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
	}

	@Override
	public void delete(String id) {
		String sql = "delete join where id = ?";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
	}
}

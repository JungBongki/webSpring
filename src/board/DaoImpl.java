package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.support.JdbcUtils;

public class DaoImpl implements Dao {
	private DataSource dataSource;
	private Connection conn;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Article a) {
		String sql = "insert into board values(seq_board.nextval, sysdate, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getWriter());
			pstmt.setString(2, a.getTitle());
			pstmt.setString(3, a.getContent());
			pstmt.setInt(4, a.getParent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
	}

	@Override
	public Article select(int num) {
		Article a = null;
		ResultSet rs = null;
		String sql = "select * from board where num = ?";
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				a = new Article(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return a;
	}

	@Override
	public List selectAll() {
		ArrayList<Article> list = new ArrayList<Article>();
		ResultSet rs = null;
		String sql = "select * from board where parent=0 order by num";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				list.add(new Article(rs.getInt(1), rs.getDate(2), 
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public List selectByParentNum(int parentNum) {
		ArrayList<Article> list = new ArrayList<Article>();
		ResultSet rs = null;
		String sql = "select * from board where parent = ? order by num";
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, parentNum);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				list.add(new Article(rs.getInt(1), rs.getDate(2), 
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public void update(Article a) {
		String sql = "update board set title = ?, content = ?, w_date = sysdate where num = ?";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getTitle());
			pstmt.setString(2, a.getContent());
			pstmt.setInt(3, a.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}

	}

	@Override
	public void delete(int num) {
		String sql = "DELETE FROM board where num = ?";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
	}

	@Override
	public List selectByWriter(String writer) {
		ArrayList<Article> list = new ArrayList<Article>();
		ResultSet rs = null;
		String sql = "select * from board where writer = ? order by num";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				list.add(new Article(rs.getInt(1), rs.getDate(2), 
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public List selectByTitle(String title) {
		ArrayList<Article> list = new ArrayList<Article>();
		ResultSet rs = null;
		String sql = "select * from board where title = ? order by num";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				list.add(new Article(rs.getInt(1), rs.getDate(2), 
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return list;
	}

}

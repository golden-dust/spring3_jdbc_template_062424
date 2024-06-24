package com.goldendust.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.goldendust.board.dto.BoardDto;
import com.goldendust.board.util.Constant;

public class BoardDao {
	
	// 멤버 변수
	DataSource dataSource;
	JdbcTemplate template;
	
	public BoardDao() {
		
		// 전역객체 불러와서 본인 걸로 초기화시키기
		this.template = Constant.template;
		
	}
	
	public void writeOk(final String bname, final String btitle, final String bcontent) {
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "INSERT INTO springboard(bname, btitle, bcontent, bhit) VALUES(?,?,?,0)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, bname);
				ps.setString(2, btitle);
				ps.setString(3, bcontent);
				
				return ps;
			}
		});
		
	}
	
	public ArrayList<BoardDto> boardDtos() {

		String sql = "SELECT * FROM springboard ORDER BY bnum DESC";

		ArrayList<BoardDto> boardDtos = (ArrayList<BoardDto>) this.template.query(sql, new BeanPropertyRowMapper(BoardDto.class));
		
		return boardDtos;
	}
	
	public BoardDto findById(String bnum) {
		
		String sql = "SELECT * FROM springboard WHERE bnum = " + bnum;
		
		BoardDto bDto = this.template.queryForObject(sql, new BeanPropertyRowMapper(BoardDto.class));
		
		return bDto;
	}
	
	public void modify(final String bnum, final String btitle, final String bcontent) {
		String sql = "UPDATE springboard SET btitle=?, bcontent=? WHERE bnum=?";
		
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, btitle);
				ps.setString(2, bcontent);
				ps.setString(3, bnum);
			}
		});
	
	}
	
	public void delete(final String bnum) {
		String sql = "DELETE FROM springboard WHERE bnum=?";
		
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bnum);
			}
		});
	}

}
	
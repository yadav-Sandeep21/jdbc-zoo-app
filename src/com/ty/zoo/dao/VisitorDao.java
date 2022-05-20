package com.ty.zoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.zoo.dto.User;
import com.ty.zoo.dto.Visitor;
import com.ty.zoo.util.AES;
import com.ty.zoo.util.ConnectionObject;

import static com.ty.zoo.util.AppConstants.SECRET_KEY;

public class VisitorDao {
	public int saveVisitor(Visitor visitor) {
		String sql="INSERT INTO visitor VALUES(?,?,?,?,?,?)";
		Connection connection=ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparestatement=connection.prepareStatement(sql);
			preparestatement.setInt(1, visitor.getId());
			preparestatement.setString(2,visitor.getName());
			preparestatement.setString(3, visitor.getEmail());
			preparestatement.setString(4, visitor.getPhone());
			preparestatement.setString(5, visitor.getGender());
			preparestatement.setInt(6, visitor.getAge());
			
			System.out.println("Data Inserted");
			return preparestatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	
	public Visitor getVisitorById(int id) {
		String query = "SELECT * FROM visitor WHERE id = ?";
		Connection connection = ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				Visitor visitor = new Visitor();
				visitor.setId(resultSet.getInt(1));
				visitor.setName(resultSet.getString(2));
				visitor.setEmail(resultSet.getString(3));
				visitor.setPhone(resultSet.getString(4));
				visitor.setGender(resultSet.getString(5));
				visitor.setAge(resultSet.getInt(6));

				System.out.println("Printing User");
				return visitor;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection != null)
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	public List<Visitor> getAllVisitor(){
		String sql="SELECT * FROM visitor";
		Connection connection=ConnectionObject.getConnection();
		List<Visitor> list =null;
		try {
			PreparedStatement prepareStatement=connection.prepareStatement(sql);
			ResultSet resultset=prepareStatement.executeQuery();
			list=new ArrayList<Visitor>();

			if(resultset.next()) {
				Visitor visitor=new Visitor();
				visitor.setId(resultset.getInt(1));
				visitor.setName(resultset.getString(2));
				visitor.setEmail(resultset.getString(3));
				visitor.setPhone(resultset.getString(4));
				visitor.setGender(resultset.getString(5));
				visitor.setAge(resultset.getInt(6));
				list.add(visitor);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}

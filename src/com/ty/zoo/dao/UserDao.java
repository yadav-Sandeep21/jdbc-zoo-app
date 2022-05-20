package com.ty.zoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ty.zoo.util.AES;
import com.ty.zoo.util.ConnectionObject;
import com.ty.zoo.dto.User;
import static com.ty.zoo.util.AppConstants.SECRET_KEY;

public class UserDao {
	public int saveUser(User user) {
		String sql="INSERT INTO user VALUES(?,?,?,?,?,?)";
		Connection connection=ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparestatement=connection.prepareStatement(sql);
			preparestatement.setInt(1, user.getId());
			
			String encName=AES.encrypt(user.getName(),SECRET_KEY);
			preparestatement.setString(2,encName);
			
			String encEmail=AES.encrypt(user.getEmail(),SECRET_KEY);
			preparestatement.setString(3, encEmail);
			
			String encPassword=AES.encrypt(user.getPassword(),SECRET_KEY);
			preparestatement.setString(4, encPassword);
			
			preparestatement.setString(5, user.getRole());
			preparestatement.setString(6, user.getPhone());
			
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
}

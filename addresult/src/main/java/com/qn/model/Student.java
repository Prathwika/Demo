package com.qn.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {
   private int id;
   private String name;
   private int mark1;
   private int mark2;
   private int mark3;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Student() {
	super();
}
public Student(int id, String name, int mark1, int mark2, int mark3) {
	super();
	this.id = id;
	this.name = name;
	this.mark1 = mark1;
	this.mark2 = mark2;
	this.mark3 = mark3;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMark1() {
	return mark1;
}
public void setMark1(int mark1) {
	this.mark1 = mark1;
}
public int getMark2() {
	return mark2;
}
public void setMark2(int mark2) {
	this.mark2 = mark2;
}
public int getMark3() {
	return mark3;
}
public void setMark3(int mark3) {
	this.mark3 = mark3;
}

public int addResult() {
	try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "root");
		
		String s ="insert into student values(?,?,?,?,?)";
		PreparedStatement p =c.prepareStatement(s);
		p.setInt(1, id);
		p.setString(2, name);
		p.setInt(3, mark1);
		p.setInt(4, mark2);
		p.setInt(5, mark3);
		int r = p.executeUpdate();
		return r;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", mark1=" + mark1 + ", mark2=" + mark2 + ", mark3=" + mark3 + "]";
}
}

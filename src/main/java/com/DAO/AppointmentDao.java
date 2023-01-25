package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;
import com.entity.Doctor;

public class AppointmentDao {
    private Connection conn;

	public AppointmentDao(Connection conn) {
		super();
		this.conn = conn;
	}
    
    public boolean addAppointment(Appointment ap)
    {
    	boolean f = false;
    	
    	try {
			String sql = "insert into appointment( userId, fullName, gender, age, appointDate, email, phNo, diseases, doctorId, address, status) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ap.getUserId());
			ps.setString(2, ap.getFullName());
			ps.setString(3, ap.getGender());
			ps.setString(4, ap.getAge());
			ps.setString(5, ap.getAppointDate());
			ps.setString(6, ap.getEmail());
			ps.setString(7, ap.getPhNo());
			ps.setString(8, ap.getDiseases());
			ps.setInt(9, ap.getDoctorId());
			ps.setString(10, ap.getAddress());
			ps.setString(11, ap.getStatus());
			
			int i = ps.executeUpdate();
			if(i==1)
			{
				f= true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	return f;
    	
    }
    
    
    public List<Appointment> getAppointmentByUserId(int userId)
    {
    	
    	List<Appointment> list = new ArrayList<Appointment>();
    	Appointment a = null;
    	
    	try {
    		String sql = "select * from appointment where userId=?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, userId);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			a= new Appointment();
    			a.setId(rs.getInt(1));
    			a.setUserId(rs.getInt(2));
    			a.setFullName(rs.getString(3));
    			a.setGender(rs.getString(4));
    			a.setAge(rs.getString(5));
    			a.setAppointDate(rs.getString(6));
    			a.setEmail(rs.getString(7));
    			a.setPhNo(rs.getString(8));
    			a.setDiseases(rs.getString(9));
    			a.setDoctorId(rs.getInt(10));
    			a.setAddress(rs.getString(11));
    			a.setStatus(rs.getString(12));
    			
    		    list.add(a);
    		}
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    	}
    	
    	return list;
    }
    
    
    
    
    public List<Appointment> getAppointmentByDoctorLogin(int doctId)
    {
    	
    	List<Appointment> list = new ArrayList<Appointment>();
    	Appointment a = null;
    	
    	try {
    		String sql = "select * from appointment where doctorId=?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, doctId);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			a= new Appointment();
    			a.setId(rs.getInt(1));
    			a.setUserId(rs.getInt(2));
    			a.setFullName(rs.getString(3));
    			a.setGender(rs.getString(4));
    			a.setAge(rs.getString(5));
    			a.setAppointDate(rs.getString(6));
    			a.setEmail(rs.getString(7));
    			a.setPhNo(rs.getString(8));
    			a.setDiseases(rs.getString(9));
    			a.setDoctorId(rs.getInt(10));
    			a.setAddress(rs.getString(11));
    			a.setStatus(rs.getString(12));
    			
    		    list.add(a);
    		}
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    	}
    	
    	return list;
    }
    
    
    
    public Appointment getAppointmentById(int Id)
    {
    	
    	
    	Appointment a = null;
    	
    	try {
    		String sql = "select * from appointment where id=?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, Id);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			a= new Appointment();
    			a.setId(rs.getInt(1));
    			a.setUserId(rs.getInt(2));
    			a.setFullName(rs.getString(3));
    			a.setGender(rs.getString(4));
    			a.setAge(rs.getString(5));
    			a.setAppointDate(rs.getString(6));
    			a.setEmail(rs.getString(7));
    			a.setPhNo(rs.getString(8));
    			a.setDiseases(rs.getString(9));
    			a.setDoctorId(rs.getInt(10));
    			a.setAddress(rs.getString(11));
    			a.setStatus(rs.getString(12));
    		
    		}
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    	}
    	
    	return a;
    }
    
    public boolean updateStatus(int id, int did, String comment)
    {
    	boolean f= false;
    	try {
			String sql = "update appointment set status=? where id=? and doctorId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comment);
			ps.setInt(2, id);
			ps.setInt(3, did);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f= true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return f;
    }
    
    
    
    public List<Appointment> getAllAppointment()
    {
    	
    	List<Appointment> list = new ArrayList<Appointment>();
    	Appointment ap = null;
    	
    	try {
    		String sql = "select * from appointment order by id desc";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			ap= new Appointment();
    			ap.setId(rs.getInt(1));
    			ap.setUserId(rs.getInt(2));
    			ap.setFullName(rs.getString(3));
    			ap.setGender(rs.getString(4));
    			ap.setAge(rs.getString(5));
    			ap.setAppointDate(rs.getString(6));
    			ap.setEmail(rs.getString(7));
    			ap.setPhNo(rs.getString(8));
    			ap.setDiseases(rs.getString(9));
    			ap.setDoctorId(rs.getInt(10));
    			ap.setAddress(rs.getString(11));
    			ap.setStatus(rs.getString(12));
    			
    		    list.add(ap);
    		}
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    	}
    	
    	return list;
    }

}

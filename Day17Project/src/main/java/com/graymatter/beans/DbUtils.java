package com.graymatter.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Component

public class DbUtils implements DbInterface {

	Connection con;

	@Override
	public List<Regions> getAll() throws SQLException {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM regions");
		
		List<Regions> rlist = new ArrayList<Regions>();
		
		while(rs.next())
			rlist.add(new Regions(rs.getInt(1), rs.getString(2)));
		
		return rlist;
	}

	@Override
	public Regions addRegion(Regions region) throws SQLException {

		PreparedStatement ps = con.prepareStatement("INSERT INTO regions VALUES (?, ?)");
		ps.setInt(1, region.getRid());
		ps.setString(2, region.getRname());
		ps.executeUpdate();
		
		ps = con.prepareStatement("SELECT * FROM regions WHERE region_id = ?");
		ps.setInt(1,  region.getRid());
		
		ResultSet rs = ps.executeQuery();
		Regions savedRegion = new Regions();
		
		while(rs.next())
		savedRegion = new Regions(rs.getInt(1), rs.getString(2));
		
		return savedRegion;		
	
	}

	
	// Get region by ID
	@Override
	public Regions getRegionbyId(int rid) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("select * from regions where region_id = ?");
		ps.setInt(1, rid);
		ResultSet rs = ps.executeQuery();
		Regions savedRegion= null;
		while(rs.next())
		savedRegion = new Regions(rs.getInt(1),rs.getString(2));

		return savedRegion;

	}

	@Override
	public Regions updateRegion(Regions region) throws SQLException {

		PreparedStatement ps=con.prepareStatement("UPDATE regions SET region_name=? WHERE region_id=?");
		  
		ps.setString(1,region.getRname());
		ps.setInt(2,region.getRid());
		
		  ps.executeUpdate();
		  Regions savedRegion = getRegionbyId(region.getRid());
		  return savedRegion;
	}

	@Override
	public void deleteRegion(int rid) throws SQLException {
		PreparedStatement ps=con.prepareStatement("DELETE FROM regions WHERE region_id = ?");
		  
		ps.setInt(1,rid);
		
		  ps.executeUpdate();
		  
		
	}
	
	
	
}

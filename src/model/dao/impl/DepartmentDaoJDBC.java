package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department department) {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("INSERT INTO Department (Id, Name) VALUES (?, ?)");
			st.setInt(1, department.getId());
			st.setString(2, department.getName());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Department department) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("UPDATE Department SET  Name = ? WHERE Department.Id = ?");

			st.setString(1, department.getName());
			st.setInt(2, department.getId());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected == 0) {
				throw new DbException("Not Updated");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deletebyId(Integer id) {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("DELETE FROM Department WHERE Department.Id = ?");
			st.setInt(1, id);

			int rowsAffected = st.executeUpdate();

			if (rowsAffected == 0) {
				throw new DbException("Could not delete seller from position because there is no seller with this id");
			}

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);
		}

	}

	@Override
	public Department findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT * FROM Department WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Department dt = new Department(rs.getInt("Id"), rs.getString("Name"));
				return dt;
			}
			return null;

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

package cl.aiep.java.cft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.java.cft.Alumno;

@Repository
public class AlumnoRepositoryImp implements AlumnoRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Alumno makeObject(ResultSet rs, int filaNum) throws SQLException {
		return new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad"));
	}
		
	@Override
	public List<Alumno> findAll() {
		String sql = "SELECT * FROM alumnoscft";
		return jdbcTemplate.query(sql, this::makeObject);
	}

	@Override
	public Alumno findById(int id) {
		String sql = "SELECT * FROM alumnoscft WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, this::makeObject, id);
	}

	@Override
	public void create(Alumno alumno) {
		String sql = "INSERT INTO alumnoscft (nombre, edad) VALUES(?,?)";
		jdbcTemplate.update(sql, alumno.getNombre(), alumno.getEdad());
	}

	@Override
	public void edit(Alumno alumno) {
		String sql = "UPDATE alumnoscft SET nombre=?, edad=? WHERE id=?";
		jdbcTemplate.update(
				sql, 
				alumno.getNombre(), 
				alumno.getEdad(), 
				alumno.getId()
		);		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM alumnoscft WHERE id =?";
		jdbcTemplate.update(sql, id);	
	}

}

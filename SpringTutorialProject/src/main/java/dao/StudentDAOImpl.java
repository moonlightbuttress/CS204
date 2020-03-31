package dao;

import model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component()
public class StudentDAOImpl implements StudentDAO {
    private JdbcTemplate jdbcTemplate;

    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Student getStudentById(int id) {
        try {
            Student student = jdbcTemplate.queryForObject("SELECT * FROM Students WHERE studentID=?", new Object[]{id},
                    new BeanPropertyRowMapper<>(Student.class));
            System.out.println("Using queryForObject method from JdbcTemplate to query studentID=12345: ");
            return student;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        System.out.println("\n" +
                "Using the query method from JdbcTemplate to query all students: ");
        List allStudents = jdbcTemplate.query("SELECT * FROM Students",
                new BeanPropertyRowMapper<>(Student.class));
        return allStudents;
    }
}

import dao.StudentDAO;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import service.report.ReportService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // The following code initializes this project using the Spring configuration in applicationContext.xml
        // TODO Check src/main/resources/applicationContext.xml to see how it initialized the JdbcTemplate bean.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAOImpl");
        System.out.println(studentDAO.getStudentById(12345));
        List allStudents = studentDAO.getAllStudents();
        for (Object stud : allStudents) {
            System.out.println(stud.toString());
        }
        // Get the Spring bean that manages access to Database
        // TODO Change the following line of code after you finish implementing StudentDAOImpl
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");

        // Using the JdbcTemplate to query for a student in the database


        // Using the JdbcTemplate to query for all students in the database


        System.out.println("\n-----Implementation of ReportService----- ");
        ReportService reportService = (ReportService) context.getBean("reportService");
        reportService.printReport(System.out);



    }
}

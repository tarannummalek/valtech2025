package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDAOImpl implements DeptDAO {

    private String username;
    private String url;
    private String password;

    public DeptDAOImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    private void setValuesToPrepareStatements(Dept d, PreparedStatement ps) throws SQLException {
        ps.setString(2, d.getName());
        ps.setString(3, d.getLocation());
        ps.setInt(1, d.getId());
    }

    public Dept first() {
        List<Dept> empList = getAll();
        int id = empList.stream().mapToInt(Dept::getId).min().orElseThrow();
        return getDept(id);
    }

    public Dept prev(int id) {
        List<Dept> empList = getAll();
        if (id == first().getId()) {
            return getDept(id);
        }
        return getDept(id - 1);
    }

    public Dept next(int id) {
        if (id == last().getId()) {
            return getDept(id);
        }
        return getDept(id + 1);
    }

    public void save(Dept dept) {
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO DEPARTMENT (ID,NAME,LOCATION) VALUES(?,?,?)");
            setValuesToPrepareStatements(dept, ps);
            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }

    public Dept getDept(int id) {
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,LOCATION FROM DEPARTMENT WHERE ID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return populateDepartment(rs);
            } else {
                throw new RuntimeException("No department with id " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Dept populateDepartment(ResultSet rs) {
        try {
            return Dept.builder().id(rs.getInt(1)).name(rs.getString(2)).location(rs.getString(3)).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Dept> getAll() {
        List<Dept> deptSet = new ArrayList<>();
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,LOCATION FROM DEPARTMENT");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                deptSet.add(populateDepartment(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deptSet;
    }

    public void update(Dept d) {
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE DEPARTMENT SET NAME=?, LOCATION=? WHERE ID=?");
            setValuesToPrepareStatements(d, ps);
            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Dept last() {
        List<Dept> empList = getAll();
        int id = empList.stream().mapToInt(Dept::getId).max().orElseThrow();
        return getDept(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(int dept_id) {
        List<Employee> empSet = new ArrayList<>();
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE WHERE DEPT_ID=?");
            ps.setInt(1, dept_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = populateEmployee(rs);
                empSet.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empSet;
    }

    private Employee populateEmployee(ResultSet rs) {
        try {
            return Employee.builder().id(rs.getLong(1))
                    .name(rs.getString(2))
                    .age(rs.getInt(3))
                    .gender(Employee.Gender.valueOf(rs.getString(4)))
                    .salary(rs.getFloat(5))
                    .exp(rs.getInt(6))
                    .level(rs.getInt(7))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

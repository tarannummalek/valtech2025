package servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import dao.Dept;
import dao.Dept.DeptBuilder;
import dao.DeptDAO;
import dao.DeptDAOImpl;
import dao.Employee;
import dao.EmployeeDAOImpl;
import dao.Employee.Gender;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/depts")
public class DeptServlet extends HttpServlet {

	private DeptDAO deptDAO;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext sc = config.getServletContext();
        String username = sc.getInitParameter("dbUsername");
        String password = sc.getInitParameter("dbPassword");
        String url = sc.getInitParameter("dbUrl");
        deptDAO = new DeptDAOImpl(url, username, password);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ServletContext sc=getServletConfig().getServletContext();
		HttpSession session = req.getSession();
		Dept current = (Dept) session.getAttribute("current");
		String operation = req.getParameter("operation");
		String attr = req.getParameter("attr");
		String sort_type = req.getParameter("sort_type");

		if (session.getAttribute("current") == null) {
			current = (Dept) deptDAO.first();
		}

		List<Employee> emps = deptDAO.getEmployeesByDepartment(current.getId());

		if ("sort".equals(operation)) {

			if ("id".equals(attr)) {
				
				if ("asc".equals(sort_type)) {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (int) (e1.getId() - e2.getId()))
									.collect(Collectors.toList()));
				} else {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (int) (e2.getId() - e1.getId()))
									.collect(Collectors.toList()));

				}

			}
			if ("name".equals(attr)) {
				if ("asc".equals(sort_type)) {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (e1.getName().compareTo(e2.getName())))
									.collect(Collectors.toList()));
				} else {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (e2.getName().compareTo(e1.getName())))
									.collect(Collectors.toList()));

				}

			}
			if ("sal".equals(attr)) {
				if ("asc".equals(sort_type)) {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (int) (e1.getSalary() - e2.getSalary()))
									.collect(Collectors.toList()));
				} else {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (int) (e2.getSalary() - e1.getSalary()))
									.collect(Collectors.toList()));

				}

			}
			if ("level".equals(attr)) {
				if ("asc".equals(sort_type)) {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (int) (e1.getLevel() - e2.getLevel()))
									.collect(Collectors.toList()));
				} else {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (int) (e2.getLevel() - e1.getLevel()))
									.collect(Collectors.toList()));

				}

			}
			if ("exp".equals(attr)) {
				if ("asc".equals(sort_type)) {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (int) (e1.getExp() - e2.getExp()))
									.collect(Collectors.toList()));
				} else {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (int) (e2.getExp() - e1.getExp()))
									.collect(Collectors.toList()));

				}

			}
			if ("age".equals(attr)) {
				if ("asc".equals(sort_type)) {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (int) (e1.getAge() - e2.getAge()))
									.collect(Collectors.toList()));
				} else {
					req.setAttribute("emps",
							emps.stream().sorted((Employee e1, Employee e2) -> (int) (e2.getAge() - e1.getAge()))
									.collect(Collectors.toList()));

				}

			}
			if ("gender".equals(attr)) {
				if ("asc".equals(sort_type)) {
					req.setAttribute("emps",
							emps.stream()
									.sorted((Employee e1, Employee e2) -> (e1.getGender().compareTo(e2.getGender())))
									.collect(Collectors.toList()));
				} else {
					req.setAttribute("emps",
							emps.stream()
									.sorted((Employee e1, Employee e2) -> (e2.getGender().compareTo(e1.getGender())))
									.collect(Collectors.toList()));

				}

			}
		}

		if (("Add").equals(operation)) {

			System.out.println("in add...");

			req.setAttribute("mode", "Add");
			// req.setAttribute("check", 1);
			req.getRequestDispatcher("editDept.jsp").forward(req, resp);
			;
			return;
		}

		session.setAttribute("current", deptDAO.getDept(current.getId()));
		if (req.getAttribute("emps") == null) {
			req.setAttribute("emps", emps);
		}
		req.setAttribute("dept", deptDAO.getDept(current.getId()));

		req.getRequestDispatcher("depts.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");

		HttpSession session = req.getSession();
		Dept current = (Dept) session.getAttribute("current");

		if (current == null) {
			System.out.println("current null");
			current = deptDAO.first();

		} else {

			if ("search".equals(operation)) {
				String name = req.getParameter("search_name");
				String id = req.getParameter("search_id");
				String sal = req.getParameter("search_sal");
				String age = req.getParameter("search_age");
				String gender = req.getParameter("search_gender");
				String exp = req.getParameter("search_exp");
				String level = req.getParameter("search_level");
				String sal_g = req.getParameter("search_sal_g");
				String sal_l = req.getParameter("search_sal_l");
				String age_g = req.getParameter("search_age_g");
				String age_l = req.getParameter("search_age_l");
				List<Employee> emps = deptDAO.getEmployeesByDepartment(current.getId());

				if (name != "") {
					req.setAttribute("emps",
							emps.stream().filter(e -> e.getName().contains(name)).collect(Collectors.toList()));
				}
				if (!id.equals("")) {
					req.setAttribute("emps",
							emps.stream().filter(e -> e.getId() == Integer.parseInt(id)).collect(Collectors.toList()));
				}
				if (sal != "") {
					req.setAttribute("emps", emps.stream().filter(e -> e.getSalary() == Integer.parseInt(sal))
							.collect(Collectors.toList()));
				}
				if (age != "") {
					req.setAttribute("emps", emps.stream().filter(e -> e.getAge() == Integer.parseInt(age))
							.collect(Collectors.toList()));
				}
				if (gender != "") {
					req.setAttribute("emps",
							emps.stream().filter(e -> e.getGender().equals(gender)).collect(Collectors.toList()));
				}
				if (exp != "") {
					req.setAttribute("emps", emps.stream().filter(e -> e.getExp() == Integer.parseInt(exp))
							.collect(Collectors.toList()));
				}
				if (level != "") {
					req.setAttribute("emps", emps.stream().filter(e -> e.getLevel() == Integer.parseInt(level))
							.collect(Collectors.toList()));
				}
				if (sal_g != "") {
					req.setAttribute("emps", emps.stream().filter(e -> e.getSalary() > Integer.parseInt(sal_g))
							.collect(Collectors.toList()));
				}
				if (sal_l != "") {
					req.setAttribute("emps", emps.stream().filter(e -> e.getSalary() < Integer.parseInt(sal_l))
							.collect(Collectors.toList()));
				}
				if (age_g != "") {
					req.setAttribute("emps", emps.stream().filter(e -> e.getAge() > Integer.parseInt(age_g))
							.collect(Collectors.toList()));
				}
				if (age_l != "") {
					req.setAttribute("emps", emps.stream().filter(e -> e.getAge() < Integer.parseInt(age_l))
							.collect(Collectors.toList()));
				}
				session.setAttribute("current", current);
				req.setAttribute("dept", current);
				req.getRequestDispatcher("depts.jsp").forward(req, resp);
				return;
			} else if ("First".equals(operation)) {
				current = deptDAO.first();
			} else if ("Last".equals(operation)) {
				current = deptDAO.last();

			} else if ("Previous".equals(operation)) {
				current = deptDAO.prev(current.getId());

			} else if ("Next".equals(operation)) {
				current = deptDAO.next(current.getId());

			} else if (("Add").equals(operation)) {

				Dept dept = Dept.builder().id(Integer.parseInt(req.getParameter("id"))).name(req.getParameter("name"))
						.location(req.getParameter("location")).build();
				deptDAO.save(dept);
				req.setAttribute("mode", "Add");
				// req.setAttribute("check", 1);
				req.getRequestDispatcher("depts.jsp").forward(req, resp);
				req.setAttribute("current", deptDAO.first());
				req.setAttribute("emps", deptDAO.getEmployeesByDepartment(deptDAO.first().getId()));
				return;
			}
		}
		session.setAttribute("current", current);
		req.setAttribute("dept", current);
		req.setAttribute("emps", deptDAO.getEmployeesByDepartment(current.getId()));

		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName() + " " + cookies[i].getValue());
		}
		resp.addCookie(new Cookie("operation", operation));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);

	}

}

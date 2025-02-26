//package hibernate.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import hibernate.Account;
import hibernate.Address;
import hibernate.AtmTx;
import hibernate.Car;
import hibernate.ChequeTx;
import hibernate.Customer;
import hibernate.Student;
import hibernate.StudentAddress;
import hibernate.StudentId;
import hibernate.TellerTx;
import hibernate.Tx;

public class HibernateClient {
	public static void main(String[] args) {
		SessionFactory sf = new AnnotationConfiguration().addAnnotatedClass(Car.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Tx.class)
				.addAnnotatedClass(ChequeTx.class)
				.addAnnotatedClass(TellerTx.class)
				.addAnnotatedClass(AtmTx.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Account.class)
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		//s.createQuery("from Tx t").list().stream().forEach(t->System.out.println(t));
		
		//s.createQuery("from Customer c where c.age>?").setInteger(0, 23).list().stream().forEach(t->System.out.println(t));
		
		
		//s.createQuery("select t from Tx t join t.account.customers c where c.age<?").setInteger(0, 50).list().stream().forEach(e->System.out.println(e));
		
		Student st=(Student) s.save(new Student("abc","pqr",1234567890L,"cs",new StudentId(1,2025)));
		//Student st1=(Student) s.save(new Student(new StudentId(1,2025),"abc","pqr",1234567890L,"cs",new StudentAddress("del","ind",676776)));

		//System.out.println(s.load(Student.class, st));
		
//		Account ac =(Account) s.load(Account.class, 3);
//		Customer customer=(Customer) s.load(Customer.class, 1L);
//		
//		Account acc1=new Account(50000,"CA");
//		Account acc2=new Account(30000,"SB");
//		Account acc3=new Account(40000,"DEF");	
//		Account acc4=new Account(5000,"CA");
//		Customer customer2=new Customer("DEF",32,false);
//		Customer customer3=new Customer("XYZ",36,false);
//		
//		s.save(acc1);
//		s.save(acc2);
//		s.save(acc3);
//		s.save(acc4);
//		s.save(customer2);
//		s.save(customer3);
//		customer2.addAccount(acc1);
//		customer2.addAccount(acc2);
//		customer2.addAccount(acc3);
//		customer3.addAccount(acc4);
//		customer3.addAccount(acc3);
//		customer3.addAccount(acc2);
		
		
		
		
//		List<Tx> txs=s.createQuery("from Tx t").list();
//		Account ac =new Account(1000,"SB");
//		s.save(ac);
//		txs.stream().forEach(t->ac.addTx(t));
		
		
		
		
//		Long id=(Long) s.save(new Car(0, "Honda", "City", 2025));
//		System.out.println(id);
//		Car car=(Car)s.load(Car.class,id);
//		System.out.println();
//		System.out.println(car.getClass().getName());
//		car.setName("Civic");
//		Car car1=(Car) s.load(Car.class, id);
//		s.update(car);
//		//s.flush();// dont call on your own 
//		System.out.println(car);
//		s.save(new Tx(1000));
//		s.save(new ChequeTx(2000,2000));
//		s.save(new TellerTx(3000,"Admin","ahmedabad"));
//		s.save(new AtmTx(4000,123));
//		List<Tx> txs=s.createQuery(" from Tx t").list();
//		
//		Customer c =new Customer("abc1",23,true);
//		s.save(c);
//		Address a =new Address(0,"srkhj","amd",393002);
//		c.setAddress(a);
//		a.setCustomer(c);
//		a.setId(c.getId());
//		s.saveOrUpdate(a);
//		
//		Customer cus=(Customer) s.load(Customer.class,1L);
//		System.out.println(cus);
//		System.out.println(cus.getAddress());
		
		
		
		
		
		
		tx.commit();
		s.close();
		sf.close();

	}

}

package webservices;

import java.util.List;

import org.apache.cxf.frontend.ServerFactoryBean;

public class MovieServer {
	public static void main(String[] args) {
		ServerFactoryBean serverFactoryBean=new ServerFactoryBean();
		serverFactoryBean.setAddress("http://localhost:7777/MovieService");
		
		MovieServiceImpl impl=new MovieServiceImpl();
		impl.addMovie(new Movie(1,"Top gun","English","Action",List.of("Tom cruise","jennifer Conley")));
		impl.addMovie(new Movie(2,"de dana dan","hindi","comedy",List.of("akshay kumar","sunil shetty")));
		impl.addMovie(new Movie(3,"3 idiots","hindi","comedy",List.of("Aamir khan","kareena kapoor","R madhvan")));
		impl.addMovie(new Movie(4,"Alaipaydhey","Tamil","drama",List.of("madhvan","shalini")));
		impl.addMovie(new Movie(5,"Nayagan","Tamil","Drama",List.of("Kamalhasan","Sharanya")));
		
		
		serverFactoryBean.setServiceBean(impl);
		serverFactoryBean.setServiceClass(MovieService.class);
		serverFactoryBean.create();
		System.out.println("movie server running...");
		
	}

}

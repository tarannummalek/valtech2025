package day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import day2.Car;

class LambdaTest {

	@Test
	void test() {
		List<Car> cars=new ArrayList<Car>();
		cars.add(Car.builder().make("Honda").model("city").varient("ZX").year("2000").version("7").build());
		cars.add(Car.builder().make("Honda").model("city").varient("ZX").year("2000").version("6").build());
		cars.add(Car.builder().make("Honda").model("city").varient("ZX").year("2000").version("5").build());
		cars.add(Car.builder().make("Benz").model("city").varient("ZX").year("2000").version("4").build());

	for(Car car:cars) {
		if(car.getVersion() =="5") {
			System.out.println(car);
		}
	}
	
	List<Car> newCars=cars.stream().filter(car->"7".equals(car.getVersion())).collect(Collectors.toList());
	System.out.println(newCars);
	//cars.parallelStream()
	Set<String> uniqueMake=cars.stream().map(car->car.getMake())
			.collect(Collectors.toSet());
	System.out.println(uniqueMake);
	
	}
	

}

package day1;

public class Dog implements Animal {

	@Override
	public void makeSound() {
		System.out.println("Bark...");
		
	}

	@Override
	public void eat() {
		System.out.println("Eating pedigree");
		
	}

	@Override
	public void sleep() {
		System.out.println("snore...");
		
	}

}

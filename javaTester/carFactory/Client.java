package carFactory;

public class Client {

	public static void main(String[] args) {
		Car car = CarFactory.getCarType(CarType.TOYOTA);
		car.viewCar();
		car.driveCar();
		
		car = CarFactory.getCarType(CarType.BENZ);
		car.viewCar();
		car.driveCar();
		
	}

}

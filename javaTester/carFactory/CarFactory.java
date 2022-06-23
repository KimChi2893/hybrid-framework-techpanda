package carFactory;

public class CarFactory {
	public static Car getCarType(CarType carType) {
		switch (carType) {
		case HONDA:
			return new Honda();
		case HUYNDAI:
			return new Huyndai();
		case TOYOTA:
			return new Toyota();
		case BENZ:
			return new Benz();
		default:
			throw new IllegalArgumentException("This car type is unsupported");
        }
    }

}


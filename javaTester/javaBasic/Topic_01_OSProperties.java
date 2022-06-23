package javaBasic;

public class Topic_01_OSProperties {
	public static void main(String args[]) {
		String osName = System.getProperty("os.name");
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.out.println(osName);
	}
}

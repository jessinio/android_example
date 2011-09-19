
public class Main {
	final static public String MainTag = "Main Thread";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b_instance = new B("B class");
		b_instance.run();
		b_instance.run("print please!");
	}

}


public class tryfinally {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		xxx();
	}

	private static void xxx() throws ClassNotFoundException {
		try{
			Class.forName("xxxxx");
		}finally{
			System.out.println(222222222);
		}
		
		System.out.println(555555);
	}

}

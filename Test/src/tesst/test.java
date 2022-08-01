package tesst;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int x; 
		int num =0;
		int mod = 1000000007, count=0;
	
		for(x = 1; ; x++) {
			if((num^x) == num+x) {
				count++;
				count = count % mod;
			}
		}
		System.out.println(count);
	}

}

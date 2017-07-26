import java.util.HashMap;
import java.util.Map;

public class Hashmap {
	public static void main(String[] args) {
		
		Map<String,String> hm=new HashMap<>();
		hm.put("Name", "sangy");
		System.out.println(hm.put("Name", "Manjeet"));
		System.out.println(hm);
	} 
}

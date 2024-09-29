import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuuferedreaderExample3 {

	public static void main(String[] args) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String name=br.readLine();		
			int age=Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println(e.getMessage());
			throw new UserInputException(e.getMessage());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

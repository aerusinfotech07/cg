import java.util.Comparator;

public class SortUserByAge implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o1.getAge()-o2.getAge();
	}

}

import java.util.List;

public class SortUtil {

	public static void bubbleSort(List<Integer> input) {

		Integer tmp;
		for (int i = input.size(); i > 0; --i) {
			for (int j = 0; j < i - 1; j++) {
				if (input.get(j).compareTo(input.get(j + 1)) > 0) {
					tmp = input.get(j);
					input.set(j, input.get(j + 1));
					input.set(j + 1, tmp);
				}
			}
		}
	}

}
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L25MissingAndRepeatingNumber {

  List<Integer> bruthSol(List<Integer> arr) {
    int n = arr.size();

    Collections.sort(arr);

    int p, q;
    for (int i = 0; i < n - 1; i++) {
      if (arr.get(i) == arr.get(i + 1))
        p = arr.get(i);
      if (arr.get(i) + 1 != arr.get(i + 1))
        q = arr.get(i) + 1;
    }
    return Arrays.asList(p, q);
  }

  public static void main(String[] args) {

  }
}

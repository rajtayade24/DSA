import java.util.Vector;

public class LegacyClass {
  public static void main(String[] args) {
    Vector<String> names = new Vector<>();
    names.add("Java");
    names.add("python");

    System.out.println(names);
    System.out.println("size" + names.size());

  }
}

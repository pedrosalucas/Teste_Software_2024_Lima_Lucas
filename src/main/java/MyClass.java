public class MyClass {
  public String method1() {
    erroFunc();
    return "Metodo Original";
  }

  public void erroFunc() {
    throw new NullPointerException();
  }
}



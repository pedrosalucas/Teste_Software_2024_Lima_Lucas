import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

class MyClassTest {
  @Test
  public void TestePergunta() {
    MyClass myInstance = new MyClass();
    MyClass myClassSpy = spy(myInstance);
    
    when(myClassSpy.method1()).thenReturn("Método Mock");
    
    assertEquals("Método Mock", myClassSpy.method1());
  }

  @Test
  public void TesteResposta() {
    MyClass myInstance = new MyClass();
    MyClass myClassSpy = spy(myInstance);

    doReturn("Método Mock").when(myClassSpy).method1();

    assertEquals("Método Mock", myClassSpy.method1());
  }
}

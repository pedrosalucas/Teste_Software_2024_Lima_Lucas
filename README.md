## Questão
A questão escolhida é a “Mockito: Trying to spy on method is calling the original method”, e está ilustrada na figura abaixo. A questão aborda o problema ao tentar simular o retorno do método method1(), porém ao chamar o método é executado o comportamento real do método, o que, no exemplo, causa uma exceção em tempo de execução.

 ![image](https://github.com/user-attachments/assets/7983a58f-0d3f-4f0c-99ad-d81f1251c62c)
 
Para reproduzir o cenário, é preciso declarar a Classe MyClass e o método method1(). A seguir está a implementação da Classe e do método:
```
public class MyClass {
  public String method1() {
    erroFunc();
    return "Metodo Original";
  }

  public void erroFunc() {
    throw new NullPointerException();
  }
}
```
Após implementar a Classe e o método, também implementamos o cenário de teste.
```
@Test
public void TestePergunta() {
  MyClass myInstance = new MyClass();
  MyClass myClassSpy = spy(myInstance);
  
  when(myClassSpy.method1()).thenReturn("Método Mock");
  
  assertEquals("Método Mock", myClassSpy.method1());
}
```
Ao executar esse teste é levantado a exceção demostrada na imagem:

![image](https://github.com/user-attachments/assets/44bfe92d-7ec9-4e17-9a19-15ff5188969f)


## Resposta Aceita
Na resposta aceita pelo criador da pergunta, é dito que a maneira de simular o método, na realidade executa o comportamento real do método. Então, como demostrado na documentação do Mockito, é necessário usar outra maneira para simular o retorno do método.

![image](https://github.com/user-attachments/assets/e8409cb1-240c-4848-88cc-4bca8d1c9b9c)


Ao aplicar no caso de teste a mudança, sugerida na resposta, temos:
```
@Test
public void TesteResposta() {
  MyClass myInstance = new MyClass();
  MyClass myClassSpy = spy(myInstance);

  doReturn("Método Mock").when(myClassSpy).method1();

  assertEquals("Método Mock", myClassSpy.method1());
}
```
E após executar o teste, é retornado o cenário esperado.

![image](https://github.com/user-attachments/assets/6e4e1fb3-fc87-4b47-b6a0-96123354733d)

## Conclusão
Por fim, entender essas diferenças e aplicar a abordagem correta para cada situação é crucial ao trabalhar com Mockito para fazer os testes unitários. Está é a diferença entre as duas formas de simular o comportamento de uma função, que vimos:
- **when(...).thenReturn(...)**: Use essa abordagem para mocks normais, onde o método real não é chamado durante a configuração.
- **doReturn(...).when(...)**: Use essa abordagem para spies, garantindo que o método real não seja chamado durante a configuração, evitando problemas e exceções.


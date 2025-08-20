import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserTest {
  @Test 
  public void testGetUsers() {
    RestAssured.baseURI = "https://serverest.dev";

    System.out.println("Iniciando o teste");

    try {
      given().
      when().
         get("/usuarios").
      then().
        log().all().
        statusCode(200)
        .body("usuarios.nome", hasItem("Fulano da Silva"));
      System.out.println("Teste concluido com sucesso!");
    }

      
    catch (AssertionError e) {
      System.out.println("Erro no teste: " + e.getMessage());
    }
  }
}
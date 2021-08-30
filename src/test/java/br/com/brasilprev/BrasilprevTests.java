package br.com.brasilprev;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BrasilprevTests {

    @Test
    public void testDadoUmUsuarioQuandoCadastrarSucessoEntaoObtenhoStatusCode200() {

        // Deve ser possível procurar pessoa pelo DDD e telefone
        baseURI = "http://localhost:9090/pessoas";
        port = 9090;
        basePath = "/pessoas";
       //final String s = "/pessoas";


        //Procurar pessoa pelo DDD e telefone
        given()

        .when()
                .get("/{11}/{985388877}")
        .then()
                .assertThat()
                .statusCode(201);

        //Deve retornar erro quando buscar pessoa por telefone inexistente
        given()

        .when()
                .get("/{11}/{999999999}")
        .then()
                .assertThat()
                .statusCode(404);



        //Deve salvar nova pessoa no sistema
        given()
                .body("{\n" +
                        " \"codigo\": \"0\",\n +" +
                        " \"nome\": \"Rommel Von\",\n +" +
                        " \"cpf\": \"34852582886\",\n +" +
                        " \"endereços\": \"[\"\n +" +
                        " \"{\"\"logradouro\":\"Rua Alexandre Dumas\",\n +" +
                        " \"numero\":\"123\",\n +" +
                        " \"complemento\":\"Empresa\",\n +" +
                        " \"bairro\":\"Chacara Santo Antonio\",\n +" +
                        " \"cidade\":\"Sao Paulo\",\n +" +
                        " \"estado\":\"SP\"}\n +" +
                        " \"]\",\n +" +
                        " \"telefones\": \"[\"\n +" +
                        " \"{\"\"ddd\":\"11\",\n +" +
                        " \"\"numero\":\"985388876\"}\n +" +
                        " \"]\",\n +" +
                        "}")
        .when()
                .post()
        .then()
                .assertThat()
                .statusCode(201);



        //Não deve ser possível salvar duas pessoas com o mesmo CPF
        given()
                .body("{\n" +
                        " \"codigo\": \"0\",\n +" +
                        " \"nome\": \"Rommel Von\",\n +" +
                        " \"cpf\": \"34852582886\",\n +" +
                        " \"endereços\": \"[\"\n +" +
                        " \"{\"\"logradouro\":\"Rua Alexandre Dumas\",\n +" +
                        " \"numero\":\"123\",\n +" +
                        " \"complemento\":\"Empresa\",\n +" +
                        " \"bairro\":\"Chacara Santo Antonio\",\n +" +
                        " \"cidade\":\"Sao Paulo\",\n +" +
                        " \"estado\":\"SP\"}\n +" +
                        " \"]\",\n +" +
                        " \"telefones\": \"[\"\n +" +
                        " \"{\"\"ddd\":\"11\",\n +" +
                        " \"\"numero\":\"985388876\"}\n +" +
                        " \"]\",\n +" +
                        "}")
        .when()
                .post()
        .then()
                .assertThat()
                .statusCode(400);



        //Cadastrar com sucesso
        given()
                .body("{\n" +
                        " \"codigo\": \"0\",\n +" +
                        " \"nome\": \"Rommel Von\",\n +" +
                        " \"cpf\": \"36362170888\",\n +" +
                        " \"endereços\": \"[\"\n +" +
                        " \"{\"\"logradouro\":\"Rua Alexandre Dumas\",\n +" +
                        " \"numero\":\"123\",\n +" +
                        " \"complemento\":\"Empresa\",\n +" +
                        " \"bairro\":\"Chacara Santo Antonio\",\n +" +
                        " \"cidade\":\"Sao Paulo\",\n +" +
                        " \"estado\":\"SP\"}\n +" +
                        " \"]\",\n +" +
                        " \"telefones\": \"[\"\n +" +
                        " \"{\"\"ddd\":\"11\",\n +" +
                        " \"\"numero\":\"985388876\"}\n +" +
                        " \"]\",\n +" +
                        "}")
        .when()
                .post()
        .then()
                .assertThat()
                .statusCode(400);



        //Não deve ser possível salvar pessoas informando valores maiores que parametrizado
        given()
                .body("{\n" +
                        " \"codigo\": \"0\",\n +" +
                        " \"nome\": \"ABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJ\",\n +" +
                        " \"cpf\": \"3485258288634852582886\",\n +" +
                        " \"endereços\": \"[\"\n +" +
                        " \"{\"\"logradouro\":\"ABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGH\",\n +" +
                        " \"numero\":\"123123123123123123\",\n +" +
                        " \"complemento\":\"ABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGH\",\n +" +
                        " \"bairro\":\"ABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGH",\n +" +
                        " \"cidade\":\"ABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGHABCDEFGHIJABCDEFGH\",\n +" +
                        " \"estado\":\"SPsp\"}\n +" +
                        " \"]\",\n +" +
                        " \"telefones\": \"[\"\n +" +
                        " \"{\"\"ddd\":\"1111\",\n +" +
                        " \"\"numero\":\"985388876985388876\"}\n +" +
                        " \"]\",\n +" +
                        "}")
            .when()
                .post()
            .then()
                .assertThat()
                .statusCode(201);



        //Não deve ser possível salvar pessoas informando valores de caracteres especiais
        given()
                .body("{\n" +
                        " \"codigo\": \"0\",\n +" +
                        " \"nome\": \"!@#$%\",\n +" +
                        " \"cpf\": \"!!!@!@!@!@!@!\",\n +" +
                        " \"endereços\": \"[\"\n +" +
                        " \"{\"\"logradouro\":\"@#@#@#@#@#@#@#\",\n +" +
                        " \"numero\":\"@#@#\",\n +" +
                        " \"complemento\":\"Empresa\",\n +" +
                        " \"bairro\":\"@#@#@#\",\n +" +
                        " \"cidade\":\"@#@#@#\",\n +" +
                        " \"estado\":\"@##@#\"}\n +" +
                        " \"]\",\n +" +
                        " \"telefones\": \"[\"\n +" +
                        " \"{\"\"ddd\":\"$#@#$#\",\n +" +
                        " \"\"numero\":\"!@!@!@!@!@!@\"}\n +" +
                        " \"]\",\n +" +
                        "}")
        .when()
                .post()
        .then()
                .assertThat()
                .statusCode(500);


    }


        }


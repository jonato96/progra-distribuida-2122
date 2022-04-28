package programacion.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClienteHttp {

    public static final String URL = "http://localhost:8080/rest02/personas";
    ObjectMapper mapper = new ObjectMapper();

    public List<PersonaClient> listarTodos() throws Exception {
        CloseableHttpClient cliente = HttpClients.createDefault();

        HttpGet get = new HttpGet(URL);
        get.addHeader(HttpHeaders.ACCEPT, "application/json");
        CloseableHttpResponse response = cliente.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Status code "+ statusCode);

        String txt = EntityUtils.toString(response.getEntity());

        System.out.println(txt);

        if(statusCode == HttpStatus.SC_OK){
            //converti texto json a objeto

            PersonaClient[] personas = mapper.readValue(txt, PersonaClient[].class);

//            int index = 1;
//            for (PersonaClient p : personas){
//                System.out.printf("[%d] Nombre: %s\n", index, p.getNombre());
//                index++;
//            }
            return Arrays.asList(personas);

        }
        else{
            return Collections.emptyList();
        }

    }

    public void insertar(PersonaClient obj) throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        String txtJson = mapper.writeValueAsString(obj);

        StringEntity entity = new StringEntity(txtJson);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(URL);
        post.addHeader(HttpHeaders.ACCEPT, "application/json");
        post.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        post.setEntity(entity);

        CloseableHttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Status code "+ statusCode);

    }


}

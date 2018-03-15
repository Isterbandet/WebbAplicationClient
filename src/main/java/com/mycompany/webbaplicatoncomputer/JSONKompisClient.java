
package com.mycompany.webbaplicatoncomputer;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;



public class JSONKompisClient {
    private static ClientConfig config = new DefaultClientConfig();
    private static Client client = Client.create(config);
    private static WebResource service = client.resource(
            UriBuilder.fromUri("http://localhost:8080/RestFull/rest/KompisarServiceX").build());
    
    public static void main(String[] args) throws IOException {
        //Hämta en kompis!
        String jsonKompis = service.path("kompisar/Fredde")
                .accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(jsonKompis);
        System.out.println();
        
        Kompisar kompis = new Gson().fromJson(jsonKompis, Kompisar.class);
        
    
    
    
    }
    }
}
    
    


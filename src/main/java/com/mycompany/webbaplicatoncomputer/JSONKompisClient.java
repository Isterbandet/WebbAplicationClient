
package com.mycompany.webbaplicatoncomputer;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
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
            UriBuilder.fromUri("http://localhost:8080/RestFull").build());
    
   
    private void sökKompis(String namn){
        //Hämta en kompis!
        String jsonKompis = service.path("rest/KompisarServiceX/kompisarJSON/" + namn)
                .accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(jsonKompis);
        System.out.println();
        
        Kompisar kompis = new Gson().fromJson(jsonKompis, Kompisar.class);
        System.out.println("Kompisens namn ;" + kompis.getNamn() + " nummer: "
        +kompis.getNummer()+ "\n");
        //return System.out.println("Succesfulkl");
    }
    public void addaEnKompis(){
        //Adda en kompis med post
       Kompisar kompis = new Kompisar("Rövungen", 133);
       
       ClientResponse response = service.path("rest/KompisarServiceX/kompisar/add")
               .accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, kompis);
       System.out.println("Response" + response.getEntity(String.class));
    }
    
    public void listaKompisar(){
         Gson gson = new Gson();
                
        //Hämta alla kompsiar
        String jsonString = service.path("rest/KompisarServiceX/kompisarJSON")
        .accept(MediaType.APPLICATION_JSON).get(String.class);
        
        Kompisar[] kompis = gson.fromJson(jsonString, Kompisar[].class);
        for (Kompisar k : kompis){
            System.out.println("Person" + k.getNamn() + "Nummreva" + k.getNummer() );
        }
    }
    public void tabortKompis(String kompis){
        //Ta bort en polare
        String jsonKompis = service.path("rest/KompisarServiceX/kompisarJSON/"+kompis+"/delete")
                .accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(kompis +"borttagen");
        
    
    
    
    }
    
    
    
    
    public static void main(String[] args) throws IOException {
        
       

        JSONKompisClient kompis = new JSONKompisClient();
        kompis.sökKompis("Freddan");//1
        
        kompis.listaKompisar();//5
        
        kompis.tabortKompis("Freddan");//4
        kompis.listaKompisar();//5
        kompis.addaEnKompis();
        
    
        
        
        
        
        
        
       
        
    
    }
    
}
  
   
    
    

    
    


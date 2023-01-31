package tp3_pe.tp_3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@SpringBootApplication
public class Tp3Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("vproxy.univ-lemans.fr", 3128));
        requestFactory.setProxy(proxy);

        return new RestTemplate(requestFactory);
    }


}

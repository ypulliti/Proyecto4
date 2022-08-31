import com.nttdata.bootcamp.bank.location.controller.Yanki;
import com.nttdata.bootcamp.bank.location.model.document.CoinBank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Date;

public class TestCoinBank
{
    Flux<CoinBank> source = Flux.just(new CoinBank("2","0002", "Test02", "Prueba 2", "None", "This is a test", new Date(), 120.0, 0.0, 0.0, "6"));
    Flux<CoinBank> source2 = Flux.just(new CoinBank("9","0009", "Test09", "Prueba 9", "None", "This is a test", new Date(), 120.0, 0.0, 0.0, "6"));

    @Autowired
    WebClient.Builder webClientBuilder;

    @Test
    public void shouldReturnForLettersUpperCaseStrings()
    {
        Yanki yanki = new Yanki(webClientBuilder);

        var result = yanki.getCoinBank("2");

        StepVerifier
                .create(source)
                .expectNextMatches(name -> name.getNameFirst().equals("Prueba 2"))
                .expectComplete()
                .verify();
    }
}

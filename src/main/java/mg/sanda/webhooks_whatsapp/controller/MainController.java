package mg.sanda.webhooks_whatsapp.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClient;

@Controller
@CrossOrigin("*")
public class MainController {

    private final String mainEndpoint = "https://graph.facebook.com/v17.0/178882625313110/messages";


    @GetMapping("/webhook")
    public ResponseEntity<Integer> webhookAuthentification(
            @RequestParam(name = "hub.verify_token") String token,
            @RequestParam(name = "hub.mode") String mode,
            @RequestParam(name = "hub.challenge") int challenge) {
        return ResponseEntity.ok(challenge);
    }

    @PostMapping("/webhook")
    public ResponseEntity<Object> response(@RequestBody Object bodyPayload) {
        RestClient graphAPI = RestClient.builder()
                .baseUrl(mainEndpoint)
                .defaultHeader("Authorization", "EAAMoG9OXI6UBO37XIeDBIP1GHthXVJdb2248qcQrU7PxzQNcOATnLVdxVCA5UkjdCHjrvuUL7waQSf7VdkgfSAm752Ufo2HR9XQ3J5oN62OhzReJxxEYC6qJx5iM2ybhODZAR3kkklTzp9qNeE5vAimAjz2AZBqydZCdZBVJphvRvpfhnktnqDXeBHZBxZBhe8HY0OfhqvuICrQZBRKKjaafI3ZAyu6n1ZAJ6hPwZD")
                .build();

        Object response = graphAPI.post()
                .body("{\"messaging_product\": \"whatsapp\","
                    +"\"to\": \"0346277634\""
                    +"\"text\": {\"body\" : \"hi\"}"
                   +"}")
                .retrieve();
            
        System.out.println(response);
        return ResponseEntity.ok(bodyPayload);
    }
}

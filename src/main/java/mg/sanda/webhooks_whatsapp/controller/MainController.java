package mg.sanda.webhooks_whatsapp.controller;

import java.util.Map;

import javax.print.attribute.standard.Media;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClient;

import mg.sanda.webhooks_whatsapp.utils.SimpleText;
import mg.sanda.webhooks_whatsapp.utils.WebhookReqPayload;

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
    public ResponseEntity<Object> response(@RequestBody Object bodyPayload) throws InterruptedException {
        System.out.println("Webhook engaged");
        
        String token = "EAAMoG9OXI6UBO37XIeDBIP1GHthXVJdb2248qcQrU7PxzQNcOATnLVdxVCA5UkjdCHjrvuUL7waQSf7VdkgfSAm752Ufo2HR9XQ3J5oN62OhzReJxxEYC6qJx5iM2ybhODZAR3kkklTzp9qNeE5vAimAjz2AZBqydZCdZBVJphvRvpfhnktnqDXeBHZBxZBhe8HY0OfhqvuICrQZBRKKjaafI3ZAyu6n1ZAJ6hPwZD";
        String endpoint = mainEndpoint + "?access_token=" + token;
        RestClient graphAPI = RestClient.builder()
                .baseUrl(endpoint)
                .build();

        SimpleText value = new SimpleText("Bonjour");
        
        WebhookReqPayload payload = new WebhookReqPayload("261346277634",value);
        
        ResponseEntity<Object> res = graphAPI.post()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(payload)
            .retrieve()
            .toEntity(Object.class);

        
        return ResponseEntity.ok(res);
    }
}

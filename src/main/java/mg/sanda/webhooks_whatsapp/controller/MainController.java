package mg.sanda.webhooks_whatsapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin("*")
public class MainController {
    
    @GetMapping("/webhook")
    public ResponseEntity<Integer> webhookAuthentification(
        @RequestParam(name = "hub.verify_token") String token,
        @RequestParam(name = "hub.mode") String mode,
        @RequestParam(name = "hub.challenge") int challenge
        ){
       return ResponseEntity.ok(challenge);     
    }

    @PostMapping("/webhook")
    public ResponseEntity<Object> response(@RequestBody Object bodyPayload){
        System.out.println(bodyPayload);
        return ResponseEntity.ok(bodyPayload);
    }
}

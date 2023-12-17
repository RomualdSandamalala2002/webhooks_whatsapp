package mg.sanda.webhooks_whatsapp.utils;

public class WebhookReqPayload {
    public String messaging_product = "whatsapp";

    private String to;

    private SimpleText text;

    public WebhookReqPayload(String to, SimpleText text) {
        this.to = to;
        this.text = text;
    }

    public String getMessaging_product() {
        return messaging_product;
    }

    public void setMessaging_product(String messaging_product) {
        this.messaging_product = messaging_product;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public SimpleText getText() {
        return text;
    }

    public void setText(SimpleText text) {
        this.text = text;
    }

    
}

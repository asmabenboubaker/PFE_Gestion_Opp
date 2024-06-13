package biz.picosoft.demo.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class JiraController {
    private final String jiraApiUrl = "https://boubaker-asma.atlassian.net";
    private final String jiraApiUsername = "asmaboubaker11@gmail.com";
    private final String jiraApiPassword = "ATATT3xFfGF0aBHlPC-aYy26raKkn1Fgt5L0nk3vC875zWzpgoXbkEhzCcRB9IrvDAFFjKEMcrig5zlUYUdsHA9nL9R_Xr7uERyviYHBdaN5LctIFXpwfX7TSopLHcj6kgeoDxRBt-bkC83U5H4ilhuy-X-YeogaKJ9FS03wCnSJjJwoEeNo1MA=1D906171";

    private final RestTemplate restTemplate = new RestTemplate();
    @CrossOrigin(origins="http://localhost.picosoft.biz:4302", allowCredentials = "true")
    @PostMapping("/create-project")
    public ResponseEntity<String> createProject(@RequestBody String projectJson) {
        HttpHeaders headers = createHeaders();
        HttpEntity<String> entity = new HttpEntity<>(projectJson, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                jiraApiUrl + "/rest/api/2/project/",
                HttpMethod.POST,
                entity,
                String.class
        );
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(jiraApiUsername, jiraApiPassword);
        headers.set("Content-Type", "application/json");
        return headers;
    }
}

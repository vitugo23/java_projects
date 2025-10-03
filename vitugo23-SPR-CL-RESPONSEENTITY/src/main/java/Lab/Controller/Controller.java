package Lab.Controller;

import Lab.Model.Sample;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/example401")
    public ResponseEntity example() {
        return ResponseEntity.status(401).body("Unauthorized resource!");
    }

    @GetMapping("/exampleHeaders")
    public ResponseEntity headers(@RequestBody Sample sample) {
        return ResponseEntity.status(200).header("content-type", "application/zip").body(sample);
    }

    /**
     * Returns a ResponseEntity with a 400 Bad Request status and "Bad Request" as the response body.
     */
    @GetMapping("/lab1")
    public ResponseEntity<String> lab1() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
    }

    /**
     * Returns a ResponseEntity with a 201 Created status, a "content-length" header of 100,
     * and the received Sample object in the response body.
     */
    @GetMapping("/lab2")
    public ResponseEntity<Sample> lab2(@RequestBody Sample sample) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("content-length", "100")
                .body(sample);
    }
}

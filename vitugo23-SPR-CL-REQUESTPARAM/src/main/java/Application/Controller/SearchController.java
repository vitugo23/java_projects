package Application.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @GetMapping(value = "cats", params = {"term"})
    public String getSearchTerm(@RequestParam String term){
        return term;
    }

    @GetMapping(value = "cats", params = {"term", "format"})
    public String[] getSearchTermAndPage(@RequestParam String term, @RequestParam String format){
        return new String[]{term, format};
    }

    /**
     * Extracts the numeric 'amount' query parameter from a request.
     * Example: GET localhost:9000/cats?amount=50 should return 50.
     */
    @GetMapping(value = "cats", params = {"amount"})
    public int getSearchFormat(@RequestParam int amount){
        return amount;
    }

    /**
     * Extracts the String 'format' and 'orderBy' query parameters from a request.
     * Example: GET localhost:9000/cats?format=gif&orderby=new should return {"gif", "new"}.
     */
    @GetMapping(value = "cats", params = {"format", "orderBy"})
    public String[] getSearchFormatAndAmount(@RequestParam String format, @RequestParam String orderBy){
        return new String[]{format, orderBy};
    }
}

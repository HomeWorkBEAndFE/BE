package vn.techzen.bai1.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.techzen.bai1.Model.DictionaryModel;
import java.util.HashMap;
import java.util.Map;
import vn.techzen.bai1.Dto.ApiResponse;

@RestController
public class DictionaryController {
    private Map<String, DictionaryModel> dictionaryMap = new HashMap<>();

    public DictionaryController() {
        addWord("Hello", "Xin chào");
        addWord("Goodbye", "Tạm biệt");
        addWord("Thank you", "Cảm ơn");
        addWord("Yes", "Có");
        addWord("No", "Không");
    }

    private void addWord(String english, String vietnamese) {
        DictionaryModel word = new DictionaryModel(english, vietnamese);
        dictionaryMap.put(english.toLowerCase(), word);
    }

    @GetMapping("/api/dictionary/search")
    public ResponseEntity<ApiResponse<?>> searchDictionary(@RequestParam(defaultValue = "") String vocabulary) {
        DictionaryModel foundWord = dictionaryMap.get(vocabulary.trim().toLowerCase());

        if (foundWord != null) {
            return ResponseEntity.ok().body(new ApiResponse<>(404, null, foundWord));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(404, "Không tìm thấy từ vựng được tra trong từ điển", null));
        }
    }

}

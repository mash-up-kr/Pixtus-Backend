package com.mashup.pixtus.pixtus.history;

import com.mashup.pixtus.pixtus.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;
    private final JwtService jwtService;

    @GetMapping("/history")
    public ResponseEntity getHistory(@RequestParam(defaultValue = "0") int prevWeek) {
        String uid = jwtService.getUid();
        return ResponseEntity.status(HttpStatus.OK).body(historyService.getHistory(uid, prevWeek));
    }
}

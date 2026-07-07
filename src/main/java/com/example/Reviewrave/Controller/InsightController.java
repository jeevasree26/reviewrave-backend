package com.example.Reviewrave.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Reviewrave.Entity.SentimentInsight;
import com.example.Reviewrave.Service.InsightService;

@RestController
@RequestMapping("/api/insights")
@CrossOrigin(origins = "http://localhost:3000")
public class InsightController {

    private  final InsightService insightService;

    public InsightController(InsightService insightService) {
        this.insightService = insightService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<SentimentInsight>
    getInsights(@PathVariable Long productId){

        return ResponseEntity.ok(
                insightService.getInsights(productId)
        );
    }

    @PostMapping("/generate/{productId}")
    public ResponseEntity<SentimentInsight>
    generateInsights(@PathVariable Long productId){

        return ResponseEntity.ok(
                insightService.generateInsights(productId)
        );
    }
}
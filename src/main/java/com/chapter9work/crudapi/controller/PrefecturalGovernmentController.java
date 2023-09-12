package com.chapter9work.crudapi.controller;

import com.chapter9work.crudapi.entity.PrefecturalGovernment;
import com.chapter9work.crudapi.service.PrefecturalGovernmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PrefecturalGovernmentController {

    //Controller -> Service -> Mapperの流れで処理を行う

    // PrefecturalGovernmentServiceという都道府県庁データに関するビジネスロジックを提供するサービスを注入
    private final PrefecturalGovernmentService prefecturalGovernmentService;

    // コンストラクタを使用してPrefecturalGovernmentServiceをインジェクト
    @Autowired
    public PrefecturalGovernmentController(PrefecturalGovernmentService prefecturalGovernmentService) {
        this.prefecturalGovernmentService = prefecturalGovernmentService;
    }

    //localhost:8080/names にアクセスするとDBに登録されている都道府県庁の名前をレスポンスとして返す。
    @GetMapping("/names")
    public List<String> names() {
        // prefecturalGovernmentServiceを使用して、すべての都道府県庁情報を取得
        List<PrefecturalGovernment> prefecturalGovernments = prefecturalGovernmentService.findAll();
        // 都道府県庁情報から都道府県庁の名前だけを抽出してリストにする
        List<String> response = prefecturalGovernments.stream().map(PrefecturalGovernment::getName).toList();
        return response;
    }

    //localhost:8080/prefecturalGovernments?postCode=060-8588 にアクセスするとDBに登録されている都道府県庁情報から
    //郵便番号が060-8588と一致する都道府県情報を取得する
    @GetMapping("/prefecturalGovernments")
    public ResponseEntity<String> getprefecturalGovernmentsByPostCode(@RequestParam("postCode") String postCode) {

        // prefecturalGovernmentServiceを使用して、指定された郵便番号にある都道府県庁を取得
        Optional<PrefecturalGovernment> prefecturalGovernment = prefecturalGovernmentService.findByPostCode(postCode);

        //都道府県庁が存在する場合はその名前を取得し、存在しない場合は空の配列を返す
        String prefecturalGovernmentName = prefecturalGovernment.map(PrefecturalGovernment::getName).orElse("");
        return ResponseEntity.ok(prefecturalGovernmentName);
    }
}

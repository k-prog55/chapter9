package com.chapter9work.crudapi.service;

import com.chapter9work.crudapi.entity.PrefecturalGovernment;

import java.util.List;
import java.util.Optional;

// PrefecturalGovernmentServiceインターフェース: 都道府県庁関連のデータを操作するためのメソッドを定義
public interface PrefecturalGovernmentService {

    //データベース内のすべての都道府県庁の情報を取得するメソッド
    List<PrefecturalGovernment> findAll();

    //指定された郵便番号の都道府県庁の情報を取得するメソッド
    Optional<PrefecturalGovernment> findByPostCode(String postCode);
}

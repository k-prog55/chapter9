package com.chapter9work.crudapi.service;

import com.chapter9work.crudapi.entity.PrefecturalGovernment;
import com.chapter9work.crudapi.mapper.PrefecturalGovernmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Spring Frameworkによるサービスクラスであることを示す
// PrefecturalGovernmentServiceImplクラス: PrefecturalGovernmentServiceインターフェースを実装し、実際のデータベース操作を行う
public class PrefecturalGovernmentServiceImpl implements PrefecturalGovernmentService {

    private final PrefecturalGovernmentMapper prefecturalGovernmentMapper;  // データベース操作用のMapperクラス

    // コンストラクタ: PrefecturalGovernmentMapperを自動的に注入
    @Autowired
    public PrefecturalGovernmentServiceImpl(PrefecturalGovernmentMapper prefecturalGovernmentMapper) {
        this.prefecturalGovernmentMapper = prefecturalGovernmentMapper;
    }

    // すべての都道府県庁情報を取得するメソッド
    @Override
    public List<PrefecturalGovernment> findAll() {
        return prefecturalGovernmentMapper.findAll(); // Mapperを使用してデータベースから映画情報を取得
    }

    // 指定された郵便番号の都道府県庁情報を取得するメソッド
    @Override
    public List<PrefecturalGovernment> findByPostCode(String postCode) {
        return prefecturalGovernmentMapper.findByPostCode(postCode);  // Mapperを使用して指定された年の映画情報を取得
    }
    
}

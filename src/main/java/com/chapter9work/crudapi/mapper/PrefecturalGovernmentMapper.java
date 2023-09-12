package com.chapter9work.crudapi.mapper;

import com.chapter9work.crudapi.entity.PrefecturalGovernment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PrefecturalGovernmentMapper {
    //データベース内の全ての都道府県庁データを取得するためのクエリ
    @Select("SELECT * FROM prefecturalGovernments")
    List<PrefecturalGovernment> findAll();  // 都道府県庁のリストを取得するfindAllメソッド。このメソッドを使うと、上記のSQLクエリが作動する

    //指定された郵便番号にある都道府県庁データを取得するためのクエリ
    @Select("SELECT * FROM prefecturalGovernments WHERE postCode = #{postCode}")
    Optional<PrefecturalGovernment> findByPostCode(@Param("postCode") String postCode);  // 郵便番号を指定して都道府県庁のリストを取得するfindByPostCodeメソッド
    // @Paramアノテーションを使用して、引数の名前（"postCode"）とSQLクエリ内のプレースホルダ（#{postCode}）を関連付ける。
    // 引数の名前（"postCode"）＝　@Paramアノテーション内のpostCode　=　SQLクエリ内のプレースホルダ（#{postCode}）となるようにコードを書く。

}

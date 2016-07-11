package com.example.qiang.myhttp.dao;

import android.content.Context;

import com.example.qiang.myhttp.entity.ProductItem;
import com.example.qiang.myhttp.utils.UIUtils;


public class ProductDao extends DaoSuper<ProductItem>{
    public ProductDao(Context context) {
        super(context);
    }


    private  static ProductDao dao;
    public static ProductDao getDao(){
        if(dao==null){
            dao=new ProductDao(UIUtils.getContext());
        }
        return dao;
    }
}

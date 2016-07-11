package com.example.qiang.myhttp.entity;


import com.example.qiang.myhttp.Base.BaseDao;
import com.example.qiang.myhttp.dao.ProductDao;
import com.example.qiang.myhttp.dao.annotation.ColmanName;
import com.example.qiang.myhttp.dao.annotation.TableName;
import com.example.qiang.myhttp.dao.annotation.TablePrimaryKey;

@TableName("product")
public class ProductItem extends BaseDao {


    @ColmanName("_id")
    @TablePrimaryKey(isautocurment=true)
    public int id;
    //产品id
    @ColmanName("product_id")
    public String product_id;
    //名字
    @ColmanName("product_name")
    public String product_name;
    //预估数
    @ColmanName("product_number")
    public String product_number;
    //图片url
    @ColmanName("product_picture")
    public String product_picture;
    //当前价格
    @ColmanName("product_price")
    public String product_price;
    //分类id
    @ColmanName("product_category")
    public String product_category;

    @ColmanName("product_sort")
    public String product_sort;
    // 是否显示特价图标
    @ColmanName("product_whether")
    public String product_whether;
    // 团购数量
    @ColmanName("product_tuangou")
    public String product_tuangou;
    // 预购数量
    @ColmanName("product_yugu")
    public String product_yugu;
    // 重量
    @ColmanName("product_guige")
    public String product_guige;

    // 特价
    @ColmanName("product_special")
    public String product_special;

    public ProductItem() {
    }

    public ProductItem(String product_id, String product_name, String product_number, String
            product_picture, String product_price, String product_category, String product_sort,
                       String product_whether, String product_tuangou, String product_yugu,
                       String product_guige, String product_special) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_number = product_number;
        this.product_picture = product_picture;
        this.product_price = product_price;
        this.product_category = product_category;
        this.product_sort = product_sort;
        this.product_whether = product_whether;
        this.product_tuangou = product_tuangou;
        this.product_yugu = product_yugu;
        this.product_guige = product_guige;
        this.product_special = product_special;
    }

    /**
     * 从数据库删除
     */
    public void del(){
        ProductDao dao= ProductDao.getDao();
        dao.delete(this);
    }

}

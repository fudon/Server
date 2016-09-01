package FJModel;

import com.fuhope.ssm.po.GoodsCustom;
import com.fuhope.ssm.po.ShopcarCustom;

public class ShopcarModel {
		
	private GoodsCustom		    goodsCustom;
	private ShopcarCustom 		shopcarCustom;
	
	public GoodsCustom getGoodsCustom() {
		return goodsCustom;
	}
	public void setGoodsCustom(GoodsCustom goodsCustom) {
		this.goodsCustom = goodsCustom;
	}
	public ShopcarCustom getShopcarCustom() {
		return shopcarCustom;
	}
	public void setShopcarCustom(ShopcarCustom shopcarCustom) {
		this.shopcarCustom = shopcarCustom;
	}
	
}

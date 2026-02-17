package com.cg.topic18.hibernate.annotation.common;

import com.mkyong.stock.model.Stock;

public interface StockBo {
	
	void save(Stock stock);
	
	void update(Stock stock);
	
	void delete(Stock stock);
	
	Stock findByStockCode(String stockCode);

}

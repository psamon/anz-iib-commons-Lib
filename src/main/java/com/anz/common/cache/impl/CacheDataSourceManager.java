/**
 * 
 */
package com.anz.common.cache.impl;

import com.anz.common.cache.ICacheDataSource;
import com.anz.common.cache.bean.CachePojoSample;
import com.anz.common.cache.data.DataSourceSample;

/**
 * Factory of the all the datasources and decides which one to call based on the cacheable object class
 * @author sanketsw
 *
 */
public class CacheDataSourceManager {

	/**
	 * Factory method to instantiate right data source for cache
	 * @param cacheablePojoClass
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static ICacheDataSource getCacheDataSource(Class cacheablePojoClass) {
		if(cacheablePojoClass.equals(CachePojoSample.class)) {
			return new DataSourceSample();
		}
		return null;
	}


}

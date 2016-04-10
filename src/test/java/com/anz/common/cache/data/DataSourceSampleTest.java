/**
 * 
 */
package com.anz.common.cache.data;

import static org.junit.Assert.*;

import java.awt.image.SampleModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.anz.common.cache.ICacheableObject;
import com.anz.common.cache.bean.CachePojoSample;
import com.anz.common.cache.impl.CacheManager;

/**
 * @author root
 * 
 */
public class DataSourceSampleTest {

	DataSourceSample ds;

	CachePojoSample obj;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ds = new DataSourceSample();
		obj = (CachePojoSample) ds.getObjectFromSource("SamppleMap",
				"SampleKey", CachePojoSample.class);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.anz.common.cache.data.DataSourceSample#getObjectFromSource(java.lang.String, java.lang.String, java.lang.Class)}
	 * .
	 */
	@Test
	public void testGetObjectFromSource() {
		assertNotNull(obj);
		assertEquals("SampleKey", obj.getKey());
	}

}

/**
 * 
 */
package com.anz.common.error;

import java.util.Date;
import java.util.Properties;

import com.anz.common.compute.ComputeInfo;
import com.anz.common.dataaccess.models.iib.ErrorStatusCode;
import com.ibm.broker.config.proxy.BrokerProxy;
import com.ibm.broker.config.proxy.ConfigManagerProxyLoggedException;
import com.ibm.broker.config.proxy.ConfigManagerProxyPropertyNotInitializedException;
import com.ibm.broker.config.proxy.ConfigurableService;


/**
 * @author root
 *
 */
public class ExceptionMessage {
	
	ErrorStatusCode status;
	
	ServiceInfo service;
	
	BrokerInfo broker;
	
	String shortException;
	
	Date timestamp;
	
	String message;

	/**
	 * @return the status
	 */
	public ErrorStatusCode getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ErrorStatusCode status) {
		this.status = status;
	}

	/**
	 * @return the service
	 */
	public ServiceInfo getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(ServiceInfo service) {
		this.service = service;
	}

	/**
	 * @return the broker
	 */
	public BrokerInfo getBroker() {
		return broker;
	}

	/**
	 * @param broker the broker to set
	 */
	public void setBroker(BrokerInfo broker) {
		this.broker = broker;
	}

	/**
	 * @return the shortException
	 */
	public String getShortException() {
		return shortException;
	}

	/**
	 * @param shortException the shortException to set
	 */
	public void setShortException(String shortException) {
		this.shortException = shortException;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public void setBrokerAndServiceDetails(ComputeInfo metadata) {
		BrokerInfo broker = new BrokerInfo();
		broker.setBrokerName(metadata.getBroker().getName());
		broker.setQueueManagerName(metadata.getBroker().getQueueManagerName());
		setBroker(broker);
		
		ServiceInfo service = new ServiceInfo();
		service.setMessageFlowName(metadata.getMessageFlow().getName());
		service.setServiceName(metadata.getMessageFlow().getApplicationName());
		setService(service);
		
	}

	public void setStaticProperties() throws ConfigManagerProxyLoggedException, InterruptedException, ConfigManagerProxyPropertyNotInitializedException {
		
		BrokerProxy b = BrokerProxy.getLocalInstance();
		while(!b.hasBeenPopulatedByBroker()) { Thread.sleep(100); } 
		ConfigurableService myUDCS = b.getConfigurableService("UserDefined", "NodeProperties");
		Properties props = myUDCS.getProperties();
		
		String region = props.getProperty("Region");
		getBroker().setRegion(region);
	}	
	

}


package com.example.deliverymoment.domain;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.deliverymoment.validator.CheckDateFormat;
import com.example.deliverymoment.validator.CheckDelivererValid;
import com.example.deliverymoment.validator.CheckStoreNumberValid;
import com.example.deliverymoment.validator.CheckStreamNumberValid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({ "id", "storenumber", "streamnumber", "deliveryDateTime", "orderDateTime", "totalOrderQuantity",
		"delivererNumber", "warehouseNumber" })
@Valid
public class DeliveryMoment {
	
	@JsonProperty("id")
	@JsonPropertyDescription("")
	private String id;

	@JsonProperty("storenumber")
	@JsonPropertyDescription("")
	@NotNull()
	@CheckStoreNumberValid
	private Integer storenumber;

	@JsonProperty("streamnumber")
	@JsonPropertyDescription("")
	@NotNull()
	@CheckStreamNumberValid
	private Integer streamnumber;

	@JsonProperty("deliveryDateTime")
	@JsonPropertyDescription("")
	@NotNull()
	@CheckDateFormat
	private String deliveryDateTime;

	@JsonProperty("orderDateTime")
	@JsonPropertyDescription("")
	@NotNull()
	@CheckDateFormat(message = "Order Date Time not specified in Specified format")
	private String orderDateTime;

	@JsonProperty("totalOrderQuantity")
	@JsonPropertyDescription("")
	private Integer totalOrderQuantity;

	@JsonProperty("delivererNumber")
	@JsonPropertyDescription("")
	@NotNull()
	@CheckDelivererValid
	private Integer delivererNumber;
	
	@JsonProperty("storenumber")
	public Integer getStorenumber() {
		return storenumber;
	}
	
	@JsonProperty("storeOrder")
	@NotNull()
	private List<StoreOrder> storeOrder;
	

	public List<StoreOrder> getStoreOrder() {
		return storeOrder;
	}

	@JsonProperty("storeOrder")
	public void setStoreOrder(List<StoreOrder> storeOrder) {
		this.storeOrder = storeOrder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("storenumber")
	public void setStorenumber(Integer storenumber) {
		this.storenumber = storenumber;
	}

	public DeliveryMoment withStorenumber(Integer storenumber) {
		this.storenumber = storenumber;
		return this;
	}

	@JsonProperty("streamnumber")
	public Integer getStreamnumber() {
		return streamnumber;
	}

	@JsonProperty("streamnumber")
	public void setStreamnumber(Integer streamnumber) {
		this.streamnumber = streamnumber;
	}

	public DeliveryMoment withStreamnumber(Integer streamnumber) {
		this.streamnumber = streamnumber;
		return this;
	}
	
	@JsonProperty("deliveryDateTime")
	public String getDeliveryDateTime() {
		return deliveryDateTime;
	}

	@JsonProperty("deliveryDateTime")
	public void setDeliveryDateTime(String deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}

	public DeliveryMoment withDeliveryDateTime(String deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
		return this;
	}

	@JsonProperty("orderDateTime")
	public String getOrderDateTime() {
		return orderDateTime;
	}

	@JsonProperty("orderDateTime")
	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public DeliveryMoment withOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
		return this;
	}

	@JsonProperty("totalOrderQuantity")
	public Integer getTotalOrderQuantity() {
		return totalOrderQuantity;
	}

	@JsonProperty("totalOrderQuantity")
	public void setTotalOrderQuantity(Integer totalOrderQuantity) {
		this.totalOrderQuantity = totalOrderQuantity;
	}

	public DeliveryMoment withTotalOrderQuantity(Integer totalOrderQuantity) {
		this.totalOrderQuantity = totalOrderQuantity;
		return this;
	}

	@JsonProperty("delivererNumber")
	public Integer getDelivererNumber() {
		return delivererNumber;
	}

	@JsonProperty("delivererNumber")
	public void setDelivererNumber(Integer delivererNumber) {
		this.delivererNumber = delivererNumber;
	}

	public DeliveryMoment withDelivererNumber(Integer delivererNumber) {
		this.delivererNumber = delivererNumber;
		return this;
	}

}

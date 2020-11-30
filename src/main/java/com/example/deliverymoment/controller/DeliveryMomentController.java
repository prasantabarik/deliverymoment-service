package com.example.deliverymoment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.deliverymoment.domain.DeliveryMoment;
import com.example.deliverymoment.service.DeliveryMomentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Delivery Moment Service", value = "API for CRUD for Deliver yMoment.")
@RequestMapping("/deliveryMoment/v1")
@Validated
public class DeliveryMomentController {

	@Autowired
	DeliveryMomentService service;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "CREATE Delivery Moment API", notes = "CREATE Delivery Moment API", response = DeliveryMoment.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The request has succeeded"),
			@ApiResponse(code = 400, message = "Invalid request : The request could not be understood by the server due to malformed syntax. ", response = String.class),
			@ApiResponse(code = 500, message = "Internal Error. ", response = String.class) })

	public ResponseEntity<DeliveryMoment> createDeliveryMoment(HttpServletRequest httpRequest,
			@Valid @RequestBody(required = true) DeliveryMoment deliveryMoment, HttpServletResponse httpResponse)
			throws Exception {

		return ResponseEntity.ok(service.createDeliveryMoment(deliveryMoment));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Update Delivery Moment API", notes = "Update Delivery Moment API", response = DeliveryMoment.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The request has succeeded"),
			@ApiResponse(code = 400, message = "Invalid request : The request could not be understood by the server due to malformed syntax. ", response = String.class),
			@ApiResponse(code = 500, message = "Internal Error. ", response = String.class) })

	public ResponseEntity<DeliveryMoment> updateDeliveryMoment(HttpServletRequest httpRequest,
			@PathVariable(name = "id", required = true) String id,
			@Valid @RequestBody(required = true) DeliveryMoment deliveryMoment, HttpServletResponse httpResponse)
			throws Exception {

		return ResponseEntity.ok(service.updateDeliveryMoment(id, deliveryMoment));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Delivery Moment API", notes = "Delete Delivery Moment API", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The request has succeeded"),
			@ApiResponse(code = 400, message = "Invalid request : The request could not be understood by the server due to malformed syntax. ", response = String.class),
			@ApiResponse(code = 500, message = "Internal Error. ", response = String.class) })

	public ResponseEntity<String> deleteDeliveryMoment(HttpServletRequest httpRequest,
			@PathVariable(name = "id", required = true) String id, HttpServletResponse httpResponse) throws Exception {
		return ResponseEntity.ok(service.deleteDeliveryMoment(id));
	}

	@RequestMapping(value="/findBy",method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "GET Delivery Moment API", notes = "GET  Delivery Moment API", response = DeliveryMoment.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The request has succeeded"),
			@ApiResponse(code = 400, message = "Invalid request : The request could not be understood by the server due to malformed syntax. ", response = String.class),
			@ApiResponse(code = 500, message = "Internal Error. ", response = String.class) })

	public ResponseEntity<List<DeliveryMoment>> getDeliveryMoment(HttpServletRequest httpRequest,
			@RequestParam(name = "storenumber", required = true) String storenumber,
			@RequestParam(name = "streamnumber", required = false) String streamnumber,
			@RequestParam(name = "delivererNumber", required = false) String delivererNumber,
			HttpServletResponse httpResponse) throws Exception {

		return ResponseEntity.ok(service.findDeliveryMoment(storenumber, streamnumber, delivererNumber));
	}

}

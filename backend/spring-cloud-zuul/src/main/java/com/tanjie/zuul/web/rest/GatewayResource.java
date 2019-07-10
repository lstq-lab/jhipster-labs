/**
 * GatewayResource.java 2019年6月19日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.zuul.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanjie.zuul.security.AuthoritiesConstants;
import com.tanjie.zuul.web.rest.vm.RouteVM;



/**
 * REST controller for managing Gateway configuration.
 */
@RestController
@RequestMapping("/api/gateway")
public class GatewayResource {
	private final RouteLocator routeLocator;

	private final DiscoveryClient discoveryClient;

	public GatewayResource(RouteLocator routeLocator, DiscoveryClient discoveryClient) {
		this.routeLocator = routeLocator;
		this.discoveryClient = discoveryClient;
	}

	/**
	 * {@code GET  /routes} : get the active routes.
	 *
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
	 *         the list of routes.
	 */
	@GetMapping("/routes")
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<List<RouteVM>> activeRoutes() {
		List<Route> routes = routeLocator.getRoutes();
		List<RouteVM> routeVMs = new ArrayList<>();
		routes.forEach(route -> {
			RouteVM routeVM = new RouteVM();
			routeVM.setPath(route.getFullPath());
			routeVM.setServiceId(route.getId());
			routeVM.setServiceInstances(discoveryClient.getInstances(route.getLocation()));
			routeVMs.add(routeVM);
		});
		return ResponseEntity.ok(routeVMs);
	}
}

package com.rudolfschmidt.http;

import java.net.URI;
import java.net.URISyntaxException;

public class UriBuilder {

	private final String initial;
	private Parameters parameters;

	private UriBuilder(String initial) {
		this.initial = initial;
	}

	public static UriBuilder from(String initial) {
		return new UriBuilder(initial);
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	public String asString() {
		return initial + (parameters != null && parameters.size() > 0 ? "?" + parameters.encode().format("%s=%s", "&") : "");
	}

	public URI asURI() throws URISyntaxException {
		return new URI(asString());
	}

}

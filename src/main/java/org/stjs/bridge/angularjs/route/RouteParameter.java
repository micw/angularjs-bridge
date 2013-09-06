package org.stjs.bridge.angularjs.route;

import org.stjs.javascript.Array;
import org.stjs.javascript.Map;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.annotation.SyntheticType;

@STJSBridge
@SyntheticType
public final class RouteParameter {
	public String templateUrl;
	public String redirectTo;
	public Array<?> controller;
	public Map<String, ?> resolve;
	public boolean reloadOnSearch;
}

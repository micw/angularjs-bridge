package org.stjs.bridge.angularjs;

import org.stjs.javascript.Array;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback2;

/**
 * # ng (core module)
 * The ng module is loaded by default when an AngularJS application is started. The module itself
 * contains the essential components for an AngularJS application to function. The table below
 * lists a high level breakdown of each of the services/factories, filters, directives and testing
 * components available within this core module.
 * 
 * {@link https://code.angularjs.org/1.4.3/docs/api/ng}
 * 
 * Compatible with angular 1.4.3
 */
public final class Angular {

    /**
     * Returns a function which calls function `fn` bound to `self` (`self` becomes the `this` for
     * `fn`). You can supply optional `args` that are prebound to the function. This feature is also
     * known as [partial application](http://en.wikipedia.org/wiki/Partial_application), as
     * distinguished from [function currying](http://en.wikipedia.org/wiki/Currying#Contrast_with_partial_function_application).
     *
     * @param {Object} self Context which `fn` should be evaluated in.
     * @param {function()} fn Function to be bound.
     * @param {...*} args Optional arguments to be prebound to the `fn` function call.
     * @returns {function()} Function that wraps the `fn` with all the specified bindings.
     * 
     * @param self Context which `fn` should be evaluated in.
     * @param fn   Function to be bound.
     * @param args Optional arguments to be prebound to the `fn` function call.
     * @return Function that wraps the `fn` with all the specified bindings.
     */
	public native <F> F bind(Object self, Object fn, Object... args);

	/**
     * Use this function to manually start up angular application.
     *
     * See: {@link guide/bootstrap Bootstrap}
     *
     * Note that Protractor based end-to-end tests cannot use this function to bootstrap manually.
     * They must use {@link ng.directive:ngApp ngApp}.
     *
     * Angular will detect if it has been loaded into the browser more than once and only allow the
     * first loaded script to be bootstrapped and will report a warning to the browser console for
     * each of the subsequent scripts. This prevents strange results in applications, where otherwise
     * multiple instances of Angular try to work on the DOM.
     *
     * ```html
     * <!doctype html>
     * <html>
     * <body>
     * <div ng-controller="WelcomeController">
     *   {{greeting}}
     * </div>
     *
     * <script src="angular.js"></script>
     * <script>
     *   var app = angular.module('demo', [])
     *   .controller('WelcomeController', function($scope) {
     *       $scope.greeting = 'Welcome!';
     *   });
     *   angular.bootstrap(document, ['demo']);
     * </script>
     * </body>
     * </html>
     * ```
     *
     * @param {DOMElement} element DOM element which is the root of angular application.
     * @param {Array<String|Function|Array>=} modules an array of modules to load into the application.
     *     Each item in the array should be the name of a predefined module or a (DI annotated)
     *     function that will be invoked by the injector as a `config` block.
     *     See: {@link angular.module modules}
     * @param {Object=} config an object for defining configuration options for the application. The
     *     following keys are supported:
     *
     * * `strictDi` - disable automatic function annotation for the application. This is meant to
     *   assist in finding bugs which break minified code. Defaults to `false`.
     *
     * @returns {auto.$injector} Returns the newly created injector for this app.
	 */
    public native Injector bootstrap(Element element, Object... modules);
    public native Injector bootstrap(Element element, Object[] modules, Object[] config);

	public native <T> T copy(T source);

	public native <T> T copy(T source, T destination);

	public native <T extends AngularJQueryCore<T>> T element(Element element);

	public native <T extends AngularJQueryCore<T>> T element(String selector);

	public native boolean equals(Object o1, Object o2);

	public native <T> T extend(T destination, Object... sources);

	public native <T> Array<T> forEach(Array<T> list, Callback2<T, Integer> iterator);

	public native <T> Array<T> forEach(Array<T> list, Callback2<T, Integer> iterator, Object context);

	public native <T> T forEach(T list, Callback2<Object, String> iterator);

	public native <T> T forEach(T list, Callback2<Object, String> iterator, Object context);

	public native <T> T fromJson(String json);

	/**
	 * A function that returns its first argument. This function is useful when writing code in the
	 * functional style.
	 *
	   ```js
	     function transformer(transformationFn, value) {
	       return (transformationFn || angular.identity)(value);
	     };
	   ```
	  * @param {*} value to be returned.
	  * @returns {*} the value passed in.
	  **/
	public native <T> T identity(T value);

    public native Injector injector(Object... modules);
    public native Injector injector(Object[] modules, boolean strictDi);

	public native boolean isElement(Object object);

	public native boolean isArray(Object object);

	public native boolean isObject(Object object);

	public native boolean isFunction(Object object);

	public native boolean isString(Object object);

	public native boolean isNumber(Object object);

	public Mock mock;

	/**
     * The `angular.module` is a global place for creating, registering and retrieving Angular
     * modules.
     * All modules (angular core or 3rd party) that should be available to an application must be
     * registered using this mechanism.
     *
     * When passed two or more arguments, a new module is created.  If passed only one argument, an
     * existing module (the name passed as the first argument to `module`) is retrieved.
     *
     *
     * # Module
     *
     * A module is a collection of services, directives, controllers, filters, and configuration information.
     * `angular.module` is used to configure the {@link auto.$injector $injector}.
     *
     * ```js
     * // Create a new module
     * var myModule = angular.module('myModule', []);
     *
     * // register a new service
     * myModule.value('appName', 'MyCoolApp');
     *
     * // configure existing services inside initialization blocks.
     * myModule.config(['$locationProvider', function($locationProvider) {
     *   // Configure existing providers
     *   $locationProvider.hashPrefix('!');
     * }]);
     * ```
     *
     * Then you can create an injector and load your modules like this:
     *
     * ```js
     * var injector = angular.injector(['ng', 'myModule'])
     * ```
     *
     * However it's more likely that you'll just use
     * {@link ng.directive:ngApp ngApp} or
     * {@link angular.bootstrap} to simplify this process for you.
     *
     * @param {!string} name The name of the module to create or retrieve.
     * @param {!Array.<string>=} requires If specified then new module is being created. If
     *     unspecified then the module is being retrieved for further configuration.
     * @param {Function=} configFn Optional configuration function for the module. Same as
     *     {@link angular.Module#config Module#config()}.
     * @returns {module} new module with the {@link angular.Module} api.
	 */
	public native Module module(String name, String... requires);

	public native Module module(String name, String[] requires, Object configFn);

	public native boolean isUndefined(Object object);

	public native boolean isDefined(Object object);

	public native boolean isDate(Object object);

	public native String lowercase(String s);

	public native void noop();
	
	/**
	 * Use this function to reload the current application with debug information turned on.
	 * This takes precedence over a call to $compileProvider.debugInfoEnabled(false).
	 */
	public native void reloadWithDebugInfo();

	public native String toJson(Object obj);

	public native String toJson(Object obj, boolean pretty);

	public native String uppercase(String s);

	public AngularVersion version;
}

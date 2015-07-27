package org.stjs.bridge.angularjs;

import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.annotation.JavascriptFunction;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.annotation.SyntheticType;
import org.stjs.javascript.annotation.Template;
import org.stjs.javascript.functions.Callback;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.functions.Callback3;
import org.stjs.javascript.functions.Function3;
import org.stjs.javascript.jquery.JQueryCore;

/********* Directive ********/

@SyntheticType
@STJSBridge
/**
 * {@link https://code.angularjs.org/1.4.3/docs/api/ng/service/$compile#directive-definition-object}
 * 
 * TODO: complete properties
 * 
 */
public class Directive {
    
    /**
     * When this property is set to true, the HTML compiler will collect DOM nodes between nodes with the attributes
     * directive-name-start and directive-name-end, and group them together as the directive elements. It is recommended
     * that this feature be used on directives which are not strictly behavioural (such as ngClick), and which do not
     * manipulate or replace child nodes (such as ngInclude).
     */
    public Boolean multiElement;
    
    /**
     * When there are multiple directives defined on a single DOM element, sometimes it is necessary to specify the order
     * in which the directives are applied. The priority is used to sort the directives before their compile functions get
     * called. Priority is defined as a number. Directives with greater numerical priority are compiled first. Pre-link
     * functions are also run in priority order, but post-link functions are run in reverse order. The order of directives
     * with the same priority is undefined. The default priority is 0.
     */
    public Integer priority;
    
    /**
     * If set to true then the current priority will be the last set of directives which will execute (any directives at the
     * current priority will still execute as the order of execution on same priority is undefined). Note that expressions and
     * other directives used in the directive's template will also be excluded from execution.
     */
    public Boolean terminal;
    
	public String require;
	
	/**
	 * String of subset of EACM which restricts the directive to a specific directive declaration style. If omitted, the
	 * defaults (elements and attributes) are used.
     *
     * E - Element name (default): <my-directive></my-directive>
     * A - Attribute (default): <div my-directive="exp"></div>
     * C - Class: <div class="my-directive: exp;"></div>
     * M - Comment: <!-- directive: my-directive exp -->
	 */
	public String restrict;
	
	/**
	 * If set to true, then a new scope will be created for this directive. If multiple directives on the same element request a new scope,
	 * only one new scope is created. The new scope rule does not apply for the root of the template since the root of the template always gets a new scope.
     *
     * If set to {} (object hash), then a new "isolate" scope is created. The 'isolate' scope differs from normal scope in that it does not prototypically
     * inherit from the parent scope. This is useful when creating reusable components, which should not accidentally read or modify data in the parent scope.
     * 
     * The 'isolate' scope takes an object hash which defines a set of local scope properties derived from the parent scope. These local properties are useful
     * for aliasing values for templates. Locals definition is a hash of local scope property to its source:
     *
     *     @ or @attr - bind a local scope property to the value of DOM attribute. The result is always a string since DOM attributes are
     *                  strings. If no attr name is specified then the attribute name is assumed to be the same as the local name. Given
     *                  <widget my-attr="hello {{name}}"> and widget definition of scope: { localName:'@myAttr' }, then widget scope property
     *                  localName will reflect the interpolated value of hello {{name}}. As the name attribute changes so will the localName
     *                  property on the widget scope. The name is read from the parent scope (not component scope).
     *     = or =attr - set up bi-directional binding between a local scope property and the parent scope property of name defined via the value
     *                  of the attr attribute. If no attr name is specified then the attribute name is assumed to be the same as the local name.
     *                  Given <widget my-attr="parentModel"> and widget definition of scope: { localModel:'=myAttr' }, then widget scope property
     *                  localModel will reflect the value of parentModel on the parent scope. Any changes to parentModel will be reflected in
     *                  localModel and any changes in localModel will reflect in parentModel. If the parent scope property doesn't exist,
     *                  it will throw a NON_ASSIGNABLE_MODEL_EXPRESSION exception. You can avoid this behavior using =? or =?attr in order to
     *                  flag the property as optional. If you want to shallow watch for changes (i.e. $watchCollection instead of $watch) you
     *                  can use =* or =*attr (=*? or =*?attr if the property is optional).
     *     & or &attr - provides a way to execute an expression in the context of the parent scope. If no attr name is specified then the attribute
     *                  name is assumed to be the same as the local name. Given <widget my-attr="count = count + value"> and widget definition of
     *                  scope: { localFn:'&myAttr' }, then isolate scope property localFn will point to a function wrapper for the count = count + value
     *                  expression. Often it's desirable to pass data from the isolated scope via an expression to the parent scope, this can be
     *                  done by passing a map of local variable names and values into the expression wrapper fn. For example, if the expression is
     *                  increment(amount) then we can specify the amount value by calling the localFn as localFn({amount: 22}).
	 */
    @Template("toProperty")
    public native void scope(Boolean scope);
    @Template("toProperty")
    public native void scope(Map<String, String> scope);
    @Template("toProperty")
    public native Object scope();
	
    public Function3<JQueryCore<JQueryCore<?>>, ? extends Attributes, Callback2<? extends Scope, ?>, ?> compile;
	
    /**
     * This property is used only if the compile property is not defined.
     * The link function is responsible for registering DOM listeners as well as updating the DOM. It is executed after the template has been cloned.
     * This is where most of the directive logic will be put.
     * 
     * scope        - Scope - The scope to be used by the directive for registering watches.
     * Element      - instance element - The element where the directive is to be used. It is safe to manipulate the children of the element only in postLink
     *                function since the children have already been linked.
     * Attrs        - instance attributes - Normalized list of attributes declared on this element shared
     *                between all directive linking functions.
     * controller   - the directive's required controller instance(s) - Instances are shared among all directives, which allows the directives to use the
     *                controllers as a communication channel. The exact value depends on the directive's require property:
     *                - no controller(s) required: the directive's own controller, or undefined if it doesn't have one
     *                - string: the controller instance
     *                - array: array of controller instances
     *                If a required controller cannot be found, and it is optional, the instance is null, otherwise the Missing Required Controller error is thrown.
     *                Note that you can also require the directive's own controller - it will be made available like like any other controller.
     * transcludeFn - A transclude linking function pre-bound to the correct transclusion scope. This is the same as the $transclude parameter of directive controllers,
     *                see there for details. function([scope], cloneLinkingFn, futureParentElement).
     */
    @Template("toProperty")
    public native void link(DirectiveLinkCallback5<?,?,?> link);

    @Template("toProperty")
    public native void link(DirectiveLinkCallback3<?> link);
    
    @Template("toProperty")
    public native Callback link();	
	
	public String template;
	public String templateUrl;
	
	@JavascriptFunction
    public static interface DirectiveLinkCallback5<
        ScopeType extends Scope,
        ControllerType extends Object,
        TranscludeFnType extends Callback3<?, ?, ?>
        >
        extends Callback
    {
	    @Template("invoke")
        void $invoke(ScopeType scope, JQueryCore<JQueryCore<?>> element, Attributes attributes, ControllerType controller, TranscludeFnType transcludeFn);
    }
    
    @JavascriptFunction
    public static interface DirectiveLinkCallback3<ScopeType extends Scope>
        extends Callback
    {
        @Template("invoke")
        void $invoke(ScopeType scope, JQueryCore<JQueryCore<?>> element, Attributes attributes);
    }
	
}

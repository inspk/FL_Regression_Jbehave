package com.hhstechgroup.ui.panels.builder;

import com.hhstechgroup.ui.pages.AbstractPage;
import com.hhstechgroup.ui.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import java.awt.*;
import java.awt.event.InputEvent;

import static java.lang.String.format;

public class BuilderBody extends AbstractPanel {

    private static final String FIELD_ELEMENT = ".//div[contains(@class,'add-buttons-panel_add') and span[text() = 'field']]";
    private static final String GROUP_ELEMENT = ".//div[contains(@class,'add-buttons-panel_add') and span[text() = 'group']]";
    private static final String SECTION_ELEMENT = ".//div[contains(@class,'add-buttons-panel_add') and span[text() = 'section']]";
    private static final String NEW_ELEMENTS_AREA = ".//div[contains(@class,'structure_app_drop_zone')]/div[contains(@class,'drop-zone-group_wrapper')]/div";
    private static final String NEW_GROUP_ELEMENTS_AREA = ".//div[contains(@class, 'level_2') and .//*[text()='%s']]/..//div[contains(@class, 'drop-zone_center')]";
    private static final String NAME = ".//div[contains(@class,'name-plate_name_')]//*[text() = '%s']";
    private static final String NEW_NAME_TEXTAREA = ".//div[contains(@class,'name-plate_label_')]/textarea";
    private static final String ELEMENT_SETTINGS_PANEL = ".//div[contains(@class,'content_builder_')]";

    public BuilderBody(WebElementFacade panelBaseLocation, AbstractPage basePage) {
        super(panelBaseLocation, basePage);
    }

    public void addNewFieldElement() {
        dragAndDrop(FIELD_ELEMENT, NEW_ELEMENTS_AREA);
    }

    public void addNewGroupElement() {
        dragAndDrop(GROUP_ELEMENT, NEW_ELEMENTS_AREA);
    }


    public void addNewFieldToGroup(String groupName) {
        dragAndDrop(FIELD_ELEMENT, format(NEW_GROUP_ELEMENTS_AREA, groupName));
    }

    private void dragAndDrop(String draggableElement, String dropElement) {
        String field = getWebCSSSelector(draggableElement);
        String fileContents = "!function t(e,r,n){function a(i,u){if(!r[i]){if(!e[i]){var s=\"function\"==typeof require&&require;if(!u&&s)return s(i,!0);if(o)return o(i,!0);var c=new Error(\"Cannot find module '\"+i+\"'\");throw c.code=\"MODULE_NOT_FOUND\",c}var f=r[i]={exports:{}};e[i][0].call(f.exports,function(t){var r=e[i][1][t];return a(r?r:t)},f,f.exports,t,e,r,n)}return r[i].exports}for(var o=\"function\"==typeof require&&require,i=0;i<n.length;i++)a(n[i]);return a}({1:[function(t,e,r){var n=t(\"./src/index.js\");\"function\"==typeof define&&define(\"dragMock\",function(){return n}),window.dragMock=n},{\"./src/index.js\":5}],2:[function(t,e,r){function n(t,e){var r=t.indexOf(e);r>=0&&t.splice(r,1)}var a=function(){this.dataByFormat={},this.dropEffect=\"none\",this.effectAllowed=\"all\",this.files=[],this.types=[]};a.prototype.clearData=function(t){t?(delete this.dataByFormat[t],n(this.types,t)):(this.dataByFormat={},this.types=[])},a.prototype.getData=function(t){return this.dataByFormat[t]},a.prototype.setData=function(t,e){return this.dataByFormat[t]=e,this.types.indexOf(t)<0&&this.types.push(t),!0},a.prototype.setDragImage=function(){},e.exports=a},{}],3:[function(t,e,r){function n(){}function a(t,e,r){if(\"function\"==typeof e&&(r=e,e=null),!t||\"object\"!=typeof t)throw new Error(\"Expected first parameter to be a targetElement. Instead got: \"+t);return{targetElement:t,eventProperties:e||{},configCallback:r||n}}function o(t,e,r){e&&(e.length<2?r&&e(t):e(t,t.type))}function i(t,e,r,n,a,i){e.forEach(function(e){var s=u.createEvent(e,a,n),c=e===r;o(s,i,c),t.dispatchEvent(s)})}var u=t(\"./eventFactory\"),s=t(\"./DataTransfer\"),c=function(){this.lastDragSource=null,this.lastDataTransfer=null,this.pendingActionsQueue=[]};c.prototype._queue=function(t){this.pendingActionsQueue.push(t),1===this.pendingActionsQueue.length&&this._queueExecuteNext()},c.prototype._queueExecuteNext=function(){if(0!==this.pendingActionsQueue.length){var t=this,e=this.pendingActionsQueue[0],r=function(){t.pendingActionsQueue.shift(),t._queueExecuteNext()};0===e.length?(e.call(this),r()):e.call(this,r)}},c.prototype.dragStart=function(t,e,r){var n=a(t,e,r),o=[\"mousedown\",\"dragstart\",\"drag\"],u=new s;return this._queue(function(){i(n.targetElement,o,\"drag\",u,n.eventProperties,n.configCallback),this.lastDragSource=t,this.lastDataTransfer=u}),this},c.prototype.dragEnter=function(t,e,r){var n=a(t,e,r),o=[\"mousemove\",\"mouseover\",\"dragenter\"];return this._queue(function(){i(n.targetElement,o,\"dragenter\",this.lastDataTransfer,n.eventProperties,n.configCallback)}),this},c.prototype.dragOver=function(t,e,r){var n=a(t,e,r),o=[\"mousemove\",\"mouseover\",\"dragover\"];return this._queue(function(){i(n.targetElement,o,\"drag\",this.lastDataTransfer,n.eventProperties,n.configCallback)}),this},c.prototype.dragLeave=function(t,e,r){var n=a(t,e,r),o=[\"mousemove\",\"mouseover\",\"dragend\"];return this._queue(function(){i(n.targetElement,o,\"dragend\",this.lastDataTransfer,n.eventProperties,n.configCallback)}),this},c.prototype.drop=function(t,e,r){var n=a(t,e,r),o=[\"mousemove\",\"mouseup\",\"drop\"],u=[\"dragend\"];return this._queue(function(){i(n.targetElement,o,\"drop\",this.lastDataTransfer,n.eventProperties,n.configCallback),this.lastDragSource&&i(this.lastDragSource,u,\"drop\",this.lastDataTransfer,n.eventProperties,n.configCallback)}),this},c.prototype.then=function(t){return this._queue(function(){t.call(this)}),this},c.prototype.delay=function(t){return this._queue(function(e){window.setTimeout(e,t)}),this},e.exports=c},{\"./DataTransfer\":2,\"./eventFactory\":4}],4:[function(t,e,r){function n(t,e){for(var r in e)e.hasOwnProperty(r)&&(t[r]=e[r]);return t}function a(t,e,r){\"DragEvent\"===e&&(e=\"CustomEvent\");var a=window[e],o={view:window,bubbles:!0,cancelable:!0};n(o,r);var i=new a(t,o);return n(i,r),i}function o(t,e,r){var a;switch(e){case\"MouseEvent\":a=document.createEvent(\"MouseEvent\"),a.initEvent(t,!0,!0);break;default:a=document.createEvent(\"CustomEvent\"),a.initCustomEvent(t,!0,!0,0)}return r&&n(a,r),a}function i(t,e,r){try{return a(t,e,r)}catch(n){return o(t,e,r)}}var u=t(\"./DataTransfer\"),s=[\"drag\",\"dragstart\",\"dragenter\",\"dragover\",\"dragend\",\"drop\",\"dragend\"],c={createEvent:function(t,e,r){var n=\"CustomEvent\";t.match(/^mouse/)&&(n=\"MouseEvent\");var a=i(t,n,e);return s.indexOf(t)>-1&&(a.dataTransfer=r||new u),a}};e.exports=c},{\"./DataTransfer\":2}],5:[function(t,e,r){function n(t,e,r){return t[e].apply(t,r)}var a=t(\"./DragDropAction\"),o={dragStart:function(t,e,r){return n(new a,\"dragStart\",arguments)},dragEnter:function(t,e,r){return n(new a,\"dragEnter\",arguments)},dragOver:function(t,e,r){return n(new a,\"dragOver\",arguments)},dragLeave:function(t,e,r){return n(new a,\"dragLeave\",arguments)},drop:function(t,e,r){return n(new a,\"drop\",arguments)},delay:function(t,e,r){return n(new a,\"delay\",arguments)},DataTransfer:t(\"./DataTransfer\"),DragDropAction:t(\"./DragDropAction\"),eventFactory:t(\"./eventFactory\")};e.exports=o},{\"./DataTransfer\":2,\"./DragDropAction\":3,\"./eventFactory\":4}]},{},[1]);";
        getBasePage().evaluateJavascript("eval(arguments[0]);", fileContents);
        boolean dragMockExists = (boolean) getBasePage().evaluateJavascript("return !!window.dragMock;");
        if (!dragMockExists) {
            try {
                throw new InterruptedException("Unable to add the drag mock to the driver");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        getBasePage().evaluateJavascript("var startEle = document.querySelector('" + field + "'); var wait = 1500; window.dragMock.dragStart(startEle);");
        String endDrag = getWebCSSSelector(dropElement);
        getBasePage().evaluateJavascript("var endEle = document.querySelector('" + endDrag + "');var wait = 3000; window.dragMock.drop(endEle).delay(wait).dragLeave(endEle);");
        waitABit(3000);
    }

    private String getWebCSSSelector(String element) {
        final String JS_BUILD_CSS_SELECTOR =
                "for(var e=arguments[0],n=[],i=function(e,n){if(!e||!n)return 0;f" +
                        "or(var i=0,a=e.length;a>i;i++)if(-1==n.indexOf(e[i]))return 0;re" +
                        "turn 1};e&&1==e.nodeType&&'HTML'!=e.nodeName;e=e.parentNode){if(" +
                        "e.id){n.unshift('#'+e.id);break}for(var a=1,r=1,o=e.localName,l=" +
                        "e.className&&e.className.trim().split(/[\\s,]+/g),t=e.previousSi" +
                        "bling;t;t=t.previousSibling)10!=t.nodeType&&t.nodeName==e.nodeNa" +
                        "me&&(i(l,t.className)&&(l=null),r=0,++a);for(var t=e.nextSibling" +
                        ";t;t=t.nextSibling)t.nodeName==e.nodeName&&(i(l,t.className)&&(l" +
                        "=null),r=0);n.unshift(r?o:o+(l?'.'+l.join('.'):':nth-child('+a+'" +
                        ")'))}return n.join(' > ');";

        return (String) getBasePage().evaluateJavascript(JS_BUILD_CSS_SELECTOR, findBy(element));
    }

    public void setNewElementName(String oldName, String newName) {
        if (!isElementPresent(NEW_NAME_TEXTAREA)) {
            findBy(format(NAME, oldName)).click();
            findBy(format(NAME, oldName)).click();
            waitForPresenceOf(NEW_NAME_TEXTAREA);
        }
        findBy(NEW_NAME_TEXTAREA).type(newName);
        action().sendKeys(Keys.ENTER).build().perform();
    }

    public ElementSettings getElementSettings() {
        return new ElementSettings(findBy(ELEMENT_SETTINGS_PANEL), getBasePage());
    }

    public void openSettingsFor(String elementName) {
        findBy(format(NAME, elementName)).click();
    }
}

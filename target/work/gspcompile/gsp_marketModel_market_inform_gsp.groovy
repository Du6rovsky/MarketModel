import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_marketModel_market_inform_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/market/_inform.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',1,['code':("label.modelMarket")],-1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('message','g',8,['code':("label.cashdestops")],-1)
printHtmlPart(3)
invokeTag('message','g',17,['code':("label.steps")],-1)
printHtmlPart(4)
invokeTag('message','g',26,['code':("label.perm")],-1)
printHtmlPart(5)
invokeTag('message','g',35,['code':("label.perw")],-1)
printHtmlPart(6)
invokeTag('message','g',44,['code':("label.perk")],-1)
printHtmlPart(7)
invokeTag('message','g',53,['code':("label.runMarket")],-1)
printHtmlPart(8)
})
invokeTag('formRemote','g',54,['name':("subForm"),'url':([controller:'market', action:'run']),'update':("subtraction"),'id':("input_form")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1416427203593L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

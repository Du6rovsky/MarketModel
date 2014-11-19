import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_marketModel_marketrun_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/market/run.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',1,['code':("label.resultView")],-1)
printHtmlPart(1)
loop:{
int i = 0
for( cash in (cashList) ) {
printHtmlPart(2)
expressionOut.print(cash.performance)
printHtmlPart(3)
invokeTag('image','asset',9,['src':("Cash.png"),'width':("150px"),'height':("50px"),'alt':("cash")],-1)
printHtmlPart(4)
expressionOut.print(cash.catered)
printHtmlPart(5)
loop:{
int j = 0
for( customer in (cash.queue) ) {
printHtmlPart(6)
expressionOut.print(customer.goods)
printHtmlPart(7)
if(true && (customer.type == 'Man')) {
printHtmlPart(8)
if(true && (customer.newstatus == true)) {
printHtmlPart(9)
invokeTag('image','asset',20,['src':("new_man.png"),'width':("50px"),'height':("50px"),'alt':("Man")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(9)
invokeTag('image','asset',23,['src':("man.png"),'width':("50px"),'height':("50px"),'alt':("Man")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (customer.type == 'Woman')) {
printHtmlPart(8)
if(true && (customer.newstatus == true)) {
printHtmlPart(9)
invokeTag('image','asset',29,['src':("new_woman.png"),'width':("50px"),'height':("50px"),'alt':("Man")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(9)
invokeTag('image','asset',32,['src':("woman.png"),'width':("50px"),'height':("50px"),'alt':("Man")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (customer.type == 'Kid')) {
printHtmlPart(8)
if(true && (customer.newstatus == true)) {
printHtmlPart(9)
invokeTag('image','asset',38,['src':("new_kid.png"),'width':("50px"),'height':("50px"),'alt':("Man")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(9)
invokeTag('image','asset',41,['src':("kid.png"),'width':("50px"),'height':("50px"),'alt':("Man")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
}
printHtmlPart(13)
j++
}
}
printHtmlPart(14)
i++
}
}
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1416428670459L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

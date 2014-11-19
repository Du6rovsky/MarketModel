<h3 id="result"><g:message code="label.resultView"/></h3>
			
<div class="output">
	
	<g:each in="${cashList}" var="cash" status="i">
		<div class="queue">
			<div class="views_ch" id="cash">
	            <p>Perf: ${cash.performance}</p>
			    <asset:image src="Cash.png" width="150px" height="50px" alt="cash"/>
			    <p>Total: ${cash.catered}</p>
			</div>
	        
	        
	        <g:each in="${cash.queue}" var="customer" status="j">
	            <div class="views_cs">
	                <p>${customer.goods}</p>
	                    
	                <g:if test="${customer.type == 'Man'}">
	                	<g:if test="${customer.newstatus == true}">
	                    	<asset:image src="new_man.png" width="50px" height="50px" alt="Man"/>
	                    </g:if>
	                    <g:else>
	                    	<asset:image src="man.png" width="50px" height="50px" alt="Man"/>
	                    </g:else>
	                </g:if>
	                
	                <g:if test="${customer.type == 'Woman'}">
	                	<g:if test="${customer.newstatus == true}">
	                    	<asset:image src="new_woman.png" width="50px" height="50px" alt="Man"/>
	                    </g:if>
	                    <g:else>
	                    	<asset:image src="woman.png" width="50px" height="50px" alt="Man"/>
	                    </g:else>
	                </g:if>
	                
	                <g:if test="${customer.type == 'Kid'}">
	                	<g:if test="${customer.newstatus == true}">
	                    	<asset:image src="new_kid.png" width="50px" height="50px" alt="Man"/>
	                    </g:if>
	                    <g:else>
	                    	<asset:image src="kid.png" width="50px" height="50px" alt="Man"/>
	                    </g:else>
	                </g:if>
	                
	            </div>
	         </g:each>
	    </div>        	               
	</g:each>
             
</div>
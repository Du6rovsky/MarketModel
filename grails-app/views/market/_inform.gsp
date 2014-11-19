%{-- File: MarketModel/views/market/_inform.gsp --}%
<h3><g:message code="label.modelMarket"/></h3>
<g:formRemote name="subForm" url="[controller:'market', action:'run']" update="subtraction" id="input_form">
		
	<div class="input">
	
	    <!-- Input cash desktops amount -->
	    <div class="input_label">
	        <g:message code="label.cashdestops" />
	    </div>
	    <div class="input_value">
	        <input type="number" name="cd"
	         min="1" value="5" required="required">
	    </div>
	
	    <!-- Input steps amount --> 
	    <div class="input_label">
	        <g:message code="label.steps" />
	    </div>
	    <div class="input_value">
	        <input type="number" name="steps"
	         min="1" value="150" required="required">
	    </div>
	
	    <!-- Input % of man in queue-->
	    <div class="input_label">
	        <g:message code="label.perm" />
	    </div>
	    <div class="input_value">
	        <input class="m" type="number" name="m"
	         min="1" max="98" value="30" required="required"/>
	    </div>
	
	    <!-- Input % of woman in queue-->
	    <div class="input_label">
	        <g:message code="label.perw" />
	    </div>
	    <div class="input_value">
	        <input class="w" type="number" name="w"
	         min="1" max="98" value="25" required="required"/>
	    </div>
	
	    <!-- Input % of kids in queue-->
	    <div class="input_label">
	        <g:message code="label.perk" />
	    </div>
	    <div class="input_value">
	        <input class="k" type="number" name="k"
	         min="1" max="98" value="45" required="required"/>
	    </div>
	    
	    <div class="input_value" id="submit">
	        <input type="submit" name="submit" value="<g:message code="label.runMarket"/>"/>	        
	    </div>   
	
	</div><!--End input -->
            
</g:formRemote>
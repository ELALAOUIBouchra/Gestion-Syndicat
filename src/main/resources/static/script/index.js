
$(document).ready(function(){
    $.ajax({
    	url:"/username",
    	type:"GET",
    	success:function(data){
			if (data === 'admin') {
				$("#admin-nav").show();
				$("#syndic-nav").hide();
				$("#resident-nav").hide();
			}
    			
			else if(data === 'syndic') {
				$("#admin-nav").hide();
				$("#syndic-nav").show();
				$("#resident-nav").hide();
			}
			else if(data === 'resident') {
				$("#admin-nav").hide();
				$("#syndic-nav").hide();
				$("#resident-nav").show();
			}
				
    			
    		
    	}
    });
	
});

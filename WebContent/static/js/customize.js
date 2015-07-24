/**
 * 
 */

$(document).ready(function() {
    $('select').material_select();
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 2, // Creates a dropdown of 15 years to control year
	    format: 'yyyy-mm-dd'
      });
    
    $("#poire").click(function() {
    	var nbDate = $('.datetime').length + 1;

    	var html = '<div class="col m6"><div class="col m12"><span>Horaire <span class="number">'+nbDate+'</span></span><br/><label for="date">Date : </label><br/><input type="date" id="date" class="datepicker" name="datetime[date][]"/></div><div class="col m6"><label>Heure : </label><input type="time" id="hour" name="datetime[hour][]"/></div><div class="col m6"><label>Minute : </label><input type="time" id="min" name="datetime[min][]"/></div></div>';
  
    	$(html).appendTo($("#content-datetime"));

    	var $input = $('.datepicker').pickadate({
    		selectMonths: true, // Creates a dropdown to control month
    		selectYears: 2, // Creates a dropdown of 15 years to control year
    	    format: 'yyyy-mm-dd'
    	  });
    	
    });
    
    
    // Gestion des graphiques
    var data = [
	    {
	        value: 300,
	        color:"#F7464A",
	        highlight: "#FF5A5E",
	        label: "Red"
	    },
	    {
	        value: 50,
	        color: "#46BFBD",
	        highlight: "#5AD3D1",
	        label: "Green"
	    },
	    {
	        value: 100,
	        color: "#FDB45C",
	        highlight: "#FFC870",
	        label: "Yellow"
	    }
	];
    
    var options = {
    	    //Boolean - Whether we should show a stroke on each segment
    	    segmentShowStroke : true,

    	    //String - The colour of each segment stroke
    	    segmentStrokeColor : "#fff",

    	    //Number - The width of each segment stroke
    	    segmentStrokeWidth : 2,

    	    //Number - The percentage of the chart that we cut out of the middle
    	    percentageInnerCutout : 50, // This is 0 for Pie charts

    	    //Number - Amount of animation steps
    	    animationSteps : 100,

    	    //String - Animation easing effect
    	    animationEasing : "easeOutBounce",

    	    //Boolean - Whether we animate the rotation of the Doughnut
    	    animateRotate : true,

    	    //Boolean - Whether we animate scaling the Doughnut from the centre
    	    animateScale : false,

    	    //String - A legend template
    	    legendTemplate : "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>"

    	};
    
    var ctx = $("#myChart")[0].getContext('2d');
    var myPieChart = new Chart(ctx).Pie(data,options);
});
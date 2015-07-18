/**
 * 
 */

$(document).ready(function() {
    $('select').material_select();
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 2 // Creates a dropdown of 15 years to control year
      });
    
    $("#new-datetime").click(function() {
    	var nbDate = $('.datetime').length + 1;
    	
    	var html = '<div class="col m6"><div class="col m12"><span>Horaire <span class="number">1</span></span><br/><label for="date">Date : </label><br/><input type="date" id="date" class="datepicker" name="datetime[date][]"/></div><div class="col m6"><label>Heure : </label><input type="time" id="hour" name="datetime[hour][]"/></div><div class="col m6"><label>Minute : </label><input type="time" id="min" name="datetime[min][]"/></div></div>';
  
    	$(html).appendTo($("#content-datetime"));
    	$('.datepicker').pickadate({
    		selectMonths: true, // Creates a dropdown to control month
    		selectYears: 2 // Creates a dropdown of 15 years to control year
    	});
    });
    
    
    // Gestion des boutons de formulaire sur la home
    $('#login').click(function() {
    	$('#loginForm').submit();
    });
    
    $('#signup').click(function() {
    	$('#signupForm').submit();
    });
    
    // Gestion du bouton du formulaire d'ajout d'un email
    $('#addEmail').click(function() {
    	$('#addEmailForm').submit();
    });
   
});
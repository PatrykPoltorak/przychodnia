$(document).ready(function(){
  $("#input").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#tables tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});

$(document).ready(function(){
  $("#closedVisit").click( function() {
    $("#tables tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf("wizyta zrealizowana") > -1)
    });
  });
});
$(document).ready(function(){
  $("#openVisit").click( function() {
    $("#tables tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf("wizyta nie zrealizowana") > -1)
    });
  });
});


function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

var subscribes = null;
$.get("subscribes", function(data) {
	if (data !== '') {
		subscribes = data;
	}
}).done(function() {
	
	var tableContent = "<tr class='header'>"+
					"<th style='width: 20%;'>Name</th>"+
					"<th style='width: 20%;'>Description</th>"+
					"<th style='width: 10%;'>Price</th>"+
					"<th style='width: 20%;'>Subscribe period</th>"+
					"<th style='width: 20%;'>Subscribe date</th>"+
					"<th style='width: 10%;'>Options</th>"+
					"</tr>";
	
	jQuery.each(subscribes, function(i, value) {
	
		tableContent+="<tr class=thg>"+
					  "<td>" + value.name + "</td>"+
					  "<td>" + value.description + "</td>"+
					  "<td>" + value.subscribePrice +"$" +"</td>"+
					  "<td>" + value.subscribePeriod + " month"+"</td>"+
					  "<td>" + value.subscribeDate +"</td>"+
					  "<td><button onclick='deleteOrderFromBucket(" + value.subscribeId + ")'>delete</button></td>"+
					  "</tr>"
					   
	});
	
	  $('#myTable').html(tableContent);
	
});

function deleteOrderFromBucket(subscribeId) {	
	var customUrl = '';
	var urlContent = window.location.href.split('/');
	for (var i = 0; i < urlContent.length-1; i++) {
		customUrl+=urlContent[i]+'/'
	}
	customUrl+='subscribe?subscribeId='+subscribeId;
	
	$.ajax({
	    url: customUrl,
	    type: 'DELETE',
	    success: function(data) {
	    	if (data == 'Success') {
	    		location.reload();
			}
	    }
	});
}
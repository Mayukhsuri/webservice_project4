

$(document).ready(function () {

 var getSearchResults = function () {

        // Get the search term.
        var idsearch = $('#term').val();

        // If the title was empty, give an error message.
        if (idsearch == '') {
            $('#content').html('Looks like someone forgot to enter a search term.');

            // Otherwise do API call
        } else {
            $('#content').html("Fetching search results...");

           var req = new XMLHttpRequest();
			req.open('GET', 'http://localhost:8081/productservice/product/' + idsearch);
			req.setRequestHeader('Content-Type', 'application/json');
			req.onload = function() {
				alert('inside req'+req.responseText);
				if (req.status === 200) {
					var data = jQuery.parseJSON(req.responseText);
					produceProductList(data);
				}
			};
			req.send();

		}
	}
	$('#search').click(getSearchResults);	
});













 </script>